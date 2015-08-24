import java.util.Scanner;

/**
 * OOPs Session1 Assignment
 * MainShape.java
 * @author Rohit
 *
 */
interface Shape // Interface has two methods draw and getArea
{
	void draw();
	double getArea();
}

class Circle implements Shape
{
	private double radius;
	public Circle( double radius )//Constructor of Circle class
	{
		this.radius = radius;
	}
	public void draw()//To print which shape is here
	{
		System.out.println("Its a circle");
	}
	public double getArea()//to return the area of circle
	{
		return ( 3.14*radius*radius );
	}
}

class Square implements Shape
{
	private double side;
	public Square ( double side )//Constructor of Square class
	{
		this.side = side;
	}
	public void draw()//To print which shape is here
	{
		System.out.println("Its a Square");
	}
	public double getArea()//to return the area of square
	{
		return ( side*side );
	}
}

public class MainShape
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter radius: ");
		double radius = sc.nextDouble();
		Circle circle = new Circle(radius);
		circle.draw();//call draw method for circle
		System.out.println("Area of circle is:"+circle.getArea());
		System.out.print("\nEnter side: ");
		double side = sc.nextDouble();
		Square square = new Square(side);
		square.draw();//call draw method for square
		System.out.println("Area of square is:"+square.getArea());
		sc.close();
	}
}

