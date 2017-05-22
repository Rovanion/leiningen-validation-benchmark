(defproject co.zensight/reagent-quill "0.1.1"
  :description "Reagent wrapper around react-quill"

  :url "https://github.com/Zensight/reagent-quill.git"

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.293"]
                 [cljsjs/react "15.2.1-0"]
                 [cljsjs/react-dom "15.2.1-0"]
                 [cljsjs/react-dom-server "15.2.1-0"]
                 [reagent "0.6.0"]]

  :plugins [[lein-cljsbuild "1.1.4"
             :exclusions [org.clojure/clojure]]
            [lein-figwheel "0.5.4-7"]]

  :deploy-repositories [["releases" :clojars]]

  :source-paths ["src"]

  :figwheel {:server-port 3450
             :css-dirs ["resources/public/css"]}

  :cljsbuild {:builds {:app
                       {:source-paths ["src" "env/dev/cljs"]
                        :figwheel true
                        :compiler {:main "reagent-quill.dev"
                                   :asset-path   "js/out"
                                   :output-to "resources/public/js/app.js"
                                   :output-dir "resources/public/js/out"
                                   :source-map true
                                   :optimizations :none
                                   :pretty-print  true
                                   :foreign-libs [{:file "src/vendor/bundle.js"
                                                   :file-min "src/vendor/bundle.min.js"
                                                   :provides ["react-quill"]}]
                                   }}
                       :release
                       {:source-paths ["src" "env/prod/cljs"]
                        :compiler
                        {:output-to "dist/reagent-quill.js"
                         :output-dir "dist/"
                         :asset-path   "js/out"
                         :foreign-libs [{:file "src/vendor/bundle.js"
                                         :file-min "src/vendor/bundle.min.js"
                                         :provides ["react-quill"]}]
                         :optimizations :advanced
                         :pretty-print false}}}})
