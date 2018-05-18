(ns expriments.renderer
  (:require [quil.core :as q]
            [expriments.computer :as computer])) 
(def scaler 100)
(defn setup []
  (q/smooth)
  (q/text-align :center :center)
  (q/frame-rate 1)
  ;; initial state
  {:circle-groups {1 [1 2 4 8 16 32]
                   2 [3 5 6 9 10 12 18 20 24 36]
                   3 [7 11 13 14 22 26 28]}
   :connections {1 [2],2 [4],3 [6],4 [1 8]
                 5 [10],6 [12],7 [14],8 [16]
                 9 [18],10 [3 20],11 [22],12 [24]
                 13 [26],14 [28]}})

(defn xy-number [circle-groups n]
  (let [level (computer/count-ones n)
        circle-elements (get circle-groups level)
        index (.indexOf circle-elements n)
        ang (* q/TWO-PI (/ index (count circle-elements)))]
    (map #(* scaler level %)
         (map #(% ang) [q/cos q/sin]))))

(defn update-state [state]
  state)
;; draw a line from start vector (sv) to end vector (ev) and make the
;; tip of arrow at ev
(defn arrow [sv ev]
  (q/line sv ev)
  (q/with-translation ev
    (let [[x y] (map - ev sv)
          len (q/mag x y)
          arr-len 10;(/ len 15 (q/sqrt 2))
          scale-fun (partial mapv #(* arr-len %))]
      (q/with-rotation [(q/atan2 y x)]
        (q/line [0 0] (scale-fun [-1 1]))
        (q/line [0 0] (scale-fun [-1 -1]))))))
;; (defn draw [{circle-groups :circle-groups
;;              connections :connections}]
;;   (q/background 50)
;;   (apply q/translate (map #(/ % 2) [(q/width) (q/height)]))
;;   (arrow [0 10] [50 0]))
;; draw: levels in circles, put numbers in their level ,order them
;; draw arrow from n to 3n+1 or n/2
(defn draw [{circle-groups :circle-groups
             connections :connections}]
  (q/background 255)
  (q/translate (/ (q/width) 2) (/ (q/height) 2))
  (doseq [[radius elements] circle-groups]
    (let [ang (/ q/TWO-PI (count elements))
          r (* scaler radius)]
      (q/no-fill)
      (q/ellipse 0 0 (+ 10  (* 2 r)) (+ 10  (* 2 r)))
      (q/fill 0)
      (doall (map-indexed (fn [frac n]
                            (q/text (str n)
                                    (*  r (q/cos (* ang frac)))
                                    (*  r (q/sin (* ang frac)))))
                          elements))))
  
  (doseq [[dist sources] connections]
    (let [pdist (xy-number circle-groups dist)]
      (doall (map (fn [n]
                    (arrow (xy-number circle-groups n) pdist))
                  sources)))))
