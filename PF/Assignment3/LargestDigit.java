import java.util.*;

/*
 * Session 3 Assignment
 * LargestDigit.java
 * Purpose :  To find largest digit from a number using Recursion
 * @ author Rohit
 */
public class LargestDigit {
	
	int max = 0;			// take a data member max which holds the maximum digit of number
	/*
	 * This method largestDigit takes a number as an argument
	 * and returns the Largest Digit of this number
	 * This is a Recursive method.
	 */
	public int largestDigit ( int x )
	{
		if ( x < 0 )
		{
			return -1;			// If number is negative than Largest Digit can't calculated 
		}
		else if ( x == 0 )
		{
			return max;			// IF number is Zero than Largest Digit is in variable max
		}
		else
		{
			if ( max < ( x% 10))  // compare max to last digit of number if max is less than put that digit in max
			{
				max = x%10;
			}
			return largestDigit ( x / 10 );   // Remove last digit from number and call the recursive method
		}
	}
	
	public static void main ( String[] args )
	{
		int x, n;
		Scanner sc = new Scanner ( System.in );
		
		System.out.print("\n Enter any Number : ");
		x=sc.nextInt();
		
		LargestDigit ld = new LargestDigit ();
		n = ld.largestDigit ( x );				// call largestDigit method and take output in n
		
		if ( n == -1 )
		{
			System.out.print("\n Number should be positive ");
		}
		else
		{
			System.out.print("\n Largest Digit is : "+n);
		}
		
	}

}
