//자바프로그래밍 1분반 32184731 최창환
//중간고사 대체 과제_

public class Triangle extends Polygon{
	private double a, b, c;
	private double area;
	
	public Triangle(Point[] points) {
		super(points);
		this.a = Point.getDistance(points[0], points[1]);
		this.b = Point.getDistance(points[1], points[2]);
		this.c = Point.getDistance(points[2], points[0]);
		setArea();
	}
	public Triangle(Point p, Point q, Point r) {
		this.a = Point.getDistance(p, q);
		this.b = Point.getDistance(q, r);
		this.c = Point.getDistance(r, p);
		setArea();

	}

	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
		
	public static double setArea(double a, double b, double c) {
		double s = (a + b + c)/2;
		double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		
		return area;
	}
	public void setArea() {
		this.area = setArea(this.a, this.b, this.c);
	}
	public double getArea() {
		return area;
	}
	
	
	@Override
	public String toString() {
		return "Triangle [a=" + a + ", b=" + b + ", c=" + c + ", area=" + area + "Bound=" + this.getBound() + "]";
	}
	
}
