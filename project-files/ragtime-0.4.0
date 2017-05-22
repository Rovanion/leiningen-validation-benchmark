(defproject clojurewerkz/ragtime "0.4.0"
  :description "A database-independent migration library"
  :dependencies [[clojurewerkz/ragtime.core "0.4.0"]
                 [clojurewerkz/ragtime.sql "0.4.0"]
                 [clojurewerkz/ragtime.sql.files "0.4.0"]]
  :plugins [[lein-sub "0.2.1"]
            [codox "0.6.7"]]
  :sub ["ragtime.core" "ragtime.sql" "ragtime.sql.files"]
  :codox {:sources ["ragtime.core/src"
                    "ragtime.sql/src"
                    "ragtime.sql.files/src"]
          :exclude [ragtime.sql.database ragtime.main]}
  :profiles
  {:dev {:dependencies [[codox/codox.core "0.6.7"]]}})
