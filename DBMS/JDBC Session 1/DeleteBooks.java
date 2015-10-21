import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.metacube.jdbc.example.ConnectionUtil;
/**
 * JDBC Sesion 1 Assignment 3
 * DeleteBooks.java
 * @author Rohit
 *
 */
public class DeleteBooks {
	
	/* Method to Delete all those books which were not issued in last 1 year */
	public static int deleteOldBooks()
	{
		String query = "DELETE FROM Books WHERE accession_no IN (SELECT accession_no "
				+ "FROM(SELECT DISTINCT b.accession_no "
				+ "FROM Book_issue bi,Books b "
				+ "WHERE (DATEDIFF(now(),b.purchase_dt)>=365 "
				+ "AND b.accession_no NOT IN (SELECT accession_no FROM Book_issue)) "
				+ "OR b.accession_no IN(SELECT br.accession_no "
				+ "FROM book_return br, books b "
				+ "WHERE(DATEDIFF(now(),IF(br.return_dt = NULL, purchase_dt, br.return_dt)) >= 365) "
				+ "AND br.accession_no IN (SELECT accession_no FROM Books WHERE status = 0))) AS a);";
                                                                                                                                    
		int deletedBooks = 0;	// Hold no of books will be deleted 
		Connection con = null;
		Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		try {
			stmt = con.createStatement();
			deletedBooks = stmt.executeUpdate(query); // executequery
		} catch (SQLException e) {
			e.printStackTrace();
			return deletedBooks;
		}
		return deletedBooks;					// return result
	}
}
