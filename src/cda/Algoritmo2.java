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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Algoritmo2 {

    private ArrayList<String> nomesAnimais = new ArrayList<>();
    private ArrayList<String> duplas = new ArrayList<>();
    private ArrayList<Double> notas = new ArrayList<>();
    private ArrayList<Double> notasAux = new ArrayList<>();
    private HashMap<String, ArrayList<Integer>> matrizDeNotas;
    private int numLinhas = -1;

    public void leituraArquivo() {
        //Altere o caminho correspondente para sua máquina
        String arquivo = "/Users/pauloatavila/Faculdade/Classificação de Demandas Por Afinidade/Matriz Animais2.txt";

        //Código para leitura do arquivo
        try {
            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            numLinhas += 1;
            while (linha != null) {
//                System.out.printf("%s\n", linha);

                int numChar = linha.length();
                String nomeAnimalDaVez = "";
                int i = 0;
                for (i = 0; i < numChar; i++) {
                    char caracter = linha.charAt(i);
                    if (caracter != ';') {
                        nomeAnimalDaVez = nomeAnimalDaVez + caracter;
                    } else {
                        break;
                    }
                }
                String num = "";
                for (i = i + 1; i < numChar; i++) {
                    char caracter = linha.charAt(i);
                    if (caracter != ';') {
                        num = num + caracter;
                    } else {
                        notas.add(Double.parseDouble(num));
                        num = "";
                    }
                }
                nomesAnimais.add(nomeAnimalDaVez);
                linha = lerArq.readLine();
                numLinhas += 1;
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

//        System.out.println();
        //Mostra os itens encontrados no arquivo
//        System.out.println("LISTA DOS ANIMAIS ENCONTRADOS:");
        for (int j = 0; j < nomesAnimais.size(); j++) {
//            System.out.println(nomesAnimais.get(j));
        }
//        System.out.println("");
//        System.out.println("LISTA DOS ANIMAIS ENCONTRADOS + NOTAS:");
        for (int j = 0; j < nomesAnimais.size(); j++) {
            int w = j * numLinhas;
//            System.out.print(nomesAnimais.get(j) + " -> ");

            for (int q = w; q < w + numLinhas; q++) {
//                System.out.print(notas.get(q) + " ");
            }
//            System.out.println("");
        }
    }

    //executa a escolha das duplas para o número de grupos escolhido pelo usuário
    public void executa(int numGruposUsuario) {
        //Faz a leitura do arquivo
        leituraArquivo();

        //verifica se o numero de duplas que o usuario quer é possível
        if (numGrupos(numGruposUsuario)) {
            produtoDasNotas();
//            imprimirDuplas(numGruposUsuario);
            gravarArquivoSaida(numGruposUsuario);
        } else {
            if (numGruposUsuario == 0) {
                produtoDasNotas();
                gravarArquivoSaida(numGruposUsuario);
            } else {
                System.out.println("Não há duplas suficientes para o que foi solicitado.");
            }
        }
    }

    //Calcula as notas para cada personagem da matriz, que foi populada na leitura do arquivo
    public void produtoDasNotas() {

        float[][] matrizNotas = new float[numLinhas][numLinhas];
        //iniciando a matriz
        for (int i = 0; i < numLinhas; i++) {
            for (int j = 0; j < numLinhas; j++) {
                matrizNotas[i][j] = 0;
            }
        }
        //codigo de multiplicacao das notas
        for (int i = 1; i < numLinhas; i++) {
            for (int j = 0; j < i; j++) {
                matrizNotas[i][j] = (float) (notas.get(i * numLinhas + j) * notas.get(j * numLinhas + i));
            }
        }

        //mostrar matriz
//        System.out.println("");
//        System.out.println("");
//        System.out.println("");
//        System.out.println("MATRIZ");
//        imprimirMatriz(matrizNotas);
//        System.out.println("");
//        System.out.println("");
        //comparando os personagens em duplas e rankeando-os
        while (!taZerada(matrizNotas)) {
            float maiorValor = pegaMaiorValor(matrizNotas);
            for (int i = 0; i < numLinhas; i++) {
                for (int j = 0; j < numLinhas; j++) {
                    if (matrizNotas[i][j] == maiorValor) {
                        duplas.add(nomesAnimais.get(i) + " e " + nomesAnimais.get(j) + " -> " + maiorValor);
                        zeraDuplas(matrizNotas, i, j);
//                        System.out.println(i + ";" + j);
//                        imprimirMatriz(matrizNotas);
//                        System.out.println("");
                    }
                }
            }
        }
    }

    //Imprime as duplas para o número de grupos escolhido pelo usuário
    public void imprimirDuplas(int numGruposUsuario) {
        //implimindo as duplas
        System.out.println("");
        System.out.println(numGruposUsuario + " duplas com as melhores pontuações:");
        for (int i = 0; i < numGruposUsuario; i++) {
            System.out.println(duplas.get(i));
        }
    }

    //verifica qual o maior valor da multiplicacao das notas dos personagens
    public float pegaMaiorValor(float[][] matriz) {
        float maior = 0;
        for (int i = 0; i < numLinhas; i++) {
            for (int j = 0; j < numLinhas; j++) {
                if (matriz[i][j] > maior) {
                    maior = matriz[i][j];
                }
            }
        }
        return maior;
    }

    //verifica se a matriz está zerada, ou seja, todos os integrantes já estão em duplas
    public boolean taZerada(float[][] matriz) {
        for (int i = 0; i < numLinhas; i++) {
            for (int j = 0; j < numLinhas; j++) {
                if (matriz[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /* Quando uma dupla é escolhida, seus valores sao zerados, para que não
       sejam utilizados em outra dupla */
    public void zeraDuplas(float[][] matriz, int linha, int coluna) {
        for (int i = 0; i < numLinhas; i++) {
            matriz[linha][i] = 0;
        }

        for (int i = 0; i < numLinhas; i++) {
            matriz[i][linha] = 0;
        }

        for (int i = 0; i < numLinhas; i++) {
            matriz[i][coluna] = 0;
        }

        for (int i = 0; i < numLinhas; i++) {
            matriz[coluna][i] = 0;
        }
    }

    //quando necessario, imprir a matriz para acompanhar os valores
    public void imprimirMatriz(float[][] matriz) {
        for (int i = 0; i < numLinhas; i++) {
            for (int j = 0; j < numLinhas; j++) {
                System.out.print(matriz[i][j]);
                if (matriz[i][j] >= 100.0) {
                    System.out.print(" ");
                } else if (matriz[i][j] >= 10.0) {
                    System.out.print("  ");
                } else {
                    System.out.print("   ");
                }

            }
            System.out.println("");
        }
    }

    //Verifica se o numero de duplas que o usuario solicitou é possível
    public boolean numGrupos(int numDeGrupos) {
        if (numDeGrupos <= numLinhas / 2) {
            return true;
        } else {
            return false;
        }
    }

    public void gravarArquivoSaida(int numGruposUsuario) {
        File arquivoSaida = new File("/Users/pauloatavila/Faculdade/Classificação de Demandas Por Afinidade/saida.txt");

        try {
            arquivoSaida.createNewFile();//arquivo criado
            //ESCREVER
            FileWriter fileW = new FileWriter(arquivoSaida);//arquivo para escrita
            BufferedWriter buffW = new BufferedWriter(fileW);

            //coloca todas as duplas possíveis no arquivo
            if (numGruposUsuario == 0) {
                buffW.write("Todas as duplas possíveis e suas pontuações:");
                for (int i = 0; i < duplas.size(); i++) {
                    buffW.newLine();
                    buffW.write(duplas.get(i));
                }
            } else { //coloca todas as melhores duplas no arquivo
                buffW.write(numGruposUsuario + " duplas com as melhores pontuações:");
                for (int i = 0; i < numGruposUsuario; i++) {
                    buffW.newLine();
                    buffW.write(duplas.get(i));
                }
            }
            buffW.close();
            System.out.println("Arquivo de saída gerado com sucesso");
        } catch (IOException io) {
        }
    }
}
