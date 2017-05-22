(defproject org.clojars.ndimiduk/reservoirsampler "0.1.0"
  :description "Reservoir Sampler extracted from Alex Holmes's Hadoop in
Practice repository."
  :url "https://github.com/ndimiduk/reservoirsampler"
  :license {:name "The Apache Software License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0.html"
            :distribution :repo}
  :min-lein-version "2.0.0"
  :source-paths []
  :java-source-paths ["src/main/java"]
  :resource-paths ["src/main/resources"]
  :test-paths ["src/test/java"]
  :target-path "target"
  :compile-path "target/classes"
  :javac-options ["-target" "1.5" "-source" "1.5"]
  :omit-source true
  :manifest {"Main-class" "com.manning.hip.ch4.sampler.SamplerJob"}
  :repositories [["apache release"
                  "https://repository.apache.org/content/repositories/releases/"]]
  :profiles {:provided {:dependencies [[org.apache.hadoop/hadoop-core "1.1.1"]]}})
