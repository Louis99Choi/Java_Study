// 자바프로그래밍_1분반_2021_06_09_최창환_32184731

// # 5

/*
 * getInstance 매소드의 반환 값은 Polygon 타입이지만 실제 객체는 열거형 type 값에 따라
 * TRIANGLE, RECTANGLE, PENTAGON, HEXAGON, HEPTAGON, OCTAGON, NONAGON
 * 이므로 매서드가 실행되어 객체를 반환하는 순간 UpCasting이 발생.
 */
public class PolygonFactory {

	// # 5.1
	// 점에 대한 정보인 Point[] points 배열을 매개변수로 받아 해당하는 다각형 객체를 Upcasting해서 반환.
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
	// 매소드 오버로딩을 통해 PolygonType을 인자로 각각의 case에서 type값에 따라 해당하는 다각형 객체를 UpCasting해서 반환.
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
