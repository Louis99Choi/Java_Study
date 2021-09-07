// �ڹ����α׷���_1�й�_2021_06_09_��âȯ_32184731

public class Triangle extends Polygon {
	private double a, b, c; // a, b, c is the side of triangle

	// # 4.1
	// constructor() , call super().
	public Triangle() {
		super();
	}

	// constructor(Point[] points) , call super(Point[] points).
	public Triangle(Point[] points) {
		super(points);
		a = sides[0];
		b = sides[1];
		c = sides[2];
	}

	// # 8 ������ �����ε�
	// constructor(Point, Point, Point) set a, b, c
	public Triangle(Point point1, Point point2, Point point3) {
		this.a = Point.getDistance(point1, point2);
		this.b = Point.getDistance(point2, point3);
		this.c = Point.getDistance(point3, point1);
	}

	// return triangle area
	public double getArea() {
		return PolygonMath.area(a, b, c);
	}

	// 4.2 , 4.3, 4.4, 4.5 �� �θ� Ŭ������ Polygon Ŭ�������� ���� ����.

	// # 4.6
	@Override
	public String toString() {

		return super.toString();
	}

	// Object class toString() method overriding
//	@Override
//	public String toString() {
//		return "Triangle [points=" + Arrays.toString(points) + ", sides=" + Arrays.toString(sides) + ", diagonals="
//				+ Arrays.toString(diagonals) + ", angles=" + Arrays.toString(angles) + ", bound=" + bound + ", type="
//				+ type + "]";
//	}

}
