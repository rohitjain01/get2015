package computer_fundamental;
import java.util.*;

public class assignment2 {
	public int[] removeDuplicate (int input[])
	{
		int n=input.length-1;
		int i,j,k;
		
		for (i=0;i<n;i++)
		{
			
			for (j=i+1;j<=n;j++)
			{
				// check the number has its duplicate
				if (input[i]==input[j])
				{
					for (k=j;k<n;k++)
					{
						input[k]=input[k+1];  // if duplicate than shift the array and remove duplicate element
					}
					n--; // reduce the size of array
					j--;
				}
			}	
		}
		
		int b[]=new int[n+1]; // make a new array which hold the output
		for (i=0;i<=n;i++)
		{
			b[i]=input[i];
		}
		return b;
	}
	public static void main (String args[])
	{
		Scanner sc=new Scanner(System.in);
		int i,size;
		System.out.print("\n Enter array size : ");
		size=sc.nextInt();
		System.out.println("Enter an array");
		int a[]=new int[size];
		
		for (i=0;i<size;i++)
		{
			a[i]=sc.nextInt();
		}
	
		assignment2 a2=new assignment2();
		int b[]=a2.removeDuplicate(a);
		// print the output
		for (i=0;i<b.length;i++)
		{
			System.out.print(b[i]);
		}
	}
	
}
