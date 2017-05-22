(defproject two-headed-boy "0.1.0"
  :description "Convenience functions for writing dual targeted, Clojure (JVM) and ClojureScript (Node.js) apps."
  :url "https://github.com/leppert/two-headed-boy"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.293"]
                 [org.clojure/core.async "0.2.395"]
                 [org.clojure/data.codec "0.1.0"]
                 [cheshire "5.6.3"]
                 [com.cemerick/piggieback "0.2.1"]]
  :plugins [[lein-cljsbuild "1.1.4"]
            [lein-npm       "0.6.2"]
            [lein-doo       "0.1.7"]]
  :npm {:dependencies [[source-map-support "0.4.6"]]}

  :doo {:build "test"
        :alias {:default [:node]}}

  :cljsbuild
  {:builds {:production {:source-paths ["src"]
                         :compiler {:output-to     "target/two-headed-boy/two_headed_boy.js"
                                    :output-dir    "target/two-headed-boy"
                                    :source-map    "target/two-headed-boy/two_headed_boy.js.map"
                                    :target        :nodejs
                                    :language-in   :ecmascript5
                                    :optimizations :advanced
                                    }}
            :test {:source-paths ["src" "test"]
                   :compiler {:output-to     "target/two-headed-boy-test/two_headed_boy.js"
                              :output-dir    "target/two-headed-boy-test"
                              :target        :nodejs
                              :language-in   :ecmascript5
                              :optimizations :none
                              :main          two-headed-boy.test-runner}}}}

  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]})
