(ns data
  (require [datomic.api :as d]))

(def uri "datomic:mem://trust-account")

(d/create-database uri)

(def conn (d/connect uri))



