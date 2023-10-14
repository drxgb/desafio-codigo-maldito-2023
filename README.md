# DESAFIO CÓDIGO MALDITO
### Evento de Hallloween do Condado Braveheart 2023

Este repositório mostra a solução do desafio **Código Maldito**, ocorrido no período do mês de Outubro no fórum [Condado Braveheart](https://condadobraveheart.com/forums/). O participante teve o direito de apresentar a solução em 1 (um) ou 3 (três) paradigmas de Programação:

- Estruturada
- Orientada a Objetos
- Funcional

Neste repositório, serão apresentadas as 3 soluções em 3 linguagens de programação diferentes, respectivamente:

- C
- Java
- Haskell

## Descrição do desafio
Um grupo de crianças encontrou uma caixa com diversos brinquedos para se divertirem no Halloween. Nessa caixa eles encontraram:

- Aranhas de plástico
- Sapos de borracha
- Dentaduras
- Fantasminhas que brilham no escuro
- Bruxinhas

**JC**, **Hellen**, **Franklin**, **Daniel** e **Samuel** gostaram da caixa e decidiram distribuir os brinquedos de acordo com seus gostos. Mas como Samuel é um menino que gosta criar brincadeira com qualquer coisa com seus amigos e resolveu propor um pequeno jogo para eles. Mas antes disso, Samuel resolveu colocar seus amigos em uma fila de frente à caixa, na seguinte ordem:

- Samuel
- Franklin
- Hellen
- JC
- Daniel
  
Feito isso, Samuel sempre retirará um brinquedo da caixa e o brinquedo será passado para as crianças de mão em mão, respeitando a ordem da fila até uma delas pegar o brinquedo que ela gosta. Se a criança receber um brinquedo que ela gosta, pegará para ela e guardará em sua mochila. Se o brinquedo é aquele que a criança não gosta, passa para a próxima que está atrás.
Abaixo, temos informações importantes para descobrir qual brinquedo cada criança gosta.

1. Hellen gosta de Fantasminhas que brilham no escuro.
2. Daniel nunca vai receber Bruxinhas.
3. Franklin não gosta de Bruxinhas.
4. As outras crianças nunca receberão Sapos de borracha.
5. As Dentaduras sempre serão passadas para todas as crianças.


## Execução dos testes
Primeiro será necessário clonar este repositório.
Todos os testes foram feitos em um ambiente Linux, portanto será necessário possui um sistema operacional Linux ou instala os subsistemas Linux, se estiver no Windows ([WSL](https://learn.microsoft.com/pt-br/windows/wsl/install)).
Com o terminal Linux aberto na raiz do repositório, basta executar o script chamando o comando:
```sh
./codigo-maldito.sh
```
Os três programas serão executados. Toda a saída gerada pelo console será gravada em arquivos `.log` contendo o relatório de cada unidade de teste para consultar os resultados de cada um dos testes. Os relatórios podem ser consultados em `log/$paradigma/resultado$i.log` onde `$paradigma` é o nome do programa que foi executado e `$i` é o mesmo número da caixa que foi testada no programa.

Serão 50 caixas diferentes contendo diversos brinquedos em diversas disposições para analisar o comportamento dos programas para cada caixa diferente. Isto inclui uma das caixas vazia. Os arquivos das caixas podem ser consultados em `caixas/caixa$i.txt` onde `$i` representa o número da caixa contida no nome do arquivo.