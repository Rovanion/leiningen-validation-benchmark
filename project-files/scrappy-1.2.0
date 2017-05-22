(defproject com.secondchance/scrappy "1.2.0"
  :description "\"Let me at em!\" -- Scrappy Do
A scraping DSL + engine for reading the web."
  :license "Eclipse Public License 1.0"
  :url "https://github.com/secctech/scrappy"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2202"]
                 [org.jsoup/jsoup "1.7.2"]
                 [jayq "2.4.0"]]

  :plugins [[s3-wagon-private "1.1.2"]
            [com.keminglabs/cljx "0.3.2"]
            [lein-cljsbuild "1.0.3"]
            [com.cemerick/austin "0.1.4"]
            [com.cemerick/clojurescript.test "0.3.0"]]

  :cljx {:builds [{:source-paths ["src/cljx" "test/cljx"]
                   :output-path "target/classes/clj"
                   :rules :clj}

                  {:source-paths ["src/cljx" "test/cljx"]
                   :output-path "target/classes/cljs"
                   :rules :cljs}]}

  :hooks [cljx.hooks
          leiningen.cljsbuild]

  :source-paths ["src/clj" "target/classes/cljs" "target/classes/clj"]
  :test-paths ["target/classes/clj"]

  :cljsbuild {:builds [{:id "test"
                        :source-paths ["target/classes/cljs" "src/clj"]
                        :externs ["externs/jquery.js"]
                        :compiler {:output-to "target/test.js"
                                   :output-dir "target/test-out"
                                   :source-map "target/test.js.map"
                                   :output-wrapper false
                                   :optimizations :simple
                                   :pretty-print true}}]
              :test-commands {"unit-tests" ["phantomjs" :runner
                                            "resources/jquery.js"
                                            "target/test.js"]}}

  :profiles {:dev {:plugins [[s3-wagon-private "1.1.2"]
                             [com.keminglabs/cljx "0.3.2"]
                             [lein-cljsbuild "1.0.3"]
                             [com.cemerick/austin "0.1.4"]
                             [com.cemerick/clojurescript.test "0.3.0"]]
                   :source-paths ["target/classes/cljs" "src/clj"]}}

  :repositories {"secondchance" {:url "s3p://maven.secondchance/releases/"
                                 :username ~(System/getenv "AWS_ACCESS_KEY")
                                 :passphrase ~(System/getenv "AWS_SECRET_KEY")
                                 :sign-releases false}})
