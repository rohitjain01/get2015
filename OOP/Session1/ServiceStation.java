import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * OOPs Session1 Assignment
 * ServiceStation.java
 * @author Rohit
 *
 */
class Mechanics
{
	private String mechanicName,specializeCar;
	private int rate;
	public Mechanics( String mechanicName, String specializeCar, int rate )//Mechanics class constructor 
	{
		this.mechanicName = mechanicName;
		this.specializeCar = specializeCar;
		this.rate = rate;
	}
	public String getMName()//get method is used to return the value
	{
		return mechanicName;
	}
	public void set_M_Name( String mechanicName )//set method is used to store the value
	{
		this.mechanicName = mechanicName;
	}
	public void setSCar( String specializeCar )
	{
		this.specializeCar = specializeCar;
	}
	public String getSCar()
	{
		return specializeCar;
	}
	public void setServiceRate( int rate )
	{
		this.rate = rate;
	}
	public int getServiceRate()
	{
		return rate;
	}
	public String toString()//to return complete information of Mechanics
	{
		return " "+mechanicName+" "+specializeCar+" "+rate;
	}
}
class CarType
{
	private String carName, carNumber;
	public CarType( String carNumber, String carName )
	{
		this.carName = carName;
		this.carNumber = carNumber;
	}
	public String getCarName()
	{
		return carName;
	}
	public void setCarName( String carName )
	{
		this.carName = carName;
	}
	public String getCarNum()
	{
		return carNumber;
	}
	public void setCarNum( String carName )
	{
		this.carNumber = carName;
	}
	public String toString()//to return complete information of Car
	{
		return " "+carNumber+" "+carName;
	}
}
public class ServiceStation 
{
	public static void main( String args[] ) throws FileNotFoundException
	{
		Scanner finMechanic = new Scanner(new FileReader("Mechanics.txt"));//to read information of Mechanics from given file
		String mechanicName, specializeCar;
		int numofmechanics = 0;
		int rate;
		int countSuv = 0, countSedan = 0, countHatchbak = 0;
		int mcountSuv = 0, mcountSedan = 0, mcountHatchbak = 0;
		
		Scanner finCar = new Scanner(new FileReader("Car.txt"));
		String carName, carNumber;
		int numofcar;
		numofcar = finCar.nextInt();//get the first line of file(total number of cars)
		String temp;
		CarType car[] = new CarType[numofcar];
		for(int i=0; i<numofcar; i++)//to store complete information of car for all object
		{
			carNumber = finCar.next();
			carName = finCar.next();
			car[i] = new CarType(carNumber, carName);
		}
		
		numofmechanics = finMechanic.nextInt();//get the first line of file(total number of mechanics)
		Mechanics mechanic[] = new Mechanics[numofmechanics];
		for(int i=0; i<numofmechanics; i++)//to store complete information of car for all object
		{
			mechanicName = finMechanic.next();
			specializeCar = finMechanic.next();
			rate = finMechanic.nextInt();
			mechanic[i] = new Mechanics(mechanicName, specializeCar, rate);
		}
		System.out.println("Mechanics information is:");//to print all the information about mechanics
		for(int i=0; i<numofmechanics; i++)
		{
			System.out.println( mechanic[i].toString() );
		}
		System.out.println("Car information is:");
		for(int i=0; i<numofcar; i++)//to print all the information about car
		{
			System.out.println( car[i].toString() );
		}
		
		for(int i=0; i<numofmechanics; i++)//count number of cars for which mechanics are available 
		{
			temp=mechanic[i].getSCar();
			if( temp.equalsIgnoreCase("SUV") )
			{
				mcountSuv++;
			}
			else if( temp.equalsIgnoreCase("Sedan") )
			{
				mcountSedan++;
			}
			else if( temp.equalsIgnoreCase("Hatchbak") )
			{
				mcountHatchbak++;
			}
			else
			{
				temp="";
			}
		}
		for(int i=0;i<numofcar;i++)//count number of cars arrived at service center
		{
			temp=car[i].getCarName();
			if( temp.equalsIgnoreCase("SUV") )
			{
				countSuv++;
			}
			else if( temp.equalsIgnoreCase("Sedan") )
			{
				countSedan++;
			}
			else if( temp.equalsIgnoreCase("Hatchbak") )
			{
				countHatchbak++;
			}
			else
			{
				temp="";
			}
		}
		
		System.out.println("Total number of cars arrived at service center\nSUV:"+countSuv+"\nSedan:"+countSedan+"\nHatchbak:"+countHatchbak);
		System.out.println("Total number of Mechanics at service center\nSUV:"+mcountSuv+"\nSedan:"+mcountSedan+"\nHatchbak:"+mcountHatchbak);
		
		if( mcountHatchbak < countHatchbak )
		{
		     countHatchbak = mcountHatchbak;
		}
		if( mcountSedan < countSedan )
		{
			countSedan = mcountSedan;
		}
		if( mcountSuv < countSuv )
		{
			countSuv = mcountSuv;
		}
		
		int totalEarning = countHatchbak*2000 + countSedan*3000 + countSuv*5000; //to calculate total earning
		System.out.println("Total earning is:"+totalEarning);
		finCar.close();
		finMechanic.close();
	}
}

