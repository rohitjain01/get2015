package ThirdProgram;

public class Square implements Shape {
	private int side;
	public Square(int side){
		this.side=side;
	}
	@Override
	public String draw() {
		return "Sqaure is drawn";
	}

	@Override
	public double getArea() {
		double area=side*side;
		return area;
	}

}
