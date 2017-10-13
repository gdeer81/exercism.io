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


(def course-map (course my-manifest

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
                                                                                       (p "Responds " (bold "\"Whatever.\"") " if given input is one of the following inputs:")
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
                                                                                       (is (= "Whatever." (response-for "1, 2, 3")) :default :advanced)))))))))

(defcoursetest test-1
               [ch-exercism sub-ch-all-exercises subj-bob ins-bob sub-ins-whatever]
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