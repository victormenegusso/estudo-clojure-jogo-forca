(ns forca.core
  (:gen-class))

(def total-de-vidas 6)

(defn perdeu [] (print "Voce perdeu"))
(defn ganhou [] (print "Voce ganhou"))

(defn letras-faltantes [palavra acertos]
  ; fazemos o (str letra) pois quando pega letra por letra da String
  ; esta letra vai ser um char
  (remove 
    (fn [letra] (contains? acertos (str letra))) 
    palavra
  )
)

(defn acertou-a-palavra-toda? [palavra acertos] 
  (empty? (letras-faltantes palavra acertos))
)

(defn jogo [vidas palavra acertos]
  (if (= vidas 0)
    (perdeu)
    (if (acertou-a-palavra-toda? palavra acertos)
      (ganhou)
      (print "chuta novamente")
    )
  )
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
