(ns forca.core
  (:gen-class))

(def total-de-vidas 6)

(defn perdeu [] (println "Voce perdeu"))
(defn ganhou [] (println "Voce ganhou"))

(defn letras-faltantes [palavra acertos]
  ; fazemos o (str letra) pois quando pega letra por letra da String
  ; esta letra vai ser um char
  (remove 
    (fn [letra] (contains? acertos (str letra))) 
    palavra))

(defn acertou-a-palavra-toda? [palavra acertos] 
  (empty? (letras-faltantes palavra acertos)))

(defn le-letra! [] (read-line))

(defn acertou? [chute palavra] (.contains palavra chute))

(defn jogo [vidas palavra acertos]
  (cond
   (= vidas 0) (perdeu)
   (acertou-a-palavra-toda? palavra acertos) (ganhou)
   :else
   (let [chute (le-letra!)]
    (if (acertou? chute palavra)
      (do
        (println "voce acertou!")
        (recur vidas palavra (conj acertos chute)))
      (do
        (println "voce errou!")
        (recur (dec vidas) palavra acertos))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
