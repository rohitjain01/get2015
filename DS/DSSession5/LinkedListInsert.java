import java.util.List;

/**
 * LinkedListInsert.java
 * @author Rohit
 *
 */
public class LinkedListInsert{
	
	public List<Integer> insert(int index, int element, List<Integer> list) {
		if( list.size() == 0 ) // if list is empty than directly add element in list
		{
			list.add(element);
		}
		else if( (int)list.get(index) < element ) // if element at index is less than the element which is going to be add
		{
			insert(index+1, element, list); // than call method recursively with increment in index by one 
		}
		else
		{
			list.add(index, element); //  else add the element at that index
		}
		return list; // at last return the list
	}
	

}
