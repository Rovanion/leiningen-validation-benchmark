(defproject org.clojars.leanpixel/om-material "1.9.0-0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-3058"]
                 [org.clojars.leanpixel/om-fields "1.9.0"]]

  :plugins [[jamesnvc/lein-lesscss "1.4.0"]]

  :lesscss-paths ["resources/less"]
  :lesscss-output-path "resources/public/css"

  :profiles {:dev {:plugins [[lein-cljsbuild "1.0.5"]]
                   :cljsbuild {:builds [{:id "om-material"
                                         :compiler {:output-to "resources/public/js/out/om-material.js"
                                                    :output-dir "resources/public/js/out"
                                                    :optimizations :none
                                                    :source-map true}}]}}}
  )
