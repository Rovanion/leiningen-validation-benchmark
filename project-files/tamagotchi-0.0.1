(defproject tamagotchi "0.0.1"
  :description "clojure(script) tamagotchi library"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.227"]]

  :plugins [[lein-cljsbuild "1.1.5"]]

  :source-paths ["src/cljc"]
  :test-paths ["test/cljc"]
  :profiles {:dev {:plugins [[lein-doo "0.1.6"]
                             [lein-auto "0.1.3"]]}}

  :cljsbuild
  {:builds
   [{:id           "unit-tests"
     :source-paths ["src/cljc" "test/cljc" "test/cljs"]
     :compiler     {:main          'tamagotchi.unit-tests
                    :output-to     "resources/public/js/compiled/unit-tests.js"
                    :target        :nodejs
                    :optimizations :none
                    }}

    {:id           "min"
     :source-paths ["src/cljc"]
     :compiler     {:main            tamagotchi.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}
    ]}

  :doo {:build "unit-tests"}
  )

  
