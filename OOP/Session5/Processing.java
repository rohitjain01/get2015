
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


/**
 * @author Rohit
 *
 */
public class Processing {
	
	BufferedReader bufferedReaderObj;
	
	public static Set<Entity> nodeSet = new HashSet<Entity>();
	
	public static HashMap<String, Set<String>> friendMap = new HashMap<String, Set<String>>();
	
	/**
	 * Method to read friends list from file
	 */
	public void readFriends() {
		int i=0;
		try {
			bufferedReaderObj = new BufferedReader(new FileReader(Constants.FRIEND_FILE.getAbsolutePath()));
			String line;
			Set<String> friendSet = new HashSet<String>();
			try {
				while ((line = bufferedReaderObj.readLine()) != null) {
					String[] email = line.split(",");
					Iterator<Entity> itr1 = nodeSet.iterator();	//Iterating list of questions
					while (itr1.hasNext()) {
						if(itr1.next().getEmail().equals(email[0])){
							for (int index = 1; index < email.length; index++) {
								Iterator<Entity> itr = nodeSet.iterator();	//Iterating list of questions
									while (itr.hasNext()) {
										if(itr.next().getEmail().equals(email[index])){
											friendSet.add(email[index]);
										}
									}
								}
								if(i==0) {
									friendMap.put(email[0], friendSet);
								}else if(!friendMap.containsKey(email[0])) {
									friendMap.put(email[0], friendSet);
								}
							}
						}
					}
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		}catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * Method to read person list from file
	 */
	public void readPersons() {
		try {

			bufferedReaderObj = new BufferedReader(new FileReader(Constants.DETAILS_FILE.getAbsolutePath()));
			try {
				String line;
				while ((line = bufferedReaderObj.readLine()) != null) {
					String[] details = line.split(",");
					if (Integer.parseInt(details[0])==0) {
						Person tempPerson = new Person();
						tempPerson.setName(details[1]);
						BigInteger ob1 = new BigInteger(details[2]);
						tempPerson.setPhone(ob1);
						tempPerson.setEmail(details[3]);
						tempPerson.setSchool(details[4]);
						tempPerson.setCollege(details[5]);
						tempPerson.setInterests(details[6].split("/"));
						nodeSet.add(tempPerson);
					}else {
						Organization  organization=new Organization();
						 organization.setName(details[1]);
						BigInteger ob1 = new BigInteger(details[2]);
						 organization.setPhone(ob1);
						 organization.setEmail(details[3]);
						 organization.setCourses(details[4].split("/"));
						 organization.setFaculty(details[5].split("/"));
						 organization.setPlacements(details[6].split("/"));
						 nodeSet.add(organization);
					}
				}
			}
			
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	
	/** Method to read Entity (Person or Organization) info from user
	 * @return : returning new entity details
	 */
	Entity acceptDetails() {
		BufferedReader bufferedReaderObj = null;
		Scanner sc = null;
		Person person = null;
		Organization organization = null;
		try
		{
			bufferedReaderObj = new BufferedReader(new InputStreamReader(System.in));
			sc = new Scanner(System.in);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		String name, school, college;
		BigInteger phone;
		String email,interest;
		int count = 0;
		System.out.println("Press 1 if want to enter person detail ");
		System.out.println("Press 2 if want to enter organizational detail ");
			
		do {// Validation
			System.out.println("Please enter a positive number!");
			while (!sc.hasNextInt()) {
				System.out
						.println("That's not a number!Please enter again");
				sc.next(); // this is important!
			}
			count = sc.nextInt();
			if ((count != 1) && (count != 2)) {
				System.out.println("Enter right values");
				count=-1;
				}
		} while (count<= 0);
				
		if (count == 1) {//if belong to person
			try {
					person = new Person();
					
					// validation for name
					System.out.println("enter person details :");
					while(true) {
						System.out.println("name : ");
						name = bufferedReaderObj.readLine();
						if(Validation.isName(name))
							break;
						else
							System.out.println("Please Enter a valid Name");
					}
					person.setName(name);
					
					//validation for phone no
					while(true)
					{
						boolean flag = false;
						System.out.println("phone no. : ");
						do {// Validation
							System.out.println("Please enter a positive number!");
							while (!sc.hasNextLong()) {
								System.out.println("That's not a number!Please enter again");
								sc.next(); // this is important!
							}
							phone = sc.nextBigInteger();
							if (Validation.isValidPhone(phone)) {
								flag = true;
								break;
							}
							else
								System.out.println("enter a valid 10-digit phone number.");	
							
						}while(!(Validation.isValidPhone(phone)));	
							if(flag == true)
								break;
					}
					person.setPhone(phone);
						
					//validation for email id
					while(true) {
						System.out.println("email : ");
						email = bufferedReaderObj.readLine();
						if (Validation.isValidEmail(email))
							break;
						else
							System.out.println("enter a valid email Id (example : abc@xyz.com)");
					}
						
					person.setEmail(email);
					
					// validation for School Name
					while(true)
					{
						System.out.println("School : ");
						school = bufferedReaderObj.readLine();
						if(Validation.isName(name))
							break;
						else
							System.out.println("Please Enter a valid Name for School");
						}
						person.setSchool(school);
			
						while(true)
						{
							System.out.println("College : ");
							college = bufferedReaderObj.readLine();
							if(Validation.isName(name))
								break;
							else
								System.out.println("Please Enter a valid Name for School");
						}
						person.setCollege(college);
						System.out.println("Interest :(Seperated by /)");
						interest = bufferedReaderObj.readLine();
						String interests[] = interest.split("/");
						person.setInterests(interests);
					}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				return person;	
			}
			
			else {//if belong to organization
				try {
					sc = new Scanner(System.in);
					organization = new Organization();
					System.out.println("enter Organization details :");
					
					// Validation for name
					while(true)
					{
						System.out.println("name : ");
						name = bufferedReaderObj.readLine();
						if(Validation.isName(name))
							break;
						else
							System.out.println("Please Enter a valid Name");
					}
					organization.setName(name);
					
					//validation for phone no
					while(true)
					{
						boolean flag = false;
						System.out.println("phone no. : ");
						do {// Validation
							System.out.println("Please enter a positive number!");
							while (!sc.hasNextLong()) {
								System.out
										.println("That's not a number!Please enter again");
								sc.next(); // this is important!
							}
						phone = sc.nextBigInteger();
						if (Validation.isValidPhone(phone)) {
							flag = true;
							break;
						}
						else
							System.out.println("enter a valid 10-digit phone number.");	
						
					}while(!(Validation.isValidPhone(phone)));	
					if(flag == true)
						break;
				}
				organization.setPhone(phone);
				
				//validation for email id
				while(true) {
					System.out.println("email : ");
					email = bufferedReaderObj.readLine();
					if (Validation.isValidEmail(email))
						break;
					else
						System.out.println("enter a valid email Id (example : abc@xyz.com)");
				}
	
				organization.setEmail(email);
				System.out.println("Courses : ");
				String courses[] = sc.next().split("/");
				organization.setCourses(courses);
	
				System.out.println("Faculty : ");
				String faculty[] = sc.next().split("/");
				organization.setFaculty(faculty);
	
				System.out.println("Placement : ");
				String placements[] = sc.next().split("/");
				organization.setPlacements(placements);	
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			return organization;
		}
	}
}
		

