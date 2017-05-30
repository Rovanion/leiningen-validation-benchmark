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
  (if (= (count a) 1)
    0.0
    (let [mn (mean a)]
      (Math/sqrt
       (/ (reduce #(+ %1 (square (- %2 mn))) 0 a)
          (dec (count a)))))))


(defn fn-over-maps
  "Benchmark fn over the given maps for the given number of samples."
  [validator-func project-maps samples]
  (println (format "%10s %10s %10s %10s %10s %10s"
                   "total" "min" "max" "mean" "median" "std-dev"))
  (for [m project-maps]
    (let [times (for [i (range samples)]
                  (time' (validator-func m)))
          sum   (apply + times)]
      (println (format "%10.5f %10.5f %10.5f %10.5f %10.5f %10.5f"
                         sum (apply min times) (apply max times) (mean times) (median times) (std-dev times))))))

(defn fn-over-maps-summary
  "Benchmark fn over the given files."
  [validator-func project-maps]
  (let [runs (for [m project-maps]
                  (time' (validator-func m)))
        times (filter number? runs)
        sum   (apply + times)]
    (println (format "%10s %10s %10s %10s %10s %10s"
                     "total" "min" "max" "mean" "median" "std-dev"))
    (println (format "%10.5f %10.5f %10.5f %10.5f %10.5f %10.5f"
                     sum (apply min times) (apply max times) (mean times) (median times) (std-dev times)))))

(defn value-sets [maps]
  (apply merge-with into (for [m maps, [k v] m] {k #{v}})))

(defn value-lists [maps]
  (apply merge-with into (for [m maps, [k v] m] {k (list v)})))

(defn per-keyword
  "Takes a timer-fn which should return a number representing the time
  it took to execute something given a key and a value. This function
  will them sumrize the results produced."
  [timer-fn project-maps project-keys]
  (println (format "%10s %10s %10s %10s %10s %10s"
                   "total" "min" "max" "mean" "median" "std-dev"))
  (let [merged-projects (value-lists project-maps)]
    (for [k project-keys]
      (let [runs  (for [v (get merged-projects k)]
                    (timer-fn k v))
            times (filter number? runs)
            sum   (apply + times)]
        (println (format "%10.5f %10.5f %10.5f %10.5f %10.5f %10.5f %s"
                         sum (apply min times) (apply max times) (mean times) (median times) (std-dev times) k))))))
