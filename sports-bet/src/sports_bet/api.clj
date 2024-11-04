(ns sports-bet.api
  (:require [clj-http.client :as client]
            [cheshire.core :as json]))

(defn obter-esportes []
  (let [url "https://betano.p.rapidapi.com/sports"
        headers {:headers {:x-rapidapi-key "26a0903448mshb6ee91b73f997a7p1362d5jsnbd976f17f5f4"
                           :x-rapidapi-host "betano.p.rapidapi.com"}}
        response (client/get url headers)]
    (if (= 200 (:status response))
      (json/parse-string (:body response) true)
      (println "Erro ao obter esportes:" (:status response)))))
