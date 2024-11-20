(ns sports-bet.conta)

(def saldo (atom 0))
(def registro-transacoes (atom []))

(defn deposito [valor]
  (swap! saldo + valor)
  (swap! registro-transacoes conj valor))

(defn debito [valor]
  (swap! saldo - valor)
  (swap! registro-transacoes conj valor))

(defn consultar-saldo []
  (println @saldo))

(defn menu-conta []
  (println "Entrou na conta")
  (println "\n=== GERENCIAR CONTA ===")
  (println "1. Fazer Deposito")
  (println "2. Consultar Saldo")
  (def opcao (read-line))
  (case opcao
    "1" (do (println "Digite o valor a ser depositado: ")
            (def valor (Integer/parseInt (read-line)))
            (deposito valor)
            (println "Operacao Concluida!")
            (println (format "Você depositou: R$ %d,00" valor)))
    "2" (do 
          (print "Seu saldo: R$ ")
          (consultar-saldo))
    (do (println "Opcao invalida!") (menu-conta))))