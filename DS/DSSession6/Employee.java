import java.util.*;

/**
 * DS Session6 Assignment
 * Employee.java
 * @author Rohit
 *
 */
public class Employee implements Comparable {
	
	Integer empId;			// three fields of Employee class Id, name and address
	String name;
	String address;
	Employee(int eID, String eName, String eAddress) // constructor to initialize the members
	{
		empId = eID;
		name = eName;
		address = eAddress;
	}
	public String toString()   // override toString method
	{
		return empId+":"+name+":"+address;
	}
	

	// getter setter method of class
	public Integer getEmpId() { 
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int compareTo(Object o) {				// override compareTo method to sort elements in list according to their id
		return getEmpId().compareTo(((Employee)o).getEmpId());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employee = new ArrayList<Employee>();   // make a list employee of Employee class type
		employee.add(new Employee(101, "Rohit", "Durgapura"));		// add some objects in list
		employee.add(new Employee(102, "Avinash", "Mansarovar"));
		employee.add(new Employee(104, "Amit", "Tonk Phatak"));
		employee.add(new Employee(105, "Banwari", "Sitapura"));
		employee.add(new Employee(103, "Bablu", "Sanganer"));
		
		System.out.print("\n List is : ");
		System.out.println(employee);		// print list
		Collections.sort(employee);		// sort the elements in list
		System.out.print("\n Natural Sorted List is : ");
		System.out.println(employee);  // display sorted list
	}
}
