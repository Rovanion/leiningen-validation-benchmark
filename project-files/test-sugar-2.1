(defproject test-sugar "2.1"
  :description "Sugar for clojure.test and clojurescript.test"
  :url "https://github.com/nvbn/test-sugar/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2311"]]
  :profiles {:uberjar {:hooks [cljx.hooks
                               leiningen.cljsbuild]}
             :dev {:plugins [[lein-cljsbuild "1.0.3"]
                             [com.keminglabs/cljx "0.3.2"]
                             [com.cemerick/clojurescript.test "0.3.1"]]
                   :cljx {:builds [{:source-paths ["src"]
                                    :output-path "target/classes"
                                    :rules :clj}
                                   {:source-paths ["test"]
                                    :output-path "target/test-classes"
                                    :rules :clj}
                                   {:source-paths ["src"]
                                    :output-path "target/generated-cljs"
                                    :rules :cljs}
                                   {:source-paths ["test"]
                                    :output-path "target/test-generated-cljs"
                                    :rules :cljs}]}
                   :cljsbuild {:builds [{:source-paths ["target/generated-cljs"
                                                        "target/test-generated-cljs"]
                                         :compiler {:output-to "target/cljs-test.js"
                                                    :optimizations :whitespace
                                                    :pretty-print true}}]
                               :test-commands {"test" ["phantomjs" :runner
                                                       "target/cljs-test.js"]}}
                   :test-paths ["target/test-classes"]}}
  :source-paths ["target/classes" "target/generated-cljs"])
