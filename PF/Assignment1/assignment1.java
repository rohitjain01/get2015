package computer_fundamental;
import java.util.*;

public class assignment1 {
	
	public int convertBinaryToOctal (int n)
	{
		int countDigits=0;
		int m,i;
		int decNumber=0;
		m=n;
		// count digits of binary number
		while (n!=0)
		{
			n=n/10;
			countDigits++;
		}
		
		//convert binary to decimal
		for (i=0;i<countDigits;i++)
		{
			decNumber=decNumber+(m%10)*power(2,i);
			m=m/10;
		}
		i=1;
		int octalNumber=0;
		//convert decimal to octal
		while (decNumber!=0)
		{
			octalNumber=octalNumber+(decNumber%8)*i;
			decNumber=decNumber/8;
			
			i=i*10;
		}
		
		return octalNumber;
	}
	public int power (int x, int n)
	{
		int pow=1;
		for (int i=1;i<=n;i++)
		{
			pow=pow*x;
		}
		return pow;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		assignment1 a1=new assignment1();
		Scanner sc=new Scanner(System.in);
		int binaryNumber;
		System.out.println("Enter a Binary Number");
		binaryNumber=sc.nextInt();
		int octal=a1.convertBinaryToOctal(binaryNumber);
		System.out.println(octal);

	}
	
	

}
