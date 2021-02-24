(ns reverse-string
    (:use [clojure.string :only (blank?)]))

(defn reverse-string
  ([s] (reverse-string s ""))
  ([s acc]
   (if (blank? s)
     acc
     (recur (subs s 1 (count s)) (str (subs s 0 1) acc)))))
