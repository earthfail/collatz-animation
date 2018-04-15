(ns expriments.core
  (:require [clojure.math.numeric-tower :as mth]
            [clojure.pprint :as pprint]))

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
           (clojure.pprint/cl-format nil "~b" n)
           #""))))

;; (doseq [l (take 20 (iterate #(map collatz-basic %) (range 1 10)))]
;;   (println l))
(def hvf7-20 '([7 3] [22 3] [11 3] [34 2] [17 2] [52 3] [26 3] [13 3] [40 2] [20 2] [10 2] [5 2] [16 1] [8 1] [4 1] [2 1]))
(def lf7-20 '(7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2))
;; making data for drawing
;; some-num is the number of iterations and integer is the seed
(def base-list (take some-num (iterate collatz-basic integer)))
;; for every node change to binary representation and count how many ones are there
(def levels (map count-ones base-list))
;; get a list of levels but without repeating
(def distinct-levels (distinct levels))
;; count how many of each level is there
(map #(count (filter #{%} levels)) distinct-levels)

