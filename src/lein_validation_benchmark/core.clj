(ns lein-validation-benchmark.core
  (:require [clojure.spec.alpha                  :as spec]
            [leiningen.core.project              :as project]
            [leiningen.core.spec.project         :as spec-p]
            [leiningen.core.schema.project       :as schema-p]
            [leiningen.core.truss.project        :as truss-p]
            [lein-validation-benchmark.benchmark :as bench]
            [lein-validation-benchmark.reader    :as reader]))


(defn -main [& args]
  (let [files (rest (file-seq (clojure.java.io/file "project-files/")))]
    (println "Truss")
    (bench/fn-with-files truss-p/validate-map (take 6 files) 2)
    (println "Spec")
    (bench/fn-with-files #(spec/valid? ::project/project-map %) files 2)))


(spec/valid? ::project/project-map (reader/read-raw (.getAbsolutePath (first files))))
