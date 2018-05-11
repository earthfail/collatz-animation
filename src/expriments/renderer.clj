(ns expriments.renderer
  (:require [quil.core :as q]
            [expriments.computer :as computer])) 

(defn setup []
  (q/smooth)
  (q/frame-rate 1)
  (q/background 0)
  (q/text "Comic Sans" 10 10))

(defn draw []
  (q/background 50)
  (q/text "Comic Sans" 10 10)
  (q/translate (/ (q/width) 2) (/ (q/height) 2))
  (q/ellipse 0 0 20 20)
  (q/ellipse 50 50 30 30)
  (q/rect 0 100 25 25)
  (q/text "Khalti firnas" -100 30))
