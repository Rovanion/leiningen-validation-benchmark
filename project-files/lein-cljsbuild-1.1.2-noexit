(defproject cprice404/lein-cljsbuild "1.1.2-noexit"
  :description "ClojureScript Autobuilder Plugin"
  :url "http://github.com/emezeske/lein-cljsbuild"
  :license
    {:name "Eclipse Public License - v 1.0"
     :url "http://www.eclipse.org/legal/epl-v10.html"
     :distribution :repo}
    :dependencies [; SNAPSHOT is intentional here, https://github.com/emezeske/lein-cljsbuild/issues/266
                   [lein-cljsbuild/cljs-compat "1.0.0-SNAPSHOT"]
                   [fs "1.1.2"]]
  :profiles {
    :dev {
      :dependencies [
        [midje "1.6.3"]
        [cljsbuild "1.1.2"]]
      :plugins [[lein-midje "3.1.3"]]}}

  :deploy-repositories [["releases" {:url "https://clojars.org/repo"
                                     :sign-releases false}]]

  :eval-in-leiningen true)
