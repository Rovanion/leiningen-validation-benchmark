(defproject broken-record "0.1.0"
  :description "Very slightly enhanced Clojure records because Russell hates boilerplate."
  :url "http://github.com/bugsbio/broken-record"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}
  :source-paths ["src"]
  :signing {:gpg-key "CF73E6ED"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [bugsbio/camel-snake-kebab "0.2.5" :exclusions [org.clojure/clojure]]]
  :profiles {:dev {:dependencies [[expectations "2.0.9"]]
                   :plugins [[lein-autoexpect "1.0"]
                             [lein-expectations "0.0.8"]]}})
