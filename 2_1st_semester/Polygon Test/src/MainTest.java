//�ڹ����α׷��� 1�й� 32184731 ��âȯ
//�߰���� ��ü ����_

//�ش� ������ �ּ��� #n ���� ���ԵǾ��ֽ��ϴ�. (ex_ 1.1�� ���� : #1.1)

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
				+ "1 : #4_ ����� �Է��� �޾Ƽ� RegularPolygonCalculator Test\n"
				+ "2 : #5.7_ ����� �Է��� �޾Ƽ� Triangle Test\n"
				+ "3 : #6_ ����� �Է��� �޾Ƽ� PolygonCalculator Test\n"
				+ "�ش� �޴� ���ڸ� �Է��Ͻÿ� : ");
			
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
		System.out.print(" ������ �߽����� ������r�� ���� �����ϴ� ��n������ ������ ��ǥ�� ���̸� ���մϴ�.\n"
				+ "3�̻� 8������ n�� �Է��Ͻÿ� : ");
		int deg = UserInput.getInteger();
		System.out.printf("������ r�� �Է��Ͻÿ� : ");
		int rad = UserInput.getInteger();
		
		RegularPolygonCalculator regularPoly = new RegularPolygonCalculator(deg, rad);
		
		System.out.printf("��%d������ ���̴� %.1f �Դϴ�.\n", deg, regularPoly.getArea());
	}
	
	public static void exeTriangle() {
		System.out.println("�ﰢ���� �̷�� �� ���� ��ǥ�� �Է��ϸ� �ﰢ���� ���̸� ���մϴ�.\n");
			
	}
	
	public static void exePolyCal() {
		System.out.print("x, y ��ǥ�� �Է¹޾� ����� �̷���� n������ ���̸� ���մϴ�\n"
				+ "n �� �Է��Ͻÿ� : ");
		int n = UserInput.getIntegerBetween(3, 100);
		Point[] points = new Point[n];

		System.out.println("��ǥ�� �ð� �Ǵ� �ݽð� �������� ���������� �Է��Ͻÿ�.");
		for(int i = 0; i < n; i++) {
			System.out.printf("%d ��° �� : ", i+1);
			points[i].setX(UserInput.nextDouble());
			points[i].setY(UserInput.nextDouble());
			
		}
		
		PolygonCalculator polycal = new PolygonCalculator(points);
		
		System.out.printf("%d ������ ���̴� %.1f �Դϴ�.", n, polycal.getArea());
	}
	
}
