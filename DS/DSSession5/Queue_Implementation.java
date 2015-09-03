import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * DS Session5 Assignment
 * Queue_Implementation.java
 * @author Rohit
 *
 */

public class Queue_Implementation {

	public static void main(String args[]) {
		Scanner scan = null;
		LinkedList<Integer> queueList = null;// take a queue which is of linked list type
		try
		{
			scan  = new Scanner(System.in);
			int choice, number, result;
			queueList = new LinkedList<Integer>();
			do  // create a menu for user options
			{
				System.out.println("Enter your choice: ");
				System.out.println("1. Add an element to queue");
				System.out.println("2. Remove an element from queue");
				System.out.println("3. Get front element of queue");
				System.out.println("4. Display the queue");
				System.out.println("5. clear the queue");
				System.out.println("6. Exit");
				do {
					System.out.println("Please Enter positive integer(less than 5)");
					while(!scan.hasNextInt()) {
						System.out.println("Please Enter Integer Only");
						scan.next();
						}
						choice = scan.nextInt();
					} while(choice <= 0 || choice >= 7);
				
					switch(choice) {
					
						case 1:
							System.out.println("Enter a numebr: ");
							while(!scan.hasNextInt()) {			// to check whether number is integer or not
								System.out.println("Please Enter Integer Only");
								scan.next();
							}
							number = scan.nextInt(); // scan the number
							queueList.addLast(number); // add this number in queue
							break;
							
						case 2:
							if(!queueList.isEmpty()) { // if queue is not empty
								result = queueList.poll(); // than remove element from queue and print it also
								System.out.println("Removed Element is: "+result);
							}
							else
								System.out.println("Queue is Empty");
							break;
							
						case 3:
							if(!queueList.isEmpty()) {  // if queue is not empty
								result = queueList.peek(); // than print fist element of queue
								System.out.println("Front Element is: "+result);
							}
							else
								System.out.println("Queue is Empty");
							break;
							
						case 4:
							if(!queueList.isEmpty()) { // if queue is not empty
								Iterator<Integer> listIterator = queueList.listIterator();// take a iterator from queue
								System.out.print("Queue is: ");
								while(listIterator.hasNext()) {	// and print element from iterator until iterator is empty
									System.out.print(listIterator.next()+" ");
								}
								System.out.println();
							}
							else
								System.out.println("Queue is Empty");
							break;
							
						case 5:
							queueList.clear();
							break;
							
						case 6:
							System.out.println("System Exited");
							System.exit(0);
							break;
							
							default:
								System.out.println("Enter correct choice");
				}
			} while(true);
		}
		catch(Exception e) {		// catch the exception if any occur
			System.out.println(e.getMessage());
			scan.close();
		}
	}
}
