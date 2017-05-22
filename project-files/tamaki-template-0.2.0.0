(defproject tamaki-template "0.2.0.0"
  :description "a demo for tamaki"
  :url "https://github.com/satokazuma/tamaki-template"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/mit-license.php"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [hiccup "1.0.5"]
                 [clj-yaml "0.4.0"]
                 [robert/hooke "1.3.0"]
                 [compojure "1.5.1"]
                 [tamaki "0.3.0.0"]]
  :exclusions [org.slf4j/slf4j-simple]
  :plugins [[lein-ring "0.10.0"]
            [lein-tamaki "0.2.0.0"]]
  :ring {:handler tamaki-template.template/handler
         ;:init tamaki-core.server/init
         :auto-reload? true})

