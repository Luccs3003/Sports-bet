(ns sports-bet.listagem
  (:require [sports-bet.api :as api]))

(defn modalidades-disponiveis [modalidade]
  (some #(= modalidade %) ["Soccer" "Counter Strike"]))

(defn listar-esportes []
  (let [esportes (api/obter-esportes)]
    (let [modalidades-filtradas (filter #(modalidades-disponiveis (:name %)) (vals esportes))]
      (dorun (map #(println (:name %)) modalidades-filtradas)))))