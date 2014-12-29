(ns looping-is-recursion)

(defn power [base exp]
  (let [helper (fn [acc n]
                 (if (>= 1 n)
                   acc
                   (recur (* acc base) (dec n))))]
    (helper base exp)))

(defn last-element [a-seq]
  (let [helper (fn [a-sequence]
                 (if (or (= (count a-sequence) 1) (empty? a-sequence))
                   (first a-sequence)
                   (recur (rest a-sequence))))]
    (helper a-seq)))

(defn seq= [seq1 seq2]
  ":(")

(defn find-first-index [pred a-seq]
  ":(")

(defn avg [a-seq]
  -1)

(defn parity [a-seq]
  ":(")

(defn fast-fibo [n]
  ":(")

(defn cut-at-repetition [a-seq]
  [":("])

