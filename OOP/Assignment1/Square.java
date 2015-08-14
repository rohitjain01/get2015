
public class Square implements Shape {
	private int side;
	public Square(int side){
		this.side=side;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		double area=side*side;
		return area;
	}

}
