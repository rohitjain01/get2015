import java.util.*;
/**
 * DS Session8 Assignment
 * RadixSort.java
 * @author Rohit
 */
public class RadixSort {
	
	static int[] radixSort( int[] itemArray, int maximum ) // static method radixSort is implementing radix sort
	{
		try
		{
			int i, j, countMaximumLength = 0, k;			
			int temp = maximum, count = 1, temp1, temp2;
			while( temp != 0 )  // calcuate length of maximum element of itemArray
			{
				countMaximumLength++;
				temp = temp/10;
			}
			Queue<Integer> queue[] = new Queue[10];  // make 10 Queues
			for(i=0; i<10; i++)
			{
				queue[i] = new LinkedList<Integer>();  // put linked list reference in each Queue
			}
			for(i=0; i<countMaximumLength; i++) // start the loop from 0 to countmaximumlength
			{
				for(j=0; j<itemArray.length; j++)	// start the loop from 0 to itemArray length
				{
					temp1 = itemArray[j]/count;			// take the element from itemArray to temp1 by removing last digits one by one
					temp2 = temp1%10;					// take the last digit after removing digits value
					queue[temp2].add(itemArray[j]);		// add this itemArray value in queue corresponding its remainder
				}
				count = count*10;				// increment count by multiply by 10
				k = 0;
				for(j=0; j<queue.length; j++)
				{
					while( queue[j].size() != 0 )
					{
						itemArray[k++] = (int)queue[j].poll();  // take the value from queue sequentially
					}
				}
			}
			return itemArray;   // after completion of loop returns the itemArray
		}
		catch(Exception e)   // catch for handling any exception
		{
			System.out.print(e.getMessage());
			return itemArray;
		}
	}

}
