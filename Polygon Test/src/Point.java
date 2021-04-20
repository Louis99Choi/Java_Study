
public class Point {
	private double x;
	private double y;
	public static Point Zero = new Point(0.0, 0.0);
	public static Point One = new Point(1.0, 1.0);
	
	public Point() {
		this(0.0, 0.0);
	}
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	

}
