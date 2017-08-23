
package cda;

import java.util.ArrayList;


public class Algoritmo1 {
    public int pessoas;
    public int numMinimo = 2; //definindo o numero minimo de pessoas em cada grupo
    
    public Algoritmo1(int p){
        pessoas = p;
    }
    
    public int numMaxDeGrupos(){ //metodo para encontrar o num maximo de grupos
        int i;
        for(i=2; i< pessoas; i++){
            if(pessoas/i < numMinimo){
                break;
            }
        }
        i = i-1;
        return i;
    }
    
    public void verificaTudo(){ //calcula pra cada num de grupo as possibilidades de divisao
        for(int i = 2; i<=numMaxDeGrupos(); i++){
            calculaPossibilidades(i);
            System.out.println("\n");
        }
    }
    
    public void calculaPossibilidades(int grupo){ //calcula as possibilidades de divisao para aquela qnt de grupo
        int pessoasRestantes = pessoas;
        int gruposRestantes = grupo;
        ArrayList<Integer> qntGrupos = new ArrayList<>();
        ArrayList<Integer> qntPessoas = new ArrayList<>();
        
        while(gruposRestantes>0){
            
            int resto = (pessoasRestantes%gruposRestantes);
            if (resto == 0){
                
                int result = pessoasRestantes/gruposRestantes;
                
                boolean jaTem = false;
                for(int i=0; i<qntGrupos.size(); i++){
                    if(qntPessoas.get(i) == result){
                        jaTem = true;
                        qntGrupos.set(i, qntGrupos.get(i)+1);
                        pessoasRestantes = 0;
                        gruposRestantes = 0;
                    }
                }
                if(!jaTem){
                    qntGrupos.add(gruposRestantes);
                    qntPessoas.add(result);
                    pessoasRestantes = 0;
                    gruposRestantes = 0;
                }
            } else {
                int incremento = pessoasRestantes + 1;
                
                while(incremento%gruposRestantes != 0){
                    incremento++;
                }
                
                int result = incremento/gruposRestantes;
                
                boolean jaTem = false;
                for(int i=0; i<qntGrupos.size(); i++){
                    if(qntPessoas.get(i) == result){
                        jaTem = true;
                        qntGrupos.set(i, qntGrupos.get(i)+1);
                        pessoasRestantes = pessoasRestantes - result;
                        gruposRestantes--;
                    }
                }
                if(!jaTem){
                    qntGrupos.add(1);
                    qntPessoas.add(result);
                    pessoasRestantes = pessoasRestantes - result;
                    gruposRestantes--;
                }
            }
        }
        System.out.println("Com "+grupo+" grupos: ");
        for(int i=0; i<qntGrupos.size(); i++){
            System.out.println(qntGrupos.get(i)+"x"+qntPessoas.get(i));
        }
    }
    
}
