(defproject vasco "0.9.0"
  :description "simple cljx routing"
  :url "http://github.com/lgastako/vasco"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :cljx {:builds [{:source-paths ["src"] :output-path "target/gen/src" :rules :clj}
                  {:source-paths ["src"] :output-path "target/gen/src" :rules :cljs}
                  {:source-paths ["test"] :output-path "target/gen/test" :rules :clj}
                  {:source-paths ["test"] :output-path "target/gen/test" :rules :cljs}]}
  :cljsbuild {:builds {:dev {:source-paths ["src" "target/gen/src"]
                             :compiler {:output-to "target/gen/js/vasco.js"
                                        :output-dir "target/gen/js"
                                        :optimizations :whitespace
                                        :pretty-print true
                                        :source-map "target/gen/js/main.js.map"}}
                       :test {:source-paths ["src" "test"
                                             "target/gen/src" "target/gen/test"]
                              :compiler {:output-to "target/gen/test/js/testable.js"
                                         :optimizations :simple
                                         :pretty-print true}}}
              :test-commands {"phantomjs" ["phantomjs"
                                           :runner
                                           "target/gen/test/js/testable.js"]}}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2197"]]
  :hooks [leiningen.cljsbuild cljx.hooks]
  :min-lein-version "2.0.0"
  :plugins [[com.keminglabs/cljx "0.3.2" :exclusions [org.clojure/clojure]]
            [lein-cljsbuild "1.0.3"]
            [com.cemerick/clojurescript.test "0.3.0"]]
  :source-paths ["src" "target/gen/src"]
  :test-paths ["test" "target/gen/test"])
