package Engineermodel;

/**
 * implements IEngineer interface.
 * make constructor private.
 * implement methods of IEngineer.
 * @author Rohit
 *
 */
public class MechanicalEngineer implements IEngineer {

	String name;
	EngineerType role;
	
	private MechanicalEngineer() {
		
	}
	
	public static MechanicalEngineer getInstance() {
		return new MechanicalEngineer();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setRole() {
		// TODO Auto-generated method stub
		this.role = EngineerType.MechanicalEngineer;
	}

	@Override
	public EngineerType getRole() {
		// TODO Auto-generated method stub
		return role;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name:"+name+" Role:"+role;
	}
	

}
