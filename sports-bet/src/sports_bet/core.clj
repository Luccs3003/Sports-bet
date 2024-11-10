(ns sports-bet.core
  (:require [sports-bet.api :as api]
            [sports-bet.conta :as conta]
            [sports-bet.apostas :as apostas])
  (:gen-class))

(defn modalidades-disponiveis [modalidade]
  (some #(= modalidade %) ["Soccer" "Counter Strike"]))

(defn listar-esportes [] 
  (let [esportes (api/obter-esportes)] 
    (let [modalidades-filtradas (filter #(modalidades-disponiveis (:name %)) (vals esportes))] 
      (dorun (map #(println (:name %)) modalidades-filtradas)))))

(defn menu []
  (println "\n=== MENU DE APOSTAS ESPORTIVAS ===")
  (println "1. Listar Esportes")
  (println "2. Gerenciar Conta")
  (println "3. Fazer Aposta")
  (println "4. Consultar Resultados")
  (println "5. Sair")
  (println "Escolha uma opção: ")
  (def opcao (read-line))
    (case opcao
      "1" (do (println "Esportes disponíveis:") (listar-esportes) (menu))
      "2" (do (conta/menu-conta) (menu))
      "3" (do (apostas/menu-apostas) (menu))
      "4" (do () (menu))
      "5" (println "Saindo...")
      (do (println "Opção inválida!") (menu))))

(defn -main [& args]
  (menu))