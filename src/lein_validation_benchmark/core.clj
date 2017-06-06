(ns lein-validation-benchmark.core
  (:require [clojure.spec.alpha                     :as spec]
            [clojure.pprint                         :refer [pprint]]
            [clojure.java.shell                     :refer [sh]]
            [schema.core                            :as schema]
            [leiningen.core.project                 :as project]
            [leiningen.core.spec.project            :as spec-p]
            [leiningen.core.schema.project          :as schema-p]
            [leiningen.core.truss.project           :as truss-p]
            [leiningen.core.pred-validation.project :as predicate-p]
            [lein-validation-benchmark.benchmark    :as bench]
            [lein-validation-benchmark.reader       :as reader]))

(def project-maps (reader/load-project-maps))

(def project-keys (sort '(:description :url :mailing-list :mailing-lists :license :licenses :min-lein-version :dependencies :managed-dependencies :pedantic? :exclusions :plugins :repositories :mirrors :local-repo :update :checksum :deploy-repositories :signing :certificates :profiles :hooks :middleware :main :aliases :release-tasks :prep-tasks :aot :injections :java-agents :javac-options :warn-on-reflection :global-vars :java-cmd :jvm-opts :eval-in :bootclasspath :source-paths :java-source-paths :test-paths :resource-paths :target-path :compile-path :native-path :clean-targets :clean-non-project-classes :checkout-deps-shares :test-selectors :monkeypatch-clojure-test :repl-options :jar-name :uberjar-name :omit-source :jar-exclusions  :uberjar-exclusions :auto-clean :uberjar-merge-with :filespecs :manifest :pom-location :parent :pom-plugins :pom-addition :scm :deploy-branches :classifiers)))

(def color-map {"Spec"   "ff0000"
                "Schema" "0000ff"
                "Truss"  "00aa00"
                "Plain"  "ffff00"})

(defn spec-timer [k v]
  (let [spec-key (keyword "leiningen.core.project" (name k))]
    (bench/time' (spec/valid? spec-key v))))

(defn schema-timer [k v]
  (let [k-schema (deref (resolve (symbol "leiningen.core.schema.project" (name k))))]
    (bench/time' (schema/check k-schema v))))

(defn truss-timer [k v]
  (let [checker (deref (resolve (symbol "leiningen.core.truss.project" (name k))))]
    (bench/time' (try (checker v)
                      (catch clojure.lang.ExceptionInfo e)))))

(defn pred-timer [k v]
  (let [checker (deref (resolve (symbol "leiningen.core.pred-validation.project" (str (name k) "?"))))]
    (bench/time' (try (checker v)
                      (catch java.lang.IllegalArgumentException e)))))

(defn -main [& args]
  (let [spec-per-key   (bench/per-keyword spec-timer   (vals project-maps)
                                          project-keys "Spec"   1 color-map)
        schema-per-key (bench/per-keyword schema-timer (vals project-maps)
                                          project-keys "Schema" 2 color-map)
        truss-per-key  (bench/per-keyword truss-timer  (vals project-maps)
                                          project-keys "Truss"  3 color-map)
        pred-per-key   (bench/per-keyword pred-timer   (vals project-maps)
                                          project-keys "Plain"  4 color-map)
        summary        (bench/fns-over-maps-summary
                        (vals project-maps)
                        color-map
                        #(spec/valid? ::project/project-map %)        "Spec"
                        #(nil? (schema/check schema-p/project-map %)) "Schema"
                        #(truss-p/validate-map-spec-like %)           "Truss"
                        #(predicate-p/valid-map-noexcept? %)          "Plain")]
    (sh "make" :dir "plot")))

(defn three-way-validation-check
  "Check if the three validators are all in accord."
  [project-maps]
  (println (format "%10s %10s %10s %10s %s"
                   "Spec" "Schema" "Truss" "Plain" "name"))
  (for [[file-name project-map] (sort project-maps)]
    (try
      (let [spec   (spec/valid? ::project/project-map project-map)
            schema (schema/check schema-p/project-map project-map)
            truss  (truss-p/validate-map-schema-like  project-map)
            pred   (predicate-p/valid-map-noexcept?   project-map)]
        (println (format "%10s %10s %10s %10s %s"
                         spec (nil? schema) (nil? truss) pred file-name))
        (when-not (or (and      spec       (nil? schema)       (nil? truss)       pred)
                      (and (not spec) (not (nil? schema)) (not (nil? truss)) (not pred)))
          (println "The failing map:")
          (pprint project-map)
          (when-not spec
            (spec/explain ::project/project-map project-map))
          (when-not (nil? schema)
            (pprint schema))
          (when-not (nil? truss)
            (pprint truss))
          (println " -- -- -- -- ")
          (println (format "%10s %10s %10s %10s %s"
                           "Spec" "Schema" "Truss" "Plain" "name"))))
      (catch clojure.lang.ExceptionInfo e
        (println "Validation failed for" file-name)
        (println (.getMessage e))
        (println "The failing map:")
        (pprint project-map)))))

; (doall (three-way-validation-check project-maps))
