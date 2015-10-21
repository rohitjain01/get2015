package workstation;

import java.util.List;

import Engineermodel.IEngineer;


/**
 * Implement IWorkstation.
 * Singleton class.
 * Define methods of IWorkstation
 * @author Rohit
 *
 */
public class Office implements IWorkstation {
	
	private static Office office = new Office();
	
	private Office() {
		
	}
	
	public static Office getInstance() {
		return office;
	}

	@Override
	public void addEngineer(IEngineer engineer) {
		engineerList.add(engineer); // add IEngineer object in list
		
	}

	@Override
	public List<IEngineer> displayList() {
		return engineerList;	// return list
	}

}
