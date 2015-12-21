package demo;

import java.util.ArrayList;
import java.util.List;

/**
 * class for implement call by value and call by reference
 * @author Rohit
 *
 */
public class CallByValueAndCallByReference {

	 public static void main(String[] args) {
		 CallByValueAndCallByReference callByValueAndCallByReference = new CallByValueAndCallByReference();
		 int firstValue = 30;
		 Integer secondValue = new Integer(34);
		 System.out.println(firstValue);
		 callByValueAndCallByReference.square(firstValue); // call by value call
		 System.out.println(firstValue);
		 
		 System.out.println(secondValue);
		 callByValueAndCallByReference.square1(secondValue); // call by value call
		 System.out.println(secondValue);
		 
		 List<Integer> listIntegers = new ArrayList<Integer>();
		 listIntegers.add(firstValue);
		 listIntegers.add(secondValue);
		 System.out.println(listIntegers.toString());
		 callByValueAndCallByReference.addInList(listIntegers); // call by reference call
		 System.out.println(listIntegers.toString());
		 
		 
	}

	 /**
	  * Method of call by value
	  * @param value
	  */
	private void square(int value) {
		value = value++;
	}
	
	/**
	 * Method for call by value
	 * @param value
	 */
	private void square1(Integer value) {
		value = value++;
	}
	
	/**
	 * Method for call by reference
	 * @param listIntegers
	 */
	private void addInList(List<Integer> listIntegers) {
		listIntegers.add(20);
	}
	
}
