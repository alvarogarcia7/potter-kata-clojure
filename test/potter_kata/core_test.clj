(ns potter-kata.core-test
  (:require [clojure.test :refer :all]
            [potter-kata.core :refer :all]))

(defn price [x]
   (let [book-num (count x)
         book-price 8]
   (if (= 1 book-num)
     book-price
     (if (= 2 book-num)
       (* 0.95 (* 2 book-price))
       0))))

(deftest basket-tests
  (testing "empty basket"
    (let [basket []]
    (is (= 0 (price basket)))))

  (testing "1 book in the basket"
    (let [basket [5]]
    (is (= 8 (price basket)))))

  (testing "two different books offer a discount"
    (let [basket [4 5]]
    (is (= (* 0.95 16) (price basket)))))
  )



