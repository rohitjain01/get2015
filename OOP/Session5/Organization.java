
/**
 * @author Rohit
 *
 */
public class Organization extends Entity{
	
	/* sData Members */
	private String courses[];
	private String placements[];
	private String faculty[];
	
	/** Method to return courses
	 * @return the courses
	 */
	public String[] getCourses() {
		return courses;
	}
	
	/** Method to set courses
	 * @param courses the courses to set
	 */
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	
	/** Method to return placements
	 * @return the placements
	 */
	public String[] getPlacements() {
		return placements;
	}
	
	/** Method to set placements
	 * @param placements the placements to set
	 */
	public void setPlacements(String[] placements) {
		this.placements = placements;
	}
	
	/** Method to return faculties
	 * @return the faculty
	 */
	public String[] getFaculty() {
		return faculty;
	}
	
	/** MEthod to set Faculties
	 * @param faculty the faculty to set
	 */
	public void setFaculty(String[] faculty) {
		this.faculty = faculty;
	}
}
