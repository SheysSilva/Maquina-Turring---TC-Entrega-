
package maquinaTuring;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
    	
    	TuringMachine TM1 = MachinesLibrary.EqualBinaryWords();
		
    	Scanner scanner = new Scanner(System.in);
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
    
}