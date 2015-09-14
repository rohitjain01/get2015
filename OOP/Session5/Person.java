
/**
 * @author Rohit
 *
 */
public class Person extends Entity {
	
	private String school;
	private String college;
	private String[] interests;
	
	/** Method to return school Name
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}
	
	/** Method to set School Name
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	
	/** Method to return college name
	 * @return the college
	 */
	public String getCollege() {
		return college;
	}
	
	/** Method to set college name
	 * @param college the college to set
	 */
	public void setCollege(String college) {
		this.college = college;
	}
	
	/** Method to return interests
	 * @return the interests
	 */
	public String[] getInterests() {
		return interests;
	}
	
	/** Method to set interests
	 * @param interests the interests to set
	 */
	public void setInterests(String[] interests) {
		this.interests = interests;
	}	
}
