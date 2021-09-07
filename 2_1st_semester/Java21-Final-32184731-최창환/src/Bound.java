// 자바프로그래밍_1분반_2021_06_09_최창환_32184731

public class Bound {
	private Point bottomLeft; // bottomLeft member
	private Point bottomRight; // bottomRight member
	private Point topLeft; // topLeft member
	private Point topRight; // topRight member

  // default constructor set bottomLeft(0,0) with width=1, height=1
	public Bound()	{
		this(new Point(0.0, 0.0), 1.0, 1.0);
	}

  // constructor(Point, double, double) set bottomLeft, bottomRight, topLeft, topRight with origin, width, height
	public Bound(Point origin, double width, double height)	{
		this.bottomLeft = origin;
		this.bottomRight = new Point(origin.getX() + width, origin.getY());
		this.topLeft = new Point(origin.getX(), origin.getY() + height);
		this.topRight = new Point(origin.getX() + width, origin.getY() + height);
	}
	
  // constructor(double, double, double, double) set bottomLeft, bottomRight, topLeft, topRight with x, y, width, height
	public Bound(double x, double y, double width, double height) {
		this.bottomLeft = new Point(x, y);
		this.bottomRight = new Point(x + width, y);
		this.topLeft = new Point(x, y + height);
		this.topRight = new Point(x + width, y + height);
	}
	
  // constructor(Point, Point) set bottomLeft, bottomRight, topLeft, topRight with bottomLeft, topRight
	public Bound(Point bottomLeft, Point topRight) {
		this.bottomLeft = bottomLeft;
		this.bottomRight = new Point(topRight.getX(), bottomLeft.getY());
		this.topLeft = new Point(bottomLeft.getX(), topRight.getY());
		this.topRight = topRight;
	}

  // bottomLeft getter
	public Point getBottomLeft() {
		return bottomLeft;
	}

  // bottomRight getter
	public Point getBottomRight() {
		return bottomRight;
	}

  // topLeft getter
	public Point getTopLeft() {
		return topLeft;
	}

  // topRight getter
	public Point getTopRight() {
		return topRight;
	}

  // getWidth returns width
	public double getWidth() {
		return topRight.getX() - bottomLeft.getX();
	}

  // getWidth returns height
	public double getHeight() {
		return topRight.getY() - bottomLeft.getY();
	}

  // static utility method findBound(Point[] points) returns Bound from points array
	public static Bound findBound(Point[] points) {
		if (points == null) return null;
		double xmin = points[0].getX();
		double xmax = points[0].getX();
		double ymin = points[0].getY();
		double ymax = points[0].getY();
		for (int i = 0; i < points.length; i++) {
			xmin = Math.min(points[i].getX(), xmin);
			xmax = Math.max(points[i].getX(), xmax);
			ymin = Math.min(points[i].getY(), ymin);
			ymax = Math.max(points[i].getY(), ymax);
		}
		return new Bound(xmin, ymin, xmax - xmin, ymax - ymin);
	}

  // Object class toString() method overriding
	@Override
	public String toString() {
		return "Bound [bottomLeft=" + bottomLeft + ", bottomRight=" + bottomRight + ", topLeft=" + topLeft
				+ ", topRight=" + topRight + "]";
	}
}
