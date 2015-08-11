import java.util.*;

/*
 * Session 3 Assignment
 * BinarySearch.java
 * Purpose :  To search an element from an array using Binary search with the help of Recursion
 * @ author Rohit
 */
public class BinarySearch {
	
	public int binarySearch ( int[] a, int max, int min, int mid, int search )
	{
		if ( max < min )
		{
			return -1;		// if max is less than min than element is not found
		}
		else if( a[mid] == search )
		{
			return mid+1;		// If element is found than return that position
		}
		else if( a[mid] < search )
		{
			/* If mid element is less than the search element than increment min as a mid+1 and call recursive method
			 */
			min = mid + 1;
			mid = ( max + min ) / 2;
			return binarySearch( a, max, min, mid, search );
		}
		else
		{
			/* If mid element is larger than the search element than make max as a mid-1 and call recursive method
			 */
			max = mid - 1;
			mid = ( max + min ) / 2;
			return binarySearch( a, max, min, mid, search );
		}
	}

	public static void main ( String[] args ) 
	{
		// TODO Auto-generated method stub
		int max, min, mid, i, size, search;
		Scanner sc = new Scanner ( System.in );
		
		System.out.print("\n Enter Size of Array : ");
		size = sc.nextInt();						// take size of array as input
		
		int[] a = new int [size];
		System.out.println("\n Enter Elements : ");
		for ( i=0; i<size; i++)
		{
			a[i] = sc.nextInt();					// take array elements as input
		}
		max = size-1;
		min = 0;
		mid = (max + min) / 2;
		
		System.out.print("\n Enter Searching Element : ");
		search = sc.nextInt();
		
		BinarySearch bs = new BinarySearch ();
		int pos = bs.binarySearch( a, max, min, mid, search );	// call BinarySearch method
		
		if( pos == -1 )
		{
			System.out.print("\n Element not found ");
		}
		else
		{
			System.out.print("\n Element is found at : "+pos);
		}

	}

}
