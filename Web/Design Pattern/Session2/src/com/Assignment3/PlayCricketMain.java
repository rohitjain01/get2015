
package com.Assignment3;

import java.util.Scanner;

public class PlayCricketMain {
	
	public static void main(String args[]) {
		
		int choice = 0;
		Cricket cricket;
		do{
			System.out.println("Enter your choice \n1. Test \n2. OneDay\n3. T20 \n4. Exit \n");
			try{
				choice=Integer.parseInt(new Scanner(System.in).next());
			}
			catch(Exception e){
				System.out.println("Enter integer value");
			}
			//End of try catch
			switch(choice){
			
			case 1:
				cricket = new TestCricket();
				cricket.play();
				System.out.println();
				break;
				
			case 2:
				cricket = new OneDayCricket();
				cricket.play();
				System.out.println();
				break;
				
			case 3:
				cricket = new T20Cricket();
				cricket.play();
				System.out.println();
				break;
				
			case 4:
				System.exit(0);
				break;
				
			default:
				System.out.println("Enter correct choice..");
			}
			//End of switch statement.
			
		}while(true);
		//End of do-while loop
	}
	//End of main method

}
//End of class
