(ns expriments.core
  (:require [clojure.math.numeric-tower :as mth]))

(defn collatz-basic [n]
  (if (< 0 n)
    (if (odd? n)
      (inc (* 3 n))
      (if (even? n)
        (/ n 2)))))
(defn format-line [n]
  "write n in decimal, binary, octal and hex and goes to a new line"
  (clojure.pprint/cl-format true "decimal ~d  binary ~b  octal ~o  hex ~x\n" n n n n))

(defn count-ones [n]
  (count (filter
          #{"1"}
          (clojure.string/split
           (clojure.pprint/cl-format nil "~b" 7)
           #""))))

;; (doseq [l (take 20 (iterate #(map collatz-basic %) (range 1 10)))]
;;   (println l))
