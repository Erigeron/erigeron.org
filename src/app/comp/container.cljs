
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
     (=< nil 40)
     (div
      {:style {:display :inline-block, :line-height "32px", :padding "0 16px"}}
      (span
       {}
       (a
        {:style {:font-family ui/font-fancy, :font-size 20},
         :inner-text "Erigeron",
         :href "https://github.com/Erigeron",
         :target "_blank"})
       (<>
        " is small explorations on designer tools."
        {:font-family ui/font-fancy, :font-size 18})))
     (=< nil 40)
     (list->
      {}
      (->> projects
           (map
            (fn [project]
              [(:repo project)
               (div
                {:style (merge
                         ui/row-parted
                         {:background-color "#fdf595",
                          :padding "16px 24px",
                          :margin-bottom 32,
                          :min-width 400})}
                (a
                 {:style {:font-family ui/font-fancy, :font-size 18, :text-decoration :none},
                  :inner-text (:name project),
                  :href (:demo project),
                  :target "_blank"})
                (=< 16 nil)
                (a
                 {:style {:font-size 13},
                  :inner-text "source",
                  :href (:repo project),
                  :target "_blank"}))])))))
    (when dev? (cursor-> :reel comp-reel states reel {})))))
