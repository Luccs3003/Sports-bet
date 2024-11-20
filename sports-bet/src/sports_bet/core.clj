(ns sports-bet.core
  (:require [sports-bet.conta :as conta]
            [sports-bet.apostas :as apostas]
            [sports-bet.listagem :as listagem])
  (:gen-class))

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
      "1" (do (println "Esportes disponiveis:") (listagem/listar-esportes) (menu))
      "2" (do (conta/menu-conta) (menu))
      "3" (do (apostas/menu-apostas) (menu))
      "4" (do () (menu))
      "5" (println "Saindo...")
      (do (println "Opção invalida!") (menu))))

(defn -main [& args]
  (menu))