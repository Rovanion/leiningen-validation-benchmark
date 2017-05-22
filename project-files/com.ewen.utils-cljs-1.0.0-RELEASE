(defproject com.ewen.utils-cljs "1.0.0-RELEASE"
  :description "Utilities for clojurescript"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/clojurescript "0.0-1586"]]
  :dev-dependencies [[lein-cljsbuild "0.3.0"]]
  :plugins [[lein-cljsbuild "0.3.0"]]
  :hooks [leiningen.cljsbuild]
  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src-cljs"]
                        :compiler {:output-to "cljs.js"
                                   :optimizations :simple
                                   :pretty-print true
                                   }}
                       {:id "advanced"
                        :source-paths ["src-cljs"]
                        :jar true
                        :compiler {:output-to "cljs.js"
                                   :optimizations :advanced
                                   :pretty-print false}}]})