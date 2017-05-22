  (defproject gov.usgs.eros/lcmap-commons "1.0.0"
   :parent-project {
                    :coords [gov.usgs.eros/lcmap-system "1.0.0-SNAPSHOT"]
                    :inherit [
                              :deploy-repositories
                              :license
                              :managed-dependencies
                              :plugins
                              :pom-addition
                              :repositories
                              :target]}
      ;; XXX The following can be un-commented once this issue is resolved:
      ;;     * https://github.com/achin/lein-parent/issues/3
      ;; [:profiles [:uberjar :dev]]

   :description "LCMAP Commons"
   :url "https://github.com/USGS-EROS/lcmap-commons"
   :dependencies [[org.clojure/clojure]
                  [org.clojure/core.match]
                  [org.clojure/data.codec]
                  [org.clojure/data.json]
                  [org.clojure/data.xml]
                  [org.clojure/core.memoize]
                   ;; Error Handling
                  [dire]
                  [slingshot]
                   ;; Dev and project metadata
                  [leiningen-core]
                  ;; for lcmap-commons/time
                  [clj-time/clj-time]]
   :plugins [[lein-parent "0.3.0"]]
   :repl-options {:init-ns lcmap.commons.dev}
   :codox {
           :project {:name "lcmap.commons"
                     :description "Base common library for lcmap"}
           :namespaces [#"^lcmap.commons\."]
           :output-path "docs/master/current"
           :doc-paths ["docs/source"]
           :metadata {:doc/format :markdown
                      :doc "Documentation forthcoming"}}
   :profiles {
              :uberjar {:aot :all}
              ;; configuration for dev environment -- if you need to make local changes,
              ;; copy `:env { ... }` into `{:user ...}` in your ~/.lein/profiles.clj and
              ;; then override values there
              :dev {
                    :dependencies [[org.clojure/tools.namespace "0.3.0-alpha3"]]
                    :aliases {}
                    :source-paths ["dev-resources/src"]}})
