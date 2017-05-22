(defproject bosky101/tabela "0.1.0"
  :description "scheduled model dispatcher into kafka"
  :uberjar-exclusions [#"(?i)^META-INF/[^/]*\.(SF|RSA)$"]
  :url "https://github.com/bosky101/tabela"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/license/LICENSE-2.0.html"}
  :scm {:name "git"
        :url "https://github.com/bosky101/tabela"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-time "0.9.0"]
                 [im.chit/cronj "1.4.3"]]
  :pom-addition [:developers [:developer
                              [:name "Bosky Kode"]
                              [:url "https://github.com/bosky101"]
                              [:email "bosky101+github@gmail.com"]
                              [:timezone "-6"]]]
  :deploy-repositories [["clojars" {:creds :gpg}]]
  :global-vars {*warn-on-reflection* true}
  :documentation {:site   "tabela"
                  :output "docs"
                  :template {:path "template"
                             :copy ["assets"]
                             :defaults {:template     "article.html"
                                        :navbar       [:file "partials/navbar.html"]
                                        :dependencies [:file "partials/deps-web.html"]
                                        :navigation   :navigation
                                        :article      :article}}
                  :paths ["test/documentation"]
                  :files {"sample-document"
                          {:input "test/documentation/sample_document.clj"
                           :title "a sample document"
                           :subtitle "generating a document from code"}
                          "index"
                          {:input "test/documentation/tabela_guide.clj"
                           :title "tabela"
                           :subtitle "dive deeper into your code"}}
                  :link {:auto-tag    true
                         :auto-number  true}}
  :profiles {:dev {:dependencies []
                   :plugins [[lein-cloverage "1.0.6"]]}
             :test {:global-vars {*warn-on-reflection* false}}})
