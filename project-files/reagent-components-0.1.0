(defproject meta-x/reagent-components "0.1.0"
  :description "A set of reusable components for Reagent."
  :url "https://github.com/meta-x/reagent-components"
  :license {
    :name "The MIT License"
    :url "http://opensource.org/licenses/MIT"
  }
  :deploy-repositories [
    ["clojars" {:sign-releases false}]
  ]

  :dependencies [
    [org.clojure/clojure "1.6.0"]
    [org.clojure/clojurescript "0.0-2311"]
    [reagent "0.4.3"]]

  :plugins [
    [lein-cljsbuild "1.0.4-SNAPSHOT"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds {
      ; :dev {
      ;   :source-paths ["src/"]
      ;   :compiler {
      ;     :output-to "reagent_components.dev.js"
      ;     :output-dir "out"
      ;     :optimizations :none
      ;     :source-map true
      ;   }
      ; }
      :prod {
        :jar true
        :source-paths ["src/"]
        :compiler {
          :output-to "reagent_components.js"
          :optimizations :advanced
          :elide-asserts true
          :pretty-print false
          :output-wrapper false
        }
      }
    }
  }
)
