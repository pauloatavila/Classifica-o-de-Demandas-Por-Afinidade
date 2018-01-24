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

    private ArrayList<Integer> faltando = new ArrayList<>();

    public void combinacoes() { //G6 P3
        //definindo os valores de g e de p, sendo g o número total de itens e
        //p o número de itens em cada grupo 
        int g = 6;
        int p = 3;  
        //variavel destinada a auxiliar na hora de imprimir na tela
        int combinacao = 1;
        
        //loop para inserir os elementos dentro do array Faltando, que serão 
        //removidos conforme forem sendo utilizados na obtenção da combinação
        for(int i=2; i<=g; i++){
            faltando.add(new Integer(i));
        }

        //loop para definir o segundo item, já que o primeiro sempre será 1
        for (int i = 2; i <= g; i++) {
            //removendo o item que foi utilizado na combinação
            faltando.remove(new Integer(i));
            //loop para definir o terceiro item
            for (int j = i + 1; j <= g; j++) {
                //removendo o item que foi utilizado na combinação
                faltando.remove(new Integer(j));
                //imprimindo na tela a combinação obtida, sendo os itens 
                //restantes sendo categorizados como a combinação restante
                System.out.print("C" + combinacao + ": 1; " + i + "; " + j + ". ");
                System.out.println(faltando.get(0) + "; " + faltando.get(1) + "; " + faltando.get(2) + ".");
                combinacao++;
                //adicionando o item que foi removido para que ele volte a fazer
                //parte das combinações futuras
                faltando.add(j);
//                Collections.sort(faltando);
            }
            //adicionando o item que foi removido para que ele volte a fazer
            //parte das combinações futuras
            faltando.add(i);
        }
    }
}
