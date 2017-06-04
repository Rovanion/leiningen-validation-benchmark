(defproject lein-validation-benchmark "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure         "1.9.0-alpha16"]
                 [leiningen-core-spec         "2.7.2-SNAPSHOT"]
                 [leiningen-core-schema       "2.7.2-SNAPSHOT"]
                 [leiningen-core-truss        "2.7.2-SNAPSHOT"]
                 [leiningen-core-predicate    "2.7.2-SNAPSHOT"]
                 [prismatic/schema            "1.1.6"]
                 [com.taoensso/truss          "1.5.0"]
                 ;; For spec and schema testing
                 [org.clojure/test.check      "0.9.0"]
                 ;; For generation
                 [com.velisco/strgen          "0.1.4"]
                 [prismatic/schema-generators "0.1.0"]]
  :main lein-validation-benchmark.core)
