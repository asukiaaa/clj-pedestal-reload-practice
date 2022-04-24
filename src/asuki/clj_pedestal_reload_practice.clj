(ns asuki.clj-pedestal-reload-practice
  (:gen-class)
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [ns-tracker.core :refer [ns-tracker]]))

(defn handler-top [req]
  {:status 200
   :body "hello world"})

(def main-route
  #{["/" :get handler-top :route-name :top]})

(def watched-namespaces
  (ns-tracker "src"))

;; define target-route out of function to relodable
(def target-route main-route)

(defn watched-target-route []
  (doseq [ns-sym (watched-namespaces)]
    #_(println "reload " ns-sym)
    (require ns-sym :reload))
  (route/expand-routes target-route))

(defn start-server [& args]
  (let [host "0.0.0.0"
        port 3000
        watch (when (some? args) (.contains args :watch))]
    (println (format "starting server as http://%s:%d" host port))
    (when watch (println "with watching"))
    (-> {::http/routes (if watch watched-target-route target-route)
         ::http/port 3000
         ::http/host host
         ::http/type :jetty}
        http/create-server
        http/start)))

(defn run-dev [& args]
  (start-server :watch))

(defn -main
  [& args]
  (start-server))
