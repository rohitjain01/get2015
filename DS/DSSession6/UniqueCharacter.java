import java.util.*;

/**
 * DS Session5 assignment
 * UniqueCharacter.java
 * @author Rohit
 *
 */
public class UniqueCharacter {	
	public static void main(String args[])
	{
		String s=""; // take a string for input
		String result; // string which holds output
		try
		{
			Concordance concordanceObj = new Concordance();// make object of concordance class
			Scanner scan = new Scanner(System.in);
			int choice;
			while(true) // make options for user choice
			{
				System.out.print("\n 1. Print Unique Characters\n 2. Exit");
				System.out.print("\n Enter your choice : ");
				do {
					System.out.println("Please Enter positive integer(less than 4)");// check whether number is integer or not
					while(!scan.hasNextInt()) {
						System.out.println("Please Enter Integer Only");
						scan.next();
					}
					choice = scan.nextInt();
				}while( choice <= 0 || choice >= 3 );
				switch(choice)
				{
				case 1:
					System.out.print("\n Enter a String : ");
					s = scan.next();// take string input from user
					result = concordanceObj.findConcordance(s); // call method findConcordance to calculate Concordance of characters
					System.out.print(result);
					break;
				case 2:
					scan.close();
					System.exit(0);
				}
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
class Concordance {
	
	private Set<Character> characterSet; // make a Hash Set to take the items uniquely
	static public Map<String, String> uniqueMap = new HashMap<String, String>();// make a hash map which holds input strings as key and their concordance as value
	
	private Map< Character, String > concordanceMap;// holds final concordance of characters
	private void readCharacters( String string )
	{
		characterSet = new HashSet<Character>();  // initialize charcterSet
		concordanceMap = new HashMap< Character, String >(); // initialize concordanceMap
		char[] charArray = string.toCharArray(); // take string is in character array
		
		for( char c: charArray )
		{
			characterSet.add(c); // add each character in characterSet
		}
		
		Iterator<Character> setIterator = characterSet.iterator();// take a iterator for characterSet
		while(setIterator.hasNext())
		{
			concordanceMap.put((char)setIterator.next(), "");// initially set the null concordance of each character
		}
	}
	public String findConcordance( String string )
	{
		readCharacters( string ); // call above method
		Iterator<Character> setIterator = characterSet.iterator();// take a iterator for characterSet
		if( uniqueMap.size() != 0) // if uniqueMap is not empty than check keys of it
		{
			Set<String> keys = uniqueMap.keySet(); // take all keys uniqueMap in a keys set
			Iterator<String> iterator = keys.iterator(); // take a iterator for keys set
			boolean flag = false;
			while( iterator.hasNext() ) 
			{
				if( string.equals( (String)iterator.next()) ) // if any key is equals to string than make flag true
				{
					flag = true;
					break;
				}
			}
			if( flag == true ) // if flag is true than take value from uniqueMap from corresponding key string
			{
				String result = uniqueMap.get(string);
				System.out.println("\n already in map");
				return result; // returns the result
			}
		}
		while( setIterator.hasNext() ) // if string is not found in uniqueMap than
		{
			int count = 0;
			char temp = (char)setIterator.next();// take one by one character in temp
			int index = string.indexOf(temp);// find first index for character in temp
			concordanceMap.put(temp, "[");// for a good view put [ in Map corresponding to that character
			while( index >= 0 )// if index is find for character
			{
				index = string.indexOf(temp, index+1);// check for another index
				count++; // increase count
			}
			concordanceMap.put(temp, concordanceMap.get(temp)+count+"]");// at last add ] in map
		}
		String result = "";
		for( Map.Entry< Character, String > entry : concordanceMap.entrySet() )
		{
			result = result+entry.getKey()+": "+entry.getValue()+"\n";
		}
		uniqueMap.put(string, result); // store this result in uniqueMap
		return result; // return the result
	}

}

