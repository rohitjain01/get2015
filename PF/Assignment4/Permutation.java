import java.util.*;

/**
 * Session4 Assignment
 * Permutation.java
 * Purpose :  To generate all possible permutations of given letters in string
 * @author Rohit
 */
public class Permutation 
{

	
	public static void main ( String[] args ) 
	{
		// TODO Auto-generated method stub
		String inputString;
		Scanner sc = new Scanner( System.in );
		
		System.out.println("Enter a String: ");
		inputString = sc.next();					// take string as input
		
		Permutation objOne=new Permutation();
		List<String> Result = objOne.permute ( inputString ) ;		// call the permute method and get the result
		for(String s : Result)
		  {
			  System.out.println(s);
		  }
		sc.close();
	}
	
	List<String> permute( String input)
	{
		/*
		 * this method takes string as input 
		 */
	  int inputLength = input.length();						// take input string length in a variable
	  StringBuilder outputString = new StringBuilder();		// Make a string builder object to append in string 
	  boolean[ ] characterUsed = new boolean[ inputLength ]; // make a boolean array of input string length
	  List<String> Result = new ArrayList<String>();		// make a List to holds the result
	  char[ ] in = input.toCharArray( );				// put string values in character array
	  
	  Result = doPermute ( in, Result, characterUsed, inputLength, 0, outputString); // call doPermute method which generates all possible permutations of string
	 
	  
	  return Result;

	}
	
	List<String> doPermute ( char[ ] in, List<String> Result, boolean[ ] characterUsed, int inputLength, int level, StringBuilder outputString)
	{
		/*
		 * this method takes 5 inputs
		 * It is a Recursive method
		 * It generates all the possible permutations of string
		 */
		boolean flag = false;
		if( level == inputLength ) 
		{				// If level is reached at the input length than this condition is work
			for(String s : Result)
			{
				if( s.equals( new String(outputString) ) ) // if generated permutation already generated than discard it
				{
					flag = true;
					break;
				}
			}
			if( flag == false )
				Result.add( outputString.toString() );		// add the desired permutation in Result list
			return Result;
		}
		
		for( int i = 0; i < inputLength; i++ )
		{       
	
			if( characterUsed[i] )     // If corresponding boolean is true than continue 
				continue;
			
			outputString.append( in[i] );      // append character in outputString String Builder
			characterUsed[i] = true;       // Make corresponding boolean value is true
			doPermute( in,   Result, characterUsed, inputLength, level + 1, outputString ); // call recursive method increase level by 1
			characterUsed[i] = false;     // make boolean value is false  
			outputString.setLength( outputString.length() - 1 );
		}
		return Result;
	}
}




