import java.util.*;

/*
 * Session 3 Assignment
 * LiearSearch.java
 * Purpose :  To search an element from an array using linear search with the help of Recursion
 * @ author Rohit
 */
public class LinearSearch {
	
	int i = 0;						// this variable holds the position of array
	public int linearSearch ( int[] a, int search )
	{
		if ( i == a.length )
		{
			return -1;			// if i reaches maximum length of array than element is not found return -1.
		}
		else if(a[i] == search)
		{
			return i+1;		// if element is found than returns that position
		}
		else
		{
			i++;
			return linearSearch ( a, search ); //otherwise increment the i and call recursive method 
		}
	}

	public static void main ( String[] args ) 
	{
		// TODO Auto-generated method stub
		int size, i, search, pos;
		Scanner sc = new Scanner ( System.in );
		
		System.out.print("\n Enter the size of an array : ");
		size = sc.nextInt();					// take size of array as input
		
		int[] a = new int [size];
		System.out.println("\n Enter Elements : ");
		for ( i=0; i<size; i++ )
		{
			a[i] = sc.nextInt();				// take array elements as input
		}
		
		System.out.print("\n Enter Element which you want to serch : ");
		search = sc.nextInt();
		LinearSearch ls = new LinearSearch ();
		
		pos = ls.linearSearch( a, search );			// call linearSearch method
		if ( pos == -1 )
		{
			System.out.print("\n Element not found ");
		}
		else
		{
			System.out.print("\n Element is found at : "+pos);
		}
	}

}
