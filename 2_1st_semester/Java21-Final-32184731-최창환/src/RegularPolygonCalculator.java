// 자바프로그래밍_1분반_2021_06_09_최창환_32184731

public class RegularPolygonCalculator {
	private int degree = 5; // 정다각형 각의 수 degree
	private double radius; // 정다각형의 외접원의 반지름 radius
	private Point center; // 정다각형 중심좌표 center
	private double angle; // 정다각형의 이웃하는 3개의 점으로 이루어진 꺽은 선의 중심각.
	private Point[] points; // 정다각형 꼭지점의 좌표배열 points

	// constructor(int) create instance with degree, radius=1, Point=(0,0)
	public RegularPolygonCalculator(int degree) {
		this(degree, 1.0, Point.getZero());
	}

	// constructor(int, int) create instance with degree, radius, Point=(0,0)
	public RegularPolygonCalculator(int degree, double radius) {
		this(degree, radius, Point.getZero());
	}

	// constructor(int, int) create instance with degree, radius, center
	public RegularPolygonCalculator(int degree, double radius, Point center) {
		this.degree = Math.max(3, Math.min(9, degree)); // clamp between 3 and 9
		this.radius = radius;
		this.center = center;
		this.angle = 2 * Math.PI / degree; // 120/90/72/60/51.4285/45 if
											// triangle/rectangle/pentagon/hexagon/heptagon/octagon
		this.points = createPoints(); // create points with degree, angle, radius, center
	}

	// createPoints create RegularPolygon points
	protected Point[] createPoints() {
		Point[] points = new Point[degree]; // create points array with degree
		double radian = Math.PI / 2.0; // radian start at 90
		for (int i = 0; i < degree; i++) { // create each point with radian (incremented by angle)
			points[i] = getPoint(radian, radius, center);
			radian += angle;
		}
		return points;
	}

	// static utility method getPoint return point with radian, radius, offset point
	// circle equation - center 중심점에서 radian과 radius를 이용한 꼭지점 Point 반환
	private static Point getPoint(double radian, double radius, Point offset) {
		return new Point(radius * Math.cos(radian) + offset.getX(), radius * Math.sin(radian) + offset.getY());
	}

	// return PolygonType of this regular polygon
	public PolygonType getPolygonType() {
		return PolygonType.valueOf(degree);
	}

	// return points array of this regular polygon
	public Point[] getPoints() {
		return points;
	}

	// return Bound of this regular polygon
	public Bound getBound() {
		return Bound.findBound(points);
	}

	// return area of this regular polygon
	// (https://www.mathopenref.com/polygonregulararea.html)
	public double getArea() {
		return radius * radius * degree * Math.sin(angle) / 2.0;
	}

	// Object class toString() method overriding (PolygonType, radius, center,
	// points array)
	@Override
	public String toString() {
		String s = getPolygonType().toString() + " [radius=" + radius + ", center=" + center.toString() + "]\n";
		for (int i = 0; i < degree; i++) {
			s += (points[i].toString() + "\n");
		}
		return s;
	}
}
