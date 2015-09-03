import java.util.*;
/**
 *DS Session 5 Assignment
 *ConcordanceCharacters.java
 *author @Rohit
 */
public class ConcordanceCharacters {
	
	public static void main(String args[])
	{
		int i;
		String s="";
		try
		{
			Concordance concordanceObj = new Concordance();// make object of concordance class
			for( i=0; i<args.length; i++ )
			{
				s = s+args[0].toString();
			}
			concordanceObj.findConcordance(s); // call method findConcordance to calculate Concordance of characters
			for( Map.Entry< Character, String > entry : Concordance.concordanceMap.entrySet() ) { // make a entry object of Map.Entry for get the values from a Map object
				System.out.println(entry.getKey()+": "+entry.getValue());
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
