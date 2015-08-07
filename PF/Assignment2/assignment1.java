import java.util.*;
public class assignment1 {
	
	public String spaces(int row,int n)
	{
		row=row+1;
		int a=row-n;
		String s="";
		a=Math.abs(a);
		int i;
		for(i=0;i<a;i++)
			s=s+" ";
		return s;	
	}
	
	public String numbers(int row, int n)
	{
		row=row+1;
		if(row>n)
			row=n-row+n;
		int i;
		String s="";
		for(i=0;i<row;i++)
			s=s+Integer.toString(i+1);
		if(row!=0)
		{	
			for(i=row;i>1;i--)
				s=s+Integer.toString(i-1);
		}
		return s;
	}
	
	public String[] printpyramid(int n) 
	{
		int i;
		int rows=(2*n)-1;
		String s[]=new String[rows];
		String s1,s2;
		for(i=0;i<rows;i++)
		{
			s1=spaces(i,n);
			s2=numbers(i,n);
			s[i]=s1+s2;
		}
		return s;
	}
	
	public static void main(String args[])
	{
		int i;
		Scanner sc=new Scanner(System.in);
		System.out.print("\n Enter Maximum Element  : ");
		int n=sc.nextInt();
		assignment1 a1=new assignment1();
		String s[]=a1.printpyramid(n);
		System.out.println("\n Pyramid is : ");
		for(i=0;i<s.length;i++)
			System.out.println(s[i]);
	}

}
