(ns adventofcode2017.day004
	(:require [adventofcode2017.core :as core]))


;;--- Day 4: High-Entropy Passphrases ---
;;===========================
;; part 1

(defn split-passphrase-by-space
	""
	[string]
	(clojure.string/split string #" "))

(defn passphrase1?
	""
	[coll]
	(= (count coll) (count (set coll))))


(defn high-entropy-passphrases-part1
	""
	[coll]
	(->> coll
		(map (fn [x] (->> x 
						(split-passphrase-by-space)
						(passphrase1?))))
		(filter true?)
		(count)))


;;===========================
;; part 2

(defn passphrase2?
	""
	[coll]
	(= (count coll) (count (set (map (fn [x] (clojure.string/join (sort x))) coll)))))


(defn high-entropy-passphrases-part2
	""
	[coll]
	(->> coll
		(map (fn [x] (->> x
						(split-passphrase-by-space)
						(passphrase2?))))
		(filter true?)
		(count)))
