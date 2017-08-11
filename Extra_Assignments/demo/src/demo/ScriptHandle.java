package demo; 

import org.apache.commons.lang.StringEscapeUtils;

public class ScriptHandle {
	/**
	 * method implements escapeHtml method.
	 * @param args
	 */
	public static void main(String[] args) {
		String output = StringEscapeUtils.escapeHtml("<script>alert('Hiii Babalu Patidar');</script>");
		System.out.println(output);
	}

}