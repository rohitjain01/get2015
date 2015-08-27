import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 * OOP Session2 Assignment
 * SurveyClass.java
 * author @Rohit
 */


/*
 * Survey class is used for take answers of questions from participants
 */
 class Survey
 {
	 FileReader Fin;					// variable used for read file survey.txt
	 BufferedReader bufferReader;		// variable holds the contents of file.
	 Scanner sc = new Scanner(System.in );
	 //method for question Single select 
	 public String singleSelect() throws IOException		// Method for singleSelect question
	 {
		 int count = 0;									// count variable is used for count lines in files
		 Fin = new FileReader("Survey.txt");			// Fin read file survey.txt
		 bufferReader = new BufferedReader(Fin);		// take contents of file in bufferReader
		 String[] questionArray = new String[6];		
		 while( count != 6 ) // starting 6 lines of files contains data for single select question. so it reads only six lines
		 {
			 String line = bufferReader.readLine();
			 System.out.println(line);
			 questionArray[count] = line; // questionArray holds sentence with its option  of single select question
			 count++;
		 }
		 int flag = 0;
		 String ans = new String(); // string ans which holds the resultant option given by the user
	     while(flag == 0)
	     {
	         ans = sc.nextLine();
	         for( int i=1; i<6; i++ )
	         {
	             if( questionArray[i].equals(ans) )		// check whether user select answer is available or not
	             {
	            	 flag = 1;				// if yes than make flag=1
	            	 break;
	             }
	         }
	         if( flag == 0 )
	         {
	            System.out.println("Enter Valid ans"); // otherwise continue the loop until answer is valid
	         }
	     }
	     return ans;		// return output
	 }
	 //method for multiple select question
	public   ArrayList<String> mulipleSelect() throws IOException{
	int count = 0;
	String line = null;
	Fin = new FileReader("Survey.txt");			// take file in file reader 
	bufferReader = new BufferedReader(Fin);		// take contents of file in buffer reader
	while( count!=6 )
	{
		line = bufferReader.readLine();				// skip first 6 lines of file because they are of question one 
		count++;
	}
	ArrayList<String> ans = new ArrayList<String>();		// array list which holds answer
	String[] questionArray = new String[4];
	while( count!=10 ) 
	{
		line = bufferReader.readLine();		// next 4 lines of file contain Multiple choice question
		System.out.println(line);
		questionArray[ count - 6 ] = line;	// take it into question array
		count++;
	}
	int flag = 0;
	while(flag == 0)
	{
		 String Ans = new String();
         ans = new ArrayList<String>();
         for(int p=0; p<3; p++)
         {
        	 Ans = sc.nextLine();
             ans.add(Ans);
         }
         for(int c=0; c<ans.size(); c++)		// check user answers are valid or not
         {
        	 if( ans.get(c).equals("1") )
        	 {
        		 ans.set(c, "1.Service Quality" );
        	 }
             else if( ans.get(c).equals("2") )
             {
            	 ans.set(c, "2.Communication");
             }
             else if( ans.get(c).equals("3") )
             {
            	 ans.set(c, "3.Delivery Process");
             }
         }
             int p=0;
             for( int i=0; i<3; i++)
             {
                 if( (questionArray[1].equals(ans.get(i))) || (questionArray[2].equals(ans.get(i))) || (questionArray[3].equals(ans.get(i))) || (ans.get(i).equals("")) ) // to check validation
                 { 
                	 	flag++;
             
                  		if( (ans.get(i).equals("")) )
                  		{
                  				p++;
                  		}
                 }
             }
             if( p==3 || flag<3 )		// if invalid then re enter the answers
             {
            	 System.out.println("Enter valid answer");
            	 flag = 0;
             }
	   }
			  return ans;		// return the result
	}
		// method for text
		public String text() throws IOException
		{
			String line = null, ans = null;
			int count = 0;
			Fin = new FileReader("Survey.txt");
			bufferReader = new BufferedReader(Fin);
			while( count!=10 )
			{
				line = bufferReader.readLine();  // skip 10 lines of file because they contains previous question data
				count++;
			}
			while( count!=11 ) 			// take question in line string
			{
				line = bufferReader.readLine();
				System.out.println(line);
				count++;
			}
			int flag = 0;
			while( flag==0 )
			{
				ans = sc.nextLine();		// takes the output from user
				if( (ans.equals("")) )
				{ 
					System.out.println("All questions are mandatory to answer."); 
				}
		     else flag = 1;
			}
			return ans;  	// returns the answer
		  }
 }
 
 // class for participant
 /*
  * participant.java
  * this class just take the name of participant
  */
  class participant extends Survey
  {
	  Scanner sc = new Scanner(System.in );
	  public String  getParticipantDetail(int i)
	  {
		String name;
		System.out.println("Enter the Name");
		name = sc.nextLine();
		return name;
	  }
  }

  /*
   * SurveyClass.java
   * use for generate output report and output percentage of question 1
   * this class also contain main method
   */
  public class SurveyClass extends participant
  {
	 // to out put reports as percentage
	 public int[] OutputReportPercentage( ArrayList<String> ans1 )
	 {	
		 int[]out = new int[5];
		 for(int i=0; i<ans1.size(); i++) // take answer of each participant of question one
		 {    
			 if(ans1.get(i).equals("1"))
			 {
				 out[0]++;
			 }
			 if(ans1.get(i).equals("2"))
			 {
				 out[1]++;
			 }
			 if(ans1.get(i).equals("3"))
			 {
				 out[2]++;
			 }
			 if(ans1.get(i).equals("4"))
			 {
				 out[3]++;
			 }
			 if(ans1.get(i).equals("5"))
			 {
				 out[4]++;
			 }
		
	 }
	 int sum = out[0]+out[1]+out[2]+out[3]+out[4]; // count total no of answer
	 try
	 {
		 for(int j=0; j<5; j++)
		 {
			 out[j]=(out[j]*100)/sum;  // count percentage of each answer
		 }
	  }
	  catch(ArithmeticException Ae)
	  {
		 System.out.println("please Enter Some Data ");
	  }
	  for(int j=0;j<5;j++)
	  {
		 System.out.print(j+1+":");
		 System.out.println(out[j]); // print the output percentage
	  }
	  return out;
	 }
	 
	 // method for print the output report of each participant
	 public void  OutputReport(ArrayList<String> name, ArrayList<String> ans1, ArrayList<ArrayList<String>> ans2, ArrayList<String> ans3 )
	 { 
		
		 for(int i=0;i<name.size();i++)
		 {
			   System.out.print("\nparticipant "+(i+1)+": ");
			   System.out.print(name.get(i));					// get name of participant
			   System.out.print("\nQ1:Overall Rating? : ");
			   System.out.print(ans1.get(i));					// get answer of question1 of that participant
			   System.out.print("\nQ2:Area of improvement? : ");
			   for(int j=0; j<3; j++)
			   {
				   System.out.print(((ArrayList<String>) ans2.get(i)).get(j)+" ");	// get answer of multiple choice question
			   }
			   System.out.print("\nQ3:Feedback? : ");	
			   System.out.println(ans3.get(i));			// get feedback of that participant
		 }
	 }
	 // main method
	 public static void main(String args[]) throws IOException
	 {
		 
		 Scanner sc = new Scanner(System.in );
		 participant par = new participant();
		 Survey S = new Survey();
		 SurveyClass SC = new SurveyClass();
		 ArrayList<String> name = new ArrayList<String>(); // holds name of participants 
		 ArrayList<String> ans1 = new ArrayList<String>(); // holds answers of single choice question
		 ArrayList<ArrayList<String>> ans2 = new ArrayList<ArrayList<String>>(); // holds answers of multiple choice question
		 
		 ArrayList<String> ans3 = new ArrayList<String>(); // holds feedbacks of all participants
		 int i = 0;
		 int n = 0;
		 do // create menu for user
		 {
			 System.out.println("\n Press 1 for participant in survey \n 2 for Output Report \n 3 for Output Data in percentage \n 4 for exit");
			 System.out.print("\n Enter Your Choice : ");
			 n = sc.nextInt();
			 if( n == 1 )  //  if user select participate than increment value of i
			 {
				 i++;
			 }
			 switch (n) 
			 {
			 case 1:
				 name.add( par.getParticipantDetail(i) );
				 ans1.add( S.singleSelect() );
				 ans2.add( S.mulipleSelect() );
				 ans3.add( S.text() );
				 break;
			 case 2:
				 SC.OutputReport( name, ans1, ans2, ans3 );
				 break;
			 case 3:
				 SC.OutputReportPercentage( ans1 );
			 	 break;
			 case 4:
				 System.exit(0);
			 }
		 }while( n!=5 );
		 
		 sc.close();
 }
 }
 
 
 