/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cda;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author pauloatavila
 */
public class Algoritmo3 {

    private ArrayList<Integer> faltandoGlobal = new ArrayList<>();
    int numCombinacoes = 1;

    public void combinacoes() { //G6 P3
        //definindo os valores de g e de p, sendo g o número total de itens e
        //p o número de itens em cada grupo 
        int g = 6;
        int p = 3;
        //variavel destinada a auxiliar na hora de imprimir na tela
        int combinacao = 1;

        //loop para inserir os elementos dentro do array Faltando, que serão 
        //removidos conforme forem sendo utilizados na obtenção da combinação
        for (int i = 2; i <= g; i++) {
            faltandoGlobal.add(new Integer(i));
        }

        //loop para definir o segundo item, já que o primeiro sempre será 1
        for (int i = 2; i <= g; i++) {
            //removendo o item que foi utilizado na combinação
            faltandoGlobal.remove(new Integer(i));
            //loop para definir o terceiro item
            for (int j = i + 1; j <= g; j++) {
                //removendo o item que foi utilizado na combinação
                faltandoGlobal.remove(new Integer(j));
                //imprimindo na tela a combinação obtida, sendo os itens 
                //restantes sendo categorizados como a combinação restante
                System.out.print("C" + combinacao + ": 1; " + i + "; " + j + ". ");
                System.out.println(faltandoGlobal.get(0) + "; " + faltandoGlobal.get(1) + "; " + faltandoGlobal.get(2) + ".");
                combinacao++;
                //adicionando o item que foi removido para que ele volte a fazer
                //parte das combinações futuras
                faltandoGlobal.add(new Integer(j));
//                Collections.sort(faltando);
            }
            //adicionando o item que foi removido para que ele volte a fazer
            //parte das combinações futuras
            faltandoGlobal.add(new Integer(i));
        }
    }

    public void preparaCombinacoes(int g) {
        //a variável g, do escopo, significa o número total de itens que serão divididos

        //o algoritmo só pode executar se o número de itens for diferente de zero,
        //pois não é possível montar combinações com nenhum item
        if (g != 0) {
            //definindo o p, que é o número de itens em cada grupo
            int p = g / 2;

            //criando os arrays para guardar as combinações, sendo comb a primeira
            //combinação e faltando a segunda combinacão.
            ArrayList comb = new ArrayList();
            ArrayList faltando = new ArrayList();

            //limpando qualquer lixo que tenha dentro do array Faltando
            faltando.removeAll(faltando);

            //loop para inserir os elementos dentro do array Faltando, que serão 
            //removidos conforme forem sendo utilizados na obtenção da combinação
            for (int i = 2; i <= g; i++) {
                faltando.add(new Integer(i));
            }
            //adicionando o número 1 a primeira combinação
            comb.add(new Integer(1));

            //chamando o método recursivo para ir aprofundando os laços de repetição
            combinacoesRec(2, 1, g, faltando, comb);
        }
    }

    public void combinacoesRec(int prox, int rep, int g, ArrayList faltando, ArrayList comb) {
        //prox refere-se ao valor inicial do laço de repetição que defini os valores das combinações
        //rep a quantas vezes o método recursivo já foi chamado
        
        for (int i = prox; i <= g; i++) {
            //adicionando o valor atual do loop a uma combinação e removendo do
            //vetor faltando
            faltando.remove(new Integer(i));
            comb.add(new Integer(i));
            
            //o número máximo de vezes que o método recursivo deve ser chamado é
            //(g/2)-1, este if verifica isso
            if (rep < g / 2 - 1) {
                //a chamada do método recurviso é aumentando 1 ao valor atual
                //do loop e a quantidade de vezes que o método foi chamado
                combinacoesRec(i + 1, rep + 1, g, faltando, comb);
            } else {
                //caso o método já tenha sido chamado a quantidade de vezes necessária,
                //então serão impressas as combinações
                System.out.println("C" + numCombinacoes + ": ");
                for (int j = 0; j < faltando.size(); j++) {
                    System.out.print(comb.get(j) + " ");
                }
                System.out.print("# "); //separando as combinações
                for (int j = 0; j < faltando.size(); j++) {
                    System.out.print(faltando.get(j) + " ");
                }
                System.out.print("\n\n");
                numCombinacoes++;
            }
            //assim que o número é utilizado em alguma combinação, ele é removido
            //do array Comb e adicionado novamente ao array Faltando
            comb.remove(new Integer(i));
            faltando.add(new Integer(i));
        }
    }
}
