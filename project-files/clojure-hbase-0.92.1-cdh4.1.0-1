(defproject org.clojars.aperiodic/clojure-hbase "0.92.1-cdh4.1.0-1"
  :description "A convenient Clojure interface to HBase."
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.apache.hadoop/hadoop-common "2.0.0-cdh4.1.0"]
                 [org.apache.hadoop/hadoop-core "2.0.0-mr1-cdh4.1.0"]
                 [org.apache.hbase/hbase "0.92.1-cdh4.1.0"]
                 [org.apache.zookeeper/zookeeper "3.3.3"]
                 [log4j/log4j "1.2.16" :exclusions [javax.mail/mail
                                                    javax.jms/jms
                                                    com.sun.jdmk/jmxtools
                                                    com.sun.jmx/jmxri]]
                 [org.clojure/tools.logging "0.2.3"]]
  :profiles {:clojure1.2 {:dependencies [[org.clojure/clojure "1.2.0"]]}
             :clojure1.3 {:dependencies [[org.clojure/clojure "1.3.0"]]}
             :hbase90 {:dependencies [[org.apache.hbase/hbase "0.90.5"]]}
             :hbase92 {:dependencies [[org.apache.hbase/hbase "0.92.1"]]}}
  :repositories {"cdh" ~(str "https://repository.cloudera.com/artifactory/"
                             "cloudera-repos/")})
