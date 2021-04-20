
public enum PolygonType {
	TRIANGLE,
	RECTANGLE,
	PENTAGON,
	HEXAGON,
	HEPTAGON,
	OCTAGON;

	public static PolygonType valueOf(int value) {
		switch(value) {
		case 3:
			return TRIANGLE;
		case 4:
			return RECTANGLE;
		case 5:
			return PENTAGON;
		case 6:
			return HEXAGON;
		case 7:
			return HEPTAGON;
		case 8:
			return OCTAGON;
		default:
			return null;
		}
		
		
	}
}
