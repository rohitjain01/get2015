

package com.Assignment2;

public class HRManager extends LeaveApprover {

	@Override
	public void ProcessRequest(int leave) {
		if (leave <= 5) {
			System.out.println("Leave approved by HR Manager");
		} else {
			System.out.println("Leave Approval requires a meeting! ");
		}
	}
}
//End of class
