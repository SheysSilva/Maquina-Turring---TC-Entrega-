package maquinaTuring;

import java.util.Scanner;

public class MachinesLibrary {
	
	private MachinesLibrary() {}
	
	public static TuringMachine EqualBinaryWords() throws Exception {
		
		TuringMachine newTM = new TuringMachine();
 
		Scanner input = new Scanner(System.in);

        int max = 100;
        String[] estados = new String[max];
        String[] estadosFinais = new String[max];
        String estadoInicial;
        int qtEstados, qtEstadosF, qtAlfabeto, qtAlfabetoAux;
        String[] alfabeto = new String[max];
        String[] alfabetoAux = new String[max];
        String branco, inicial;
        int qtTransicao;
        String[][] transicao = new String[max][max];

        // Quantidade de estados da maquina de Turing
        System.out.print("Digite a quantidade de Estados: ");
        qtEstados = input.nextInt();

        // Pedindo o nome dos estados.
        input.nextLine(); // "Limpar" uma linha inteira do buffer
        for (int i = 0; i < qtEstados; i++) {

            System.out.print("Digite o nome do " + (i + 1) + "º estado: ");
            estados[i] = input.nextLine();
            newTM.addState(estados[i]);
          
        }

        System.out.println("------------------------------------------------------------------------------------");
        // Mostrar os valores contidos no vetor
        for (int i = 0; i < qtEstados; i++) {

            System.out.println("Estado " + (i + 1) + " = " + estados[i]);

        }
        System.out.println("------------------------------------------------------------------------------------");

        // Pedir o estado inicial
        System.out.print("Digite o estado Inicial: ");
        String estadoInic = input.nextLine();
        if (!newTM.setStartState(estadoInic)){
        	throw new Exception("Não existe o estado: "+ estadoInic);
        }
    	

        System.out.println("------------------------------------------------------------------------------------");
        // Pedir a quantidade de estados finais
        System.out.print("Digite a quantidade de estados finais existentes: ");
        qtEstadosF = input.nextInt();
        input.nextLine();
        System.out.println("------------------------------------------------------------------------------------");

        if (qtEstadosF > qtEstados) {
        	throw new Exception("Erro: a quantidade de estados finais eh maior ou iqual a quantidade de estados.");
        	
        } else { //pede para informar quais sao os estados finais
        	
            for (int i = 0; i < qtEstadosF; i++) {
                System.out.print("Digite os estados de Aceitacao: ");
                estadosFinais[i] = input.nextLine();
                if(!newTM.setAcceptState(estadosFinais[i])){
                	throw new Exception("Erro na adicao do estado de aceitação");
                }
            }

            System.out.println("------------------------------------------------------------------------------------");
            
            // Mostrar quais sao os estados de aceitacao
            for (int i = 0; i < qtEstadosF; i++) {
                System.out.println("Estado de Aceitacao: " + estadosFinais[i]);
            }

            System.out.println("------------------------------------------------------------------------------------\n");
            
            //Pede os estados de rejeicao
   
            estadosFinais = new String[max];
            int qtEstadosR = qtEstados - qtEstadosF;
            
            for (int i = 0; i < qtEstadosR; i++) {
                System.out.print("Digite os estados de rejeicao: ");
                estadosFinais[i] = input.nextLine();
                newTM.setRejectState(estadosFinais[i]);
            }

            System.out.println("------------------------------------------------------------------------------------\n");
            
            // Mostrar quais sÃ£o os estados de rejeicao
            for (int i = 0; i < qtEstadosF; i++) {
                System.out.println("Estado de Rejeicao: " + estadosFinais[i]);
            }
            System.out.println("------------------------------------------------------------------------------------");

        }

        
        
        
        
        // Pedir a quantiade de simbolos do alfabeto da maquina de turing
         
        System.out.print("Digite a quantidade de simbolos do alfabeto: ");
        qtAlfabeto = input.nextInt();
        input.nextLine();
        
        // Pedir os simbolos do alfabeto
        for (int i = 0; i < qtAlfabeto; i++) {

            System.out.print("Digite o " + (i + 1) + "º simbolo do Alfabeto: ");
            alfabeto[i] = input.nextLine();

        }
        System.out.print("Alfabeto:");
        
        //Mostrando o Alfabeto
        for (int i = 0; i < qtAlfabeto; i++) {
            System.out.print(alfabeto[i] + ",");
        }
        
        System.out.println();
        
        // Pedir quantidade de simbolos do alfabeto aux
        System.out.print("Digite a quantidade de simbolos do Alfabeto Auxiliar: ");
        qtAlfabetoAux = input.nextInt();
        input.nextLine();

        System.out.println("------------------------------------------------------------------------------------\n");
       
       
        for (int i = 0; i < qtAlfabetoAux; i++) {
            System.out.print("Digite o " + (i + 1) + "º simbolo do alfabeto Auxiliar:");
            alfabetoAux[i] = input.nextLine();

        }
        System.out.println("------------------------------------------------------------------------------------\n");

        for (int i = 0; i < qtAlfabetoAux; i++) {
            // Mostrando o alfabeto aux
            System.out.println("Alfabeto Auxiliar:" + alfabetoAux[i]);
        }
        
        
        
        
        
        
        // Transicoes
        System.out.print("Quantas transicoes existem: ");
        qtTransicao = input.nextInt();
        input.nextLine();
        String estado;
        String proxEstado;
        char simboloRejeicao;
        char  simboloAceitacao;
        String verifica;
        boolean direcao = false;
        for (int i = 0; i < qtTransicao; i++) {

            System.out.print("Digite o nome do " + (i + 1) + "º estado: ");
            estado = input.nextLine(); 
          
            System.out.print("Digite o nome do proximo estado: ");
            proxEstado = input.nextLine(); 
 
            System.out.print("Digite o nome do simbolo de rejeicao: ");
            simboloRejeicao = input.nextLine().charAt(0); 
          
            System.out.print("Digite o nome do simbolo de Aceitacao: ");
            simboloAceitacao = input.nextLine().charAt(0); 
            
            System.out.print("Digite a direcao(sim/nao) ");
            verifica = input.nextLine(); 
            if(verifica.equalsIgnoreCase("SIM")){
            	direcao = true;
            }
            else if(verifica.equalsIgnoreCase("NAO")){
            	direcao = false;
            }else{
            	System.out.println("Erro de digitacao, tente novamente digitando 'sim' ou 'nao'");
            }
            
          //Funcoes de Transicao
    		newTM.addTransition(estado, simboloRejeicao, proxEstado, simboloAceitacao, direcao);	
        }

		return newTM;		
	}

}
