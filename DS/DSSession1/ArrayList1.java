import java.util.Scanner;

/**
 * DS Session1 Assignment
 * ArrayList1.java
 * @author Rohit
 *
 */
public class ArrayList1 {

	/**
	 * This class is same as previous assignment all methods are same except one method addlist()
	 * this method add two separate list into in one list  
	 */
	int index;
	int[] list;
	Scanner sc = new Scanner(System.in);
	ArrayList1()
	{
		index = 0;
		list = new int[10];
	}
	void addItem()
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
		list[index++] = item;
	}
	void addItemLocation( int loc )
	{
		if( loc < index )
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
			for(i=index; i>loc; i--)
			{
				list[i] = list[i-1];
			}
			list[loc] = item;
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
			item = list[loc];
			int i;
			for(i=0; i<=loc; i++)
			{
				if( item == list[i] )
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
			if( item == list[i] )
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
				list[i] = list[i+1];
			}
			index--;
		}
		else
		{
			System.out.print("\n Location not found");
		}
	}
	void removeItem( int item )
	{
		int i, loc = 0;
		for(i=0; i<index; i++)
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
				list[i] = list[i+1];
			}
			index--;
		}
	}
	void removeAll()
	{
		index = 0;
		list = new int[10];
	}
	void reverse()
	{
		int i;
		int buff[] = new int[index];
		int temp = index-1;
		for(i=0; i<index; i++)
		{
			buff[i] = list[i];
		}
		for(i=0; i<index; i++)
		{
			list[temp--] = buff[i];
		}
	}
	void sort()
	{
		int i, j, temp;
		for(i=0; i<index; i++)
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
	void addlist(ArrayList1 list1)
	{
		int n, count = 0, i, j;
		System.out.print("\n Enter how many elements you want to store in list ");
		n = sc.nextInt();				// get how many elements user wants to store in new list
		list1.index = n;				// put this value in that list index
		while( n != 0 )
		{
			n = n/10;				// take size of new list in a multiplier of 10
			count++;
		}
		n = count*10;
		list1.list = new int[n];			// make a list of size n(Sufficient size in multiplier of 10)
		System.out.println("\n Enter Elements : ");
		for(i=0; i<list1.index; i++)
		{
			list1.list[i] = sc.nextInt();				// store elements in new list
		}
		int[] buffer = new int[index];
		for(i=0; i<index; i++)
		{
			buffer[i] = list[i];				// take a buffer array to store elements of old list
		}
		int listlength;
		listlength = list.length + n;
		list = new int[listlength];			// resize the old list that can store both lists's elements
		for(i=0; i<index; i++)
		{
			list[i] = buffer[i];		// store the elements of 1st list from buffer array
		}
		for(j=0; j<list1.index; j++)
		{
			list[i++] = list1.list[j];		// store elements of 2nd list in 1st list
		}
		index = i;						// update the index location
	}
	void display()
	{
		int i;
		
		System.out.print("Array list is : ");
		for(i=0; i<index; i++)
		{
			System.out.print(list[i]+" ");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList1 al = new ArrayList1();
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
							 "\n 10.Add new list"+
							 "\n 11.Display List"+
							 "\n 12.Exit");
			System.out.print("\n Enter Your Choice : ");
			ch = sc.nextInt();
			switch(ch)
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
				ArrayList1 al1 = new ArrayList1();
				al.addlist(al1); break;
			case 11:
				al.display(); break;
			case 12:
				System.exit(0);
			}
		}
		
	}

}
