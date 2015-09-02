

/**
 * DS Session7 Assignment
 * BinarSearch.java
 * @author Rohit
 *
 */
public class BinarySearch {
	
	int result = -1;
	public int leftMostOccurence(Integer[] itemArray, int searchNumber, int min, int max)
	{
		int mid = (max+min)/2;  // calculate mid
		try
		{
			if( max < min)  // if max become less than mid than return result
			{
				return result;
			}
			else if( searchNumber == itemArray[mid] ) // if search number if equals to mid element of itemArray
			{
				result = mid; // than put mid index in result
				return leftMostOccurence( itemArray, searchNumber, min, mid-1);// and call method recursively with change the value of max as mid-1 
			}
			else if( searchNumber < itemArray[mid] )  // if search number is less than element of itemArray at mid index 
			{
				return leftMostOccurence( itemArray, searchNumber, min, mid-1); // than call method recursively with change the value of max as mid-1
			}
			else if( searchNumber > itemArray[mid] )   // if search number is greater than element of itemArray at mid index 
			{
				return leftMostOccurence( itemArray, searchNumber, mid+1, max); // than call method recursively with change the value of max as mid+1
			}
			return result;
		}
		catch(Exception e)
		{
			
			System.out.print(e.getMessage());
			return -1;
		}
		
	}
	public int rightMostOccurence(Integer[] itemArray, int searchNumber, int min, int max)
	{
		int mid = (max+min)/2;  // calculate mid
		try
		{
			if( max < min)  // if max become less than mid than return result
			{
				return result;
			}
			else if( searchNumber == itemArray[mid] ) // if search number if equals to mid element of itemArray
			{
				result = mid; // than put mid index in result
				return rightMostOccurence( itemArray, searchNumber, mid+1, max);// and call method recursively with change the value of min as mid+1 
			}
			else if( searchNumber < itemArray[mid] )  // if search number is less than element of itemArray at mid index 
			{
				return rightMostOccurence( itemArray, searchNumber, min, mid-1); // than call method recursively with change the value of max as mid-1
			}
			else if( searchNumber > itemArray[mid] )   // if search number is greater than element of itemArray at mid index 
			{
				return rightMostOccurence( itemArray, searchNumber, mid+1, max); // than call method recursively with change the value of max as mid+1
			}
			return result;
		}
		catch(Exception e)
		{
			
			System.out.print(e.getMessage());
			return -1;
		}
		
	}
}
