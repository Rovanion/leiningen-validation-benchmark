(defproject jimbru/ragtime "0.4.0-SNAPSHOT"
  :description "A database-independent migration library"
  :url "https://github.com/jimbru/ragtime"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :scm {:name "git"
        :url "https://github.com/jimbru/ragtime.git"}
  :dependencies [[jimbru/ragtime.core "0.4.0-SNAPSHOT"]
                 [jimbru/ragtime.sql "0.4.0-SNAPSHOT"]
                 [jimbru/ragtime.sql.files "0.4.0-SNAPSHOT"]
                 [jimbru/ragtime.sql.resources "0.4.0-SNAPSHOT"]]
  :plugins [[lein-sub "0.2.1"]
            [codox "0.8.10"]]
  :sub ["ragtime.core" "ragtime.sql" "ragtime.sql.files" "ragtime.sql.resources"]
  :codox {:sources ["ragtime.core/src"
                    "ragtime.sql/src"
                    "ragtime.sql.files/src"
                    "ragtime.sql.resources/src"]
          :exclude [ragtime.sql.database ragtime.main]})
