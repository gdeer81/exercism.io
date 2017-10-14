(ns exercism-io.core
  (:require [clojurecademy.dsl.core :refer :all]
            [clojurecademy.dsl.test :refer :all]))



(def my-manifest (manifest :title "Exercism.io"
                           :report-bug-email-or-link "https://github.com/clojurecademy/exercism.io/issues"
                           :name 'exercism-io
                           :skip? true
                           :short-description "Exercism.io Clojure exercises"
                           :long-description "Learning to program is exhilarating and challenging... and also frustrating, exhausting, and overwhelming. Exercism(http://exercism.io) provides countless small wins. The exercises are achievable mini-quests: small and well-defined, and with enough complexity to uncover bite-sized knowledge gaps. The solutions you write provide reviewers with clues about what you haven't grasped yet. The feedback you receive will guide you to relevant study topics and dramatically increase the ease with which you write code."
                           :who-is-this-course-for :clojure-experience))


(def course-map
  (course my-manifest

          (chapter 'ch-exercism
                   "Exercism"

                   (sub-chapter 'sub-ch-all-exercises
                                "All exercises"

                                (subject 'subj-bob
                                         "Bob"

                                         (learn
                                           (text
                                             (p "Bob is a lackadaisical teenager. In conversation, his responses are very limited.")
                                             (p "Bob answers 'Sure.' if you ask him a question.")
                                             (p "He answers 'Whoa, chill out!' if you yell at him.")
                                             (p "He says 'Fine. Be that way!' if you address him without actually saying anything.")
                                             (p "He answers 'Whatever.' to anything else.")))

                                         (instruction 'ins-bob
                                                      (run-pre-tests? true)
                                                      (initial-code "(ns exercises.bob)\n\n(defn response-for\n  [phrase]\n  )")
                                                      (rule :no-rule? true)

                                                      (sub-instruction 'sub-ins-whatever

                                                                       (text
                                                                         (p "Returns " (bold "\"Whatever.\"") " if given phrase is one of the following inputs:")
                                                                         (p (italic "\"Tom-ay-to, tom-aaaah-to.\""))
                                                                         (p (italic "\"Let's go make out behind the gym!\""))
                                                                         (p (italic "\"It's OK if you don't want to go to the DMV.\""))
                                                                         (p (italic "\"Ending with ? means a question.\""))
                                                                         (p (italic "\"1, 2, 3\"")))

                                                                       (testing
                                                                         (is (= "Whatever." (response-for "Tom-ay-to, tom-aaaah-to.")) :default :advanced)
                                                                         (is (= "Whatever." (response-for "Let's go make out behind the gym!")) :default :advanced)
                                                                         (is (= "Whatever." (response-for "It's OK if you don't want to go to the DMV.")) :default :advanced)
                                                                         (is (= "Whatever." (response-for "Ending with ? means a question.")) :default :advanced)
                                                                         (is (= "Whatever." (response-for "1, 2, 3")) :default :advanced)))

                                                      (sub-instruction 'sub-ins-chill-out

                                                                       (text
                                                                         (p "Returns " (bold "\"Woah, chill out!\"") " if given phrase is one of the following inputs:")
                                                                         (p (italic "\"WATCH OUT!\""))
                                                                         (p (italic "\"WHAT THE HELL WERE YOU THINKING?\""))
                                                                         (p (italic "\"ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!\""))
                                                                         (p (italic "\"1, 2, 3 GO!\""))
                                                                         (p (italic "\"I HATE YOU\"")))

                                                                       (testing
                                                                         (is (= "Woah, chill out!" (response-for "WATCH OUT!")) :default :advanced)
                                                                         (is (= "Woah, chill out!" (response-for "WHAT THE HELL WERE YOU THINKING?")) :default :advanced)
                                                                         (is (= "Woah, chill out!" (response-for "ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!")) :default :advanced)
                                                                         (is (= "Woah, chill out!" (response-for "1, 2, 3 GO!")) :default :advanced)
                                                                         (is (= "Woah, chill out!" (response-for "I HATE YOU")) :default :advanced)))

                                                      (sub-instruction 'sub-ins-sure

                                                                       (text
                                                                         (p "Returns " (bold "\"Sure.\"") " if given phrase is one of the following inputs:")
                                                                         (p (italic "\"Does this cryogenic chamber make me look fat?\""))
                                                                         (p (italic "\"4?\"")))

                                                                       (testing
                                                                         (is (= "Sure." (response-for "Does this cryogenic chamber make me look fat?")) :default :advanced)
                                                                         (is (= "Sure." (response-for "4?")) :default :advanced)))

                                                      (sub-instruction 'sub-ins-fine

                                                                       (text
                                                                         (p "Returns " (bold "\"Fine. Be that way!\"") " if given phrase is one of the following inputs:")
                                                                         (p (italic "\"\""))
                                                                         (p (italic "\"      \"")))

                                                                       (testing
                                                                         (is (= "Fine. Be that way!" (response-for "")) :default :advanced)
                                                                         (is (= "Fine. Be that way!" (response-for "      ")) :default :advanced)))))

                                (subject 'subj-rna
                                         "Rna Transcription"

                                         (learn
                                           (text
                                             (p "Given a DNA strand, return its RNA complement (per RNA transcription).")
                                             (p "Both DNA and RNA strands are a sequence of nucleotides.")
                                             (p "The four nucleotides found in DNA are adenine (A), cytosine (C), guanine (G) and thymine (T).")
                                             (p "The four nucleotides found in RNA are adenine (A), cytosine (C), guanine (G) and uracil (U).")
                                             (p "Given a DNA strand, its transcribed RNA strand is formed by replacing each nucleotide with its complement:")
                                             (p (hi "G") " -> " (hi "C"))
                                             (p (hi "C") " -> " (hi "G"))
                                             (p (hi "T") " -> " (hi "A"))
                                             (p (hi "A") " -> " (hi "U"))))

                                         (instruction 'ins-rna
                                                      (run-pre-tests? true)
                                                      (initial-code "(ns exercises.rna)\n\n(defn to-rna\n  [x]\n  )")
                                                      (rule :no-rule? true)

                                                      (sub-instruction 'sub-ins-single-transform

                                                                       (text
                                                                         (code (= "G" (to-rna "C")))
                                                                         (code (= "C" (to-rna "G")))
                                                                         (code (= "U" (to-rna "A")))
                                                                         (code (= "A" (to-rna "T"))))

                                                                       (testing
                                                                         (is (= "G" (to-rna "C")) :default :advanced)
                                                                         (is (= "C" (to-rna "G")) :default :advanced)
                                                                         (is (= "U" (to-rna "A")) :default :advanced)
                                                                         (is (= "A" (to-rna "T")) :default :advanced)))

                                                      (sub-instruction 'sub-ins-multi-transform

                                                                       (text
                                                                         (code (= "UGCACCAGAAUU" (to-rna "ACGTGGTCTTAA"))))

                                                                       (testing
                                                                         (is (= "UGCACCAGAAUU" (to-rna "ACGTGGTCTTAA")) :default :advanced)))
                                                      (sub-instruction 'sub-ins-failed-transform

                                                                       (text
                                                                         (code (throws? AssertionError (to-rna "XCGFGGTDTTAA"))))

                                                                       (testing
                                                                         (is (throws? AssertionError (to-rna "XCGFGGTDTTAA")) :default :advanced)))))

                                (subject 'subj-collatz
                                         "Collatz Conjecture"

                                         (learn
                                           (text
                                             (p "The Collatz Conjecture or " (bold "3x+1") " problem can be summarized as follows:")
                                             (p "Take any positive integer n. If n is even, divide n by 2 to get n / 2. If n is odd, multiply n by 3 and add 1 to get 3n + 1. Repeat the process indefinitely. The conjecture states that no matter which number you start with, you will always reach 1 eventually.")
                                             (p "Given a number n, return the number of steps required to reach 1.")
                                             (p "Starting with n = 12, the steps would be as follows:")
                                             (code ";1.  12\n;2.  6\n;3.  3\n;4.  10\n;5.  5\n;6.  16\n;7.  8\n;8.  4\n;9.  2\n;10. 1")
                                             (p "Resulting in 9 steps. So for input n = 12, the return value would be 9.")))

                                         (instruction 'ins-collatz
                                                      (run-pre-tests? true)
                                                      (initial-code "(ns exercises.rna)\n\n(defn collatz\n  [x]\n  )")
                                                      (rule :no-rule? true)

                                                      (sub-instruction 'sub-ins-steps-for-1

                                                                       (text
                                                                         (p "Zero steps for one:")
                                                                         (code (= 0 (collatz 1))))

                                                                       (testing
                                                                         (is (= 0 (collatz 1)) :default :advanced)))

                                                      (sub-instruction 'sub-ins-steps-for-16

                                                                       (text
                                                                         (p "Divide if even:")
                                                                         (code (= 4 (collatz 16))))

                                                                       (testing
                                                                         (is (= 4 (collatz 16)) :default :advanced)))

                                                      (sub-instruction 'sub-ins-steps-for-12

                                                                       (text
                                                                         (p "Even and odd steps:")
                                                                         (code (= 9 (collatz 12))))

                                                                       (testing
                                                                         (is (= 9 (collatz 12)) :default :advanced)))

                                                      (sub-instruction 'sub-ins-steps-for-1000000

                                                                       (text
                                                                         (p "Large number of even and odd steps:")
                                                                         (code (= 152 (collatz 1000000))))

                                                                       (testing
                                                                         (is (= 152 (collatz 1000000)) :default :advanced)))

                                                      (sub-instruction 'sub-ins-steps-for-0-and-negative

                                                                       (text
                                                                         (p "Zero and negative value lead an error")
                                                                         (code (throws? IllegalArgumentException (collatz 0)))
                                                                         (code (throws? IllegalArgumentException (collatz -12))))

                                                                       (testing
                                                                         (is (throws? IllegalArgumentException (collatz 0)) :default :advanced)
                                                                         (is (throws? IllegalArgumentException (collatz -12)) :default :advanced)
                                                                         ))))

                                (subject 'subj-series
                                         "Series"

                                         (learn
                                           (text
                                             (p "Given a string of digits, output all the contiguous substrings of length " (hi "n") " in that string.")
                                             (p "For example, the string " (bold "\"49142\"") " has the following 3-digit series:")
                                             (p (bold "491"))
                                             (p (bold "914"))
                                             (p (bold "142"))
                                             (p "And the following 4-digit series:")
                                             (p (bold "4914"))
                                             (p (bold "9142"))
                                             (p "And if you ask for a 6-digit series from a 5-digit string, you deserve whatever you get.")
                                             (p "Note that these series are only required to occupy adjacent positions in the input; the digits need not be numerically consecutive.")))

                                         (instruction 'ins-series
                                                      (run-pre-tests? true)
                                                      (initial-code "(ns exercises.series)\n\n(defn slices\n  [x n]\n  )")
                                                      (rule :no-rule? true)

                                                      (sub-instruction 'sub-ins-series
                                                                       (text
                                                                         (code (= [] (slices "" 1)))
                                                                         (code (= [""] (slices "123" 0)))
                                                                         (code (= [] (slices "123" 1000)))
                                                                         (code (= ["123"] (slices "123" 3)))
                                                                         (code (= #{"123" "234" "345"} (set (slices "12345" 3)))))

                                                                       (testing
                                                                         (is (= [] (slices "" 1)) :default :advanced)
                                                                         (is (= [""] (slices "123" 0)) :default :advanced)
                                                                         (is (= [] (slices "123" 1000)) :default :advanced)
                                                                         (is (= ["123"] (slices "123" 3)) :default :advanced)
                                                                         (is (= #{"123" "234" "345"} (set (slices "12345" 3))) :default :advanced)))))))))


(defcoursetest test-1
               [ch-exercism sub-ch-all-exercises subj-bob ins-bob sub-ins-whatever]
               (defn response-for [phrase]
                 "Whatever."))

(defcoursetest test-2
               [ch-exercism sub-ch-all-exercises subj-bob ins-bob sub-ins-chill-out]
               (defn- shouting? [phrase]
                 (and (= (.toUpperCase phrase) phrase)
                      (re-find #"[a-zA-Z]+" phrase)))

               (defn response-for [phrase]
                 (cond
                   (shouting? phrase) "Woah, chill out!"
                   :else "Whatever.")))

(defcoursetest test-3
               [ch-exercism sub-ch-all-exercises subj-bob ins-bob sub-ins-sure]
               (defn- shouting? [phrase]
                 (and
                   (= (.toUpperCase phrase) phrase)
                   (re-find #"[a-zA-Z]+" phrase)))

               (defn- question? [phrase]
                 (.endsWith phrase "?"))

               (defn response-for [phrase]
                 (cond
                   (shouting? phrase) "Woah, chill out!"
                   (question? phrase) "Sure."
                   :else "Whatever.")))

(defcoursetest test-4
               [ch-exercism sub-ch-all-exercises subj-bob ins-bob sub-ins-fine]
               (defn- silence? [phrase]
                 (empty? (.trim phrase)))

               (defn- shouting? [phrase]
                 (and (not (silence? phrase))
                      (= (.toUpperCase phrase) phrase)
                      (re-find #"[a-zA-Z]+" phrase)))

               (defn- question? [phrase]
                 (.endsWith phrase "?"))

               (defn response-for [phrase]
                 (cond
                   (silence? phrase) "Fine. Be that way!"
                   (shouting? phrase) "Woah, chill out!"
                   (question? phrase) "Sure."
                   :else "Whatever.")))

(defcoursetest test-5
               [ch-exercism sub-ch-all-exercises subj-rna ins-rna sub-ins-single-transform]
               (defn to-rna [nucleotides]
                 (let [n (case nucleotides
                           "C" "G"
                           "G" "C"
                           "A" "U"
                           "T" "A"
                           (throw (AssertionError. "Not found nucleotides")))]
                   (clojure.string/replace nucleotides nucleotides n))))

(defcoursetest test-6
               [ch-exercism sub-ch-all-exercises subj-rna ins-rna sub-ins-multi-transform]
               (defn to-rna [nucleotides]
                 (apply str (map (fn [x]
                                   (let [x (str x)
                                         n (case x
                                             "C" "G"
                                             "G" "C"
                                             "A" "U"
                                             "T" "A")]
                                     (clojure.string/replace x x n))) (seq nucleotides)))))

(defcoursetest test-7
               [ch-exercism sub-ch-all-exercises subj-rna ins-rna sub-ins-failed-transform]
               (defn to-rna [nucleotides]
                 (apply str (map (fn [x]
                                   (let [x (str x)
                                         n (case x
                                             "C" "G"
                                             "G" "C"
                                             "A" "U"
                                             "T" "A"
                                             (throw (AssertionError. "Not found nucleotides")))]
                                     (clojure.string/replace x x n))) (seq nucleotides)))))

;;MOCK!!!!!!!!!
(defcoursetest test-8
               [ch-exercism sub-ch-all-exercises subj-collatz ins-collatz sub-ins-steps-for-1]
               (defn collatz
                 [x]
                 0))

(defcoursetest test-9
               [ch-exercism sub-ch-all-exercises subj-collatz ins-collatz sub-ins-steps-for-16]
               (defn collatz
                 [x]
                 (if (= 1 x)
                   0
                   4)))

(defcoursetest test-10
               [ch-exercism sub-ch-all-exercises subj-collatz ins-collatz sub-ins-steps-for-12]
               (defn collatz
                 [x]
                 (case x
                   1 0
                   16 4
                   12 9)))

(defcoursetest test-11
               [ch-exercism sub-ch-all-exercises subj-collatz ins-collatz sub-ins-steps-for-1000000]
               (defn collatz
                 [x]
                 (case x
                   1 0
                   16 4
                   12 9
                   1000000 152)))

(defcoursetest test-12
               [ch-exercism sub-ch-all-exercises subj-collatz ins-collatz sub-ins-steps-for-0-and-negative]
               (defn collatz
                 [x]
                 (case x
                   1 0
                   16 4
                   12 9
                   1000000 152
                   (throw (IllegalArgumentException. "Error")))))

(defcoursetest test-13
               [ch-exercism sub-ch-all-exercises subj-series ins-series sub-ins-series]
               (defn helper
                 [x n c]
                 (cond
                   (> n (count x))
                   []

                   (= n 0)
                   [""]

                   (seq x)
                   (conj (conj c (mapv #(apply str %) (into [] (partition n (seq x)))))
                         (helper (apply str (drop 1 x)) n c))

                   :else
                   c))

               (defn slices
                 [x n]
                 (flatten (helper x n []))))
