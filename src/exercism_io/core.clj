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
                                                      (run-pre-tests? false)
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
                                                                         (is (= #{"123" "234" "345"} (set (slices "12345" 3))) :default :advanced)))))

                                (subject 'subj-phone-number
                                         "Phone Number"

                                         (learn
                                           (text
                                             (p "Clean up user-entered phone numbers so that they can be sent SMS messages.")
                                             (p "The " (bold "North American Numbering Plan (NANP)") " is a telephone numbering system used by many countries in North America like the United States, Canada or Bermuda. All NANP-countries share the same international country code: " (hi "1") ".")
                                             (p "NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan Area code, commonly known as area code, followed by a seven-digit local number. The first three digits of the local number represent the " (italic "exchange code") ", followed by the unique four-digit number which is the subscriber number.")
                                             (p "The format is usually represented as:")
                                             (p (hi "(NXX)-NXX-XXXX\n"))
                                             (p "where " (hi "N") " is any digit from 2 through 9 and " (hi "X") " is any digit from 0 through 9.")
                                             (p "Your task is to clean up differently formated telephone numbers by removing punctuation and the country code (1) if present.")
                                             (p "For example, the inputs:")
                                             (p (hi "+1 (613)-995-0253"))
                                             (p (hi "613-995-0253"))
                                             (p (hi "1 613 995 0253"))
                                             (p (hi "613.995.0253"))
                                             (p "should all produce the output:")
                                             (p (hi "6139950253"))
                                             (p (bold "Note:") " As this exercise only deals with telephone numbers used in NANP-countries, only 1 is considered a valid country code.")))

                                         (instruction 'ins-phone-number
                                                      (run-pre-tests? true)
                                                      (initial-code "(ns exercises.phone-number)\n\n(defn number\n  [x]\n  )\n\n(defn area-code\n  [x]\n  )\n\n(defn pretty-print\n  [x]\n  )")
                                                      (rule :no-rule? true)

                                                      (sub-instruction 'sub-ins-cleans

                                                                       (text
                                                                         (code (= "1234567890" (number "(123) 456-7890")))
                                                                         (code (= "1234567890" (number "123.456.7890"))))

                                                                       (testing
                                                                         (is (= "1234567890" (number "(123) 456-7890")) :default :advanced)
                                                                         (is (= "1234567890" (number "123.456.7890")) :default :advanced)))

                                                      (sub-instruction 'sub-ins-valid

                                                                       (text
                                                                         (code (= "1234567890" (number "11234567890"))))

                                                                       (testing
                                                                         (is (= "1234567890" (number "11234567890")) :default :advanced)))

                                                      (sub-instruction 'sub-ins-invalid-when-9-or-11-digits

                                                                       (text
                                                                         (code (= "0000000000" (number "123456789")))
                                                                         (code (= "0000000000" (number "21234567890"))))

                                                                       (testing
                                                                         (is (= "0000000000" (number "123456789")) :default :advanced)
                                                                         (is (= "0000000000" (number "21234567890")) :default :advanced)))

                                                      (sub-instruction 'sub-ins-area-code

                                                                       (text
                                                                         (code (= "123" (area-code "1234567890"))))

                                                                       (testing
                                                                         (is (= "123" (area-code "1234567890")) :default :advanced)))

                                                      (sub-instruction 'sub-ins-pretty-print

                                                                       (text
                                                                         (code (= "(123) 456-7890" (pretty-print "1234567890")))
                                                                         (code (= "(123) 456-7890" (pretty-print "11234567890"))))

                                                                       (testing
                                                                         (is (= "(123) 456-7890" (pretty-print "1234567890")) :default :advanced)
                                                                         (is (= "(123) 456-7890" (pretty-print "11234567890")) :default :advanced)))))

                                (subject 'subj-leap-year
                                         "Leap Year"

                                         (learn
                                           (text
                                             (p "Given a year, report if it is a leap year.")
                                             (p "The tricky thing here is that a leap year in the Gregorian calendar occurs:")
                                             (p (hi "on every year that is evenly divisible by 4"))
                                             (p (hi "except every year that is evenly divisible by 100"))
                                             (p (hi "unless the year is also evenly divisible by 400"))
                                             (p "For example, 1997 is not a leap year, but 1996 is. 1900 is not a leap year, but 2000 is.")))
                                         (instruction 'ins-leap
                                                      (run-pre-tests? false)
                                                      (initial-code "(ns exercises.leap-year)\n\n(defn leap-year?\n  [year]\n  )")
                                                      (rule :no-rule? true)

                                                      (sub-instruction 'sub-ins-leap
                                                                       (text
                                                                         (code (true? (leap-year? 1996)))
                                                                         (code (false? (leap-year? 1997)))
                                                                         (code (false? (leap-year? 1900)))
                                                                         (code (true? (leap-year? 2400))))

                                                                       (testing
                                                                         (is (true? (leap-year? 1996)) :default :advanced)
                                                                         (is (false? (leap-year? 1997)) :default :advanced)
                                                                         (is (false? (leap-year? 1900)) :default :advanced)
                                                                         (is (true? (leap-year? 2400)) :default :advanced)))))

                                (subject 'subj-roman
                                         "Roman Numerals"

                                         (learn
                                           (text
                                             (p "Write a function to convert from normal numbers to Roman Numerals.")
                                             (p "The Romans were a clever bunch. They conquered most of Europe and ruled it for hundreds of years. They invented concrete and straight roads and even bikinis. One thing they never discovered though was the number zero. This made writing and dating extensive histories of their exploits slightly more challenging, but the system of numbers they came up with is still in use today. For example the BBC uses Roman numerals to date their programmes.")
                                             (p "The Romans wrote numbers using letters - I, V, X, L, C, D, M. (notice these letters have lots of straight lines and are hence easy to hack into stone tablets).")
                                             (p (hi "1  => I"))
                                             (p (hi "10  => X"))
                                             (p (hi "7  => VII"))
                                             (p "There is no need to be able to convert numbers larger than about 3000. (The Romans themselves didn't tend to go any higher)")
                                             (p "Wikipedia says: Modern Roman numerals ... are written by expressing each digit separately starting with the left most digit and skipping any digit with a value of zero.")
                                             (p "To see this in practice, consider the example of 1990.")
                                             (p "In Roman numerals 1990 is MCMXC:")
                                             (p "1000=M 900=CM 90=XC")
                                             (p "2008 is written as MMVIII:")
                                             (p "2000=MM 8=VIII")))

                                         (instruction 'ins-roman
                                                      (run-pre-tests? true)
                                                      (initial-code "(ns exercises.roman-numerals)\n\n(defn numerals\n  [n]\n  )")
                                                      (rule :no-rule? true)

                                                      (sub-instruction 'sub-ins-up-to-4
                                                                       (text
                                                                         (code (= "I" (numerals 1)))
                                                                         (code (= "II" (numerals 2)))
                                                                         (code (= "III" (numerals 3))))

                                                                       (testing
                                                                         (is (= "I" (numerals 1)) :default :advanced)
                                                                         (is (= "II" (numerals 2)) :default :advanced)
                                                                         (is (= "III" (numerals 3)) :default :advanced)))

                                                      (sub-instruction 'sub-ins-5ish
                                                                       (text
                                                                         (code (= "IV" (numerals 4)))
                                                                         (code (= "V" (numerals 5)))
                                                                         (code (= "VI" (numerals 6))))

                                                                       (testing
                                                                         (is (= "IV" (numerals 4)) :default :advanced)
                                                                         (is (= "V" (numerals 5)) :default :advanced)
                                                                         (is (= "VI" (numerals 6)) :default :advanced)))

                                                      (sub-instruction 'sub-ins-X
                                                                       (text
                                                                         (code (= "IX" (numerals 9)))
                                                                         (code (= "XXVII" (numerals 27)))
                                                                         (code (= "XLVIII" (numerals 48)))
                                                                         (code (= "LIX" (numerals 59))))

                                                                       (testing
                                                                         (is (= "IX" (numerals 9)) :default :advanced)
                                                                         (is (= "XXVII" (numerals 27)) :default :advanced)
                                                                         (is (= "XLVIII" (numerals 48)) :default :advanced)
                                                                         (is (= "LIX" (numerals 59)) :default :advanced)))

                                                      (sub-instruction 'sub-ins-C
                                                                       (text
                                                                         (code (= "XCIII" (numerals 93)))
                                                                         (code (= "CXLI" (numerals 141)))
                                                                         (code (= "CLXIII" (numerals 163)))
                                                                         (code (= "CDII" (numerals 402)))
                                                                         (code (= "DLXXV" (numerals 575))))

                                                                       (testing
                                                                         (is (= "XCIII" (numerals 93)) :default :advanced)
                                                                         (is (= "CXLI" (numerals 141)) :default :advanced)
                                                                         (is (= "CLXIII" (numerals 163)) :default :advanced)
                                                                         (is (= "CDII" (numerals 402)) :default :advanced)
                                                                         (is (= "DLXXV" (numerals 575)) :default :advanced)))

                                                      (sub-instruction 'sub-ins-M
                                                                       (text
                                                                         (code (= "CMXI" (numerals 911)))
                                                                         (code (= "MXXIV" (numerals 1024)))
                                                                         (code (= "MMM" (numerals 3000))))

                                                                       (testing
                                                                         (is (= "CMXI" (numerals 911)) :default :advanced)
                                                                         (is (= "MXXIV" (numerals 1024)) :default :advanced)
                                                                         (is (= "MMM" (numerals 3000)) :default :advanced)))))

                                (subject 'subj-gigasecond
                                         "Gigasecond"

                                         (learn
                                           (text
                                             (p "Calculate the moment when someone has lived for " (hi "10ˆ9") " seconds.")
                                             (p "A gigasecond is " (hi "10ˆ9") " (1,000,000,000) seconds.")))

                                         (instruction 'ins-giga
                                                      (run-pre-tests? false)
                                                      (initial-code "(ns exercises.gigasecond)\n\n(defn gigasecond\n  [year month day]\n  )")
                                                      (rule :no-rule? true)

                                                      (sub-instruction 'sub-ins-giga
                                                                       (text
                                                                         (code (= [2043 1 1] (gigasecond 2011 4 25)))
                                                                         (code (= [2009 2 19] (gigasecond 1977 6 13)))
                                                                         (code (= [1991 3 27] (gigasecond 1959 7 19))))

                                                                       (testing
                                                                         (is (= [2043 1 1] (gigasecond 2011 4 25)) :default :advanced)
                                                                         (is (= [2009 2 19] (gigasecond 1977 6 13)) :default :advanced)
                                                                         (is (= [1991 3 27] (gigasecond 1959 7 19)) :default :advanced)))))

                                (subject 'subj-grains
                                         "Grains"

                                         (learn
                                           (text
                                             (p "Calculate the number of grains of wheat on a chessboard given that the number on each square doubles.")
                                             (p "There once was a wise servant who saved the life of a prince. The king promised to pay whatever the servant could dream up. Knowing that the king loved chess, the servant told the king he would like to have grains of wheat. One grain on the first square of a chess board. Two grains on the next. Four on the third, and so on.")

                                             (p "There are 64 squares on a chessboard.")
                                             (p "Write code that shows: " (bold "how many grains were on each square, and the total number of grains"))))

                                         (instruction 'ins-grains
                                                      (run-pre-tests? true)
                                                      (initial-code "(ns exercises.grains)\n\n(defn square\n  [n]\n  )\n\n(defn total\n  []\n  )")
                                                      (rule :no-rule? true)

                                                      (sub-instruction 'sub-ins-grains
                                                                       (text
                                                                         (code (= 1 (square 1)))
                                                                         (code (= 2 (square 2)))
                                                                         (code (= 4 (square 3)))
                                                                         (code (= 8 (square 4)))
                                                                         (code (= 32768 (square 16)))
                                                                         (code (= 2147483648 (square 32)))
                                                                         (code (= 9223372036854775808 (square 64))))

                                                                       (testing
                                                                         (is (= 1 (square 1)) :default :advanced)
                                                                         (is (= 2 (square 2)) :default :advanced)
                                                                         (is (= 4 (square 3)) :default :advanced)
                                                                         (is (= 8 (square 4)) :default :advanced)
                                                                         (is (= 32768 (square 16)) :default :advanced)
                                                                         (is (= 2147483648 (square 32)) :default :advanced)
                                                                         (is (= 9223372036854775808 (square 64)) :default :advanced)))

                                                      (sub-instruction 'sub-ins-grains-total
                                                                       (text
                                                                         (code (= 18446744073709551615 (total))))

                                                                       (testing
                                                                         (is (= 18446744073709551615 (total)) :default :advanced)))))

                                (subject 'subj-triangle
                                         "Triangle"


                                         (learn
                                           (text
                                             (p "Determine if a triangle is equilateral, isosceles, or scalene.")
                                             (p "An " (italic "equilateral") " triangle has all three sides the same length.")
                                             (p "An " (italic "isosceles") " triangle has at least two sides the same length. (It is sometimes specified as having exactly two sides the same length, but for the purposes of this exercise we'll say at least two.)")
                                             (p "A " (italic "scalene") " triangle has all sides of different lengths.")

                                             (p "For a shape to be a triangle at all, all sides have to be of length > 0, and the sum of the lengths of any two sides must be greater than or equal to the length of the third side. See " (link "Triangle Inequality" "https://en.wikipedia.org/wiki/Triangle_inequality") ".")))

                                         (instruction 'ins-triangle
                                                      (run-pre-tests? true)
                                                      (initial-code "(ns exercises.triangle)\n\n(defn triangle-type\n  [a b c]\n  )")
                                                      (rule :no-rule? true)

                                                      (sub-instruction 'sub-ins-equilateral
                                                                       (text
                                                                         (code (= :equilateral (triangle-type 2 2 2)))
                                                                         (code (= :equilateral (triangle-type 10 10 10))))


                                                                       (testing
                                                                         (is (= :equilateral (triangle-type 2 2 2)) :default :advanced)
                                                                         (is (= :equilateral (triangle-type 10 10 10)) :default :advanced)))

                                                      (sub-instruction 'sub-ins-isosceles
                                                                       (text
                                                                         (code (= :isosceles (triangle-type 3 4 4)))
                                                                         (code (= :isosceles (triangle-type 4 3 4))))


                                                                       (testing
                                                                         (is (= :isosceles (triangle-type 3 4 4)) :default :advanced)
                                                                         (is (= :isosceles (triangle-type 4 3 4)) :default :advanced)))

                                                      (sub-instruction 'sub-ins-scalene
                                                                       (text
                                                                         (code (= :scalene (triangle-type 3 4 5))))


                                                                       (testing
                                                                         (is (= :scalene (triangle-type 3 4 5)) :default :advanced)))

                                                      (sub-instruction 'sub-ins-invalid
                                                                       (text
                                                                         (code (= :illogical (triangle-type 1 1 50)))
                                                                         (code (= :illogical (triangle-type 1 2 1)))
                                                                         (code (= :illogical (triangle-type 2 4 2))))


                                                                       (testing
                                                                         (is (= :illogical (triangle-type 1 1 50)) :default :advanced)
                                                                         (is (= :illogical (triangle-type 1 2 1)) :default :advanced)
                                                                         (is (= :illogical (triangle-type 2 4 2)) :default :advanced)))))))))


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

(defcoursetest test-14
               [ch-exercism sub-ch-all-exercises subj-phone-number ins-phone-number sub-ins-cleans]
               (def length 10)
               (def bad-number (apply str (repeat length "0")))

               (defn- clean
                 [number]
                 (clojure.string/replace number #"[^0-9]+" ""))

               (defn- phone-with-us-or-ca-country-code?
                 [digits]
                 (and (= (count digits) (+ length 1))
                      (= (subs digits 0 1) "1")))

               (defn number
                 [digits]
                 (let [digits (clean digits)]
                   (cond
                     (= (count digits) length) digits
                     (= (phone-with-us-or-ca-country-code? digits) true) (subs digits 1)
                     :else bad-number))))

(defcoursetest test-15
               [ch-exercism sub-ch-all-exercises subj-phone-number ins-phone-number sub-ins-valid]
               (def length 10)
               (def bad-number (apply str (repeat length "0")))

               (defn- clean
                 [number]
                 (clojure.string/replace number #"[^0-9]+" ""))

               (defn- phone-with-us-or-ca-country-code?
                 [digits]
                 (and (= (count digits) (+ length 1))
                      (= (subs digits 0 1) "1")))

               (defn number
                 [digits]
                 (let [digits (clean digits)]
                   (cond
                     (= (count digits) length) digits
                     (= (phone-with-us-or-ca-country-code? digits) true) (subs digits 1)
                     :else bad-number))))

(defcoursetest test-16
               [ch-exercism sub-ch-all-exercises subj-phone-number ins-phone-number sub-ins-invalid-when-9-or-11-digits]
               (def length 10)
               (def bad-number (apply str (repeat length "0")))

               (defn- clean
                 [number]
                 (clojure.string/replace number #"[^0-9]+" ""))

               (defn- phone-with-us-or-ca-country-code?
                 [digits]
                 (and (= (count digits) (+ length 1))
                      (= (subs digits 0 1) "1")))

               (defn number
                 [digits]
                 (let [digits (clean digits)]
                   (cond
                     (= (count digits) length) digits
                     (= (phone-with-us-or-ca-country-code? digits) true) (subs digits 1)
                     :else bad-number))))

(defcoursetest test-17
               [ch-exercism sub-ch-all-exercises subj-phone-number ins-phone-number sub-ins-area-code]
               (def length 10)
               (def bad-number (apply str (repeat length "0")))

               (defn- clean
                 [number]
                 (clojure.string/replace number #"[^0-9]+" ""))

               (defn- phone-with-us-or-ca-country-code?
                 [digits]
                 (and (= (count digits) (+ length 1))
                      (= (subs digits 0 1) "1")))

               (defn number
                 [digits]
                 (let [digits (clean digits)]
                   (cond
                     (= (count digits) length) digits
                     (= (phone-with-us-or-ca-country-code? digits) true) (subs digits 1)
                     :else bad-number)))

               (defn area-code
                 [digits]
                 (subs (number digits) 0 3)))

(defcoursetest test-18
               [ch-exercism sub-ch-all-exercises subj-phone-number ins-phone-number sub-ins-pretty-print]
               (def length 10)
               (def bad-number (apply str (repeat length "0")))

               (defn- clean
                 [number]
                 (clojure.string/replace number #"[^0-9]+" ""))

               (defn- phone-with-us-or-ca-country-code?
                 [digits]
                 (and (= (count digits) (+ length 1))
                      (= (subs digits 0 1) "1")))

               (defn number
                 [digits]
                 (let [digits (clean digits)]
                   (cond
                     (= (count digits) length) digits
                     (= (phone-with-us-or-ca-country-code? digits) true) (subs digits 1)
                     :else bad-number)))

               (defn area-code
                 [digits]
                 (subs (number digits) 0 3))

               (defn- exchange
                 [digits]
                 (subs (number digits) 3 6))

               (defn- subscriber
                 [digits]
                 (subs (number digits) 6))

               (defn pretty-print
                 [digits]
                 (format "(%s) %s-%s" (area-code digits) (exchange digits) (subscriber digits))))

(defcoursetest test-19
               [ch-exercism sub-ch-all-exercises subj-leap-year ins-leap sub-ins-leap]
               (defn- divisible-by? [a b]
                 (zero? (mod a b)))

               (defn leap-year? [year]
                 (cond
                   (divisible-by? year 400) true
                   (divisible-by? year 100) false
                   (divisible-by? year 4) true
                   :else false)))

(defcoursetest test-20
               [ch-exercism sub-ch-all-exercises subj-roman ins-roman sub-ins-up-to-4]
               (def ^:private conversions
                 (sorted-map-by >
                                1000 "M"
                                900 "CM"
                                500 "D"
                                400 "CD"
                                100 "C"
                                90 "XC"
                                50 "L"
                                40 "XL"
                                10 "X"
                                9 "IX"
                                5 "V"
                                4 "IV"
                                1 "I"))

               (defn- amount->numerals [[output total] amount numeral]
                 (let [times (quot total amount)]
                   [(apply str output (repeat times numeral))
                    (rem total amount)]))

               (defn numerals [number]
                 (->> conversions
                      (reduce-kv amount->numerals ["" number])
                      (first))))

(defcoursetest test-21
               [ch-exercism sub-ch-all-exercises subj-roman ins-roman sub-ins-5ish]
               (def ^:private conversions
                 (sorted-map-by >
                                1000 "M"
                                900 "CM"
                                500 "D"
                                400 "CD"
                                100 "C"
                                90 "XC"
                                50 "L"
                                40 "XL"
                                10 "X"
                                9 "IX"
                                5 "V"
                                4 "IV"
                                1 "I"))

               (defn- amount->numerals [[output total] amount numeral]
                 (let [times (quot total amount)]
                   [(apply str output (repeat times numeral))
                    (rem total amount)]))

               (defn numerals [number]
                 (->> conversions
                      (reduce-kv amount->numerals ["" number])
                      (first))))

(defcoursetest test-22
               [ch-exercism sub-ch-all-exercises subj-roman ins-roman sub-ins-X]
               (def ^:private conversions
                 (sorted-map-by >
                                1000 "M"
                                900 "CM"
                                500 "D"
                                400 "CD"
                                100 "C"
                                90 "XC"
                                50 "L"
                                40 "XL"
                                10 "X"
                                9 "IX"
                                5 "V"
                                4 "IV"
                                1 "I"))

               (defn- amount->numerals [[output total] amount numeral]
                 (let [times (quot total amount)]
                   [(apply str output (repeat times numeral))
                    (rem total amount)]))

               (defn numerals [number]
                 (->> conversions
                      (reduce-kv amount->numerals ["" number])
                      (first))))

(defcoursetest test-23
               [ch-exercism sub-ch-all-exercises subj-roman ins-roman sub-ins-C]
               (def ^:private conversions
                 (sorted-map-by >
                                1000 "M"
                                900 "CM"
                                500 "D"
                                400 "CD"
                                100 "C"
                                90 "XC"
                                50 "L"
                                40 "XL"
                                10 "X"
                                9 "IX"
                                5 "V"
                                4 "IV"
                                1 "I"))

               (defn- amount->numerals [[output total] amount numeral]
                 (let [times (quot total amount)]
                   [(apply str output (repeat times numeral))
                    (rem total amount)]))

               (defn numerals [number]
                 (->> conversions
                      (reduce-kv amount->numerals ["" number])
                      (first))))

(defcoursetest test-24
               [ch-exercism sub-ch-all-exercises subj-roman ins-roman sub-ins-M]
               (def ^:private conversions
                 (sorted-map-by >
                                1000 "M"
                                900 "CM"
                                500 "D"
                                400 "CD"
                                100 "C"
                                90 "XC"
                                50 "L"
                                40 "XL"
                                10 "X"
                                9 "IX"
                                5 "V"
                                4 "IV"
                                1 "I"))

               (defn- amount->numerals [[output total] amount numeral]
                 (let [times (quot total amount)]
                   [(apply str output (repeat times numeral))
                    (rem total amount)]))

               (defn numerals [number]
                 (->> conversions
                      (reduce-kv amount->numerals ["" number])
                      (first))))


(defcoursetest test-25
               [ch-exercism sub-ch-all-exercises subj-gigasecond ins-giga sub-ins-giga]
               (def ^:private ->seconds
                 (bigint (Math/pow 10 9)))

               (defn- build-offset-cal [year month day offset]
                 (doto (java.util.Calendar/getInstance)
                   (.set year (dec month) day 0 0 offset)))

               (defn- cal->date-vec [cal]
                 [(.get cal java.util.Calendar/YEAR)
                  (inc (.get cal java.util.Calendar/MONTH))
                  (.get cal java.util.Calendar/DAY_OF_MONTH)])

               (defn gigasecond [year month day]
                 (-> (build-offset-cal year month day ->seconds)
                     cal->date-vec)))

(defcoursetest test-26
               [ch-exercism sub-ch-all-exercises subj-grains ins-grains sub-ins-grains]
               (defn- expt [number exponent]
                 (if (= exponent 0)
                   1
                   (apply * (repeat exponent number))))

               (defn square [number]
                 (expt (bigint 2) (- number 1))))

(defcoursetest test-27
               [ch-exercism sub-ch-all-exercises subj-grains ins-grains sub-ins-grains-total]
               (defn- expt [number exponent]
                 (if (= exponent 0)
                   1
                   (apply * (repeat exponent number))))

               (defn square [number]
                 (expt (bigint 2) (- number 1)))

               (defn total []
                 (- (square 65) 1)))

(defcoursetest test-28
               [ch-exercism sub-ch-all-exercises subj-triangle ins-triangle sub-ins-equilateral]
               (defn- valid? [a b c]
                 (and (> (+ a b) c)
                      (> (+ b c) a)
                      (> (+ c a) b)))

               (defn- isosceles? [a b c]
                 (or (= a b)
                     (= b c)
                     (= c a)))

               (defn triangle-type [a b c]
                 (cond
                   (= a b c) :equilateral)))

(defcoursetest test-29
               [ch-exercism sub-ch-all-exercises subj-triangle ins-triangle sub-ins-isosceles]
               (defn- valid? [a b c]
                 (and (> (+ a b) c)
                      (> (+ b c) a)
                      (> (+ c a) b)))

               (defn- isosceles? [a b c]
                 (or (= a b)
                     (= b c)
                     (= c a)))

               (defn triangle-type [a b c]
                 (cond
                   (= a b c) :equilateral
                   (isosceles? a b c) :isosceles)))

(defcoursetest test-30
               [ch-exercism sub-ch-all-exercises subj-triangle ins-triangle sub-ins-scalene]
               (defn- valid? [a b c]
                 (and (> (+ a b) c)
                      (> (+ b c) a)
                      (> (+ c a) b)))

               (defn- isosceles? [a b c]
                 (or (= a b)
                     (= b c)
                     (= c a)))

               (defn triangle-type [a b c]
                 (cond
                   (= a b c) :equilateral
                   (isosceles? a b c) :isosceles
                   :else :scalene)))

(defcoursetest test-31
               [ch-exercism sub-ch-all-exercises subj-triangle ins-triangle sub-ins-invalid]
               (defn- valid? [a b c]
                 (and (> (+ a b) c)
                      (> (+ b c) a)
                      (> (+ c a) b)))

               (defn- isosceles? [a b c]
                 (or (= a b)
                     (= b c)
                     (= c a)))

               (defn triangle-type [a b c]
                 (cond
                   (= a b c) :equilateral
                   (not (valid? a b c)) :illogical
                   (isosceles? a b c) :isosceles
                   :else :scalene)))