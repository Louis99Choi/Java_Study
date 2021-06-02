
public class Triangle extends Shape {
	
	protected Triangle(ShapeColor color, ShapeRect bound) {
		super(color, bound);
		this.type = ShapeType.TRIANGLE;
	}

	@Override
	public void area() {
		System.out.println("Area " + type + 
				"( " + bound + ") = " + bound.getWidth() * bound.getHeight() / 2.0);
	}
	
	

}
