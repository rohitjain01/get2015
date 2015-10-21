import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.metacube.jdbc.example.ConnectionUtil;

/**
 * JDBC Session 1 Assignment 1
 * FetchBooks.java
 * @author Rohit
 *
 */
public class FetchBooks {
	String titleName;									// title name to hold book title
	/* Getter setter method*/
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	

	public static ArrayList<FetchBooks> getBooksByAuthorName(String authorName)
	{
		String query = "SELECT t.title_nm FROM Titles t, Authors a, Title_author ta WHERE ta.title_id = t.title_id AND ta.author_id = a.author_id AND a.author_nm = '"+authorName+"';";
		Connection con = null;					// for establish connection
		ResultSet rs = null;					// to hold result of query
		Statement stmt = null;					// statement object to execute query
		ConnectionUtil conUtil = new ConnectionUtil();		// make object of ConnectionUtil 
		FetchBooks title;
		con = conUtil.getConnection();					// establish connection
		ArrayList<FetchBooks> titleList = new ArrayList<FetchBooks>();
		try {
			stmt = con.createStatement();  // give address to statement reference
			rs = stmt.executeQuery(query); // execute query

			while (rs.next()) {    // loop until rs is not null
				title = new FetchBooks();     // make object of FetchBooks
				title.setTitleName(rs.getString(1));   // set name of books corresponding author name
				titleList.add(title);			// add title object in array list
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return titleList;				// return array list
	}

}
