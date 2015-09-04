import java.util.*;

/**
 * DS Session8 Assignment
 * SortingSystem.java
 * @author Rohit
 *
 */
public class SortingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size, i, choice, maximum, maximumElementLength, temp;
		Scanner sc = new Scanner(System.in);
		System.out.print("\n Enter size of an array : ");
		try
		{
			do{
				System.out.print(" Enter positive Integer : ");
				while(!sc.hasNextInt()) {			// check whether number is integer or not
				System.out.println(" (Please Enter Integer Only)");
				sc.next();
				}
				size = sc.nextInt();   // take size of array as input
			}while( size <= 0);		// check size should be greate than zero
			int[] itemArray = new int[size];   // take a itemArray
			System.out.println("\n Enter elements in array");
			for(i=0; i<size; i++)
			{
				do{
					System.out.print(" Enter positive Integer : ");
					while(!sc.hasNextInt()) {			// check whether number is integer or not
					System.out.println(" (Please Enter Integer Only)");
					sc.next();
					}
					itemArray[i] = sc.nextInt();		// enter elements in itemArray takes input from user
				}while( itemArray[i] <= 0);
			}
			System.out.print("\n 1. Comparison Sorting ");  // create a menu for user for selecton for sorting
			System.out.print("\n 2. Linear Sorting ");
			System.out.print("\n\n Enter your choice : ");
			do{
				System.out.print(" (Enter positive Integer(0 to 1)) : ");
				while(!sc.hasNextInt()) {			// check whether number is integer or not
				System.out.println(" (Please Enter Integer Only)");
				sc.next();
				}
				choice = sc.nextInt();  // take choice from user
			}while( choice <= 0 || choice >=3 ); // It should be either one or two
			switch(choice)
			{
			case 1:   // If user select comparison sorting
				if( itemArray.length <= 10 )  // than check length of array if it is greter than 10 than use apply Bubble sorting on array
				{
					itemArray = BubbleSort.bubblesort(itemArray);
					System.out.print("\n By Using Bubble Sort Sorted array is : ");
				}
				else
				{
					itemArray = QuickSort.quickSort(itemArray, 0, size-1);  // else apply Quick sorting on array
					System.out.print("\n By Using Quick Sort Sorted array is : ");
				}
				break; // If user selct Linear Sorting
			case 2:
				maximum = itemArray[0]; 
				for(i=0; i<itemArray.length; i++)  // than first calculate maximum length of elemnt in array
				{
					if( maximum < itemArray[i] )
					{
						maximum = itemArray[i];
					}
				}
				temp = maximum;
				maximumElementLength = 0;
				while( temp != 0 )   // now calculate number digits in maximum element of itemArray 
				{
					temp = temp/10;
					maximumElementLength++;
				}
				if( maximumElementLength <= 2 ) // If digits are less than or equals to two than apply Counting Sorting on itemArray
				{
					itemArray = CountingSort.countSort(itemArray, maximum);
					System.out.print("\n By Using Counting Sort Sorted array is : ");
				}
				else  // else apply Radix Sorting on itemArray
				{
					itemArray = RadixSort.radixSort(itemArray, maximum);
					System.out.print("\n By Using Radix Sort Sorted array is : ");
				}
			}
			for(i=0; i<itemArray.length; i++)   // and in last display the elements of sorted itemArray
			{
				System.out.print(itemArray[i]+" ");
			}
			sc.close();
		}
		catch(Exception e)   // catch for handling any exception
		{
			System.out.print(e.getMessage());
		}
	}

}
