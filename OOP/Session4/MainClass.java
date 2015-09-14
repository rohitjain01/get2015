
/**
 * OOP Sessio4 Assignment
 * MainClass.java
 * @author Rohit
 *
 */
public class MainClass {
	
	public void main(String[] args) {
	
		Menu menu = new Menu(); // create object of Menu class
		/*
		 *  make object of menu class and pass user options string as argument
		 *  for each option make a separete object
		 */
		ActionableMenuItem Item = new ActionableMenuItem("Enter 1  for participant"); 
		ActionableMenuItem Item2 = new ActionableMenuItem("Enter 2 for output reports");
		ActionableMenuItem Item3 = new ActionableMenuItem("Enter 3 for output reports in form of percentage");	
		ActionableMenuItem Item4 = new ActionableMenuItem("Enter 4 for exit");
		/*
		 * add these object in menu class by addMenuItem method
		 */
		menu.addMenuItem(Item);
		menu.addMenuItem(Item2);
		menu.addMenuItem(Item3);
		menu.addMenuItem(Item4);
		menu.display();  // and at last call display method
		
	}

}
