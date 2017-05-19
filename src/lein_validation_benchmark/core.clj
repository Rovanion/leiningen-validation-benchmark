(ns lein-validation-benchmark.core
  (:require [leiningen.core.spec.project   :as spec]
            [leiningen.core.schema.project :as schema]
            [leiningen.core.truss.project  :as truss]))



(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
