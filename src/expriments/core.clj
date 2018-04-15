(ns expriments.core
  (:require [clojure.math.numeric-tower :as mth]))


;;----------------NEW SHIP------------------------------------
(import 
  '(java.awt Rectangle Dimension Robot Toolkit)
  '(java.awt.image BufferedImage)
  '(java.io File IOException)
  '(javax.imageio ImageIO))
;; note never use M-q to organize code
(defn take-screenshot [] (let [screen (.getScreenSize
  (Toolkit/getDefaultToolkit)) rt (new Robot) img
  (.createScreenCapture rt (new Rectangle (int (.getWidth screen))
  (int (.getHeight screen))))] (ImageIO/write img "jpg" (new File (str
  "resources/pics/" (System/currentTimeMillis) ".jpg")))))

;; (take-screenshot)
;;----------------NEW SHIP------------------------------------
(defn tail-fact
  ([n] (tail-fact n 1))
  ([n accum]
   (if (zero? n)
     accum
     (tail-fact (dec n) (*' n accum)))))

(defn e-to-n [n]
  (reduce +'
          (map #(/ (mth/expt Math/E %)) (range 1 n))))
;;----------------NEW SHIP------------------------------------
(defn collatz-basic [n]
  (if (< 0 n)
    (if (odd? n)
      (inc (* 3 n))
      (if (even? n)
        (/ n 2)))))
(defn format-line [n]
  "write n in decimal, binary, octal and hex and goes to a new line"
  (cl-format true "decimal ~d  binary ~b  octal ~o  hex ~x\n" n n n n))
(doseq [l (take 20 (iterate #(map collatz-basic %) (range 1 10)))]
  (println l))
(defn count-ones [n]
  (count (filter
          {"1"}
          (clojure.string/split
           (cl-format nil "~b" n)
           #"d"))))
