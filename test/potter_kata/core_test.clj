(ns potter-kata.core-test
  (:require [clojure.test :refer :all]
            [potter-kata.core :refer :all]))

(defn price [x]
  0)

(deftest basket-tests
  (testing "empty basket"
    (let [basket []]
    (is (= 1 (price basket))))
  ))
