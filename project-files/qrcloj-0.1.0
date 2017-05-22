(defproject qrcloj "0.1.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths ["src/cljc" "src/clj" "src/cljs"]
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]]
 :plugins [[lein-cljsbuild "1.1.1-SNAPSHOT"]]
 :cljsbuild {
  :builds [{:source-paths ["src/cljs" "src/cljc"]
            :compiler {:output-to "out/main.js"
                       :optimizations :advanced}}]})
