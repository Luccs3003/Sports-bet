(ns sports-bet.apostas
  (:require [sports-bet.core :as core]
            [sports-bet.conta :as conta]))

(def registro-apostas (atom []))

(defn efetuar-aposta [valor]
  (conta/debito valor)
  (swap! registro-apostas conj valor))

(defn menu-apostas []
  (println "\n=== EFETUAR APOSTA ===")
  (println "Selecione a modalidade esportiva: ")
  (println "1. Futebol")
  (println "2. Counter-Strike")
  (println "3. Voltar")
  (def opcao (read-line))
  (case opcao
    "1" (do 
          (println "Selecione o mercado (Tipo): ")
          (println "1. Vencedor da Partida")
          (println "2. Resultado Correto da Partida")
          (println "3. Voltar"))
    "2" (do ())
    "3" (core/menu)
    (do (println "Opção inválida!") (menu-apostas))))