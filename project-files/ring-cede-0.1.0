(defproject rm-hull/ring-cede "0.1.0"
  :description "Renders images and audio streams into a format palatable for ring."
  :url "https://github.com/rm-hull/ring-cede"
  :license {
    :name "The MIT License (MIT)"
    :url "http://opensource.org/licenses/MIT"}
  :dependencies [
    [org.clojure/clojure "1.8.0"]
    [compojure "1.5.0"]
    [ring "1.4.0"]]
  :scm {:url "git@github.com:rm-hull/ring-cede.git"}
  :plugins [
    [codox "0.9.4"] ]
  :source-paths ["src"]
  :jar-exclusions [#"(?:^|/).git"]
  :codox {
    :sources ["src"]
    :output-dir "doc/api"
    :src-dir-uri "http://github.com/rm-hull/ring-cede/blob/master/"
    :src-linenum-anchor-prefix "L" }
  :min-lein-version "2.6.1"
  :profiles {
    :dev {
      :global-vars {*warn-on-reflection* true}
      :dependencies [
        [digest "1.4.4"]]
      :plugins [
        [lein-cloverage "1.0.6"]]}})
