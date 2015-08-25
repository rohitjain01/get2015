package computer_fundamental;
import java.util.*;

public class assignment3 {
	public int[] longestSequence(int input[])
	{
		
		int n=input.length;
		int buff1[]=new int[n]; //buff1 holds longest sequence
		int buff2[]=new int[n]; //buff2 holds current sequence
		int count1=1,count2=1;
		int k=0;
		int i,j,l;
		
		buff1[k]=input[0]; /* Let's assume each element is unique than longest sequence is 1.
						      put that element in buff1*/
		
		i=0;
		while (i < n)
		{
			k=0;
			buff2[k++]=input[i];
			
			for (j=i; j<n-1; j++)
			{
				if (input[j]>=input[j+1])
				{
					
					break;
				}
				buff2[k++]=input[j+1]; //take element which is in a sequence in buff2
				count2++;
			}
			
			if (count2 > count1) // compare  which has longest sequence either buff1 or buff2
			{
				// if buff2 has longest sequence than move all the elements of buff2 to buff1.
				for (l=0;l<count2;l++) 
				{
					buff1[l]=buff2[l];
				}
				count1=count2;
			}
			i=i+count2;
			count2=1;
		}
		
		int b[]=new int[count1]; // to make an output array
		for (i=0;i<count1;i++)
		{
			b[i]=buff1[i];
		}
		return b;
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int i,size;
		
		System.out.print("\n Enter array size : ");
		size=sc.nextInt();
		
		System.out.println("Enter an array");
		int a[]=new int[size];
		
		for (i=0;i<25;i++)
		{
			a[i]=sc.nextInt();
		}
		assignment3 a3=new assignment3();
		int b[]=a3.longestSequence(a);
		for (i=0;i<b.length;i++)
		{
			System.out.print(b[i]);
		}
	}

}
