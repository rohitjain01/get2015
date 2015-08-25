import java.util.*;

/**
 * DS Session1 Assignment
 * BinarySearch.java
 * @author Rohit
 *
 */
public class BinarySearch {

	int binarySearch ( int[] sortedArray, int search )
	{
		int max, min, mid;
		min = 0;
		max = sortedArray.length - 1;
		mid = (max+min)/2;
		while( (sortedArray[mid]!=search) && (min<=max) )
		{
			if( sortedArray[mid] > search ) // if search element is less than mid element than reduce max is mid-1 and update mid
			{
				max = mid-1;
				mid = (max+min)/2;
			}
			else			// if search element is greater than mid element than make min as mid+1 and update mid
			{
				min = mid+1;
				mid = (max+min)/2;
			}
		}
		if( max < min )		//if element is not found then make mid = -1 
		{
			mid = -1;
		}
		return mid;		// otherwise return mid
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size, i, search, loc;
		Scanner sc = new Scanner(System.in);
		System.out.print("\n Enter the size of an array : ");
		size = sc.nextInt();
		int[] sortedArray = new int[size];
		System.out.println("\n Enter Elements in sorted manner : ");
		for(i=0; i<size; i++)
		{
			sortedArray[i] = sc.nextInt();
		}
		System.out.print("\n Enter element which you want to search : ");
		search = sc.nextInt();
		BinarySearch bs = new BinarySearch();
		loc = bs.binarySearch(sortedArray, search);
		if( loc == -1 )
		{
			System.out.print("\n Element not found ");
		}
		else
		{
			System.out.print("Element at found at "+(loc+1));
		}
	}

}
