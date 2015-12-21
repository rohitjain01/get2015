package demo;

/**
 * Class to differentiate String, StringBuilder and StringBuffer
 * @author Rohit
 *
 */
public class TestString {

	public static void main(String[] args) {
		String  demo = " hello " ;
		// The above object is stored in constant string pool and its value can not be modified.
		System.out.println(demo.hashCode());


		demo="Bye" ;     //new "Bye" string is created in constant pool and referenced by the demo variable
		System.out.println(demo.hashCode());
		
		StringBuffer demo1 = new StringBuffer("Hello") ;
		// The above object stored in heap and its value can be changed .
		System.out.println(demo1.hashCode());
		
		demo1 = new StringBuffer("Bye");
		// Above statement is right as it modifies the value which is allowed in the StringBuffer
		System.out.println(demo1.hashCode());
		
		StringBuilder demo2= new StringBuilder("Hello");
		// The above object too is stored in the heap and its value can be modified
		System.out.println(demo2.hashCode());
		
		demo2=new StringBuilder("Bye"); 
		// Above statement is right as it modifies the value which is allowed in the StringBuilder
		System.out.println(demo2.hashCode());
	}

}
