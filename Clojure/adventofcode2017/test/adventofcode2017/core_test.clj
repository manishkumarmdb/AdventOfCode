(ns adventofcode2017.core-test
  (:require [clojure.test :refer :all]
            [adventofcode2017.core :refer :all]
            [adventofcode2017.day001 :as day001]
            [adventofcode2017.day004 :as day004]
  			[adventofcode2017.day010 :as day010]))

;;
(def day001-input-path "./input/day001.txt")
(def day001-input (first (read-input-from-file day001-input-path)))

;;
(def day004-input-path "./input/day004.txt")
(def day004-input (read-input-from-file day004-input-path))

;;
(def day010-input-path "./input/day010.txt")
(def day010-input (first (read-input-from-file day010-input-path)))



;;
(deftest day001-part1
  (testing "FIXME, I fail."
    (is (= 1228 (day001/inverse-captcha-part1 day001-input)))))


(deftest day001-part2
  (testing "FIXME, I fail."
    (is (= 1238 (day001/inverse-captcha-part2 day001-input)))))


(deftest day004-part1
  (testing "FIXME, I fail."
    (is (= 325 (day004/high-entropy-passphrases-part1 day004-input)))))


(deftest day004-part2
  (testing "FIXME, I fail."
    (is (= 119 (day004/high-entropy-passphrases-part2 day004-input)))))


(deftest day010-part1
  (testing "FIXME, I fail."
    (is (= 37230 (day010/knot-hash-part1 (range 256) day010-input)))))


(deftest day010-part2
  (testing "FIXME, I fail."
    (is (= "70b856a24d586194331398c7fcfa0aaf" (day010/knot-hash-part2 (range 256) day010-input)))))
