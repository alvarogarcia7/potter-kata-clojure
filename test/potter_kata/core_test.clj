(ns potter-kata.core-test
  (:require [clojure.test :refer :all]
            [potter-kata.core :refer :all]))

(defn price [x]
  (*
   (count x)
   8))

(deftest basket-tests
  (testing "empty basket"
    (let [basket []]
    (is (= 0 (price basket)))))

  (testing "1 book in the basket"
    (let [basket [5]]
    (is (= 8 (price basket)))))
  )
