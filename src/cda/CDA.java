
package cda;

import java.util.concurrent.TimeUnit;

public class CDA {

    public static void main(String[] args) {
        int numPessoas = 730;
        Algoritmo1 alg1 = new Algoritmo1(numPessoas);
//        long tempoInicio = System.currentTimeMillis();
        long timeInicio = System.nanoTime();
        int numDeGrupos = alg1.numMaxDeGrupos();
        System.out.println("Num max de grupos para "+numPessoas+" : "+numDeGrupos+"\n");
        alg1.verificaTudo();
        long timeFinal = System.nanoTime();
        long elapsTime = timeFinal - timeInicio;
        System.out.println(TimeUnit.NANOSECONDS.convert(elapsTime, TimeUnit.NANOSECONDS));
//        System.out.println("Tempo Total Alg1: "+(System.currentTimeMillis()-tempoInicio));
        
//        Algoritmo1 alg12 = new Algoritmo1(58);
//        tempoInicio = System.currentTimeMillis();
        long timeInicio2 = System.nanoTime();
        alg1.calculaGruposEspecifico(730, 13);
//        System.out.println("Tempo Total Alg2: "+(System.currentTimeMillis()-tempoInicio));
        long timeFinal2 = System.nanoTime();
        long elapsTime2 = timeFinal2 - timeInicio2;
        System.out.println(TimeUnit.NANOSECONDS.convert(elapsTime2, TimeUnit.NANOSECONDS));
        
//        Algoritmo2 alg2 = new Algoritmo2();
//        alg2.produtoDasNotas();
        
//        int animalSelecionado = 0;
//        int soma = alg2.somarPopularidadeIndividual(animalSelecionado);
//        String nomeDoAnimal = alg2.nomeAnimal(animalSelecionado);
//        System.out.println("Soma de popularidade da(o) "+ nomeDoAnimal +" : "+ soma +"\n");
//        System.out.println("\nPopularidade Geral:\n");
//        alg2.somarPopularidadeGeral();
        
        
    }
    
}
