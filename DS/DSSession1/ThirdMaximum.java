import java.util.*;

/**
 * DS Session1 Assignment
 * ThirdMaximum.java
 * @author Rohit
 *
 */
public class ThirdMaximum {

	int maximum3 ( int[] array )
	{
		int max1, max2, max3, i;
		int min = array[0];
		for(i=0; i<array.length; i++)		// find minimum element in array
		{
			if( min > array[i] )
			{
				min = array[i];
			}
		}
		max1 = min;					// assign minimum value in max1, max2 & max3.
		max2 = min;
		max3 = min;
		for(i=0; i<array.length; i++)
		{
			if( max1 < array[i] )		
			{
				max3 = max2;			// put max2 in max3
				max2 = max1;			// put max1 in max2
				max1 = array[i];		// put array value in max1
			}
			else if( max2 < array[i] )
			{
				max3 = max2;		// put max2 in max3
				max2 = array[i];	// put array value in max2
			}
			else if( max3 < array[i] )
			{
				max3 = array[i];		// put array value in max3
			}
		}
		return max3;			// return max3
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size, i, max3;
		Scanner sc = new Scanner(System.in);
		System.out.print("\n Enter the size of an array : ");
		size = sc.nextInt();
		int[] array = new int[size];
		System.out.println("\n Enter Elements : ");
		for(i=0; i<size; i++)
		{
			array[i] = sc.nextInt();
		}
		ThirdMaximum tm  = new ThirdMaximum();
		max3 = tm.maximum3(array);						// call maximum3 method and get the result
		System.out.print("\n Third Maximum is : "+max3);
	}

}
