(ns lein-validation-benchmark.core
  (:require [clojure.spec.alpha                  :as spec]
            [clojure.pprint                      :refer [pprint]]
            [clojure.java.shell                  :refer [sh]]
            [schema.core                         :as schema]
            [leiningen.core.project              :as project]
            [leiningen.core.spec.project         :as spec-p]
            [leiningen.core.schema.project       :as schema-p]
            [leiningen.core.truss.project        :as truss-p]
            [lein-validation-benchmark.benchmark :as bench]
            [lein-validation-benchmark.reader    :as reader]))

(def project-maps (reader/load-project-maps))

(def project-keys '(:description :url :mailing-list :mailing-lists :license :licenses :min-lein-version :dependencies :managed-dependencies :pedantic? :exclusions :plugins :repositories :mirrors :local-repo :update :checksum :deploy-repositories :signing :profiles :hooks :middleware :main :aliases :release-tasks :prep-tasks :aot :injections :java-agents :javac-options :warn-on-reflection :global-vars :java-cmd :jvm-opts :eval-in :bootclasspath :source-paths :java-source-paths :test-paths :resource-paths :target-path :compile-path :native-path :clean-targets :clean-non-project-classes :test-selectors :monkeypatch-clojure-test :repl-options :jar-name :uberjar-name :omit-source :jar-exclusions  :uberjar-exclusions :auto-clean :uberjar-merge-with :filespecs :manifest :pom-location :parent :pom-plugins :pom-addition :scm :deploy-branches :classifiers))

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


(defn -main [& args]
  (let [spec-per-key   (bench/per-keyword spec-timer   project-maps
                                          project-keys "per-keyword-spec")
        schema-per-key (bench/per-keyword schema-timer project-maps
                                          project-keys "per-keyword-schema")
        truss-per-key  (bench/per-keyword truss-timer  project-maps
                                          project-keys "per-keyword-truss")
        spec-summary   (bench/fns-over-maps-summary
                        project-maps
                        #(spec/valid? ::project/project-map %) "spec"
                        #(schema/check schema-p/project-map %) "schema"
                        #(truss-p/validate-map-noexcept %)     "truss")])

    (sh "make" :dir "plot"))


(defn three-way-validation-check
  "Check if the three validators are all in accord."
  [files]
  (println (format "%10s %10s %10s %s"
                   "spec" "schema" "truss" "project"))
  (for [file files]
    (try
      (let [m      (reader/read-raw (.getAbsolutePath file))]
        (try
          (let [spec   (spec/valid? ::project/project-map  m)
                schema (schema/check schema-p/project-map m)
                truss  (truss-p/validate-map-noexcept m)]
            (println (format "%10s %10s %10s %s"
                             spec (nil? schema) (nil? truss)
                             (.getName file)))
            (when-not (and spec (nil? schema) (nil? truss))
              (println "The failing map:")
              (pprint m)
              (when-not spec
                (spec/explain ::project/project-map m))
              (when-not (nil? schema)
                (pprint schema))
              (when-not (nil? truss)
                (pprint truss))
              (println " -- -- -- -- ")
              (println (format "%10s %10s %10s %s"
                   "spec" "schema" "truss" "project"))))
          (catch clojure.lang.ExceptionInfo e
            (println "Validation failed for" (.getName file))
            (println (.getMessage e))
            (println "The failing map:")
            (pprint m))))
      (catch java.lang.Exception e
        (println "Exception while loading file:" (.getMessage e))))))

; (three-way-validation-check (sort (rest (file-seq (clojure.java.io/file "project-files/")))))
