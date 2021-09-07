
public class Rectangle extends Shape {

	protected Rectangle(ShapeColor color, ShapeRect bound) {
		super(color, bound);
		this.type = ShapeType.RECTANGLE;
	}

	@Override
	public void area() {
		System.out.println("Area " + type + 
				"( " + bound + ") = " + bound.getWidth() * bound.getHeight());
	}


}
