// 자바프로그래밍_1분반_2021_06_09_최창환_32184731

// Polygon의 성질(sides, angles, diagonals, area 등을 구할 때 필요한 수학적 공식 등을 구현한 클래스.
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

	// points[]를 인자로 받아 다각형의 모든 변의 길이를 원소로하는 배열 sides[]를 반환하는 static 매소드.
	public static double[] findSides(Point[] points) {
		
		// 인자로 null 값을 받는다면 null 값을 반환.
		if (points == null) return null;

		// 다각형을 이루는 점의 개수와 변의 개수는 같기 때문에 points.length 크기의 배열 sides[] 생성.
		double[] sides = new double[points.length];
		
		// Point.getDistance() static 매소드를 이용해 연속하는 두 점 사이의 거리인 다각형의 변의 길이를 순서대로 sides[]의 원소로 초기화.
		for (int i = 0; i < points.length; i++) {
			int nextIndex = (i + 1) % points.length;
			sides[i] = Point.getDistance(points[i], points[nextIndex]);
		}
		
		return sides;
	}

	// points[]를 인자로 받아 
	public static double[] findDiagonals(Point[] points) {
		
		// 인자 points가 null 값이거나 points[]의 원소의 개수가 4개 미만이면 대각선이 나올수 없으므로 null을 반환.
		if (points == null) return null;
		if (points.length < 4) return null;
		
		/*
		 *   초기화 후 원소로하는 diagonals[]를 반환한다.
		 */
		// points[0]을 시작 점으로하는 n각형의 대각선의 개수는 n-3 개 이므로 diagonals[]를 크기가 (n - 3)인 배열 생성.
		double[] diagonals = new double[points.length - 3];
		
		// points[0]에서 points[2],...,points[n-2] 까지의 거리인 대각선을 순서대로 각각 diagonals[]의 원소로 초기화.
		// 0-2/ 0-3 / 0-4 /.../ 0-(n-2)
		for (int i = 2; i < points.length - 1; i++) {
			diagonals[i-2] = Point.getDistance(points[0], points[i]);
		}
		
		return diagonals;
	}

	// points[]로 이루어진 n각형의 내각을 원소로하는 배열 angles[]를 반환하는 매소드.
	public static double[] findAngles(Point[] points) {
		
		if (points == null) return null;
		
		// 점의 개수와 내각의 개수는 같다.
		double[] angles = new double[points.length];
		
		/*
		 * n각형을 이루는 점이 0번부터 (n-1)번 까지 있을때, (n-1)-0-1/ 0-1-2/.../(n-2)-(n-1)-0 순서로 
		 * 그렸을 때 생기는 내각을 angles[] 에 원소로 넣는다
		 */
		for (int i=0; i<points.length; i++) {
			int prevIndex = i==0 ? (i + points.length - 1) : (i - 1); //(i+pints.length-1) if i is zero
			int nextIndex = (i + 1) % points.length; // n각형이므로 nextIndex의 Max값은 n-1 이기때문에 n(point.length)로 나눈 나머지를 저장.
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
		// v1은 점 p2를 시작점, p1을 끝점으로 하는 벡터이다.
		Point v1 = new Point(p1.getX() - p2.getX(), p1.getY() - p2.getY()); 
		// v2은 점 p2를 시작점, p3을 끝점으로 하는 벡터이다.
		Point v2 = new Point(p3.getX() - p2.getX(), p3.getY() - p2.getY());
		
		// len1은 벡터 v1의 크기이고 len2는 벡터 v2의 크기 이다.
		double len1 = Math.sqrt(v1.getX()*v1.getX() + v1.getY()*v1.getY());
		double len2 = Math.sqrt(v2.getX()*v2.getX() + v2.getY()*v2.getY());
		
		// 두 벡터 v1, v2로 내적과 Math.acos(역코사인 함수)를 이용해 사이의 내각을 라디안 형태로 저장
		double angrad = Math.acos(dot(v1, v2)/(len1 * len2));  
		
		// 라디안 값 angrad를 degree 값으로 변환.
		return Math.toDegrees(angrad);
	}

}
