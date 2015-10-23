package factory;

import Engineermodel.IEngineer;
import Engineermodel.MechanicalEngineer;
/**
 * Concrete class for MechanicalEngineer which inherit EngineerFactory and return instance of MechanicalEngineer
 * @author Rohit
 *
 */
public class ConcreteMechanicalEngineer extends EngineerFactory {

	@Override
	IEngineer createEngineer() {
		
		return MechanicalEngineer.getInstance();
	}

}
