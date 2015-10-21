package factory;

import Engineermodel.IEngineer;

/**
 * Abstract factory class for Developer and MechanicalEngineer which have an abstract method createEngineer
 * @author Rohit
 *
 */
public abstract class EngineerFactory {
	
	abstract IEngineer createEngineer();
}
