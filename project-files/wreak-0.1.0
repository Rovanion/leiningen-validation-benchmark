(defproject ewen/wreak "0.1.0"
            :description "React.js wrapper for clojurescript"
            :url "https://github.com/EwenG/wreak"
            :license {:name "Eclipse Public License"
                      :url "http://www.eclipse.org/legal/epl-v10.html"}
            :min-lein-version "2.0.0"
            :source-paths ["src-cljs"]
            :test-paths ["test"]
            :resource-paths ["resources/main"]
            :dependencies [[org.clojure/clojure "1.6.0"]
                           [org.clojure/clojurescript "0.0-2311"]]
            :dev-dependencies [[lein-cljsbuild "1.0.3"]]
            :profiles {:dev {:plugins [[lein-cljsbuild "1.0.3"]]}}
            :hooks [leiningen.cljsbuild]
            :cljsbuild {:builds [{:id "dev"
                                  :source-paths ["src-cljs"]
                                  :compiler {
                                              :output-to "resources/dev/public/cljs/wreak.js"
                                              :output-dir "resources/dev/public/cljs/"
                                              :optimizations :none
                                              :source-map true}}
                                 {:id "prod"
                                  :source-paths ["src-cljs"]
                                  :compiler {
                                              :output-to "resources/prod/public/cljs/wreak.min.js"
                                              :optimizations :advanced
                                              :pretty-print false}}]}
            :jvm-opts ["-Xss1G"]                                         ;Avoid stackoverflow when compiling clojurescript (for example, large go-loop macros)
            )
