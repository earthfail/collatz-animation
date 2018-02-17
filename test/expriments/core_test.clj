(ns expriments.core-test
  (:require [clojure.test :refer :all]
            [expriments.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (and
         (= 1 (always1 10))
         (= 1 (always1 -1))
         (= 1 (always1 0))))))
