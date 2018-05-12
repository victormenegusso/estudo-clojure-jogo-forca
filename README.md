# jogo forca

Projeto de um jogo de forca em Clojure para começar a aprender a linguagem. (não terminei ainda)

## Iniciando 

Para desenvolver foi utilizado o Leiningen (ajuda a criar projetos em clojure).

## Leiningen

### instalando

 - https://leiningen.org/
 - baixe o script lein
 - adicione em path
 - execute ( baixa tudo automatico )

### criando o projeto

```
lein new app forca
```

### executando o projeto

dentro do path do projeto executar:

```
lein repl
```

caso mude o fonte para recarregar o código:
(recarrega um namespace)

```
(require '[forca.core :as forca] :reload)
```

## Notas ( estudo )


```
# soma
(+ 1 2)

# definindo uma "variavel" 
(def idade 29)

# definindo uma funcao
(defn somador [x,y] (+ x y) )

# comparando se é igual
(= 10 10)

# diferente
(not= 20 10)

# definindo um conjunto
#{"A" "B"}

# conjunto -> contains
(contains? conjunto "C")

# conjunto add (devolve um novo conjunto)
(conj conjunto "X")

# conjunto remove (devolve um novo conjunto)
(disj conjunto "X")

# processando uma lista com 'map' (multiplacando cada um por 2)
(def lista [1 2 3])
(map (fn [x] (* x 2)) lista)

# removendo itens de um lista passando funçao 'remove'
(remove FUNCAO_X lista)

# [nomeclatura de funções] terminando com ? -> retornam booleano

# [nomeclatura de funções] terminando com ! -> mudam o estado da aplicação (le do teclado/HD  salva em um BD)

```

### Funções recursivas e recursão de cauda

No exemplo abaixo o a função jogo se chama varias vezes, e isso faz com que a pilha de execução cresça.

```
(defn jogo [vidas palavra acertos]
    (cond
        (=vidas 0) (perdeu)
        (acertou-a-palavra-toda? palavra acertos) (ganhou)
        :else   
        (let [chute (le-letra!)]
            (if (acertou? chute palavra)
                (do
                    (println "Acertou a letra!")
                    (jogo vidas palavra (conj acertos chute)))
                (do
                    (println "Errou a letra! Perdeu vida!")
                    (jogo (dec vidas) palavra acertos))))))
```
Em programação funcional existe um conceito que chamamos de recursão de cauda, que se a última linha de código da função chama ela mesma, então o compilador é inteligente o suficiente para não fazer os vários empilhamentos. Usamos recur no lugar do nome da função:

```
(defn jogo [vidas palavra acertos]
    (cond
        (=vidas 0) (perdeu)
        (acertou-a-palavra-toda? palavra acertos) (ganhou)
        :else   
        (let [chute (le-letra!)]
            (if (acertou? chute palavra)
                (do
                    (println "Acertou a letra!")
                    (recur vidas palavra (conj acertos chute)))
                (do
                    (println "Errou a letra! Perdeu vida!")
                    (recur (dec vidas) palavra acertos))))))
```

### Links

https://programming-pages.com/2012/01/23/loops-in-clojure/


## License

Copyright © 2017

Distributed under the Eclipse Public License either version 1.0.
