package ThirdProgram;
import java.util.ArrayList;
import java.util.List;


public class MainClass {
	static void printShape(Shape shape){
		System.out.print(shape.getArea());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape circleShape=new Circle(2);
		Shape squareArea=new Square(5);
		printShape(circleShape);
		printShape(squareArea);
		List<Shape> shape=new ArrayList<Shape>();
		shape.add(circleShape);
		shape.add(squareArea);
		double check=squareArea.getArea();
		System.out.println("\n"+check);
		double check1=circleShape.getArea();
		System.out.println("\n"+check1);
	}
}
