(ns potter-kata.core-test
  (:require [clojure.test :refer :all]
            [potter-kata.core :refer :all]))

(defn price [x]
   (let [book-num (count x)
         book-price 8
         different-books (count (keys (group-by identity x)))
         total-price (* book-price book-num)
         discount (* total-price 0.05 (dec different-books))]
     (if (> discount total-price)
       total-price
       (- total-price discount))))

(deftest basket-tests
  (testing "empty basket"
    (let [basket []]
    (is (= 0. (price basket)))))

  (testing "1 book in the basket"
    (let [basket [5]]
    (is (= 8. (price basket)))))

  (testing "two different books offer a discount"
    (let [basket [4 5]]
    (is (= (* 0.95 16) (price basket)))))

  (testing "two same books doesn't offer a discount"
    (let [basket [4 4]]
    (is (= 16. (price basket)))))

  (testing "three different books should offer 10% discount on them"
    (let [basket [1 2 3]]
    (is (= (* 0.9 24) (price basket)))))


  (testing "four different books should offer 20% discount on them"
    (let [basket [1 2 3 4]]
    (is (= (* 0.80 32) (price basket)))))
)
; counts how many different books there are
(count (keys (group-by identity '(1 3 3))))

(let [basket [4 4]] (price basket))

(price [1 2 3])
(* 0.9 24)

(price [4 2])
