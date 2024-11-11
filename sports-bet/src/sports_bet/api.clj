(ns sports-bet.api
  (:require [clj-http.client :as client]
            [cheshire.core :as json]))

(def api-headers {:x-rapidapi-key "26a0903448mshb6ee91b73f997a7p1362d5jsnbd976f17f5f4"
                  :x-rapidapi-host "betano.p.rapidapi.com"})

(defn obter-esportes []
  (let [url "https://betano.p.rapidapi.com/sports"
        headers {:headers {:x-rapidapi-key "26a0903448mshb6ee91b73f997a7p1362d5jsnbd976f17f5f4"
                           :x-rapidapi-host "betano.p.rapidapi.com"}}
        response (client/get url headers)]
    (if (= 200 (:status response))
      (json/parse-string (:body response) true)
      (println "Erro ao obter esportes:" (:status response)))))

(defn obter-oddstypes [sport]
  (let [url "https://betano.p.rapidapi.com/oddstypes"
        response (client/get url {:headers api-headers :query-params {:sport sport}})]
    (if (= 200 (:status response))
      (json/parse-string (:body response) true)
      (println "Erro ao obter tipos de odds:" (:status response)))))

(defn obter-torneios [sport]
  (let [url "https://betano.p.rapidapi.com/tournaments"
        response (client/get url {:headers api-headers :query-params {:sport sport}})]
    (if (= 200 (:status response))
      (json/parse-string (:body response) true)
      (println "Erro ao obter torneios:" (:status response)))))

(defn obter-eventos [tournament-id]
  (let [url "https://betano.p.rapidapi.com/events"
        response (client/get url {:headers api-headers :query-params {:tournamentId tournament-id}})]
    (if (= 200 (:status response))
      (json/parse-string (:body response) true)
      (println "Erro ao obter eventos:" (:status response)))))

(defn obter-odds [event-id]
  (let [url "https://betano.p.rapidapi.com/odds_betano"
        response (client/get url {:headers api-headers :query-params {:eventId event-id
                                                                      :oddsFormat "decimal"
                                                                      :raw "false"}})]
    (if (= 200 (:status response))
      (json/parse-string (:body response) true)
      (println "Erro ao obter odds:" (:status response)))))