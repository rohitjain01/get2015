import java.util.*;
/**
 * DS Session 8 Assignment
 * SortUsingTree.java
 * @author Rohit
 *
 */
public class SortUsingTree {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int noOfStudents, i, j;
		Scanner sc = new Scanner(System.in);
		try
		{
			System.out.print("\n Enter Number of students");
			do{
				System.out.print(" (Enter valid number) : ");
				while(!sc.hasNextInt()) {			// check whether number is integer or not
				System.out.println(" Please Enter Integer Only");
				sc.next();					// take number of students from user as input
				}
				noOfStudents = sc.nextInt();
			}while( noOfStudents <= 0 );
			int[] rollNo = new int[noOfStudents]; // make a array for roll numbers of students
			boolean flag;
			for(i=0; i<noOfStudents; i++)
			{
				System.out.print("\n Enter Roll Number for student "+(i+1));
				do{
					flag = false;
					System.out.print(" (Enter valid Roll number) : ");
					while(!sc.hasNextInt()) {			// check whether number is integer or not
						System.out.println(" Please Enter Integer Only");
						sc.next();
					}
					rollNo[i] = sc.nextInt();  // take roll number of students one by one as input
					for(j=0; j<i; j++)
					{
						if( rollNo[j] == rollNo[i] )
						{
							System.out.print(" Roll number already Exist");  // check two students roll number should not be same
							flag = true;
						}
					}
				}while( rollNo[i] <= 0 || rollNo[i] > noOfStudents || flag );
			}
			System.out.print("\n Entered Roll Numbers are : ");
			for(i=0; i<noOfStudents; i++)
			{
				System.out.print(rollNo[i]+" ");  // display input roll numbers
			}
			BinarySearchTree tree = new BinarySearchTree(); // make object of BinarySearchTree
			for(i=0; i<noOfStudents; i++)
			{
				BinarySearchTree.root = tree.insert(rollNo[i], BinarySearchTree.root);  // insert the roll nubers in binary search tree
			}
			ArrayList<Integer> ItemList = tree.inorder( BinarySearchTree.root );  // take a array list which take all the elements from tree in inorder
			Iterator<Integer> iterator = ItemList.iterator(); // take a iterator to traverse in array list
			i = 0;
			while( iterator.hasNext() )
			{
				rollNo[i++] = (int)iterator.next(); // put element from iterator to roll number array
			}
			System.out.print("\n Sorted Roll Numbers are  : ");  // now display the sorted roll numbers
			for(i=0; i<noOfStudents; i++)
			{
				System.out.print(rollNo[i]+" ");
			}
		}
		catch(Exception e)    // catch is used to handle exception if occur
		{
			System.out.print( e.getMessage() );
		}
		sc.close();

	}

}
