import java.util.*;

/**
 * DS Session6 Assignment
 * Employee2.java
 * @author Rohit
 *
 */
public class Employee2 implements Comparator{

	int empId;			// three fields of Employee class Id, name and address
	String name;
	String address;
	Employee2()		// default constructor
	{
		
	}
	Employee2(int eID, String eName, String eAddress)		// constructor to initialize the members
	{
		empId = eID;
		name = eName;
		address = eAddress;
	}
	public String toString()		// override toString method
	{
		return empId+":"+name+":"+address;
	}
	

	// getter setter method of class
	public int getEmpId() {
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
	public int compare(Object o1, Object o2) {	// override compare method to sort elements in list according to their names
		// TODO Auto-generated method stub
		Employee2 employee1 = (Employee2)o1;
		Employee2 employee2 = (Employee2)o2;
		return (int)(employee1.getName().compareTo(employee2.getName()));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee2> employee = new ArrayList<Employee2>();	// make a list employee of Employee class type
		employee.add(new Employee2(101, "Rohit", "Durgapura"));		// add some objects in list
		employee.add(new Employee2(102, "Avinash", "Mansarovar"));
		employee.add(new Employee2(104, "Amit", "Tonk Phatak"));
		employee.add(new Employee2(105, "Banwari", "Sitapura"));
		employee.add(new Employee2(103, "Bablu", "Sanganer"));
		System.out.print("\n List is : ");
		System.out.println(employee);	// print list
		Collections.sort(employee, new Employee2());	// sort the elements in list
		System.out.print("\n Sorted List is : ");
		System.out.print(employee);		// display sorted list
		

	}

}
