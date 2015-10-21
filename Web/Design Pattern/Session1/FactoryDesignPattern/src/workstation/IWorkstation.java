package workstation;

import java.util.ArrayList;
import java.util.List;

import Engineermodel.IEngineer;

/**
 * an interface which have a list of IEngineer and have two methods
 * @author Rohit
 *
 */
public interface IWorkstation {
	
	public static List<IEngineer> engineerList = new ArrayList<IEngineer>();
	
	public void addEngineer( IEngineer engineer);
	public List<IEngineer> displayList();

}
