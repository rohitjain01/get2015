import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.metacube.jdbc.example.ConnectionUtil;
/**
 * JDBC Session 1 Assignment 2
 * BookIssue.java
 * @author Rohit
 *
 */
public class BookIssue {
	
	/* Method to Issue a given book to a existing member*/
	public static boolean bookIssueByBookName( String bookName )
	{
		String query = "INSERT INTO Book_issue(issue_dt, accession_no, member_id, due_dt) VALUES(now(),(select accession_no  from Books where status=0 and title_id =( select title_id from Titles where title_nm= '"+bookName+"')), (select member_id from Members where member_nm = 'Rohit'),'2015-11-06')";
		boolean flag = true;
		Connection con = null;
		Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		try {
			stmt = con.createStatement();
			flag = stmt.execute(query);  // excecute query
			if( flag == false ) // If book has issued than update status as 1
			{
				query = "UPDATE Books set status = 1 WHERE title_id = (SELECT title_id FROM Titles WHERE title_nm = '"+bookName+"')";
				stmt.executeUpdate(query);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return flag;
		}
		return flag;	//return the result
	}

}
