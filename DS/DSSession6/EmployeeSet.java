import java.util.*;

/**
 * DS Session6 Assignment
 * EmployeeSet.java
 * @author Rohit
 *
 */
public class EmployeeSet {

	int empId;		// three fields of Employee class Id, name and address
	String name;
	String address;
	EmployeeSet(int eID, String eName, String eAddress)		// constructor to initialize the members
	{
		empId = eID;
		name = eName;
		address = eAddress;
	}
	public String toString()		// override toString method
	{
		return empId+":"+name+":"+address;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<EmployeeSet> employee = new HashSet<EmployeeSet>(); // make a set of EmployeeSet class type
		employee.add(new EmployeeSet( 101, "Rohit", "Durgapura" ));	// add some objects in set
		employee.add(new EmployeeSet( 102, "Avinash", "Mansarovar" ));
		employee.add(new EmployeeSet( 104, "Amit", "Tonk Phatak" ));
		employee.add(new EmployeeSet( 105, "Banwari", "Sitapura" ));
		employee.add(new EmployeeSet( 104, "Gaurav", "Gandhinagar" ));
		employee.add(new EmployeeSet( 103, "Bablu", "Sanganer") );
		System.out.print("\n Set is : "+employee); // print the set
	}
	@Override
	public int hashCode() {  // override hash code method
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		return result;
	}
	@Override		// override equals method
	public boolean equals(Object obj) {  /* this method store elements in list is their ids are different*/
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeSet other = (EmployeeSet) obj;
		if (empId != other.empId)
			return false;
		return true;
	}

}
