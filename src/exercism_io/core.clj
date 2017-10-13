(ns exercism-io.core
  (:require [clojurecademy.dsl.core :refer [manifest course]]))



(def my-manifest (manifest :title "Exercism.io"
                           :report-bug-email-or-link ""
                           :name 'exercism-io
                           :skip? true
                           :short-description "Exercism.io Clojure exercises"
                           :long-description "Learning to program is exhilarating and challenging... and also frustrating, exhausting, and overwhelming. Exercism(http://exercism.io) provides countless small wins. The exercises are achievable mini-quests: small and well-defined, and with enough complexity to uncover bite-sized knowledge gaps. The solutions you write provide reviewers with clues about what you haven't grasped yet. The feedback you receive will guide you to relevant study topics and dramatically increase the ease with which you write code."
                           :who-is-this-course-for :clojure-experience))

(def course-map (course my-manifest
                        ch-katas))