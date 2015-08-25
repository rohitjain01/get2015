import java.util.*;
public class assignment2 {
	public String spaces(int row,int n)
	{
		String s="";
		int i;
		for(i=0;i<row;i++)
			s=s+" ";
		return s;	
	}
	public String numbers(int row, int n)
	{
		int i,j=1;
		String s="";
		for(i=row;i<n;i++)
			s=s+Integer.toString(j++);
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
		assignment2 a2=new assignment2();
		String s[]=a2.printpyramid(n);
		System.out.println("\n Pyramid is : ");
		for(i=0;i<s.length;i++)
			System.out.println(s[i]);
	}

}
