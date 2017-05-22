(defproject colinkahn.flux.scroll-list "1.0.0"
  :description "Clojurescript functions for "
  :url "https://github.com/colinkahn/colinkahn.flux.dispatcher"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2760"]]
  :profiles {:dev {:plugins [[com.cemerick/clojurescript.test "0.2.1"]
                             [lein-cljsbuild "1.0.3"]]
                   :cljsbuild {:builds [{:source-paths ["src" "test"]
                                         :compiler {:output-to "target/main.js"
                                                    :optimizations :whitespace
                                                    :pretty-print true}}]
                               :test-commands {"unit-tests" ["phantomjs"
                                                             :runner
                                                             "window.literal_js_was_evaluated=true"
                                                             "target/main.js"]}}}})
