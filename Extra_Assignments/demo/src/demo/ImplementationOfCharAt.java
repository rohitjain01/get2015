package demo;

public class ImplementationOfCharAt {

	public static void main(String[] args) {

		StringOperation str = new StringOperation("babalu patidar");
		try {
			System.out.println(str.charAt(34));
		} catch (MetaException e) {
			System.out.println(e.getMessage());
		}
	}
	
}

