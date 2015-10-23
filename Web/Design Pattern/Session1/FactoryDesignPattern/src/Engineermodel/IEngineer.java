package Engineermodel;

/**
 * @Interface IEngineer.java
 * Have setter getter methods for name and role
 * @author Rohit
 *
 */
public interface IEngineer {
	public void setName(String name);
	public String getName();
	public void setRole();
	public EngineerType getRole();
	public String toString();
}
