import java.util.*;

/**
 * DS Session7 Assignment
 * BinarSearchMain.java
 * @author Rohit
 *
 */
public class BinarySearchMain {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, size, searchNumber;
		Scanner sc = new Scanner(System.in);
		System.out.print("\n Enter Size of array : ");
		while(!sc.hasNextInt()) {			// check whether number is integer or not
			System.out.println("Please Enter Integer Only");
			sc.next();
		}
		size = sc.nextInt();						// take size of array as input
		Integer[] itemArray = new Integer[size];
		System.out.print("\n Enter elements in array : ");
		for(i=0; i<size; i++)
		{
			while(!sc.hasNextInt()) {			// check whether number is integer or not
				System.out.println("Please Enter Integer Only");
				sc.next();
			}
			itemArray[i] = sc.nextInt();		// input array elements
		}
		Arrays.sort(itemArray);
		System.out.print("\n Enter a number to be searched : ");
		while(!sc.hasNextInt()) {			// check whether number is integer or not
			System.out.println("Please Enter Integer Only");
			sc.next();
		}
		searchNumber = sc.nextInt();				// input item to be searched
		BinarySearch bs = new BinarySearch();  // make object of BinarySearch class
		int indexleft = bs.leftMostOccurence(itemArray, searchNumber, 0, size-1);  // call binarySearch method for calculate left most index of search item in array
		int indexright = bs.rightMostOccurence(itemArray, searchNumber, 0, size-1);  // call binarySearch method for calculate right most index of search item in array
		if( indexleft == -1 )   // if indexleft = -1 means element is not available in array
		{
			System.out.print("\n Element Not found ");
		}
		else				
		{
			System.out.print("\n Left most index of Element is "+indexleft+" index");
			System.out.print("\n Right most index of Element is "+indexright+" index");
		}
		
		sc.close();

	}

}
