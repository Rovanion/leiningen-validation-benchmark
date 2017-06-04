(ns lein-validation-benchmark.benchmark
  (:require [clojure.string                   :as string]
            [lein-validation-benchmark.reader :as reader]))

(def data-folder "plot/data/")

(defmacro time'
  "Evaluates expr and prints the time it took in milliseconds .
  Returns the value of expr."
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

(defn median-partition [coll]
  (let [n      (count coll)
        sorted (sort coll)
        i      (bit-shift-right n 1)]
    (if (even? n)
      [(/ (+ (nth sorted (dec i)) (nth sorted i)) 2)
       (take i sorted)
       (drop i sorted)]
      [(nth sorted (bit-shift-right n 1))
       (take i sorted)
       (drop (inc i) sorted)])))

(defn quartiles [coll]
  (when (>= (count coll) 2)
    (let [[m lower upper] (median-partition coll)]
      [(first (median-partition lower)) m (first (median-partition upper))])))

(defn square [n] (* n n))

(defn third  [s] (nth s 2))

(defn std-dev
  [a]
  (if (= (count a) 1)
    0.0
    (let [mn (mean a)]
      (Math/sqrt
       (/ (reduce #(+ %1 (square (- %2 mn))) 0 a)
          (dec (count a)))))))

(defn anglify [s]
  (string/replace s #"," "."))


(defn fn-over-maps
  "Benchmark fn over the given maps for the given number of samples."
  [validator-func project-maps samples]
  (println (format "%10s %10s %10s %10s %10s %10s"
                   "total" "min" "max" "mean" "median" "std-dev"))
  (for [m project-maps]
    (let [runs  (for [i (range samples)]
                  (time' (validator-func m)))
          times (filter number? runs)
          sum   (apply + times)]
      (println (format "%10.5f %10.5f %10.5f %10.5f %10.5f %10.5f"
                       sum (apply min times) (apply max times) (mean times) (median times) (std-dev times)))
      times)))

(defn fns-over-maps-summary
  "Pass the given project-maps to the fn's in fn-name-pars and time
  the fn's performance. Write the results to a file (str \"summary\"
  name) as specified by the string given as the second member of a
  fn-name-pair.

  Example invocation:
  (fn-over-maps-summary [{:a 1} {:a 2}] #(println %) \"println\")"
  [project-maps & fn-name-pairs]
  (spit (str data-folder "summary")
        (format "# %s %9s %10s %10s %10s %10s %12s %10s %s%n"
                    "id" "min""1st quart" "median" "3rd quart" "max" "sum" "std-dev" "name"))
  (doall (map-indexed
   (fn [i [validator-func name]]
     (let [runs   (for [m project-maps]
                    (time' (validator-func m)))
           times  (filter number? runs)
           minima (apply min times)
           maxima (apply max times)
           quart  (quartiles times)
           sum    (apply + times)]
       (spit (str data-folder "summary")
             (anglify
              (format "%3d %10.5f %10.5f %10.5f %10.5f %10.5f %12.5f %10.5f %s %n"
                      (inc i) minima (first quart) (second quart) (third quart) maxima sum (std-dev times) name))
             :append true)
       times))
   (partition 2 fn-name-pairs))))

(defn value-sets [maps]
  (apply merge-with into (for [m maps, [k v] m] {k #{v}})))

(defn value-lists [maps]
  (apply merge-with into (for [m maps, [k v] m] {k (list v)})))

(defn per-keyword
  "Takes a timer-fn which should return a number representing the time
  it took to execute something given a key and a value. This function
  will them sumrize the results produced."
  [timer-fn project-maps project-keys lib-name run-nr]
  ;; Empty files
  (spit (str data-folder "all-keywords-" lib-name)
        (format "#%s %5s %10s %10s %10s %10s %10s %12s %10s %s%n"
                "id" "count" "min""1st quart" "median" "3rd quart" "max" "sum" "std-dev" "name"))
  (when (= run-nr 1)
    (doseq [k project-keys]
      (spit (str data-folder "one-keyword-" (name k))
        (format "#%s %5s %10s %10s %10s %10s %10s %12s %10s %s%n"
                "id" "count" "min""1st quart" "median" "3rd quart" "max" "sum" "std-dev" "name"))))

  (let [merged-projects (value-lists project-maps)]
    (zipmap
     project-keys
     (map-indexed
      (fn [i k]
        (let [runs   (let [data-list (if (> (count (get merged-projects k)) 10)
                                       (get merged-projects k)
                                       (flatten (repeat 10 (get merged-projects k))))]
                       (for [v data-list]
                         (timer-fn k v)))
              times  (filter number? runs)
              minima (apply min times)
              maxima (apply max times)
              quart  (quartiles times)
              sum    (apply + times)
              result (anglify
                      (format "%5d %10.5f %10.5f %10.5f %10.5f %10.5f %12.5f %10.5f"
                              (count times) minima (first quart) (second quart) (third quart) maxima sum (std-dev times)))]
          (spit (str data-folder "all-keywords-" lib-name)
                (str (format "%3d " (inc i)) result " " k \newline)        :append true)
          (spit (str data-folder "one-keyword-" (name k))
                (str (format "%3d " run-nr)  result " " lib-name \newline) :append true)
          times))
      project-keys))))

(defn tprintln
  "Transparent print. Do a println and return the value being printed."
  [retval] (doto retval println))
