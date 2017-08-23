/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cda;

import java.util.ArrayList;

/**
 *
 * @author pauloatavila
 */
public class MatrizDeValores {
    public ArrayList<Integer> totalValores = new ArrayList<>();
    public ArrayList<Integer> idDosTotais = new ArrayList<>();
    public ArrayList<String> nomes = new ArrayList<>();
    public int[][] matrizValores;
    
    public MatrizDeValores(){
        adicionaNomes();
    }
    
    public void adicionaNomes(){
        nomes.add("Arara");
        nomes.add("Baleia");
        nomes.add("Cachorro");
        nomes.add("Dragão");
        nomes.add("Elefante");
        nomes.add("Foca");
        nomes.add("Gato");
        nomes.add("Hipopótamo");
        nomes.add("Iguana");
        nomes.add("Jacaré");
        nomes.add("Kiwi");
        nomes.add("Leão");
        nomes.add("Morcego");
        nomes.add("Naja");
        nomes.add("Porco");
        nomes.add("Quati");
        nomes.add("Raposa");
        nomes.add("Sapo");
        nomes.add("Tartaruga");
        nomes.add("Urso");
        nomes.add("Vaca");
        nomes.add("Ximango");
        nomes.add("Y.-.");
        nomes.add("Zebra");
    }
}
