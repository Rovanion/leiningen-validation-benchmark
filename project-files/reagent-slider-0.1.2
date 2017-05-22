(defproject reagent-slider "0.1.2"
  :description "Reagent wrapper around react-components/slider"
  :url "http://github.com/Zensight/reagent-slider.git"
  :license {:name "MIT"}

  :dependencies [[org.clojure/clojure "1.8.0" :scope "provided"]
                 [org.clojure/clojurescript "1.9.495" :scope "provided"]
                 [cljsjs/react "15.2.1-0"]
                 [cljsjs/react-dom "15.2.1-0"]
                 [cljsjs/react-dom-server "15.2.1-0"]
                 [reagent "0.6.1"]]

  :plugins [[lein-cljsbuild "1.1.5"
             :exclusions [org.clojure/clojure]]
            [lein-figwheel "0.5.9"]]

  :deploy-repositories [["releases" :clojars]]

  :source-paths ["src"]

  :figwheel {:server-port 3450
             :css-dirs ["resources/public/css"]}

  :cljsbuild {:builds {:app
                       {:source-paths ["src" "env/dev/cljs"]
                        :figwheel true
                        :compiler {:main "reagent-slider.dev"
                                   :asset-path "js/out"
                                   :output-to "resources/public/js/app.js"
                                   :output-dir "resources/public/js/out"
                                   :source-map true
                                   :optimizations :none
                                   :pretty-print  true
                                   :foreign-libs [{:file "src/vendor/bundle.js"
                                                   :file-min "src/vendor/bundle.min.js"
                                                   :provides ["react-slider"]}]
                                   }}
                       :release
                       {:source-paths ["src" "env/prod/cljs"]
                        :compiler
                        {:output-to "dist/reagent-slider.js"
                         :output-dir "dist/"
                         :asset-path   "js/out"
                         :foreign-libs [{:file "src/vendor/bundle.js"
                                         :file-min "src/vendor/bundle.min.js"
                                         :provides ["react-slider"]}]
                         :optimizations :advanced
                         :pretty-print false}}}})
