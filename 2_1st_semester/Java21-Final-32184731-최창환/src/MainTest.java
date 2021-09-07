// 자바프로그래밍_1분반_2021_06_09_최창환_32184731

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
	 * 다각형의 차수(degree)와 외접원의 반지름(radius), 다각형으 중심 좌표(Point center)를 인자로 클래스
	 * RegularPolygonCalculator, PolygonCalculator, PolygonFactory를 이용해 각각 다각형 객체
	 * poly, poly2, poly3을 생성하고 각 객체의 정보를 출력하는 static 매소드.
	 */
	public static void calculate(int degree, double radius, Point center) {
		// 정다각형 객체 poly 생성
		RegularPolygonCalculator poly = new RegularPolygonCalculator(degree, radius, center);
		System.out.println(poly); // 생성한 정다각형 객체 poly 출력.
		System.out.println(poly.getPolygonType()); // 정다각형 객체 poly의 PolygonType 출력.
		System.out.println(poly.getBound()); // 정다각형 객체 poly의 Bound 출력.
		System.out.println(poly.getArea()); // 정다각형 poly의 넓이를 출력.
		System.out.println("\n\n");

		PolygonCalculator poly2 = new PolygonCalculator(poly.getPoints()); // 정다각형 객체 poly를 PolygonCalculator 클래스의 객체
																			// poly2에 통해 deep copy.
		System.out.println(poly2); // deep copy로 생성한 정다각형 객체 poly2 출력.
		System.out.println(poly2.getPolygonType()); // 정다각형 객체 poly2의 PolygonType 출력.
		System.out.println(poly2.getArea()); // 정다각형 객체 poly2의 Bound 출력.
		System.out.println(poly2.getBound()); // 정다각형 poly2의 넓이를 출력.

		// 정다각형 객체 poly를 PolygonFactory 클래스 객체 poly3에 static 매소드 getInstance()를 통해 deep
		// copy.
		Polygon poly3 = PolygonFactory.getInstance(poly.getPoints());
		System.out.println(poly3); // deep copy로 생성한 정다각형 객체 poly2 출력.
		System.out.println(poly3.getType()); // 정다각형 객체 poly2의 PolygonType 출력.
		System.out.println(poly3.getBound()); // 정다각형 객체 poly2의 Bound 출력.
		System.out.println("area=" + poly3.getArea()); // 정다각형 poly의 넓이를 출력.
		System.out.println("perimeter=" + poly3.getPerimeter()); // 정다각형 poly의 둘레를 출력.
		System.out.println("sides=" + Arrays.toString(poly3.getSides())); // 정다각형 poly의 모든 변의 길이를 순서대로 출력.
		System.out.println("angles=" + Arrays.toString(poly3.getAngles())); // 정다각형 poly의 모든 내각을 순서대로 출력.

		// isRegular() 매소드를 통해 poly3이 정다각형이라면 'REGULAR' 와 PolygonType 정보 출력.
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

		PolygonListManager listManager = new PolygonListManager(); // 리스트 인스턴스로 하는 PolygonListManager 객체 생성.
		PolygonMapManager mapManager = new PolygonMapManager(); // Map을 인스턴스로 하는 PolygonMapManager 객체 생성.

		/*
		 * static 2차원 배열 polygons의 각 원소의 점들의 정보를 출력하고 PolygonFactory클래스를 이용해 각 원소로 다각형을
		 * 생성해 각각의 다각형을 출력하고 각각의 다각형을 리스트 객체와 Map객체에 원소로 추가.
		 */
		for (Point[] points : polygons) {
			System.out.println(Arrays.toString(points)); // points배열의 모든 점에 대한 정보 출력
			Polygon polygon = PolygonFactory.getInstance(points); // PolygonFactory.getInstance()로 다각형 객체 생성.
			System.out.println("polygon: " + polygon); // 다각형 정보 출력

			listManager.add(polygon); // PolygonListManager 객체의 인스턴스 리스트에 다각형을 원소로 추가.
			mapManager.add(polygon); // PolygonMapManager 객체의 인스턴스 Map에 다각형을 원소로 추가.
			System.out.println("\n\n");
		}

		System.out.println("\nlistManager print..");
		listManager.print(); // listManager의 인스턴스 리스트의 모든 원소(다각형)를 출력.

		// listManager의 인스턴스 리스트의 원소 중에서 정다각형인 원소를 새로운 리스트 resultList의 원소로 추가.
		List<Polygon> resultList = listManager.select(e -> e.isRegular());

		System.out.println("\n\nRegular Polygon resultList print..");
		resultList.forEach(System.out::println); // resultList의 모든 원소 출력.

		System.out.println("\n\nmapManager print..");
		mapManager.print(); // listManager의 인스턴스 Map의 모든 원소(다각형)를 출력.

		Map<PolygonType, Polygon> resultMap = mapManager.select(e -> e.isRegular());
		System.out.println("\n\nresultMap print..");
		resultMap.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));

		do {
			System.out.println("\nUser Input Polygon\n");
			/*
			 * 본 과제 소스파일에 대해서는 Polygon 클래스의 getUserInput() 매소드에서 사용자가 원하는 만큼 점의 개수, 즉 다각형
			 * 정보를 입력하기 때문에 type 정보를 미리 입력 받을 필요는 없음.
			 */
			PolygonType type = UserInput.getUserPolygonType(); // user가 입력할 다각형의 type 입력 받음.
			Polygon polygon = PolygonFactory.getInstance(type); // 입력 받은 type에 해당하는 객체 polygon 생성.

			polygon.getUserInput(); // 사용자의 입력.

			System.out.println(polygon); // 해당 다각형 출력.

		} while (!UserInput.getExitKey());

		System.out.println("\n\n");

		// user에게 정다각형의 차수, 외접원의 반지름, 중심 좌표를 입력 받아 정다각형 객체를 생성하고
		// static 매소드인 calculate() 매소드를 통해 정다각형 정보 출력.
		do {
			System.out.println("\nRegular polygon test\n");
			System.out.print("Please enter the Polygon numberOfSides [3 to 9]: ");
			int degree = UserInput.getIntegerBetween(3, 9); // User에게 다각형의 차수 정보 입력 받음.

			System.out.print("Please enter the Polygon radius: ");
			double radius = UserInput.getDouble(); // user에게 다각형의 외접원의 반지름 입력 받음.

			Point center = new Point(); // 다각형의 중심 점 객체 생성
			System.out.print("Please enter the Polygon center.x: ");
			center.setX(UserInput.getDouble()); // 다각형의 중심 x 좌표 설정.
			System.out.print("Please enter the Polygon center.y: ");
			center.setY(UserInput.getDouble()); // 다각형의 중심 x 좌표 설정.

			calculate(degree, radius, center);
		} while (!UserInput.getExitKey());
		
		// # 8 PolygonCalculator test
		// (0, 0)이 중심이고 반지름이 12인 외접원을 가지는 정삼각형 객체 생성. 
		RegularPolygonCalculator regularTriangle = new RegularPolygonCalculator(3, 12); 
		
		// PolygonCalculator 클래스 객체를 생성해 인스턴스 매소드 getArea() 테스트.
		PolygonCalculator triangle = new PolygonCalculator(regularTriangle.createPoints());
		System.out.println("\n# 8 " + "\nTriangle's area from PolygonCalculator : " + triangle.getArea() );

		// # 9 test MyCode_ Nonagon
		// (0, 0)이 중심이고 반지름이 12인 외접원을 가지는 정9각형 객체 생성. 
		RegularPolygonCalculator regularNonagon = new RegularPolygonCalculator(9, 12);  
		
		// RegularPolygonCalculator 클래스로 만든 객체로부터 점 9개를 얻어 Nonagon 클래스 객체를 생성해 Upcasting.
		Polygon nonagon = new Nonagon(regularNonagon.createPoints()); 
		System.out.println("\n# 9 test\n" + nonagon);
		
	}
}
