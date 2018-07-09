(ns adventofcode2017.day010
	(:require [adventofcode2017.core :as core]))


;; --- Day 10: Knot Hash ---
;;===========================
;; part 1

;;(def input-lengths-list [147 37 249 1 31 2 226 0 161 71 254 243 183 255 30 70])

(defn input-lengths
	""
	[input]
	(mapv (fn [x] (Integer/parseInt x)) (clojure.string/split input #",")))

(defn rotate-coll-by-n-range 
	""
	[n coll]
	(let 
		[m (mod n (count coll))]
		(concat (drop m coll) (take m coll))))

(defn reverse-range-of-coll 
	""
	[n coll]
	(concat (reverse (take n coll)) (drop n coll)))

(defn binding-knot-hash
	""
	[[pos skip coll] length]
	[
	(+ pos skip length) 
	(inc skip) 
	(->> coll
		(rotate-coll-by-n-range pos)
		(reverse-range-of-coll length)
		(rotate-coll-by-n-range (- pos)))])


(defn get-final-coll
	""
	[coll input]
	(last 
		(reduce 
			binding-knot-hash [0 0 coll] input)))


(defn knot-hash-part1 
	""
	[coll input]
	(let 
		[input (input-lengths input)
		coll (get-final-coll coll input)]
		(* (first coll) (second coll))))


;;===========================
;; part 2

(defn knot-hash-part2 [coll input]
  (->> input
  	(map int)
  	(#(concat % [17, 31, 73, 47, 23]))
  	(repeat 64)
  	flatten
  	(get-final-coll coll)
  	(partition 16)
  	(map #(format "%02x" (reduce bit-xor %)))
  	clojure.string/join))

