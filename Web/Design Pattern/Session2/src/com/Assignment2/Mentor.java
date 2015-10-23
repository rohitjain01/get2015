
package com.Assignment2;

public class Mentor extends LeaveApprover {

	@Override
	public void ProcessRequest(int leave) {
		if (leave <= 1) {
			System.out.println("Leave approved by Mentor");
		} else if (successor != null) {
			successor.ProcessRequest(leave);
		}
	}
}
