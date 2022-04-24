(ns asuki.clj-pedestal-reload-practice
  (:gen-class)
  (:require [io.pedestal.http :as http]))

(defn handler-top [req]
  {:status 200
   :body "hello world"})

(def main-route
  #{["/" :get handler-top :route-name :top]})

(defn start-server []
  (let [host "0.0.0.0"
        port 3000]
    (println (format "starting server as http://%s:%d" host port))
    (-> {::http/routes main-route
         ::http/port 3000
         ::http/host host
         ::http/type :jetty}
        http/create-server
        http/start)))

(defn -main
  [& args]
  (start-server))
