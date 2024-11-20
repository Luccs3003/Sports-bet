(ns sports-bet.apostas
  (:require [sports-bet.conta :as conta]
            [sports-bet.listagem :as listagem]))

(def registro-apostas (atom []))

(defn efetuar-aposta [valor]
  (conta/debito valor)
  (swap! registro-apostas conj valor))

(defn menu-apostas []
  (println "\n=== EFETUAR APOSTA ===")
  (println "Selecione a modalidade esportiva: ")
  (listagem/listar-esportes)
  (println "3. Voltar")
  (def opcao (read-line))
  (case opcao
    "1" (do 
          (println "Voce selecionou Futebol")
          (println "Selecione o mercado (Tipo): ")
          (println "1. Vencedor da Partida")
          (println "2. Resultado Correto da Partida")
          (println "3. Voltar")
          (def opcao (read-line)))
    "2" (do
          (println "Você selecionou Counter Strike")
          (println "Selecione o mercado (Tipo): ")
          (println "1. Vencedor da Partida")
          (println "2. Resultado Correto da Partida")
          (println "3. Voltar")
          (def opcao (read-line)))
    "3" (println "Voltando..")
    (do (println "Opção invalida!") (menu-apostas))))