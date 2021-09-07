//자바프로그래밍 1분반 32184731 최창환
//중간고사 대체 과제_

//해당 문제는 주석에 #n 으로 포함되어있습니다. (ex_ 1.1번 문제 : #1.1)

public class MainTest {

	private static Point[][] polygons = {
			{new Point(1, 0), new Point(0, 3), new Point(-4, 0)},
			{new Point(1, 0), new Point(-1, 4), new Point(0, 3), new Point(-4, 0)},
			{new Point(2, 0), new Point(2, 2), new Point(0, 4), new Point(-2, 2), new Point(-2, 0)},
			{new Point(4, 0), new Point(2, 2), new Point(-2, 2), new Point(-4, 0), new Point(-2, -2), new Point(2, -2)}
	};

	public static void main(String[] args) {
		
		//#1.2
		Point[] rectanglePoints = new Point[4];
		rectanglePoints[0] = Point.getZero();
		rectanglePoints[1] = new Point(5.0, 0.0);
		rectanglePoints[2] = new Point(5.0, 7.0);
		rectanglePoints[3] = new Point(0.0, 2.0);

		Polygon rec = new Polygon(rectanglePoints);
		System.out.println(rec);
		
		rectanglePoints[3] = Point.getOne();
		rectanglePoints[2].set(6);
		Point.swap(rectanglePoints[1], rectanglePoints[3]);
		rectanglePoints[2].move(Point.getOne());
		
		System.out.println(rec);
		
		//#1.3
		Point bottomLeft = new Point(0.0, 0.0);
		System.out.println(bottomLeft);

		Point topRight = new Point(5.0, 5.0);
		System.out.println(topRight);

		Bound bound = new Bound(Point.getZero(), Point.getOne());
		System.out.println(bound);

		//#5.6
		Point firstPoint = Point.getZero();
		Point secondPoint = Point.getOne();
		Point thirdPoint = new Point(-3.0, 4.0);
		Triangle triangle = new Triangle(firstPoint, secondPoint, thirdPoint);
		System.out.println(triangle);
		

		Polygon[] polygonPoints = new Polygon[polygons.length];

		for (Point[] k : polygons) {
			int i = 0;
			polygonPoints[i] = new Polygon(k);
			System.out.println(polygonPoints[i]);
			i++;
			
		}
		
		do {
			System.out.println("================================================================================\n"
				+ "1 : #4_ 사용자 입력을 받아서 RegularPolygonCalculator Test\n"
				+ "2 : #5.7_ 사용자 입력을 받아서 Triangle Test\n"
				+ "3 : #6_ 사용자 입력을 받아서 PolygonCalculator Test\n"
				+ "해당 메뉴 숫자를 입력하시오 : ");
			
			int selectedNum = UserInput.getIntegerBetween(1, 3);
			
			switch (selectedNum) {
			case 1:
				exeRegularPoly();
				break;
				
			case 2:
				exeTriangle();
				break;
				
			case 3:
				exePolyCal();
				break;

			default:
				break;
			}
		
		
		} while (!UserInput.getExitKey());
		
		

	}

	public static void exeRegularPoly() {
		System.out.print(" 원점을 중심으로 반지름r인 원에 내접하는 정n각형의 꼭짓점 좌표와 넓이를 구합니다.\n"
				+ "3이상 8이하의 n을 입력하시오 : ");
		int deg = UserInput.getInteger();
		System.out.printf("반지름 r을 입력하시오 : ");
		int rad = UserInput.getInteger();
		
		RegularPolygonCalculator regularPoly = new RegularPolygonCalculator(deg, rad);
		
		System.out.printf("정%d각형의 넓이는 %.1f 입니다.\n", deg, regularPoly.getArea());
	}
	
	public static void exeTriangle() {
		System.out.println("삼각형을 이루는 세 점의 좌표를 입력하면 삼각형의 넓이를 구합니다.\n");
			
	}
	
	public static void exePolyCal() {
		System.out.print("x, y 좌표를 입력받아 점들로 이루어진 n각형의 넓이를 구합니다\n"
				+ "n 을 입력하시오 : ");
		int n = UserInput.getIntegerBetween(3, 100);
		Point[] points = new Point[n];

		System.out.println("좌표를 시계 또는 반시계 방향으로 순차적으로 입력하시오.");
		for(int i = 0; i < n; i++) {
			System.out.printf("%d 번째 점 : ", i+1);
			points[i].setX(UserInput.nextDouble());
			points[i].setY(UserInput.nextDouble());
			
		}
		
		PolygonCalculator polycal = new PolygonCalculator(points);
		
		System.out.printf("%d 각형의 넓이는 %.1f 입니다.", n, polycal.getArea());
	}
	
}
