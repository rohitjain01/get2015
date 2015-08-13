import java.util.*;

/*
 * Session 4 Assignment
 * TowerOfHanoi.java
 * @ author Rohit
 */
public class TowerOfHanoi {

	List<String> result = new ArrayList<String>();  // result is a list variable which holds output
	public List<String> towerOfHanoi ( String source, String destination, String temp, int noOfDisk )
	{
		/*
		 * It is a recursive method which takes 4 inputs
		 * and finally gives output of disk movement
		 */
		if ( noOfDisk > 0 )
		{
			
			towerOfHanoi ( source, temp, destination, noOfDisk-1); // call recursive method interchange temp and destination and reduce noOfDisk by 1
			result.add("Move Disk "+noOfDisk+" from "+source+" to "+destination); // add movement of disk in result list
			towerOfHanoi ( temp, destination, source, noOfDisk-1); // // call recursive method interchange temp and source and reduce noOfDisk by 1
		}
		return result;
	}
	public static void main ( String args[] )
	{
		Scanner sc = new Scanner ( System.in );
		int noOfDisk;
		System.out.print("\n Enter no of Disks : ");
		noOfDisk = sc.nextInt();					// take number of disks as input
		
		TowerOfHanoi toh = new TowerOfHanoi();
		List<String> result = toh.towerOfHanoi( "A", "B", "C", noOfDisk );
		
		Iterator<String> itr=result.iterator();//getting Iterator from arraylist to traverse elements  
		while(itr.hasNext())
		{  
			System.out.println( itr.next() );  
		}
	}
}
