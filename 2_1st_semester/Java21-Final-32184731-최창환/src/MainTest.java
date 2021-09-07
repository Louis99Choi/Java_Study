// �ڹ����α׷���_1�й�_2021_06_09_��âȯ_32184731

import java.util.Arrays;
import java.util.List;
import java.util.Map;

// MainTest class - java21-1 final
public class MainTest {
	// triangle, Quadrilateral, pentagon, hexagon, heptagon, octagon polygon data
	private static Point[][] polygons = { { new Point(1, 0), new Point(0, 3), new Point(-4, 0) },
			{ new Point(2, 0), new Point(0, 2), new Point(0, 0) },
			{ new Point(1, 0), new Point(-1, 4), new Point(0, 3), new Point(-4, 0) },
			{ new Point(2, 2), new Point(-2, 2), new Point(-2, -2), new Point(2, -2) },
			{ new Point(2, 0), new Point(0, 2), new Point(-2, 0), new Point(0, -2) },
			{ new Point(2, 0), new Point(2, 2), new Point(0, 4), new Point(-2, 2), new Point(-2, 0) },
			{ new Point(0, 4), new Point(-2, 2), new Point(-2, -2), new Point(0, -4), new Point(2, -2),
					new Point(2, 2) },
			{ new Point(4, 0), new Point(2, 2), new Point(-2, 2), new Point(-4, 0), new Point(-2, -2),
					new Point(2, -2) },
			{ new Point(5, 0), new Point(0, 5), new Point(-5, 0), new Point(-4, -2), new Point(-2, -4),
					new Point(2, -4), new Point(4, -2) },
			{ new Point(5, 0), new Point(2.5, 2.5), new Point(0, 5), new Point(-2.5, 2.5), new Point(-5, 0),
					new Point(-2.5, -2.5), new Point(0, -5), new Point(2.5, -2.5) } };

	/*
	 * �ٰ����� ����(degree)�� �������� ������(radius), �ٰ����� �߽� ��ǥ(Point center)�� ���ڷ� Ŭ����
	 * RegularPolygonCalculator, PolygonCalculator, PolygonFactory�� �̿��� ���� �ٰ��� ��ü
	 * poly, poly2, poly3�� �����ϰ� �� ��ü�� ������ ����ϴ� static �żҵ�.
	 */
	public static void calculate(int degree, double radius, Point center) {
		// ���ٰ��� ��ü poly ����
		RegularPolygonCalculator poly = new RegularPolygonCalculator(degree, radius, center);
		System.out.println(poly); // ������ ���ٰ��� ��ü poly ���.
		System.out.println(poly.getPolygonType()); // ���ٰ��� ��ü poly�� PolygonType ���.
		System.out.println(poly.getBound()); // ���ٰ��� ��ü poly�� Bound ���.
		System.out.println(poly.getArea()); // ���ٰ��� poly�� ���̸� ���.
		System.out.println("\n\n");

		PolygonCalculator poly2 = new PolygonCalculator(poly.getPoints()); // ���ٰ��� ��ü poly�� PolygonCalculator Ŭ������ ��ü
																			// poly2�� ���� deep copy.
		System.out.println(poly2); // deep copy�� ������ ���ٰ��� ��ü poly2 ���.
		System.out.println(poly2.getPolygonType()); // ���ٰ��� ��ü poly2�� PolygonType ���.
		System.out.println(poly2.getArea()); // ���ٰ��� ��ü poly2�� Bound ���.
		System.out.println(poly2.getBound()); // ���ٰ��� poly2�� ���̸� ���.

		// ���ٰ��� ��ü poly�� PolygonFactory Ŭ���� ��ü poly3�� static �żҵ� getInstance()�� ���� deep
		// copy.
		Polygon poly3 = PolygonFactory.getInstance(poly.getPoints());
		System.out.println(poly3); // deep copy�� ������ ���ٰ��� ��ü poly2 ���.
		System.out.println(poly3.getType()); // ���ٰ��� ��ü poly2�� PolygonType ���.
		System.out.println(poly3.getBound()); // ���ٰ��� ��ü poly2�� Bound ���.
		System.out.println("area=" + poly3.getArea()); // ���ٰ��� poly�� ���̸� ���.
		System.out.println("perimeter=" + poly3.getPerimeter()); // ���ٰ��� poly�� �ѷ��� ���.
		System.out.println("sides=" + Arrays.toString(poly3.getSides())); // ���ٰ��� poly�� ��� ���� ���̸� ������� ���.
		System.out.println("angles=" + Arrays.toString(poly3.getAngles())); // ���ٰ��� poly�� ��� ������ ������� ���.

		// isRegular() �żҵ带 ���� poly3�� ���ٰ����̶�� 'REGULAR' �� PolygonType ���� ���.
		if (poly3.isRegular())
			System.out.println("REGULAR " + poly3.getType());
	}

	public static void main(String[] args) {
		System.out.println("\n# 1 test \n"); // 1 test
		Point[] p = { new Point(-5, 0), 
		              new Point(0, -5), new Point(6, -6) };
		
		double[] sides = PolygonMath.findSides(p);
		double[] angles = PolygonMath.findAngles(p);
		
		System.out.println("# 1 "
				+ "\n Point[] p = {"+ p[0] +", " + p[1] +", " + 
				p[2] +"} " + "\nArea of Triangle by Polygon.area() = " + 
				PolygonMath.area(sides[0], sides[1], sides[2]));

		// # 1 test
		// s = a*b*sin(angle)/2.0
		double areaFromDot = sides[0] * sides[1] * Math.sin(angles[1]) / 2.0;
		System.out.printf("\n# 1 test_Area of Triangle by dot = %f", areaFromDot );
				
		
		
		System.out.println("\n# 8 test \n"); // 8 test

		System.out.println("\npolygons data test\n");

		PolygonListManager listManager = new PolygonListManager(); // ����Ʈ �ν��Ͻ��� �ϴ� PolygonListManager ��ü ����.
		PolygonMapManager mapManager = new PolygonMapManager(); // Map�� �ν��Ͻ��� �ϴ� PolygonMapManager ��ü ����.

		/*
		 * static 2���� �迭 polygons�� �� ������ ������ ������ ����ϰ� PolygonFactoryŬ������ �̿��� �� ���ҷ� �ٰ�����
		 * ������ ������ �ٰ����� ����ϰ� ������ �ٰ����� ����Ʈ ��ü�� Map��ü�� ���ҷ� �߰�.
		 */
		for (Point[] points : polygons) {
			System.out.println(Arrays.toString(points)); // points�迭�� ��� ���� ���� ���� ���
			Polygon polygon = PolygonFactory.getInstance(points); // PolygonFactory.getInstance()�� �ٰ��� ��ü ����.
			System.out.println("polygon: " + polygon); // �ٰ��� ���� ���

			listManager.add(polygon); // PolygonListManager ��ü�� �ν��Ͻ� ����Ʈ�� �ٰ����� ���ҷ� �߰�.
			mapManager.add(polygon); // PolygonMapManager ��ü�� �ν��Ͻ� Map�� �ٰ����� ���ҷ� �߰�.
			System.out.println("\n\n");
		}

		System.out.println("\nlistManager print..");
		listManager.print(); // listManager�� �ν��Ͻ� ����Ʈ�� ��� ����(�ٰ���)�� ���.

		// listManager�� �ν��Ͻ� ����Ʈ�� ���� �߿��� ���ٰ����� ���Ҹ� ���ο� ����Ʈ resultList�� ���ҷ� �߰�.
		List<Polygon> resultList = listManager.select(e -> e.isRegular());

		System.out.println("\n\nRegular Polygon resultList print..");
		resultList.forEach(System.out::println); // resultList�� ��� ���� ���.

		System.out.println("\n\nmapManager print..");
		mapManager.print(); // listManager�� �ν��Ͻ� Map�� ��� ����(�ٰ���)�� ���.

		Map<PolygonType, Polygon> resultMap = mapManager.select(e -> e.isRegular());
		System.out.println("\n\nresultMap print..");
		resultMap.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));

		do {
			System.out.println("\nUser Input Polygon\n");
			/*
			 * �� ���� �ҽ����Ͽ� ���ؼ��� Polygon Ŭ������ getUserInput() �żҵ忡�� ����ڰ� ���ϴ� ��ŭ ���� ����, �� �ٰ���
			 * ������ �Է��ϱ� ������ type ������ �̸� �Է� ���� �ʿ�� ����.
			 */
			PolygonType type = UserInput.getUserPolygonType(); // user�� �Է��� �ٰ����� type �Է� ����.
			Polygon polygon = PolygonFactory.getInstance(type); // �Է� ���� type�� �ش��ϴ� ��ü polygon ����.

			polygon.getUserInput(); // ������� �Է�.

			System.out.println(polygon); // �ش� �ٰ��� ���.

		} while (!UserInput.getExitKey());

		System.out.println("\n\n");

		// user���� ���ٰ����� ����, �������� ������, �߽� ��ǥ�� �Է� �޾� ���ٰ��� ��ü�� �����ϰ�
		// static �żҵ��� calculate() �żҵ带 ���� ���ٰ��� ���� ���.
		do {
			System.out.println("\nRegular polygon test\n");
			System.out.print("Please enter the Polygon numberOfSides [3 to 9]: ");
			int degree = UserInput.getIntegerBetween(3, 9); // User���� �ٰ����� ���� ���� �Է� ����.

			System.out.print("Please enter the Polygon radius: ");
			double radius = UserInput.getDouble(); // user���� �ٰ����� �������� ������ �Է� ����.

			Point center = new Point(); // �ٰ����� �߽� �� ��ü ����
			System.out.print("Please enter the Polygon center.x: ");
			center.setX(UserInput.getDouble()); // �ٰ����� �߽� x ��ǥ ����.
			System.out.print("Please enter the Polygon center.y: ");
			center.setY(UserInput.getDouble()); // �ٰ����� �߽� x ��ǥ ����.

			calculate(degree, radius, center);
		} while (!UserInput.getExitKey());
		
		// # 8 PolygonCalculator test
		// (0, 0)�� �߽��̰� �������� 12�� �������� ������ ���ﰢ�� ��ü ����. 
		RegularPolygonCalculator regularTriangle = new RegularPolygonCalculator(3, 12); 
		
		// PolygonCalculator Ŭ���� ��ü�� ������ �ν��Ͻ� �żҵ� getArea() �׽�Ʈ.
		PolygonCalculator triangle = new PolygonCalculator(regularTriangle.createPoints());
		System.out.println("\n# 8 " + "\nTriangle's area from PolygonCalculator : " + triangle.getArea() );

		// # 9 test MyCode_ Nonagon
		// (0, 0)�� �߽��̰� �������� 12�� �������� ������ ��9���� ��ü ����. 
		RegularPolygonCalculator regularNonagon = new RegularPolygonCalculator(9, 12);  
		
		// RegularPolygonCalculator Ŭ������ ���� ��ü�κ��� �� 9���� ��� Nonagon Ŭ���� ��ü�� ������ Upcasting.
		Polygon nonagon = new Nonagon(regularNonagon.createPoints()); 
		System.out.println("\n# 9 test\n" + nonagon);
		
	}
}
