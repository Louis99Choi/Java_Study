// �ڹ����α׷���_1�й�_2021_06_09_��âȯ_32184731

// # 5

/*
 * getInstance �żҵ��� ��ȯ ���� Polygon Ÿ�������� ���� ��ü�� ������ type ���� ����
 * TRIANGLE, RECTANGLE, PENTAGON, HEXAGON, HEPTAGON, OCTAGON, NONAGON
 * �̹Ƿ� �ż��尡 ����Ǿ� ��ü�� ��ȯ�ϴ� ���� UpCasting�� �߻�.
 */
public class PolygonFactory {

	// # 5.1
	// ���� ���� ������ Point[] points �迭�� �Ű������� �޾� �ش��ϴ� �ٰ��� ��ü�� Upcasting�ؼ� ��ȯ.
	public static Polygon getInstance(Point[] points) {

		switch (PolygonType.valueOf(points.length)) {

		case TRIANGLE:
			return new Triangle(points);

		case QUADRILATERAL:
			return new Quadrilateral(points);

		case PENTAGON:
			return new Pentagon(points);

		case HEXAGON:
			return new Hexagon(points);

		case HEPTAGON:
			return new Heptagon(points);

		case OCTAGON:
			return new Octagon(points);

		case NONAGON:
			return new Nonagon(points);

		default:
			return null;

		}

	}
	
	// # 5.2
	// �żҵ� �����ε��� ���� PolygonType�� ���ڷ� ������ case���� type���� ���� �ش��ϴ� �ٰ��� ��ü�� UpCasting�ؼ� ��ȯ.
	public static Polygon getInstance(PolygonType type) {
		
		switch (type) {

		case TRIANGLE:
			return new Triangle();

		case QUADRILATERAL:
			return new Quadrilateral();

		case PENTAGON:
			return new Pentagon();

		case HEXAGON:
			return new Hexagon();

		case HEPTAGON:
			return new Heptagon();

		case OCTAGON:
			return new Octagon();

		case NONAGON:
			return new Nonagon();

		default:
			return null;

		}

	}
	
}
