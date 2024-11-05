(ns sports-bet.core
  (:require [sports-bet.api :as api]
            [sports-bet.conta :as conta])
  (:gen-class))

(defn listar-esportes []
  (def esportes (api/obter-esportes))
    (println "Esportes disponíveis:")
    (dorun (map #(println (:name %)) (vals esportes))))

(defn menu []
  (println "\n=== MENU DE APOSTAS ESPORTIVAS ===")
  (println "1. Listar Esportes")
  (println "2. Gerenciar Conta")
  (println "3. Sair")
  (print "Escolha uma opção:\n ")
  (def opcao (read-line))
    (case opcao
      "1" (do (listar-esportes) (menu))
      "2" (do (conta/menu-conta) (menu))
      "3" (println "Saindo...")
      (do (println "Opção inválida!") (menu))))

(defn -main [& args]
  (menu))
