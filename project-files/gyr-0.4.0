(defproject im.chit/gyr "0.4.0"
  :description "Native objects and arrays functions in clojurescript"
  :url "http://www.github.com/purnam/gyr"
  :license {:name "The MIT License"
            :url "http://opensource.org/licencses/MIT"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :profiles {:dev {:dependencies [[org.clojure/clojurescript "0.0-2138"]
                                  [midje "1.6.0"]]
                   :plugins [[lein-cljsbuild "1.0.0"]]}}
  :cljsbuild {:builds [{:source-paths ["src"]
                       :compiler {:output-to "test/gyr.js"
                                  :optimizations :whitespace
                                  :pretty-print true}}]})