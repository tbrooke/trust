(set-env!
  :source-paths #{"src"}
  :asset-paths  #{"assets"}
  :dependencies '[
                  [adzerk/boot-cljs          "1.7.228-2"]
                  [adzerk/boot-reload        "0.4.13"]
                  [hoplon/hoplon             "6.0.0-alpha17"]
                  [org.clojure/clojure       "1.8.0"]
                  [com.datomic/datomic-free "0.9.5407"]
                  [hoplon/ui                 "0.1.0-SNAPSHOT"]
                  [tailrecursion/boot-jetty  "0.1.3"]
                  [org.clojure/clojurescript "1.9.293"]])

(require
 '[adzerk.boot-cljs          :refer [cljs]]
 '[adzerk.boot-reload        :refer [reload]]
 '[hoplon.boot-hoplon        :refer [hoplon prerender]]
 '[tailrecursion.boot-jetty :refer [serve]])

(deftask dev
  "Build trust for local development."
  []
  (comp
    (watch)
    (speak)
    (hoplon)
    (reload)
    (cljs)
    (serve :port 8000)))

(deftask prod
  "Build trust for production deployment."
  []
  (comp
    (hoplon)
    (cljs :optimizations :advanced)
    (target :dir #{"target"})))
