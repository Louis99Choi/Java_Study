
public abstract class Shape implements Moveable {
	protected ShapeType type;
	protected ShapeColor color;
	protected ShapeRect bound;

	protected Shape(ShapeColor color, ShapeRect bound) {
		super();
		this.color = color;
		this.bound = bound;
	}

	public void print() {
		System.out.printf("Shape: %s (%s) %s\n", type, bound, color);
	}
	
	@Override
	public void move(int x, int y) {
		bound.setX(bound.getX() + x);
		bound.setY(bound.getY() + y);
	}
	
	public abstract void area();

}