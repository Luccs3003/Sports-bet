(ns sports-bet.core
  (:require [sports-bet.api :as api])
  (:gen-class))

(defn listar-esportes []
  (def esportes (api/obter-esportes))
    (println "Esportes disponíveis:")
    (dorun (map #(println (:name %)) (vals esportes))))

(defn menu []
  (println "\n=== MENU DE APOSTAS ESPORTIVAS ===")
  (println "1. Listar Esportes")
  (println "2. Sair")
  (print "Escolha uma opção:\n ")
  (def opcao (read-line))
    (case opcao
      "1" (do (listar-esportes) (menu))
      "2" (println "Saindo...")
      (do (println "Opção inválida!") (menu))))

(defn -main [& args]
  (menu))
