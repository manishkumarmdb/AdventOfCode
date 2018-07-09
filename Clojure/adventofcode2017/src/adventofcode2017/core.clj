(ns adventofcode2017.core
	(:gen-class))


(defn read-input-from-file
	""
	[path]
	(with-open [rdr (clojure.java.io/reader path
                             :append true
                             :encoding "UTF-8")]
		(doall (line-seq rdr))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
