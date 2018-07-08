(ns adventofcode2017.day004)


;;--- Day 4: High-Entropy Passphrases ---
;;===========================
;; part 1

(def path "/home/manish/manish/manishkumarmdb@github/AdventOfCode/Clojure/adventofcode2017/input/day004.txt")

;;(def path (atom ""))


(defn read-input-and-put-in-seq-line-by-line
	""
	[path]
	(with-open [rdr (clojure.java.io/reader path
                             :append true
                             :encoding "UTF-8")]
		(doall (line-seq rdr))))

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
	[input-file-path]
	(->> input-file-path 
		(read-input-and-put-in-seq-line-by-line)
		(map (fn [x] (->> 
						x 
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
	[input-file-path]
	(->> input-file-path
		(read-input-and-put-in-seq-line-by-line)
		(map (fn [x] (->>
						x
						(split-passphrase-by-space)
						(passphrase2?))))
		(filter true?)
		(count)))
