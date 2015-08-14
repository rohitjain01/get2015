package ThirdProgram;

public class Circle implements Shape{
	int radius;
	public Circle(int radius){
		this.radius=radius;
	}
	@Override
	public String draw() {
		return "Circle is drawn";
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		double result=2*3.14*radius;
		return result;
	}

}
