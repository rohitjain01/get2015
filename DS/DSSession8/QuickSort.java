
public class QuickSort {
	
	static int[] quickSort(int[] elements, int left, int right) {
		// base case
				if (right - left <= 0) 
				{
					return elements;
				}
				
				// recursive case
				else 
				{
					int border = partition(elements, left, right);	// recursive method partition is invoked with parameters itemArray, left index and right index
					quickSort(elements, left, border-1);		// recursive method recQuickSort is invoked with parameters itemArray, leftIndex and border-1 index
					quickSort(elements, border+1, right);		// recursive method recQuickSort is invoked with parameters itemArray, border+1 index
					return elements;								// return itemArray as sorted array at completion of sorting	
				}
	}
	
	/* this method performs partition of the array as elements less than pivot and
	 * elements greater than pivot.
	 */
	private static int partition(int itemArray[], int left, int right)
	{
		int low = left; // set at the left border of the range
		int high = right; //set at the right border where the pivot sits

		int pivot = itemArray[right];		// set element at right index of array as pivot element
		while(low < high) 					
		{	
			/* this code will be executed till low index is less than high index*/
			if (itemArray[low] < pivot) 
			{
				low++;
			}
			else 
			{
				high--;
				swap(itemArray, low, high);		// swap function to swap two elements of itemArray
			}
		}
		swap(itemArray, high, right); // put the pivot on the border
		return high;
	}
	
	private static void swap(int[] elements, int i, int j) {  // method for swap the elements of array from location i and j
		int temp;
		temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}

}
