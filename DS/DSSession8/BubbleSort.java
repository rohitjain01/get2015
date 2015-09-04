/**
 *DS Session8 Assignment
 *BubbleSort.java
 *@author Rohit
 */
public class BubbleSort {
	
	static int[] bubblesort ( int[] itemArray ) // static method bubbleSort implement Bubble Sorting
	{
		try
		{
			int i, j, temp;
			for(i=0; i<itemArray.length; i++)   // start the loop from 0 to array length
			{
				for(j=0; j<(itemArray.length-i-1); j++)  // run nested loop from 0 to looplength - i
				{
					if( itemArray[j] > itemArray[j+1] ) // if itemArray of jth position is greater than j+1 th position than swap both values
					{
						temp = itemArray[j];
						itemArray[j] = itemArray[j+1];
						itemArray[j+1] = temp;
					}
				}
			}
			return itemArray; // at last return the sorted array
		}
		catch(Exception e)   // catch for handling any exception
		{
			System.out.print(e.getMessage());
			return itemArray;
		}
	}

}
