package factory;

import Engineermodel.EngineerType;
import Engineermodel.IEngineer;

/**
 * Factory Maker class which create instance of IEngineer according to role type
 * @author Rohit
 *
 */
public class FactoryMaker {
	private static IEngineer iEngineer = null; // make reference of IEngineer
	public static IEngineer getFactory(EngineerType engineerType) {
		EngineerFactory engineerFactory;
		if(engineerType.equals(EngineerType.Developer)) {
			engineerFactory = new ConcreteDeveloper();
			iEngineer = engineerFactory.createEngineer();
		} else {
			engineerFactory = new ConcreteMechanicalEngineer();
			iEngineer = engineerFactory.createEngineer();
		}
		return iEngineer;
	}

}
