import java.util.*;


/**
 * DS Session1 Assignment
 * SinglyList.java
 * @author Rohit
 *
 */
public class SinglyList {

	
	int nodeValue;				// variable holds the node value
	SinglyList next;			// It is a class type variable which holds address of next node
	static SinglyList first = null;		// static class type variable which holds address of first node
	static int count = 0;		// count holds total number of nodes in linked list 
	SinglyList()				// constructor initialize the members of class
	{
		nodeValue = 0;
		next = null;
	}
	void addAtFirst(int item)
	{
		SinglyList newnode = new SinglyList();		// make a new node which is going to be add 
		newnode.nodeValue = item;		// put the item value into node value
		newnode.next = first;			// now new node holds the address of first node
		first = newnode;			// make new node as a first node
		count++;				// increment count by 1
	}
	void addAtLoc(int loc, int item)
	{
		if( loc < count )							
		{
			SinglyList newnode = new SinglyList();
			newnode.nodeValue = item;
			int i;
			SinglyList tempnode = first;
			if( loc == 0 )			// if location is zero than add the node at first
			{
				newnode.next = tempnode;
				first = newnode;
				count++;
			}
			else					// otherwise go to that loc-1
			{
				for(i=0; i<(loc-1); i++)
				{
					tempnode = tempnode.next;
				}
				newnode.next = tempnode.next;		// now insert the node at that location
				tempnode.next = newnode;
				count++;
			}
		}
		else
		{
			System.out.print("\n Location not found ");
		}
	}
	void remove(int item)
	{
		SinglyList previousnode = first;
		SinglyList currnode = first;
		while( currnode != null )
		{
			if( currnode.nodeValue == item )// go to that location in list where this node value is find
			{
				break;
			}
			previousnode = currnode;			// previous node holds node at location -1  
			currnode = currnode.next;			// current node holds node at that location
		}
		if( currnode == null )
		{
			System.out.print("\n Item Not Found ");
		}
		else
		{
			previousnode.next = currnode.next;		// now create link between previous node to next node  
			currnode.next = null;	// remove links of current node
			count --;				// reduce the size of count
		}
	}
	void removeAtIndex(int loc)
	{
		if( loc < count )			// this method is same as previous method
		{
			int i;
			SinglyList previousnode = first;
			SinglyList currnode = first;
			for(i=0; i<loc; i++)
			{
				previousnode = currnode;
				currnode = currnode.next;
			}
			previousnode.next = currnode.next;
			currnode.next = null;
			count --;
		}
		else
		{
			System.out.print("\n Location not found ");
		}
	}
	void retrievel(int loc)
	{
		if( loc < count )	// for retrieving the element go to that location and print  element of that location
		{
			int i;
			SinglyList currnode = first;
			for(i=0; i<loc; i++)
			{
				currnode = currnode.next;
			}
			System.out.print("\n Item at "+loc+"th location is "+currnode.nodeValue);
		}
		else
		{
			System.out.print("\n Location not found ");
		}
	}
	void reverse()
	{
		SinglyList tempnode1 = first, tempnode2 = null, tempnode3;
		while( tempnode1 != null )
		{
			tempnode3 = tempnode2;			// put tempnode3 at tempnode3
			tempnode2 = tempnode1;			// put tempnode2 at tempnode1
			tempnode1 = tempnode1.next;		// tempnode1 goes to next node
			tempnode2.next = tempnode3;		// put tempnode3 address in tempnode2.next
		}
		first = tempnode2; // after completion of loop make tempnode2 as start
	}
	void sort()
	{
		SinglyList tempnode1 = first, tempnode2;
		int temp;
		while( tempnode1 != null )  // apply simple sorting to sort the elements of Linked list
		{
			tempnode2 = first;
			while( tempnode2.next != null )
			{
				if( tempnode2.nodeValue > tempnode2.next.nodeValue )
				{
					temp = tempnode2.nodeValue;
					tempnode2.nodeValue = tempnode2.next.nodeValue;
					tempnode2.next.nodeValue = temp;
				}
				tempnode2 = tempnode2.next;
			}
			tempnode1 = tempnode1.next;
		}
	}
	void display()
	{
		SinglyList currnode = first;			//put currnode at first
		System.out.print("\n Linked list is : ");
		while( currnode != null )
		{
			System.out.print(currnode.nodeValue+" ");		// now print the node value of currnode until currnode reach at null 
			currnode = currnode.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ch, loc, item;
		Scanner sc = new Scanner(System.in);
		SinglyList list = new SinglyList();
		while(true)
		{
			System.out.print("\n 1. Add Element at First"
							+"\n 2. Add Element at Location"
							+"\n 3. Removal of an item based on its value "
							+"\n 4. Removal of an item based on its index"
							+"\n 5. Retrieval of an item of particular index"
							+"\n 6. Reversal of linked list"
							+"\n 7. Sorting of linked list"
							+"\n 8. Display linked list"
							+"\n 9. Exit");
			System.out.print("\n Enter Your choice : ");
			ch = sc.nextInt();
			switch(ch)			// Apply switch case and call corresponding method according to the user's choice
			{
			case 1:
				System.out.print("\n Enter node value : ");
				item = sc.nextInt();
				list.addAtFirst(item); break;
			case 2:
				System.out.print("\n Enter node value : ");
				item = sc.nextInt();
				System.out.print("\n Enter Location : ");
				loc = sc.nextInt();
				list.addAtLoc(loc, item); break;
			case 3:
				System.out.print("\n Enter node value : ");
				item = sc.nextInt();
				list.remove(item); break;
			case 4:
				System.out.print("\n Enter Location : ");
				loc = sc.nextInt();
				list.removeAtIndex(loc); break;
			case 5:
				System.out.print("\n Enter Location : ");
				loc = sc.nextInt();
				list.retrievel(loc); break;
			case 6:
				list.reverse(); break;
			case 7:
				list.sort(); break;
			case 8:
				list.display(); break;
			case 9:
				System.exit(0);
			}
		}

	}

}
