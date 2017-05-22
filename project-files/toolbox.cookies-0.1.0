(defproject org.clojars.intception/toolbox.cookies "0.1.0"
  :description "ClojureScript interface for handling browser cookies via `goog.net.cookies`"
  :url "http://github.com/intception/toolbox.cookies"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths  ["src"]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2356" :scope "provided"]]
  :min-lein-version "2.0.0"
  :plugins [[lein-cljsbuild "1.0.4-SNAPSHOT"]]
  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src"]
                        :compiler {:output-to "resources/out/toolbox_cookies.js"
                                   :output-dir "resources/out"
                                   :source-map "resources/out/toolbox_cookies.map"
                                   :output-wrapper false
                                   :optimizations :simple}}]})
