import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * DS Session 5 Assignment
 * LinkedListMain.java
 * @author Rohit
 *
 */
public class LinkedListMain {

	public static void main(String args[]) {
		
		List<Integer> listObj = new LinkedList<Integer>();// make a object of list with the reference of linked list
		listObj.sort(null);			// sort the list
		int choice, value;
		Scanner scan = null;
		Iterator<Integer> iterator = null;
		LinkedListInsert linkedListInsertObj = new LinkedListInsert();// make a object of linkedListInsert class to insert an element in list in a sorted order
		try{
			scan = new Scanner(System.in);
			while( true )
			{
				System.out.print("\n 1. Insert an Element\n 2. Display List\n 3. Exit");
				System.out.print("\n Enter your choice : ");
				do {
						System.out.println("Please Enter positive integer(less than 4)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Only");
							scan.next();
						}
						choice = scan.nextInt();
					}while( choice <= 0 || choice >= 4 );
				switch(choice)
				{
				case 1:
					System.out.print("\n Enter Item value : ");
					do {
						System.out.println("Please Enter positive integer(less than 4)");
						while(!scan.hasNextInt()) {
							System.out.println("Please Enter Integer Only");
							scan.next();
						}
						value = scan.nextInt();
					}while( value <= 0 );
					listObj = linkedListInsertObj.insert(0, value, listObj);// call insert method
					break;
				case 2:
					if( listObj.size() != 0 )
					{
						iterator = listObj.iterator();// make a iterator to print elements of list
						System.out.print("\n List is : ");
						while(iterator.hasNext()) {
							System.out.print(iterator.next()+" ");
						}
					}
					else
					{
						System.out.print("\n List is empty ");
					}
				}
			}
		}
		catch( Exception e )
		{
			System.out.print(e.getMessage());
		}
		
	}
}
