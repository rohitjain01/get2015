package factory;

import Engineermodel.Developer;
import Engineermodel.IEngineer;
/**
 * Concrete class for Developer which inherit EngineerFactory and return instance of Developer
 * @author Rohit
 *
 */
public class ConcreteDeveloper extends EngineerFactory {

	@Override
	IEngineer createEngineer() {
		return Developer.getInstance();	
	}

}
