package LoggerMain;

import Loggerclass.LoggerClass;
/**
 * LoggerMain.java
 * to generate exceptions manually
 * @author Rohit
 *
 */
public class LoggerMain {
	public static void main(String[] args) {
		// make instance of LoggerClass
		LoggerClass loggerClass = LoggerClass.getInstance();
		try {
			@SuppressWarnings("unused")
			int c = 100 / 0;
		} catch (Exception e) {
			// call catch exception method and log the exception
			loggerClass.catchException(e.fillInStackTrace().toString());
		}
		try {
			int[] array = new int[4];
			array[5] = 10;
		} catch (Exception e) {
			loggerClass.catchException(e.fillInStackTrace().toString());
		}
	}

}
