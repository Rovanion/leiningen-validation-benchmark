(ns lein-validation-benchmark.reader
  (:require [clojure.java.io :as io]
            [clojure.walk :as walk])
  (:import (java.io PushbackReader Reader)))


(defn- unquote-project
  "Inside defproject forms, unquoting (~) allows for arbitrary evaluation."
  [args]
  (walk/walk (fn [item]
               (cond (and (seq? item) (= `unquote (first item))) (second item)
                     ;; needed if we want fn literals preserved
                     (or (seq? item) (symbol? item)) (list 'quote item)
                     :else (let [result (unquote-project item)]
                             ;; clojure.walk strips metadata
                             (if-let [m (meta item)]
                               (with-meta result m)
                               result))))
             identity
             args))

(defn- argument-list->argument-map
  [args]
  (let [keys (map first (partition 2 args))
        unique-keys (set keys)]
    (if (= (count keys) (count unique-keys))
      (apply hash-map args)
      (let [duplicates (->> (frequencies keys)
                            (remove #(> 2 (val %)))
                            (map first))]
        (throw
         (IllegalArgumentException.
          (format "Duplicate keys: %s"
                  (clojure.string/join ", " duplicates))))))))

(defmacro defproject
  "The project.clj file must either def a project map or call this macro.
  See `lein help sample` to see what arguments it accepts."
  [project-name version & args]
  `(def ~'project ~(unquote-project (argument-list->argument-map args))))

(defn read-raw
  "Read project file without loading certificates, plugins, middleware, etc."
  [source]
  (locking read-raw
    (binding [*ns* (find-ns 'lein-validation-benchmark.reader)]
      (try
        (if (instance? Reader source)
          (load-reader source)
          (load-file source))
        (catch Exception e
          (throw (Exception. (format "Error loading %s" source) e)))))
    (let [project (resolve 'lein-validation-benchmark.reader/project)]
      (when-not project
        (throw (Exception. (format "%s must define project map" source))))
      ;; return it to original state
      (ns-unmap 'lein-validation-benchmark.reader 'project)
      @project)))


(defn load-project-maps
  []
  (let [files (sort (rest (file-seq (clojure.java.io/file "project-files/"))))]
    (zipmap
     (map #(.getName %) files)
     (for [file files]
       (try
         (read-raw (.getAbsolutePath file))
         (catch clojure.lang.ExceptionInfo e
           (println "Validation failed for" (.getName file)))
         (catch java.lang.Exception e
           (println "Exception thrown:" (.getMessage e))))))))
