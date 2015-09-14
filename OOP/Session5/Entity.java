
import java.math.BigInteger;


/**
 * @author Rohit
 *
 */
public class Entity implements Node {
	
	private String name;
	private BigInteger phone;
	private String email;
	
	
	/** Method to get the name of entity
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/** Method to set the name of entity
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Method to get the phone number of entity
	 * @return the phone
	 */
	public BigInteger getPhone() {
		return phone;
	}

	/** MEthod to set the phone number of entity
	 * @param phone the phone to set
	 */
	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

	/** MEthod to get email id of entity
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/** MEthod to set email of entity
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
