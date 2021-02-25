(ns reverse-string
    (:use [clojure.string :only (blank?)]))

(defn reverse-string [s]
  (apply str (into () s)))
