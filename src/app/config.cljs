
(ns app.config (:require [app.util :refer [get-env!]]))

(def cdn?
  (cond
    (exists? js/window) false
    (exists? js/process) (= "true" js/process.env.cdn)
    :else false))

(def dev?
  (let [debug? (do ^boolean js/goog.DEBUG)]
    (cond
      (exists? js/window) debug?
      (exists? js/process) (not= "true" js/process.env.release)
      :else true)))

(def site
  {:dev-ui "http://localhost:8100/main.css",
   :release-ui "http://cdn.tiye.me/favored-fonts/main.css",
   :cdn-url "http://cdn.tiye.me/respo-mvc.org/",
   :title "Respo: a virtual DOM library in ClojureScript",
   :icon "http://cdn.tiye.me/logo/respo.png",
   :storage-key "respo-site"})
