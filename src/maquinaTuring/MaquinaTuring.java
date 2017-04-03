
package maquinaTuring;

import java.util.Scanner;

public class MaquinaTuring {

    public static void main(String[] args) throws Exception {
    	
    	TuringMachine TM1 = MachinesLibrary.EqualBinaryWords();
		
		boolean done = TM1.Run("10000110101#01000011010", false);
		
		if (done==true){
			System.out.println("The input was accepted.");
		}
		else{
			System.out.println("The input was rejected.");
		}	
		
    }

    
}