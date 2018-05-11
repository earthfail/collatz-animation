(ns expriments.renderer
  (:require [quil.core :as q]
            [expriments.computer :as computer])) 

(defn setup []
  (q/smooth)
  (q/frame-rate 1)
  (q/background 255)
  (q/no-fill)
  (q/text "Shit is going Down¡" 10 10)
  (def circle-group {1 [1 2 4 8 16 32]
                     2 [3 5 6 10 9 18 36]
                     3 [7 11 13 14]}))

(defn draw []
  (q/background 255)
  (q/translate (/ (q/width) 2) (/ (q/height) 2))
  (doseq [[radius elements] circle-group]
    (q/ellipse 0 0 (* 50 radius) (* 50 radius))
    (let [ang (/ q/TWO-PI (count elements))]
      (doall (map-indexed (fn [frac n]
                            (q/text (str n)
                                    (* radius (q/cos (* ang frac)))
                                    (* radius (q/sin (* ang frac)))))
                          elements)))))
