package CompanyMain;

import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

import workstation.Office;
import factory.FactoryMaker;
import Engineermodel.EngineerType;
import Engineermodel.IEngineer;

/**
 * Design Pattern session 1 assignments
 * MainClass.java
 * @author Rohit
 *
 */
public class MainClass {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		EngineerType role;
		IEngineer engineer;
		Office office = Office.getInstance();
		List<IEngineer> listEngineers;
		Iterator<IEngineer> iterator;
		int choice, type;
		while(true) {
			// create a menu for user input
			System.out.print("\n 1. Add Engineer");
			System.out.print("\n 2. Display Engineers");
			System.out.print("\n 3. Exit");
			System.out.print("\n Enter your choice : ");
			do {
				// validate user input
				System.out.println("\n Please Enter positive integer(less than 4)");
				while(!sc.hasNextInt()) {
					System.out.println("\n Please Enter Integer Only");
					sc.next();
				}
				choice = sc.nextInt();
			}while( choice <= 0 || choice >= 4 );
			switch(choice) {
			case 1:
				System.out.print("\n 1. Developer");
				System.out.print("\n 2. Mechanical Engineer");
				System.out.print("\n Select Engineer's type : ");
				do {
					System.out.print("\n Please Enter positive integer(less than 3)");
					while(!sc.hasNextInt()) {
						System.out.print("\n Please Enter Integer Only");
						sc.next();
					}
					type = sc.nextInt();
				}while( type <= 0 || type >= 3 );
				System.out.print("\n Enter Name of Engineer : ");
				name = sc.next();
				if( type == 1 ){
					role = EngineerType.Developer;
				} else {
					role = EngineerType.MechanicalEngineer;
				}
				engineer = FactoryMaker.getFactory(role);
				engineer.setName(name);
				engineer.setRole();
				office.addEngineer(engineer);
				break;
			case 2:
				listEngineers = office.displayList();
				if(listEngineers.size() == 0) {
					System.out.println("\n List is empty..");
				} else {
					iterator = listEngineers.iterator();
					while(iterator.hasNext()) {
						engineer = iterator.next();
						System.out.print("\n"+engineer.toString());
					}
					System.out.println("\n");
				}
				break;
			case 3:
				sc.close();
				System.exit(0);
			}
		}
	}
}
