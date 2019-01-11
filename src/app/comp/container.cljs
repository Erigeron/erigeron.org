
(ns app.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo-ui.core :as ui]
            [respo.core
             :refer
             [defcomp cursor-> action-> mutation-> <> div button textarea span]]
            [respo.comp.space :refer [=<]]
            [reel.comp.reel :refer [comp-reel]]
            [respo-md.comp.md :refer [comp-md]]
            [app.config :refer [dev?]]))

(defcomp
 comp-container
 (reel)
 (let [store (:store reel), states (:states store)]
   (div
    {:style (merge ui/global ui/row {:padding 32})}
    (div
     {:style {:display :inline-block,
              :background-color (hsl 220 90 86),
              :line-height "64px",
              :padding "0 16px",
              :color :white,
              :cursor :pointer},
      :on-click (fn [e d! m!] (.open js/window "https://github.com/Erigeron"))}
     (<>
      "Erigeron is small explorations on designer tools."
      {:font-family ui/font-fancy, :font-size 24}))
    (when dev? (cursor-> :reel comp-reel states reel {})))))
