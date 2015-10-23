
package com.Assignment2;

import java.util.Scanner;

public class RequestForLeaveMain {

	public static void main(String args[]) {
		LeaveApprover mentor = new Mentor();
		LeaveApprover srMentor = new SeniorMentor();
		LeaveApprover hrManager = new HRManager();
		int leave=0;
		System.out.println("Enter number of leave that you wants.");
		try{
			leave=Integer.parseInt(new Scanner(System.in).next());
		}
		catch(Exception e){
			System.out.println("Enter integer value");
		}
		if(leave<=0){

			System.out.println("Enter value greter than zero\n");
			main(args);
		}
		mentor.setSuccessor(srMentor);
		srMentor.setSuccessor(hrManager);
		mentor.ProcessRequest(leave);
	}
}
//End of main class.

