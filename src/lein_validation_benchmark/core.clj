(ns lein-validation-benchmark.core
  (:require [clojure.spec.alpha                  :as spec]
            [clojure.pprint                      :refer [pprint]]
            [schema.core                         :as schema]
            [leiningen.core.project              :as project]
            [leiningen.core.spec.project         :as spec-p]
            [leiningen.core.schema.project       :as schema-p]
            [leiningen.core.truss.project        :as truss-p]
            [lein-validation-benchmark.benchmark :as bench]
            [lein-validation-benchmark.reader    :as reader]))

(def project-maps (reader/load-project-maps))

(def project-keys '(:description :url :mailing-list :mailing-lists :license :licenses :min-lein-version :dependencies :managed-dependencies :pedantic? :exclusions :plugins :repositories :mirrors :local-repo :update :checksum :deploy-repositories :signing :certificates :profiles :hooks :middleware :main :aliases :release-tasks :prep-tasks :aot :injections :java-agents :javac-options :warn-on-reflection :global-vars :java-cmd :jvm-opts :eval-in :bootclasspath :source-paths :java-source-paths :test-paths :resource-paths :target-path :compile-path :native-path :clean-targets :clean-non-project-classes :checkout-deps-shares :test-selectors :monkeypatch-clojure-test :repl-options :jar-name :uberjar-name :omit-source :jar-exclusions  :uberjar-exclusions :auto-clean :uberjar-merge-with :filespecs :manifest :pom-location :parent :pom-plugins :pom-addition :scm :deploy-branches :classifiers))

(defn -main [& args]
  (println "Spec per key:")
  (bench/per-keyword
   (fn [k v]
     (let [spec-key (keyword "leiningen.core.project" (name k))]
       (bench/time' (spec/valid? spec-key v))))
   project-maps project-keys)

  (println "Schema per key:")
  (bench/per-keyword
   (fn [k v]
     (let [k-schema (deref (resolve (symbol "leiningen.core.schema.project" (name k))))]
       (bench/time' (schema/check k-schema v))))
   project-maps project-keys)

  (println "Truss per key:")
  (bench/per-keyword
   (fn [k v]
     (let [checker (deref (resolve (symbol "leiningen.core.truss.project" (name k))))]
       (bench/time' (try (checker v)
                         (catch clojure.lang.ExceptionInfo e)))))
   project-maps project-keys))


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
