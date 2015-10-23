import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * JDBC Session 1 Assignments
 * MainClass.java
 * @author Rohit
 *
 */
public class MainClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		String authorName;
		System.out.print("\n Fetch books by Author Name");
		System.out.print("\n Enter Author Name : ");
		authorName = sc.next();					// take author name as input
		ArrayList<FetchBooks> titleList = FetchBooks.getBooksByAuthorName(authorName); // call method getBooksByAuthorName , pass author name as argument and take result in array list
		System.out.print("\n Books are : ");
		ListIterator<FetchBooks> iterator = titleList.listIterator(); // take a iterator to traverse the list
		while(iterator.hasNext())
		{
			System.out.print(iterator.next().getTitleName()+"\t");   // display each book of author
		}
		String bookName;
		System.out.print("\n\n Check Book Status");
		System.out.print("\n Enter title of Book : ");
		BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
		bookName = inp.readLine().toString();					// take book name as input
		boolean flag = BookIssue.bookIssueByBookName(bookName); // call bookIssueByBookName, pass book name as argument and take result in flag
		if( flag == true ) // if flag is false than book can't be issue
		{
			System.out.print("\n Book can't be issued ");
		}
		else
		{
			System.out.print("\n Book has issued"); // otherwise book has been issue
		}
		System.out.print("\n Delete all those books which were not issued in last 1 year");
		int deletedBooks = DeleteBooks.deleteOldBooks();  // call deleteOldBooks method
		// display how many books are deleted
		if( deletedBooks == 0 )
		{
			System.out.print("\n no book is delete ");
		}
		else
		{
			System.out.print("\n No of books is deleted are : "+deletedBooks);
		}
		sc.close();
	}

}
