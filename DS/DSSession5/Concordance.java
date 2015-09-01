import java.util.*;
public class Concordance {
	
	private Set<Character> characterSet = new HashSet<Character>(); // make a Hash Set to take the items uniquely
	
	static public Map< Character, String > concordanceMap = new HashMap< Character, String >();// holds final concordance of characters
	private void readCharacters( String string )
	{
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
	public void findConcordance( String string )
	{
		readCharacters( string ); // call above method
		Iterator<Character> setIterator = characterSet.iterator();// take a iterator for characterSet
		while( setIterator.hasNext() )
		{
			int count = 0;
			char temp = (char)setIterator.next();// take one by one character in temp
			int index = string.indexOf(temp);// find first index for character in temp
			concordanceMap.put(temp, "[");// for a good view put [ in Map corresponding to that character
			while( index >= 0 )// if index is find for character
			{
				if( count > 0 )// if more than one index than 
				{
					concordanceMap.put(temp, concordanceMap.get(temp)+",");// add , in map corresponding to temp character
				}
				concordanceMap.put(temp, ""+concordanceMap.get(temp)+index);// add index value in map 
				index = string.indexOf(temp, index+1);// check for another index
				count++; // increase count
			}
			concordanceMap.put(temp, concordanceMap.get(temp)+"]");// at last add ] in map
		}
	}

}
