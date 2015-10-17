package com.helper;

/**
 * this class is check that id is not null to registration
 *
 */
public class RegistrationAuthentication {
	
	
	public static boolean  check(int Id){
		EmployeeCache employeeCache = EmployeeCache.getInstance();
		if(employeeCache.getEmployeeForId(Id) == null) {
			return true;
		} else {
			return false;
		}
	}
}
