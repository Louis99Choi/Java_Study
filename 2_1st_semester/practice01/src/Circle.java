
public class Circle extends Square {

	public Circle(ShapeColor color, ShapeRect bound) {
		super(color, bound);
		this.type = ShapeType.CIRCLE;
	}

	@Override
	public void area() {
		double radius = bound.getWidth() / 2.0;
		System.out.println("Area " + type + 
				"( " + bound + ") = " + radius * radius * Math.PI);
	}

}
