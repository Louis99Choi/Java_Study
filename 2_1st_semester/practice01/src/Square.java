
public class Square extends Shape {

	public Square(ShapeColor color, ShapeRect bound) {
		super(color, bound);
		this.type = ShapeType.SQUARE;
		
		if(bound.getWidth() < bound.getHeight()) {	bound.setHeight(bound.getWidth());	}
		else {	bound.setWidth(bound.getHeight());	}
	}

	@Override
	public void area() {
		System.out.println("Area " + type + 
				"( " + bound + ") = " + bound.getWidth() * bound.getHeight());
	}

}
