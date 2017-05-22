(ns lein-validation-benchmark.benchmark
  (:require [lein-validation-benchmark.reader :as reader]))

(defmacro time'
  "Evaluates expr and prints the time it took.  Returns the value of
 expr."
  [expr]
  `(let [start# (. System (nanoTime))
         ret# ~expr]
     (/ (double (- (. System (nanoTime)) start#)) 1000000.0)))

(defn mean [coll]
  (let [sum (apply + coll)
        count (count coll)]
    (if (pos? count)
      (/ sum count)
            0)))

(defn median [coll]
  (let [sorted (sort coll)
        cnt (count sorted)
        halfway (quot cnt 2)]
    (if (odd? cnt)
      (nth sorted halfway)
      (let [bottom     (dec halfway)
            bottom-val (nth sorted bottom)
            top-val    (nth sorted halfway)]
        (mean [bottom-val top-val])))))


(def square #(* % %))

(defn std-dev
  [a]
  (let [mn (mean a)]
    (Math/sqrt
     (/ (reduce #(+ %1 (square (- %2 mn))) 0 a)
        (dec (count a))))))


(defn fn-with-files
  "Benchmark generation from the given keys over the given number of samples."
  [validator-func files samples]
  (println (format "%10s %10s %10s %10s %10s %10s"
                   "total" "min" "max" "mean" "median" "std-dev"))
  (for [file files]
    (try
      (let [times (for [i (range samples)]
                    (time' (validator-func (reader/read-raw (.getAbsolutePath file)))))
            sum   (apply + times)]
        (println (format "%10.5f %10.5f %10.5f %10.5f %10.5f %10.5f"
                         sum (apply min times) (apply max times) (mean times) (median times) (std-dev times)) (.getName file)))
      (catch clojure.lang.ExceptionInfo e
        (println "Validation failed for" (.getName file)))
      (catch java.io.IOException e
        (println "File not found:" (.getName file) )))))
