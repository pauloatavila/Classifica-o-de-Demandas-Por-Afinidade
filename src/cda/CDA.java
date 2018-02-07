package cda;

import java.util.concurrent.TimeUnit;

public class CDA {

    public static void main(String[] args) {
        
        /* Código para execução do Algoritmo 1:
           É informado o número de personagens, e são retornadas todas as
           possibilidades de grupos para aquela quantidade.
           (Para executar, descomente as 11 linhas seguintes, e popule a variável
           'numPessoas')
        */
//        int numPessoas = 52;
//        Algoritmo1 alg1 = new Algoritmo1(numPessoas);
//        long tempoInicio = System.currentTimeMillis();
//        long timeInicio = System.nanoTime();
//        int numDeGruposMax = alg1.numMaxDeGrupos();
//        System.out.println("Num max de grupos para " + numPessoas + " : " + numDeGrupos + "\n");
//        alg1.verificaTudo();
//        long timeFinal = System.nanoTime();
//        long elapsTime = timeFinal - timeInicio;
//        System.out.println("\nTempo Total de execução do Alg1: "+TimeUnit.NANOSECONDS.convert(elapsTime, TimeUnit.NANOSECONDS)+" nanosegundos");
//        
        /* Código para execução do Algoritmo 2:
           É informado o número de grupos (duplas), e são retornadas melhores
           duplas (número de duplas que o usuário informou).
           (Para executar, descomente as 9 linhas seguintes, e popule a variável
           'numDeGrupos')
           (Se 'numDeGrupos' for igual a 0, serão mostradas todas as duplas)
        */
//        int numDeGrupos = 0;
//        Algoritmo2 alg2 = new Algoritmo2();
//        
//        long tempoInicio = System.currentTimeMillis();
//        long timeInicio2 = System.nanoTime();
//        alg2.executa(numDeGrupos);
//        long timeFinal2 = System.nanoTime();
//        long elapsTime2 = timeFinal2 - timeInicio2;
//        System.out.println("\nTempo Total de execução do Alg2: "+ TimeUnit.NANOSECONDS.convert(elapsTime2, TimeUnit.NANOSECONDS)+" nanosegundos");
        
        /*
           Este é um recurso extra, em que consiste na divisão da lista de itens
           em duas, gerando assim dois grupos aleatórios de itens.
        */
//        alg2.sortearEmDoisGrupos();


    /* Código para execução do Algoritmo 3:
           É informado o número de grupos, e quanto eles devem ser divididos, 
           para isso podemos usar o algoritmo que divide 6 itens, 3 a 3:
          
//        Algoritmo3 alg3 = new Algoritmo3();
//        alg3.combinacoes();

          Ou um genérico que necessita apenas que seja passado o número de itens
          a serem divididos:
        
//        alg3.preparaCombinacoes(8);
        */
    
        Algoritmo3 alg3 = new Algoritmo3();

        long tempoInicio = System.currentTimeMillis();
        long timeInicio2 = System.nanoTime();
        alg3.preparaCombinacoes(6);
        long timeFinal2 = System.nanoTime();
        long elapsTime2 = timeFinal2 - timeInicio2;
        System.out.println("\nTempo Total de execução do Alg3 ( recursivo): "+ TimeUnit.NANOSECONDS.convert(elapsTime2, TimeUnit.NANOSECONDS)+" nanosegundos");
          /* Comparando Não recursivo com o recursivo */
        tempoInicio = System.currentTimeMillis();
        timeInicio2 = System.nanoTime();
        alg3.combinacoes();
        timeFinal2 = System.nanoTime();
        elapsTime2 = timeFinal2 - timeInicio2;
        System.out.println("\nTempo Total de execução do Alg3 (nao recursivo): "+ TimeUnit.NANOSECONDS.convert(elapsTime2, TimeUnit.NANOSECONDS)+" nanosegundos");
    }

}
