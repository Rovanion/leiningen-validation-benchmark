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


(defn -main [& args]
  (let [files (sort (rest (file-seq (clojure.java.io/file "project-files/"))))]
    (println "Truss")
    (bench/fn-with-files truss-p/validate-map (take 6 files) 2)
    (println "Spec")
    (bench/fn-with-files #(spec/valid? ::project/project-map %) files 2)))



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
