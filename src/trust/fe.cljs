(ns+ trust.fe
  (:page
    "index.html")
  (:refer-clojure
    :exclude [-])
  (:require
    [javelin.core    :refer [defc defc= cell= cell]]
    [hoplon.core     :refer [defelem for-tpl when-tpl case-tpl]]
    [hoplon.ui       :refer [window elem frame image object video form line lines pick picks file files item s b]]
    [hoplon.ui.elems :refer [markdown]]
    [hoplon.ui.attrs :refer [- c r d]]))

;;; constants ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def icon-url   "https://fonts.googleapis.com/icon?family=Material+Icons")
(def font-url   "https://fonts.googleapis.com/css?family=RobotoDraft:400,500,700,400italic")

;;; model ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defc db {:session {:state :home}})

;;; queries ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defc= state (-> db :session :state))

;;; commands ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn swap-state! [state]
  (swap! db assoc-in [:session :state] state))

;;; styles ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;-- breakpoints ---------------------------------------------------------------;

(def sm 760)
(def md 1240)
(def lg 1480)

(defn >sm [& bks] (apply b (r 1 1) sm bks))

;-- sizes ---- ----------------------------------------------------------------;

(def gutter 6)

;-- colors --------------------------------------------------------------------;

(def black      (c 0x1F1F1F))
(def orange     (c 0xE73624))
(def blue       (c 0x009BFF))
(def yellow     (c 0xF5841F))
(def grey       (c 0x9E9E9E))
(def white      (c 0xFFFFFF))
(def grey-300   (c 0xE0E0E0))
(def font-black (c 0x333333))

;-- fonts ---------------------------------------------------------------------;

(def menu-font {:f 28 :ff "opensans" :ft :800 :fc :black :fw 1})

;;; views ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(window
  :title "Trust"
  (elem :sh (r 1 1) :ah :mid :c grey-300 :bt 8 :bc grey
    (elem :sh (>sm md) :p 50 :gv 50 :a :mid
      (image :s 400 :m :pointer :click #(swap-state! :home) :url "BrookeLaw-logo-2color.png")
      (elem :sh (>sm (- (r 1 1) (+ 0 10))) :p 10 :g 10 :ah :end
        (elem :sh (>sm :auto) :ah :mid :m :pointer menu-font "Accounts")
        (elem :sh (>sm :auto) :ah :mid :m :pointer menu-font "Matters")
        (elem :sh (>sm :auto) :ah :mid :m :pointer menu-font "Shared")
        (elem :sh (>sm :auto) :ah :mid :m :pointer menu-font "Trust")))))








