(ns sports-bet.conta)

(def saldo (atom []))
(def registro-transacoes (atom []))

(defn deposito [valor]
  (swap! saldo conj valor))

(defn- consultar-saldo []
  (doall (println saldo)))

(defn menu-conta []
  (println "Entrou na conta")
  (println "\n=== GERENCIAR CONTA ===")
  (println "1. Fazer Depósito")
  (println "2. Consultar Saldo")
  (def opcao (read-line))
  (case opcao
    "1" (do (println "Digite o valor a ser depositado: ")
            (def valor (Integer/parseInt (read-line)))
            (deposito valor)
            (println (format "Você depositou: R$ %d,00" valor)))
    "2" (do 
          (print "Seu saldo é: ")
          (consultar-saldo))
    (do (println "Opção inválida!") (menu-conta))))