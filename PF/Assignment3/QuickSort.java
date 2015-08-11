import java.util.*;

/*
 * Session 3 Assignment
 * QuickSort.java
 * Purpose :  To implement quick sorting algorithm with the help of Recursion
 * @ author Rohit
 */
public class QuickSort {
	
	public int[] quickSort ( int[] a, int max, int min )
	{
		if ( max > min )
		{
			int pivot;
			pivot = (min + max) / 2;		// take mid element as pivot
			int i, j;
			i = min;
			j = max;
			while ( i < j )
			{
				while ( (a[i] < a[pivot]) )	// check in left side of pivot element which is greater than pivot
				{
					i++;
				}
				while ( (a[j] > a[pivot]) ) // check in right side of pivot element which is less than pivot 
				{
					j--;
				}
				if ( i < j )
				{
					if ( i == pivot )
					{
						pivot = j;	// if i reached at pivot location than make pivot location is j
					}
					else if ( j == pivot )
					{
						pivot = i;	// if j reached at pivot location than make pivot location is i
					}
					int temp;		// now swaps the elements of location i and j 
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
			/* Now element which is on pivot location reached its correct location
			 * so divide the array in two sub arrays one is left side of pivot and other is in right side of pivot
			 * now call the recursive method for both of these and so on 
			 */
			quickSort( a, pivot-1, min);	 
			quickSort( a, max, pivot+1);
		}
		
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, size, max, min;
		Scanner sc = new Scanner( System.in );
		
		System.out.print("\n Enter Size of array : ");
		size = sc.nextInt();								// take size of array as input
		
		int[] input = new int[size];
		System.out.println("\n Enter Elements : ");
		for ( i=0; i<size; i++ )
		{
			input[i] = sc.nextInt();						// take array elements as input
		}
		
		QuickSort qs = new QuickSort();
		int[] output = qs.quickSort ( input, size-1, 0 );	// call Recursive method 
		System.out.print("\n Output Array is : ");
		for ( i=0; i<output.length; i++ )
		{
			System.out.print(output[i]+" ");
		}

	}

}
