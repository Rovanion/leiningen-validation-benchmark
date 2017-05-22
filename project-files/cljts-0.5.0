(defproject org.clojars.diogok/cljts "0.5.0"
  :description "Clojure wrapper of JTS, implements the Simple Feature Spec of Open Geospatial Consortium (OGC)."
  :url "http://github.com/diogok/cljts"
  :license "Distributed under the Eclipse Public License, the same as Clojure."
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.vividsolutions/jts "1.13"]
                 [org.geotools/gt-geojson "14.4"]
                 [org.geotools/gt-geometry "14.4"]
                 [org.geotools/gt-epsg-hsql "14.4"]
                 [org.geotools/gt-referencing "14.4"]]
  :repositories [["osgeo" "http://download.osgeo.org/webdav/geotools/"]
                 ["clojars" {:sign-releases false}]]
  :profiles {:dev {:dependencies [[midje "1.8.2"]]
                   :plugins [[lein-midje "3.2"]]}}
  :warn-on-reflection true)
