package demo;

/**
 * Class to differentiate int and Integers
 * @author Rohit
 *
 */
public class testInteger {

	public static void main(String[] args) {
		Integer test = null; // it is a object
		test = 0;
		//test = "ch"; only take integer type of values
		System.out.println(test);
		System.out.println(test.toString()); // can convert into string
		int test1;
		//test1 = null; can't assign null value
		test1 = 0;
		//test1.toString(); can't convert into string
		System.out.println(test1);

	}

}
