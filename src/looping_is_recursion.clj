(ns looping-is-recursion)

(defn power [base exp]
  (let [helper (fn [acc n]
                 (if (>= 1 n)
                   acc
                   (recur (* acc base) (dec n))))]
    (if (= exp 0)
      1
      (helper base exp))))

(defn last-element [a-seq]
  (let [helper (fn [a-sequence]
                 (if (or (= (count a-sequence) 1) (empty? a-sequence))
                   (first a-sequence)
                   (recur (rest a-sequence))))]
    (helper a-seq)))

(defn seq= [seq1 seq2]
  (let [helper (fn [a b]
                (cond
                 (and (empty? a) (empty? b)) true
                 (or (empty? a) (empty? b)) false
                 (not= (first a) (first b)) false
                 :else (recur (rest a) (rest b))))]
    (helper seq1 seq2)))

(defn find-first-index [pred a-seq]
  (loop [a-sequence a-seq
         index 0]
    (let [current (first a-sequence)]
    (cond
     (nil? current) nil
     (pred current) index
     :else (recur (rest a-sequence) (inc index))
    ))))

(defn avg [a-seq]
  (if (zero? (count a-seq))
    0
      (loop [a-sequence a-seq
           total 0]
      (let [current (first a-sequence)
            elements (count a-seq)]
        (if (nil? current)
          (/ total elements)
          (recur (rest a-sequence) (+ total current)))))))

(defn toggle [a-set elem]
  (if (contains? a-set elem)
    (disj a-set elem)
    (conj a-set elem)))

(defn parity [a-seq]
  (loop [a-sequence a-seq
         a-set #{}]
    (let [current (first a-sequence)]
      (if (nil? current)
        a-set
        (recur (rest a-sequence) (toggle a-set current))))))

(defn fast-fibo [n]
  (loop [index 0
         current 0
         next-fibo 1]
    (if (= index n)
      current
      (recur (inc index) next-fibo (+ current next-fibo)))))

(defn cut-at-repetition [a-seq]
  (loop [a-sequence a-seq
         a-set #{}
         result []]
  (let [cur (first a-sequence)]
    (if (or (contains? a-set cur)(nil? cur))
      result
      (recur (rest a-sequence) (conj a-set cur) (conj result cur))))))

