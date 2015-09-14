/**
 * OOP Session4 Assignment
 * MenuItem.java
 * It is an interface
 * @author Rohit
 */
import java.util.ArrayList;

public interface MenuItem {
	 
	 ArrayList<String> name = new ArrayList<String>();   // arraylist for storing names of participants
	 ArrayList<String> ans1 = new ArrayList<String>();  // arraylist for storing answers of question one(Single choice) of each participant
	 ArrayList<ArrayList<String>> ans2 = new ArrayList<ArrayList<String>>();		// arraylist for storing answers of question two(Multiple choice) of each participant
	 ArrayList<String> ans3 = new ArrayList<String>();	// arraylist for storing answers of question three(feedback) of each participant
	// two methods are declayerd display is display the options to user and take action is perform task according to user selcting option
	 public void display();       
	 public void takeAction(int i);

}
