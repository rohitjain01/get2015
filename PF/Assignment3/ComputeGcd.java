import java.util.*;

/*
 * Session 3 Assignment
 * ComputeGcd.java
 * Purpose :  To compute the GCD(Greatest Common Divisor of two numbers) using Recursion
 * @ author Rohit
 */
public class ComputeGcd {
	
	/*
	 * This method gcd takes two arguments 
	 * It returns the gcd of these two numbers.
	 * This is a Recursive method.
	 */
	public int gcd ( int x, int y )
	{
		if ( x < 0 || y < 0 )
		{
			return -1;			// If any number is less than 0 gcd can not be computed so return -1.
		}
		else if ( x == y )
		{
			return x;			// If both numbers are equal than gcd is that number. 
		}
		/* 
		 * IF one number is larger than another number than make large number is large-small
		 * and than call the recursive method gcd
		 */
		else if ( x > y )		
		{
			x = x - y;
			return gcd ( x, y );
		}
		else
		{
			y = y - x;
			return gcd ( x, y );
		}
	}

	public static void main ( String[] args )
	{
		
		int x, y;
		int n;
		ComputeGcd cg = new ComputeGcd ();
		Scanner sc = new Scanner ( System.in );
		
		System.out.print("\n Enter First Number : ");
		x = sc.nextInt ();
		System.out.print("\n Enter Second Number : ");
		y = sc.nextInt ();
		
		n = cg.gcd ( x, y );				// call the gcd method and take output in n
		if ( n == -1 )
		{
			System.out.print("\n Each Number should be positive ");
		}
		else
		{
			System.out.print("\n GCD of these numbers is : "+n);
		}
		
		
	}
}
