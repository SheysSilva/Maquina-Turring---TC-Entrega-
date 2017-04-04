package maquinaTuring;

import java.util.Scanner;

public class Teste {
	
	 public static void main(String[] args) throws Exception {
	    	
	    	MaquinaTurring TM1 = Teste.teste();
			
	    	Scanner scanner = new Scanner(System.in);
	    	
	    	System.out.println("================== MAQUINA TURRING ==================");
	    	System.out.println();
	    	System.out.println("Digite a entrada (Coloque '#' no meio da palavra): ");
	    	
	    	String entrada = scanner.nextLine(); 
	    	
			boolean resultado = TM1.Run(entrada, false);
			if (resultado == true)
			{
				System.out.println("A entrada foi aceita.");
			}
			else
			{
				System.out.println("A entrada foi rejeitada.");
			}	
	}
	    

	public static MaquinaTurring teste(){

		MaquinaTurring maquinaTurring = new MaquinaTurring();
		maquinaTurring.addState("q1");
		maquinaTurring.addState("q2");
		maquinaTurring.addState("q3");
		maquinaTurring.addState("q4");
		maquinaTurring.addState("q5");
		maquinaTurring.addState("q6");
		maquinaTurring.addState("q7");
		maquinaTurring.addState("q8");
		maquinaTurring.addState("qa");
		maquinaTurring.addState("qr");
		maquinaTurring.setStartState("q1");
		maquinaTurring.setAcceptState("qa");
		maquinaTurring.setRejectState("qr");
		maquinaTurring.addTransition("q1", '1', "q3", 'x', true);
		maquinaTurring.addTransition("q1", '0', "q2", 'x', true);
		maquinaTurring.addTransition("q1", '#', "q8", '#', true);
		maquinaTurring.addTransition("q2", '0', "q2", '0', true);
		maquinaTurring.addTransition("q2", '1', "q2", '1', true);
		maquinaTurring.addTransition("q2", '#', "q4", '#', true);
		maquinaTurring.addTransition("q3", '0', "q3", '0', true);
		maquinaTurring.addTransition("q3", '1', "q3", '1', true);
		maquinaTurring.addTransition("q3", '#', "q5", '#', true);
		maquinaTurring.addTransition("q4", 'x', "q4", 'x', true);
		maquinaTurring.addTransition("q4", '0', "q6", 'x', false);
		maquinaTurring.addTransition("q5", 'x', "q5", 'x', true);
		maquinaTurring.addTransition("q5", '1', "q6", 'x', false);
		maquinaTurring.addTransition("q6", '0', "q6", '0', false);
		maquinaTurring.addTransition("q6", '1', "q6", '1', false);
		maquinaTurring.addTransition("q6", 'x', "q6", 'x', false);
		maquinaTurring.addTransition("q6", '#', "q7", '#', false);
		maquinaTurring.addTransition("q7", '0', "q7", '0', false);
		maquinaTurring.addTransition("q7", '1', "q7", '1', false);
		maquinaTurring.addTransition("q7", 'x', "q1", 'x', true);
		maquinaTurring.addTransition("q8", 'x', "q8", 'x', true);
		maquinaTurring.addTransition("q8", '_', "qa", '_', true);
		
		return maquinaTurring;		

	}
}
