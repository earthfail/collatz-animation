(ns expriments.core
  (:require [quil.core :as q]
            [expriments.renderer :as renderer]))

(q/defsketch example                
  :title "Oh so many grey circles"
  :setup renderer/setup           
  :draw renderer/draw              
  :size [323 200])
