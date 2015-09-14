import java.util.Scanner;
/**
 * OOP Sessio4 Assignment
 * Participant.java
 * @author Rohit
 *
 */

public class Participant {
	  
		 Scanner sc = new Scanner(System.in );
		 //method take users information 
		 //i no of participant 
		 //return name of participant
		 public String  getParticipantDetail(int i){  
			 String name;
			 System.out.println("Enter the Name");
			 name = sc.nextLine();  // take name as ainput from user
		     return name; // return this name
		 }
		 
}
