// �ڹ����α׷���_1�й�_2021_06_09_��âȯ_32184731

// Polygon�� ����(sides, angles, diagonals, area ���� ���� �� �ʿ��� ������ ���� ���� ������ Ŭ����.
public class PolygonMath {
	private PolygonMath() {}
	
	/*
	 * static utility method getArea(a, b, c) return triangle area.
	 * Heron's formula_
	 * S = sqrt(s * (s-a) * (s-b) * (s-c)) where s = (a+b+c)/2
	 */
	public static double area(double a, double b, double c) {
		System.out.println("\n#1 test\n"); // # 1 test
		double s = (a + b + c) /2.0;
		return Math.sqrt(s * (s-a) * (s-b) * (s-c));
	}

	// points[]�� ���ڷ� �޾� �ٰ����� ��� ���� ���̸� ���ҷ��ϴ� �迭 sides[]�� ��ȯ�ϴ� static �żҵ�.
	public static double[] findSides(Point[] points) {
		
		// ���ڷ� null ���� �޴´ٸ� null ���� ��ȯ.
		if (points == null) return null;

		// �ٰ����� �̷�� ���� ������ ���� ������ ���� ������ points.length ũ���� �迭 sides[] ����.
		double[] sides = new double[points.length];
		
		// Point.getDistance() static �żҵ带 �̿��� �����ϴ� �� �� ������ �Ÿ��� �ٰ����� ���� ���̸� ������� sides[]�� ���ҷ� �ʱ�ȭ.
		for (int i = 0; i < points.length; i++) {
			int nextIndex = (i + 1) % points.length;
			sides[i] = Point.getDistance(points[i], points[nextIndex]);
		}
		
		return sides;
	}

	// points[]�� ���ڷ� �޾� 
	public static double[] findDiagonals(Point[] points) {
		
		// ���� points�� null ���̰ų� points[]�� ������ ������ 4�� �̸��̸� �밢���� ���ü� �����Ƿ� null�� ��ȯ.
		if (points == null) return null;
		if (points.length < 4) return null;
		
		/*
		 *   �ʱ�ȭ �� ���ҷ��ϴ� diagonals[]�� ��ȯ�Ѵ�.
		 */
		// points[0]�� ���� �������ϴ� n������ �밢���� ������ n-3 �� �̹Ƿ� diagonals[]�� ũ�Ⱑ (n - 3)�� �迭 ����.
		double[] diagonals = new double[points.length - 3];
		
		// points[0]���� points[2],...,points[n-2] ������ �Ÿ��� �밢���� ������� ���� diagonals[]�� ���ҷ� �ʱ�ȭ.
		// 0-2/ 0-3 / 0-4 /.../ 0-(n-2)
		for (int i = 2; i < points.length - 1; i++) {
			diagonals[i-2] = Point.getDistance(points[0], points[i]);
		}
		
		return diagonals;
	}

	// points[]�� �̷���� n������ ������ ���ҷ��ϴ� �迭 angles[]�� ��ȯ�ϴ� �żҵ�.
	public static double[] findAngles(Point[] points) {
		
		if (points == null) return null;
		
		// ���� ������ ������ ������ ����.
		double[] angles = new double[points.length];
		
		/*
		 * n������ �̷�� ���� 0������ (n-1)�� ���� ������, (n-1)-0-1/ 0-1-2/.../(n-2)-(n-1)-0 ������ 
		 * �׷��� �� ����� ������ angles[] �� ���ҷ� �ִ´�
		 */
		for (int i=0; i<points.length; i++) {
			int prevIndex = i==0 ? (i + points.length - 1) : (i - 1); //(i+pints.length-1) if i is zero
			int nextIndex = (i + 1) % points.length; // n�����̹Ƿ� nextIndex�� Max���� n-1 �̱⶧���� n(point.length)�� ���� �������� ����.
			angles[i] = innerAngle(points[prevIndex], points[i], points[nextIndex]);
		}
		return angles;
	}
	
	// dot = p1.x * p2. x + p1.y * p2.y
	public static double dot(Point p1, Point p2) {
		return p1.getX()*p2.getX() + p1.getY()*p2.getY();
	}

	// Angle between two vectors = acos(dot(v1, v2)/|v1|*|v2|)
	public static double innerAngle(Point p1, Point p2, Point p3) {
		// v1�� �� p2�� ������, p1�� �������� �ϴ� �����̴�.
		Point v1 = new Point(p1.getX() - p2.getX(), p1.getY() - p2.getY()); 
		// v2�� �� p2�� ������, p3�� �������� �ϴ� �����̴�.
		Point v2 = new Point(p3.getX() - p2.getX(), p3.getY() - p2.getY());
		
		// len1�� ���� v1�� ũ���̰� len2�� ���� v2�� ũ�� �̴�.
		double len1 = Math.sqrt(v1.getX()*v1.getX() + v1.getY()*v1.getY());
		double len2 = Math.sqrt(v2.getX()*v2.getX() + v2.getY()*v2.getY());
		
		// �� ���� v1, v2�� ������ Math.acos(���ڻ��� �Լ�)�� �̿��� ������ ������ ���� ���·� ����
		double angrad = Math.acos(dot(v1, v2)/(len1 * len2));  
		
		// ���� �� angrad�� degree ������ ��ȯ.
		return Math.toDegrees(angrad);
	}

}
