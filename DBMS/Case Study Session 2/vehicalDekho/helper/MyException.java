package helper;

/**
 * Case Study Phase II assignment
 * MyException.java
 * purpose : To handle all the eaception manually
 * @author Rohit 
 */
public class MyException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public MyException(Exception e) {
		// TODO Auto-generated constructor stub
		System.out.print(e.getMessage());
	}

}
