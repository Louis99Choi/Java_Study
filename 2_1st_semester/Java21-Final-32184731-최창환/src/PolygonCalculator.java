// 자바프로그래밍_1분반_2021_06_09_최창환_32184731

public class PolygonCalculator {

	private Point[] points; // 임의의 볼록다각형 꼭지점 배열 points
	private Triangle[] triangles; // 임의의 볼록다각형을 삼각형들로 쪼개기 triangles

	// constructor(Point[])
	public PolygonCalculator(Point[] points) {
		this.points = points;
		this.triangles = findTriangles(points); // create triangles array using points array
	}

	// findTriangles create tessellated triangles from Polygon points
	// 임의의 볼록다각형 점들로부터 삼각형 배열을 생성해주어야하는데 넓이를 구하는 것이 목적이므로 쪽매붙임(모자이크식) 삼각형을 생성해야함
	public static Triangle[] findTriangles(Point[] points) {
		if (points == null)
			return null; // return null if points is null
		if (points.length < 3)
			return null; // return null if points.length is less then 3

		Triangle[] triangles = new Triangle[points.length - 2]; // 8/7/6/5/4/3각형이라면 6/5/4/3/2/1개의 삼각형을 생성
		for (int i = 1; i < points.length - 1; i++) {
			triangles[i - 1] = new Triangle(points[0], points[i], points[i + 1]); // 꼭지점 0을 중심으로, 0-1-2, 1-2-3, 1-3-4,
																					// ... 순서로 생성
		}
		return triangles;
	}

	// return points of this polygon
	public Point[] getPoints() {
		return points;
	}

	// return tessellated triangles of this polygon
	public Triangle[] getTriangles() {
		return triangles;
	}

	// return PolygonType of this polygon
	public PolygonType getPolygonType() {
		return PolygonType.valueOf(points.length);
	}

	// return Bound of this polygon
	public Bound getBound() {
		return Bound.findBound(points);
	}

	// return area of this polygon - sum of tessellated triangles' area
	public double getArea() {
		double value = 0.0;
		for (Triangle triangle : getTriangles()) {
			value += triangle.getArea();
		}
		return value;
	}

	// Object class toString() method overriding
	@Override
	public String toString() {
		String s = getPolygonType().toString() + "\n";

		for (int i = 0; i < points.length; i++) {
			s += (points[i].toString() + "\n");
		}
		for (int i = 0; i < points.length - 2; i++) {
			s += (triangles[i].toString() + "\n");
		}
		s += getPolygonType().toString() + " AREA[" + getArea() + "]" + "\n";
		return s;
	}
}
