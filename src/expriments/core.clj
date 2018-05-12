(ns expriments.core
  (:require [quil.core :as q]
            [expriments.renderer :as renderer]
            [quil.middleware :as m]))

(q/defsketch example
  :title "my collatz solution"
  :setup renderer/setup
  :draw renderer/draw
  :update renderer/update-state
  :size [400 400]
  :middleware [m/fun-mode]
  :features [:resizable])
