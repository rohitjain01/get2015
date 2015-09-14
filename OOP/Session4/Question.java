import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * OOP Sessio4 Assignment
 * Qestion.java.java
 * @author Rohit
 * Question class is used for take answers of questions from participants
 */
public class Question {

	 FileReader Fin;					// variable used for read file survey.txt
	 BufferedReader bufferReader;		// variable holds the contents of file.
	 Scanner sc = new Scanner(System.in );
	//method single select question return string having answer of single select question throws IOException
	 public String singleSelect() throws IOException{
		 int count = 0;						// count variable is used for count lines in file
		 Fin = new FileReader("Survey.txt");// to read form text file
		 
		 bufferReader = new BufferedReader(Fin);	// take contents of file in bufferReader
		
		 String[] questionArray = new String[6];
		 while( count != 6 ) 		 // starting 6 lines of files contains data for single select question. so it reads only six line
		 {
			
			 String line = bufferReader.readLine();
			 System.out.println(line);
			 questionArray[count] = line;	// questionArray holds sentence with its option  of single select question
			 
			 count++;
		 }
		 int flag = 0;
		 String answer = new String();	// string ans which holds the resultant option given by the user
         while( flag == 0 )
         {
        	 answer = sc.nextLine();
        
	         for( int i=1; i<6; i++ )
	         {
	             if( questionArray[i].equals(answer) )	// check whether user select answer is available or not
	             {
	            	 flag = 1;					// if yes than make flag=1
	            	 break;
	             }
	         }
	         if( flag == 0 )
	         {
	            System.out.println("Enter Valid ans");	 // otherwise continue the loop until answer is valid
	      
	         }
         }
         return answer;			// return output
	 }
// method for multiple select question return array list having response of multiselect question throws IOException
	 public ArrayList<String> mulipleSelect() throws IOException{
			int count = 0;
			String line = null;
			Fin = new FileReader("Survey.txt");		// take file in file reader 
			bufferReader = new BufferedReader(Fin);	// take contents of file in buffer reader
			while( count != 6 )						// skip first 6 lines of file because they are of question one 
		    {
				line = bufferReader.readLine();
				count++;
			}
			ArrayList<String> answer = new ArrayList<String>();		// array list which holds answer
			String[] questionArray = new String[4];
			 
			while(count!=10) {
				 line = bufferReader.readLine();			// next 4 lines of file contain Multiple choice question
				 System.out.println(line);
				 questionArray[count-6] = line;			// take it into question array
				 
				 count++;
			}
			 
			int flag = 0;
			
			while( flag == 0 )
			{
                String Ans = new String();
                answer = new ArrayList<String>();
	            for(int p=0; p<3; p++)
	            {
	            	Ans=sc.nextLine();
	                answer.add(Ans);
	            }
	            for(int c=0; c<answer.size(); c++)				// check user answers are valid or not
	            {
	                if( answer.get(c).equals("1") )
	                {
	                	answer.set( c, "1.Service Quality" );
	                }
	                else if(answer.get(c).equals("2"))
	                {
	                	answer.set( c, "2.Communication" );
	                }
	                else if(answer.get(c).equals("3"))
	                {
	                	answer.set( c, "3.Delivery Process" );
	                }
	            }
	            int p = 0;
	            for( int i=0; i<3; i++ )
	            {
	                if( (questionArray[1].equals(answer.get(i))) || (questionArray[2].equals(answer.get(i))) || (questionArray[3].equals(answer.get(i))) || (answer.get(i).equals("")) )// to check validation
	                {
	                	flag++;
	            
	                	if( (answer.get(i).equals("")) )
	                	{
	                		p++;
	                	}
	                }
	            }
	            if( p == 3 || flag < 3 )			// if invalid then re enter the answers
	           	{
	            	System.out.println("Enter valid answer");
	           	 	flag=0;
	           	}
			}
			return answer;
		 }
		// method for text
		 public String text() throws IOException{
				  String line = null, ans = null;;
				  int count = 0;
				  Fin = new FileReader("Survey.txt");
				  bufferReader = new BufferedReader(Fin);
				  while( count != 10 )
				  {
					  line = bufferReader.readLine();		// skip 10 lines of file because they contains previous question data
					  count++;
				  }
				  while( count != 11 ) {		// take question in line string
						
					  line = bufferReader.readLine();
					  System.out.println(line);
					  count++;
				  }
				  int flag = 0;
				  while( flag == 0 )
				  {
					  ans=sc.nextLine();				// takes the output from user
				      if( (ans.equals("")) )
				      { 
				    	 System.out.println("All questions are mandatory to answer.");
				    	 
				      }
				      else
				      {
				    	 flag = 1;
				      }
			      }
				  return ans;  // returns the answer
		  }
}


