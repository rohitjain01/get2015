
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Rohit
 *
 */
public class MainSocialNetwork {

	public static Scanner sc = new Scanner(System.in);

	// Main method
	public static void main(String[] args) {
		
		BufferedReader bufferedReaderObj = null;
		try
		{
			bufferedReaderObj = new BufferedReader(new InputStreamReader(System.in));
			String tempName, email = null;
			int choice;
			Graph graph = new Graph();
			Processing processing = new Processing();
			/* reading person details */
			processing.readPersons();
			
			/* Reading organization details */
			processing.readFriends();
			
			do {
				
				MenuClass.showBasicMenu();
	
				do {// Validation
					System.out.println("Please enter a positive number!");
					while (!sc.hasNextInt()) {
						System.out
								.println("That's not a number!Please enter again");
						sc.next(); // this is important!
					}
					choice = sc.nextInt();
				} while (choice <= 0);
	
				switch (choice) {
				
				/* Case to print the social network */
				case 1:
					SocialNetwork.showNetwork();
					break;
	
				/* case to accept details of entity from user */
				case 2:
					Entity entity = processing.acceptDetails();
					graph.addNode(entity);
					break;
	
					/* case to remove entity */
				case 3:
					System.out.println("Enter name you want to remove : ");
					while(true) {
						System.out.println("name : ");
						tempName = bufferedReaderObj.readLine();
						if(Validation.isName(tempName))
							break;
						else
							System.out.println("Please Enter a valid Name");
					}
					for (Entity Object : Processing.nodeSet) {
	
						if (tempName.equalsIgnoreCase(Object.getName())) {
							graph.removeNode(Object);
							break;
						}
					}
					break;
	
					/* case to find an entity */
				case 4:
					SocialNetwork socialNetwork = new SocialNetwork();
					System.out.println("Enter name you want to find : ");
					while(true) {
						System.out.println("name : ");
						tempName = bufferedReaderObj.readLine();
						if(Validation.isName(tempName))
							break;
						else
							System.out.println("Please Enter a valid Name");
					}
					socialNetwork.searchByName(tempName);
					break;
	
					/* case to show friends of an entity */
				case 5:
					int count = 0;
					System.out.println("Enter name whose friends list you want : ");
					while(true) {
						System.out.println("name : ");
						tempName = bufferedReaderObj.readLine();
						if(Validation.isName(tempName))
							break;
						else
							System.out.println("Please Enter a valid Name");
					}
					/* Iterating list of entities */
					Iterator<Entity> entityIterator = Processing.nodeSet.iterator();
																			
					while (entityIterator.hasNext()) {
						Entity entity2 = entityIterator.next();
						if (entity2.getName().equalsIgnoreCase(tempName)) {
							email = entity2.getEmail();
							System.out.println("name whose friends list you want : "+email);
							count++;
							break;
						}
						
					}
					if(count == 0)
						System.out.println("Entity not found in the list");
					else
						count = 0;
					for (Entity entityObject : Processing.nodeSet) {
						if (tempName.equalsIgnoreCase(entityObject.getName())) {
							Set<String> friends = SocialNetwork.getFriends(entityObject);
							if (friends.size() != 0) {
								System.out.println("Friends of " + tempName
										+ " are :");
								for (String friend : friends) {
									if (!friend.equals(email)) {
										System.out.println(friend);
									}
								}
							}
							else {
								System.out.println("No friends exist");
							}
						}
					}
					break;
					
					/* case to create connection */
				case 6:
					try
					{
						Entity entityVariable = new Entity();
						boolean test;
						do {
							System.out.println("Enter your email : ");
							while(true) {
								System.out.println("email : ");
								email = bufferedReaderObj.readLine();
								if (Validation.isValidEmail(email))
									break;
								else
									System.out.println("enter a valid email Id (example : abc@xyz.com)");
							}
							test = Validation.isValidEmail(email);
							if (test == false)
								System.out
										.println("enter a valid email Id (example : abc@xyz.com)");
						} while (test == false);
						entityVariable.setEmail(email);
						
						Entity entitySecondVariable = new Entity();
						do {
							System.out.println("Enter friend email : ");
							while(true) {
								System.out.println("email : ");
								email = bufferedReaderObj.readLine();
								if (Validation.isValidEmail(email))
									break;
								else
									System.out.println("enter a valid email Id (example : abc@xyz.com)");
							}
							test = Validation.isValidEmail(email);
							if (test == false)
								System.out
										.println("enter a valid email Id (example : abc@xyz.com)");
						} while (test == false);
						entitySecondVariable.setEmail(email);
						SocialNetwork.connect(entityVariable, entitySecondVariable);
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					break;
					
					/* Case to remove connection*/
				case 7:
					String emailFirst, emailSecond;
					System.out.println("enter your email: ");
					Entity entityFirst = new Entity();
					while(true) {
						System.out.println("Email : ");
						emailFirst = bufferedReaderObj.readLine();
						if(Validation.isValidEmail(emailFirst))
							break;
						else
							System.out.println("Please Enter a valid Name");
					}
					entityFirst.setEmail(emailFirst);
					System.out.println("enter friend's email: ");
					while(true) {
						System.out.println("Email: ");
						emailSecond = bufferedReaderObj.readLine();
						if(Validation.isValidEmail(emailSecond))
							break;
						else
							System.out.println("Please Enter a valid Name");
					}
					Entity entitySecond = new Entity();
					entitySecond.setEmail(emailSecond);
					
					/* removing connection between entity first and entity second */
					SocialNetwork.disconnect(entityFirst, entitySecond);
					break;
					
				case 8:
					/* System Exit */
					System.out.println("System.exited");
					System.exit(0);
				default:
					System.out.println("Enter Correct Choice");
				}
	
					System.out.println("Do you want to continue(Y/N)");	// continuing the procedure
			        choice = sc.next().toUpperCase().charAt(0);
			        if(choice=='N') {
		            	System.out.println("System Exited");
			        	System.exit(0);	  
			        }
	
			} while (choice=='Y');
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}