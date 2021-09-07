// 자바프로그래밍_1분반_2021_06_09_최창환_32184731

public enum PolygonType {
	TRIANGLE(3), // triangle
	QUADRILATERAL(4), // quadrilateral
	PENTAGON(5), // pentagon
	HEXAGON(6), // hexagon
	HEPTAGON(7), // heptagon
	OCTAGON(8), // octagon
	NONAGON(9); // # 9 nonagon 9각형, 9변형
	
	private final int type; // type member
	// constructor
	private PolygonType(int type) {
		this.type = type;
	}
		
	// type getter
	public int getType() {
		return type;
	}
	
	// static utility method valueOf returns PolygonType by integer type
	public static PolygonType valueOf(int type) {
		switch(type) {
		case 3:
			return TRIANGLE;
		case 4:
			return QUADRILATERAL;
		case 5:
			return PENTAGON;
		case 6:
			return HEXAGON;
		case 7:
			return HEPTAGON;
		case 8:
			return OCTAGON;
		case 9:
			return NONAGON;
		default:
			return null;
		}
	}
}