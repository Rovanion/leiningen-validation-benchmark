(defproject org.dunaj/core.rrb-vector "0.0.12-dunaj_pre4"
  :description "RRB-Trees for Clojure(Script) -- see Bagwell & Rompf"
  :url "https://github.com/clojure/core.rrb-vector"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.2.0"
  :dependencies [#_[org.clojure/clojure "1.5.1"]]
  :source-paths ["src/main/clojure"
                 "src/main/cljs"]
  :test-paths ["src/test/clojure"]
  :jvm-opts ^:replace ["-XX:+UseG1GC"]
  :scm {:name "git" :url "https://github.com/dunaj-project/core.rrb-vector"}
  :signing {:gpg-key "6A72CBE2"}
  :deploy-repositories [["clojars" {:creds :gpg}]]
  :profiles {:dev {:test-paths ["src/test_local/clojure"]
                   :dependencies [[org.clojure/clojurescript "0.0-3153"]
                                  [org.clojure/test.check "0.7.0"]
                                  [collection-check "0.1.5"]]
                   :plugins [[lein-cljsbuild "1.0.3"]]}
             :1.6 {:dependencies [[org.clojure/clojure "1.6.0"]]}
             :1.7 {:dependencies [[org.clojure/clojure "1.7.0-alpha5"]]}}
  :cljsbuild {:builds {:test {:source-paths ["src/main/cljs"
                                             "src/test/cljs"]
                              :compiler {:optimizations :advanced
                                         :output-to "out/test.js"}}}})
