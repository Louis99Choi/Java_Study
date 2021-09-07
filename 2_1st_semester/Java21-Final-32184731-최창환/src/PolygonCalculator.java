// �ڹ����α׷���_1�й�_2021_06_09_��âȯ_32184731

public class PolygonCalculator {

	private Point[] points; // ������ ���ϴٰ��� ������ �迭 points
	private Triangle[] triangles; // ������ ���ϴٰ����� �ﰢ����� �ɰ��� triangles

	// constructor(Point[])
	public PolygonCalculator(Point[] points) {
		this.points = points;
		this.triangles = findTriangles(points); // create triangles array using points array
	}

	// findTriangles create tessellated triangles from Polygon points
	// ������ ���ϴٰ��� ����κ��� �ﰢ�� �迭�� �������־���ϴµ� ���̸� ���ϴ� ���� �����̹Ƿ� �ʸź���(������ũ��) �ﰢ���� �����ؾ���
	public static Triangle[] findTriangles(Point[] points) {
		if (points == null)
			return null; // return null if points is null
		if (points.length < 3)
			return null; // return null if points.length is less then 3

		Triangle[] triangles = new Triangle[points.length - 2]; // 8/7/6/5/4/3�����̶�� 6/5/4/3/2/1���� �ﰢ���� ����
		for (int i = 1; i < points.length - 1; i++) {
			triangles[i - 1] = new Triangle(points[0], points[i], points[i + 1]); // ������ 0�� �߽�����, 0-1-2, 1-2-3, 1-3-4,
																					// ... ������ ����
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
