(defproject supersport "1"
  :description "An almost worthless utility library that aids with releasing projects that have single-segment version numbers."
  :url "https://github.com/tobias/supersport"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[supersport "1-SNAPSHOT"]]
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.7.0"]]}}
  :deploy-repositories [["releases" :clojars]]
  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "super.sport/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag"]
                  ["deploy"]
                  ["change" "version" "super.sport/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]])
