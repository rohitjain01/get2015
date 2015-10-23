package Engineermodel;

/**
 * implements IEngineer interface.
 * make constructor private.
 * implement methods of IEngineer.
 * @author Rohit
 *
 */
public class Developer implements IEngineer{
	
	String name;
	EngineerType role;
	private Developer() {
		
	}
	
	public static Developer getInstance() {
		return new Developer();
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
		this.role = EngineerType.Developer;
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
