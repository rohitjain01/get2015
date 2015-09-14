/**
 *DS Session8 Assignment
 *CountingSort.java
 *@author Rohit
 */
public class CountingSort {
	
	static int[] countSort( int[] itemArray, int maximum) // static method count is used to implement the count sort
	{
		try
		{
			int i, j;
			int[] temporary = new int[maximum+1]; // take a temporary array which size is equal to maximum element of itemArray
			for(i=0; i<temporary.length; i++) // initally put 0's in temporary array
			{
				temporary[i] = 0;
			}
			for(i=0; i<itemArray.length; i++) //increment the value in temporay array corresponding variables of itemArray
			{
				temporary[itemArray[i]]++;
			}
			j = 0;
			for(i=0; i<temporary.length; i++) 
			{
				if( temporary[i] != 0)  // if temporary[i] is not zero than value of i put in itemArray and decrement the value of temporary[i]
				{
					itemArray[j++] = i;
					temporary[i]--;
					i--;
				}
			}
			return itemArray; // at last return the sortd array
		}
		catch(Exception e)   // catch for handling any exception
		{
			System.out.print(e.getMessage());
			return itemArray;
		}
	}

}
