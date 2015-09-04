import java.util.*;

/**
 * OOP Sessio4 Assignment
 * Menu.java
 * @author Rohit
 *
 */
public class Menu  {
	List<MenuItem> items = new ArrayList<>();  // make a array list to store options
	private Scanner scan  = new Scanner(System.in); // scan to take value from user
	
	
	public void addMenuItem(MenuItem item){  // add items in list
		items.add(item);
	}

	public void display() {
		try
		{
			while (true) {
			for ( MenuItem i: items )
			{
				i.display();   // display the list elements to user
			}
			System.out.println("Enter your choice");
			int choice = scan.nextInt();  // take input from user as input
			
			items.get(choice-1).takeAction(choice); // according to choice call takeAction
			}
		}
		catch(IndexOutOfBoundsException ae)			// catch any exception if occur
		{
			System.out.println("cdfv");
			return;
		}
	
	}
}



