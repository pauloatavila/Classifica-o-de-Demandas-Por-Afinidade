/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cda;

/**
 *
 * @author pauloatavila
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Algoritmo2 {
    
    private ArrayList<String> nomesAnimais = new ArrayList<>();
    private ArrayList<String> duplas = new ArrayList<>();
    private ArrayList<Integer> notas = new ArrayList<>();
    private ArrayList<Integer> notasAux = new ArrayList<>();
    private HashMap<String, ArrayList<Integer>> matrizDeNotas;
    private int numLinhas = -1;
    
    public void leituraArquivo(){
      String arquivo = "/Users/pauloatavila/Faculdade/Classificação de Demandas Por Afinidade/Matriz Animais.txt";
 
    System.out.printf("\nConteúdo do arquivo texto:\n");
    try {
      FileReader arq = new FileReader(arquivo);
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine();
      numLinhas += 1;
      while (linha != null) {
        System.out.printf("%s\n", linha);
 
        int numChar = linha.length();
        String nomeAnimalDaVez = "";
        int i = 0;
        for (i=0; i<numChar; i++){
            char caracter = linha.charAt(i);
            if (caracter != ';'){
                nomeAnimalDaVez = nomeAnimalDaVez + caracter;
            } else {
                break;
            }
        }
        String num = "";
        for (i=i+1; i<numChar; i++){
            char caracter = linha.charAt(i);
            if (caracter != ';'){
                num = num + caracter;
            } else {
                notas.add(Integer.parseInt(num));
                num = "";
            }
        }
        
//          System.out.println("saiu do for");
//          System.out.println("nome recuperado: "+nomeAnimalDaVez);
        nomesAnimais.add(nomeAnimalDaVez);
          
//        System.out.println("valor de i: "+i);
        
//          System.out.println("num de chars na linha: "+linha.length()); 
        
        linha = lerArq.readLine(); // lê da segunda até a última linha
        numLinhas += 1;
      }
 
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
 
    System.out.println();
    
        System.out.println("LISTA DOS ANIMAIS ENCONTRADOS:");
        for(int j= 0; j<nomesAnimais.size(); j++){
            System.out.println(nomesAnimais.get(j));
        }
        
        
        System.out.println("");
        System.out.println("LISTA DOS ANIMAIS ENCONTRADOS + NOTAS:");
        for(int j= 0; j<nomesAnimais.size(); j++){
            int w = j*numLinhas;
//            System.out.println("valor j: "+j);
//            System.out.println("valor numLinhas: "+numLinhas);
//            System.out.println("VALOR W: "+w);
            System.out.print(nomesAnimais.get(j) + " -> ");
            
            for(int q = w; q<w+numLinhas; q++){
                System.out.print(notas.get(q) + " ");
            }
            System.out.println("");
        }
    
    
    }
    
    
    public void produtoDasNotas(){
        leituraArquivo();
        
        int[][] matrizNotas = new int[numLinhas][numLinhas];
        
        //iniciando a matriz
        for (int i=0; i<numLinhas; i++){
            for(int j=0; j<numLinhas; j++){
                matrizNotas[i][j]=0;
            }
        }
        
        //codigo de multiplicacao das notas
        for(int i=1;i<numLinhas;i++){
            for(int j=0; j<i; j++){
                matrizNotas[i][j] = notas.get(i*numLinhas + j) * notas.get(j*numLinhas+i);
            }
        }
        
        //mostrar matriz
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("MATRIZ");
        imprimirMatriz(matrizNotas);
        
        System.out.println("");
        System.out.println("");
        //pegando as duplas
        while(!taZerada(matrizNotas)){
            int maiorValor = pegaMaiorValor(matrizNotas);
            for(int i=0; i<numLinhas;i++){
                for(int j=0; j<numLinhas;j++){
                    if(matrizNotas[i][j] == maiorValor){
                        duplas.add(nomesAnimais.get(i)+" e "+nomesAnimais.get(j));
                        zeraDuplas(matrizNotas, i, j);
                        System.out.println(i+";"+j);
                        imprimirMatriz(matrizNotas);
                        System.out.println("");
                    }
                }
            }
        }
        
        System.out.println("");
        System.out.println("DUPLAS");
        for(int i=0; i<duplas.size(); i++){
            System.out.println(duplas.get(i));
        }
        
    }
    
    public int pegaMaiorValor(int[][] matriz){
        int maior = 0;
        for(int i=0; i<numLinhas; i++){
            for(int j=0; j<numLinhas;j++){
                if(matriz[i][j]>maior){
                    maior = matriz[i][j];
                }
            }
        }
        return maior;
    }
    
    public boolean taZerada(int[][] matriz){
        for(int i=0; i<numLinhas; i++){
            for(int j=0; j<numLinhas;j++){
                if(matriz[i][j]!=0){
                    return false;
                    
                }
            }
        }
        return true;
    }
    
    public void zeraDuplas(int[][] matriz, int linha, int coluna){
        for(int i=0; i<numLinhas; i++){
            matriz[linha][i] = 0;
        }
        
        for(int i=0; i<numLinhas; i++){
            matriz[i][linha] = 0;
        }
        
        for(int i=0; i<numLinhas; i++){
            matriz[i][coluna] = 0;
        }
        
        for(int i=0; i<numLinhas; i++){
            matriz[coluna][i] = 0;
        }
    }
    
    public void imprimirMatriz(int[][] matriz){
        for(int i=0; i<numLinhas; i++){
            for(int j=0; j<numLinhas;j++){
                System.out.print(matriz[i][j]);
                if(matriz[i][j]>=100){
                    System.out.print(" ");
                } else if(matriz[i][j]>=10){
                    System.out.print("  ");
                } else {
                    System.out.print("   ");
                }
                
            }
            System.out.println("");
        }
    }
}






//public class Algoritmo2 {
//    
//    public int linha = 26;
//    public int coluna = 26;
//    
//    public int[][] notas = {{0,3,16,15,9,20,26,7,12,21,14,10,13,11,2,22,23,18,6,19,4,5,25,17,24,8},{10,0,23,25,7,4,2,13,17,18,21,9,22,16,11,3,26,12,6,15,5,14,19,8,20,24},{21,7,0,16,14,5,6,11,2,22,17,4,10,12,26,20,24,18,9,13,23,8,3,15,19,25},{21,3,17,0,23,22,16,14,20,15,24,11,19,25,7,2,6,4,18,5,9,26,13,12,10,8},{23,26,11,21,0,12,18,4,10,6,13,22,25,14,5,8,9,24,16,15,7,3,19,17,2,20},{6,4,7,3,9,0,14,26,21,15,10,8,2,20,16,22,19,23,5,13,17,24,18,25,12,11},{7,5,25,2,23,18,0,21,11,26,9,15,16,12,17,10,22,3,14,20,19,13,24,4,6,8},{2,20,6,18,15,14,26,0,5,4,23,21,8,25,3,12,22,19,24,9,10,17,13,16,11,7},{15,4,16,23,9,19,2,13,0,17,11,20,10,7,3,24,8,12,18,5,14,25,26,6,21,22},{7,16,18,9,12,4,26,8,2,0,10,20,22,21,14,11,6,3,19,25,17,5,13,23,15,24},{16,9,8,15,23,26,25,5,6,12,0,4,20,2,24,21,11,17,10,7,14,13,3,18,19,22},{8,15,22,2,21,17,13,26,9,14,25,0,11,6,3,20,10,24,5,18,7,4,19,12,23,16},{9,25,24,12,13,23,14,2,11,21,17,15,0,8,18,4,6,19,7,26,16,22,10,20,3,5},{13,5,18,21,17,2,12,11,25,9,22,14,7,0,20,6,16,3,8,15,4,10,26,24,19,23},{14,24,4,26,18,12,8,11,2,19,25,16,5,23,0,7,22,21,13,17,9,3,6,15,10,20},{13,14,15,18,17,9,8,25,4,23,21,16,11,5,7,0,12,22,3,24,6,26,10,20,19,2},{15,23,17,6,26,14,3,20,9,13,21,24,5,12,25,8,0,22,2,18,7,10,19,4,11,16},{8,3,15,2,9,16,23,11,20,6,14,13,19,4,22,7,18,0,12,17,21,26,10,5,24,25},{26,2,19,21,6,18,16,23,12,7,20,15,22,13,3,14,11,10,0,9,4,8,5,17,25,24},{2,16,26,9,15,13,8,11,4,19,20,24,25,6,21,7,22,3,17,0,14,12,5,10,18,23},{5,22,2,20,10,18,25,21,16,6,4,11,13,14,7,23,26,9,19,3,0,12,8,15,24,17},{16,15,14,11,2,18,4,8,22,6,13,24,19,20,21,23,3,26,7,9,12,0,10,5,25,17},{18,15,20,17,9,7,4,16,10,8,13,26,11,12,22,25,19,24,14,23,5,2,0,21,3,6},{20,2,6,15,26,9,16,19,12,10,3,22,4,24,13,7,5,14,21,11,23,25,8,0,17,18},{3,10,26,19,11,23,25,2,20,9,17,21,5,8,16,14,15,24,12,4,18,6,7,13,0,22},{5,9,3,22,24,15,6,19,18,7,21,25,14,16,13,4,10,11,17,2,12,20,8,23,26,0}};
//    public String[] nomes = {"Arara", "Baleia", "Cavalo", "Dragão", "Elefante", "Foca", "Gato", "Hiena", "Iguana", "Jaguar", "Koala", "Leão", "Macaco", "Naja", "Onça", "Porco", "Quati", "Raposa", "Sapo", "Tatu", "Urso", "Vaca", "Welsh", "Xexéu", "yorkshire", "Zebra"};
//    // cada {} sao as notas de uma pessoa
//    
//    public Algoritmo2(){
//        
//    }
//    
//    public int somarPopularidadeIndividual(int i){
//        // i eh a pessoa
//        int soma = 0;
//        
//        for(int j=0; j<coluna; j++){
//            soma = soma + notas[j][i];
//        }
//        
//        return soma;
//    }
//    
//    public String nomeAnimal(int i){
//        return nomes[i];
//    }
//    
//    public void somarPopularidadeGeral(){
//        
//        int soma;
//        
//        for (int i=0; i<linha; i++){
//            soma = 0;
//            
//            
//            for (int j=0; j<coluna; j++){
//                soma = soma + notas[j][i];
////                System.out.print(notas[j][i]+" + ");
//            }
////            System.out.print("\n");
//            System.out.println(nomes[i] +" : "+ soma);
//        }
//    }
//    
//}
