package Loggerclass;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * This class is used for creating log file for log all the exception which are generated in LoggerMain
 * It is a singleton class
 * @fileHandler: to log exceptions in log file
 * @consoleHandler: to log exceptions on console 
 * @author Rohit
 *
 */
public class LoggerClass {
		private static Logger logger = Logger.getLogger(LoggerClass.class.getName());
		private static LoggerClass loggerClass = new LoggerClass();
		Handler fileHandler;
		Handler consoleHandler;
		// constructor is private so that new object can't be created
		private LoggerClass() {
			try {
				// Initialize fileHandler and consoleHandler once in a program
				fileHandler = new FileHandler("./exception.log",true);
				consoleHandler = new ConsoleHandler();
				fileHandler.setFormatter(new SimpleFormatter());// set format of log file
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static LoggerClass getInstance() {
			return loggerClass; // return single instance of LoggerClass
		}
		public void catchException( String string ) {
			//System.out.print(string);
			logger.removeHandler(fileHandler);
			logger.removeHandler(consoleHandler);
			logger.addHandler(consoleHandler);
			logger.addHandler(fileHandler);
			logger.setLevel(Level.ALL);		// set message level in log file
			consoleHandler.setLevel(Level.ALL); // set message level on console
			logger.log(Level.FINE,string);
		}
}


