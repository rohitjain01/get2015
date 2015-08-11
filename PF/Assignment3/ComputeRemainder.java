import java.util.*;

/*
 * Session 3 Assignment
 * ComputeRemainder.java
 * Purpose :  To compute the remainder of when a number is divided by another number using Recursion
 * @ author Rohit
 */
public class ComputeRemainder {

	/*
	 * This method rem takes two arguments 
	 * First is Dividend and Second is Divisor
	 * It returns the reminder after performing division.
	 * This is a Recursive method.
	 */
	public int rem ( int x, int y )
	{
		int n;
		x = Math.abs (x); // To make each number is positive
		y = Math.abs (y);
		if (y == 0)
		{
			return -1; // if Divisor is 0 than It will return -1 means division can't possible.
		}
		else if ( x < y )
		{
			return x;    // if Dividend is less then Divisor then remainder is Dividend. 
		}
		else if ( x == y )
		{
			return 0;    // If both Dividend and Divisor are equal then remainder will be 0. 
		}
		else
		{
			n = x - y;              // make Dividend as a Divisor-Dividend
			return rem ( n, y );        // call the recursive method
		}
	}
	
	public static void main ( String[] args )
	{
		ComputeRemainder a1 = new ComputeRemainder ();
		int n;
		Scanner sc = new Scanner ( System.in );
		int x, y;
		
		System.out.print("\n Enter Dividend : ");
		x = sc.nextInt();							// take Dividend as input
		System.out.print("\n Enter Divisor : ");
		y = sc.nextInt();							// take Divisor as input
		
		n = a1.rem ( x, y );					// call rem method and take the output in variable n.
		if ( n == -1 )
		{
			System.out.print("\n Divisior should be positive ");
		}
		else
		{
			System.out.print("\n Remainder is : "+n);
		}
	}
}
