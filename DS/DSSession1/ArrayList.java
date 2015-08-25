import java.util.*;

/**
 * DS Session1 Assignment
 * ArrayList.java
 * @author Rohit
 *
 */
public class ArrayList {

	
	int index;							// index variable holds that location in list where last variable is stored
	int[] list;							// list array to make a list
	Scanner sc = new Scanner(System.in);
	ArrayList()					// constructor to initialize the members of class
	{
		index = 0;
		list = new int[10];
	}
	void addItem()			// function to add an item in list at last position
	{
		System.out.print("\n Enter Item Value : ");
		int item;
		item = sc.nextInt();
		if( index == list.length )			// if list is full
		{
			int i;
			int buffer[] = new int[index];		// take all values of list in an array
			for(i=0; i<index; i++)
			{
				buffer[i] = list[i];
			}
			list = new int[index+10];		// resize the list
			for(i=0; i<index; i++)
			{
				list[i] = buffer[i];		// put all values from array to list
			}
		}
		list[index++] = item;			// add new item in list
	}
	void addItemLocation( int loc )				// this method add a new item in list at given location
	{
		if( loc < index )			// no the process is same as previous method how to resize the list
		{
			System.out.print("\n Enter Item Value : ");
			int item;
			item = sc.nextInt();
			if( index == list.length )
			{
				int i;
				int buffer[] = new int[index];
				for(i=0; i<index; i++)
				{
					buffer[i] = list[i];
				}
				list = new int[index+10];
				for(i=0; i<index; i++)
				{
					list[i] = buffer[i];
				}
			}
			int i;
			for(i=index; i>loc; i--)		// go to that location where item is going to be stored
			{
				list[i] = list[i-1];
			}
			list[loc] = item;			// put new item in that location
			index++;
		}
		else
		{
			System.out.print("\n Location not found");
		}
		
	}
	void retrievingFirstOccurrence( int loc )
	{
		if( loc < index )
		{
			int item;
			item = list[loc];			// get item from given location
			int i;
			for(i=0; i<=loc; i++)
			{
				if( item == list[i] )			// find its first occurrence
				{
					break;
				}
			}
			System.out.print(" Item is : "+item+" and its first occurrences is at : "+i+"th location");
		}
		else
		{
			System.out.print("\n Location not found");
		}
	}
	void findIndex( int item )
	{
		int i;
		for(i=0; i<index; i++)
		{
			if( item == list[i] )		// find location of that item in list
			{
				break;
			}
		}
		if( i == index )
		{
			System.out.print("\n Item not found ");
		}
		else
		{
			System.out.print("\n Item found at "+i+"th location");
		}
	}
	void removeAtLocation( int loc )
	{
		if( loc < index )
		{
			int i;
			for(i=loc; i<(index-1); i++)
			{
				list[i] = list[i+1];		// remove item by shifting the elements of list from that location
			}
			index--;			// reduce the size of index by one
		}
		else
		{
			System.out.print("\n Location not found");
		}
	}
	void removeItem( int item )
	{
		int i, loc = 0;
		for(i=0; i<index; i++)				// get the location of that item
		{
			if( item == list[i] )
			{
				loc = i;
				break;
			}
		}
		if( i == index )
		{
			System.out.print("\n Item not found ");
		}
		else
		{
			for(i=loc; i<index-1; i++)
			{
				list[i] = list[i+1];				// remove item by shifting elements of list
			}
			index--;
		}
	}
	void removeAll()
	{
		index = 0;				// make index is 0
		list = new int[10];		// list is reinitialized from beginning.
	}
	void reverse()
	{
		int i;
		int buff[] = new int[index];
		int temp = index-1;
		for(i=0; i<index; i++)			// take all the elements of list in a buffer array
		{
			buff[i] = list[i];
		}
		for(i=0; i<index; i++)			// put the elements of buffer array in list from last to first 
		{
			list[temp--] = buff[i];
		}
	}
	void sort()
	{
		int i, j, temp;
		for(i=0; i<index; i++)					// use bubble sort to sort the list
		{
			for(j=0; j<(index-i-1); j++)
			{
				if( list[j] > list[j+1] )
				{
					temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
		}
	}
	void display()
	{
		int i;
		
		System.out.print("Array list is : ");
		for(i=0; i<index; i++)					// display all elements of list 
		{
			System.out.print(list[i]+" ");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al = new ArrayList();   // make object of ArrayList class
		int ch, loc, item;
		Scanner sc = new Scanner( System.in );
		while(true)
		{
			
			System.out.print("\n 1. Adding an item "+
							 "\n 2. Adding an item into array list at the given particular location i"+
							 "\n 3. Retrieving the first occurrence of an item based on its given location"+
							 "\n 4. Retrieving the first index of particular item in the arraylist"+
							 "\n 5. Removing an item based on particular location"+
							 "\n 6. Remove given particular item from the arraylist  "+
							 "\n 7. Clear the list i.e. remove all the elements of the list"+
							 "\n 8. Reverse the arraylist"+
							 "\n 9. Sort the elements of arraylist"+
							 "\n 10.Display List"+
							 "\n 11.Exit");
			System.out.print("\n Enter Your Choice : ");
			ch = sc.nextInt();
			switch(ch)			// Apply switch case and call corresponding method according to the choice 
			{
			case 1: 
				al.addItem(); break;
			case 2:
				System.out.print("\n Enter Location : ");
				loc = sc.nextInt();
				al.addItemLocation(loc); break;
			case 3:
				System.out.print("\n Enter Location : ");
				loc = sc.nextInt();
				al.retrievingFirstOccurrence(loc); break;
			case 4: 
				System.out.print("\n Enter item : ");
				item = sc.nextInt();
				al.findIndex(item); break;
			case 5:
				System.out.print("\n Enter Location : ");
				loc = sc.nextInt();
				al.removeAtLocation(loc); break;
			case 6:
				System.out.print("\n Enter item : ");
				item = sc.nextInt();
				al.removeItem(item); break;
			case 7:
				al.removeAll(); break;
			case 8:
				al.reverse(); break;
			case 9:
				al.sort(); break;
			case 10:
				al.display(); break;
			case 11:
				System.exit(0);
			}
		}
		
	}

}
