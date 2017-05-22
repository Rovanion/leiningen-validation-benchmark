(def VERSION (.trim (slurp "VERSION")))

(defproject foxglove VERSION
  :main         foxglove.core
  :description  "Clojure client for Walker."
  :url          "https://github.com/simplefinance/foxglove"
  :license      "The Apache Software License, Version 2.0"
  :repl-options {:init-ns foxglove.core}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/tools.logging "0.2.6"]
                 [clj-http "1.0.1"]]
  :min-lein-version "2.0.0"
  :codox {:output-dir "target/doc"
          :src-dir-url "https://github.com/simplefinance/foxglove/blob/master"}
  :global-vars {*warn-on-reflection* true}
  :profiles {:dev {:plugins [[codox "0.8.10"]
                             [jonase/eastwood "0.2.1"]
                             [lein-cloverage "1.0.2"]]}})
