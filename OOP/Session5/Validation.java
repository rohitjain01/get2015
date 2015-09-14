import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validation {

	private static Pattern pattern;
	private static Matcher matcher;
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	
	/** Method to validate name of ant entity */
	public static boolean isName(String name) 
	{
	    char[] chars = name.toCharArray();

	    for (char c : chars) 
	    {
	        if(!(Character.isLetter(c)) && !(c == ' ')) 
	            return false;
	    }
	    return true;
	}
	
	/** Method to validate phone number of any entity */ 
	public static boolean isValidPhone(BigInteger phone)
	{
		if (phone.toString().length() == 10)
			return true;
		else
			return false;
	}
	
	/** Method to validate email id of any entity */
	public static boolean isValidEmail(String email) 
	{
		
		EmailValidator();
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	private static void EmailValidator()
	{
		pattern = Pattern.compile(EMAIL_PATTERN);
	}
}
