
(ns app.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo-ui.core :as ui]
            [respo.core
             :refer
             [defcomp cursor-> action-> list-> <> div button textarea span a]]
            [respo.comp.space :refer [=<]]
            [reel.comp.reel :refer [comp-reel]]
            [respo-md.comp.md :refer [comp-md]]
            [app.config :refer [dev?]]))

(def projects
  [{:name "Deviser",
    :demo "http://deviser.erigeron.org",
    :repo "https://github.com/Erigeron/deviser"}
   {:name "Bored Board",
    :demo "http://repo.erigeron.org/bored-board/",
    :repo "https://github.com/Erigeron/bored-board/"}])

(defcomp
 comp-container
 (reel)
 (let [store (:store reel), states (:states store)]
   (div
    {:style (merge ui/global {:padding 32})}
    (div
     {:style (merge ui/center)}
     (div
      {:style {:background-image "url(http://cdn.tiye.me/logo/erigeron.png)",
               :height 200,
               :width 200,
               :background-size :contain}})
     (div
      {:style {:display :inline-block, :line-height "64px", :padding "0 16px"}}
      (span
       {}
       (a
        {:style {:font-family ui/font-fancy, :font-size 20},
         :inner-text "Erigeron",
         :href "https://github.com/Erigeron",
         :target "_blank"})
       (<>
        " is small explorations on designer tools."
        {:font-family ui/font-fancy, :font-size 24})))
     (=< nil 80)
     (list->
      {}
      (->> projects
           (map
            (fn [project]
              [(:repo project)
               (div
                {:style {:background-color (hsl 200 80 90),
                         :padding 16,
                         :margin-bottom 32,
                         :min-width 320}}
                (a
                 {:style {:font-size 24},
                  :inner-text (:name project),
                  :href (:demo project),
                  :target "_blank"})
                (=< 16 nil)
                (a
                 {:style {:font-size 16},
                  :inner-text "Repo",
                  :href (:repo project),
                  :target "_blank"}))])))))
    (when dev? (cursor-> :reel comp-reel states reel {})))))
