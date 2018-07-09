(ns adventofcode2017.day001
	(:require [adventofcode2017.core :as core]))


;; --- Day 1: Inverse Captcha ---
;; part 1

(defn generate-coll-of-digits 
	""
	[number]
	(mapv #(- (byte %) (byte \0)) number))

(defn add-first-element-to-end-of-coll 
	""
	[coll]
	(conj coll (first coll)))

(defn partition-and-group-by-n-with-step
	""
	[n step coll]
	(partition n step coll))

(defn filter-by-same-element-in-subseq 
	""
	[coll]
	(filter (fn [x] (= (first x) (last x))) coll))

(defn get-first-element-from-all-subseq
	""
	[coll]
	(map (fn [x] (first x)) coll))

(defn inverse-captcha-part1
	""
	[number]
	(let 
		[n 2
		step 1
		partition-coll (partition-and-group-by-n-with-step n step
			(add-first-element-to-end-of-coll 
				(generate-coll-of-digits number)))]
		(reduce + 
			(get-first-element-from-all-subseq 
				(filter-by-same-element-in-subseq partition-coll)))))


;;===========================
;; part 2

(defn get-map-of-sum-of-same-element-at-same-index
	""
	[coll1 coll2]
	(map (fn [x y] (if (= x y) (+ x y) 0)) coll1 coll2))

(defn inverse-captcha-part2
	""
	[number]
	(let 
		[n (/ (count number) 2)
		step n
		partition-coll (partition-and-group-by-n-with-step n step
			(generate-coll-of-digits number))]
		(reduce 
			+ 
			(get-map-of-sum-of-same-element-at-same-index
				(first partition-coll) (last partition-coll)))))

