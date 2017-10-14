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
                                                                         (is (throws? AssertionError (to-rna "XCGFGGTDTTAA")) :default :advanced)))))))))


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