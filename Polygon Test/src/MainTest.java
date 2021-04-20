
public class MainTest {

	private static Point[][] polygonPoints = {
			{new Point(1, 0), new Point(0, 3), new Point(-4, 0)},
			{new Point(3, 0), new Point(0, 5), new Point(-2, 5), new Point(-4, 0)},
			{new Point(0, 0), new Point(0, 4), new Point(-4, 6), new Point(-4, 2), new Point(3, -4)},
			{new Point(-2, -4), new Point(0, -3),new Point(3, 0), new Point(6, 3), new Point(4, 4), new Point(-1, 2)},
			{new Point(-4, -7), new Point(-1, -9), new Point(2, -1), new Point(6, 8), new Point(3, 5), new Point(0, 2), new Point(0, 5)},
			{new Point(-5, -6), new Point(-2, -4), new Point(0, -5), new Point(2, 5), new Point(5, 8), new Point(7, 3), new Point(2, 7), new Point(-3, 5)}
			 
	};
	
	public static void main(String[] args) {
		Point bottomLeft = new Point(0.0, 0.0);
		System.out.println(bottomLeft);

		Point topRight = new Point(5.0, 5.0);
		System.out.println(topRight);
		
		System.out.println(Point.Zero);
		System.out.println(Point.One);
		
		Bound bound = new Bound(Point.Zero, Point.One);
		System.out.println(bound);
		
		Point[] rectanglePoints = new Point[4];
		rectanglePoints[0] = Point.Zero;
		rectanglePoints[1] = new Point(5.0, 0.0);
		rectanglePoints[2] = new Point(5.0, 7.0);
		rectanglePoints[3] = new Point(0.0, 2.0);

		/*Point p1 = Point.Zero;
		Point p2 = new Point(2.0, 0.0);
		Point p3 = new Point(1.0, 2.0);*/
		
		Polygon rec = new Polygon(rectanglePoints);
		System.out.println(rec);
		
		Polygon[] polygons = new Polygon[polygonPoints.length];
		
		for (Point[] k : polygonPoints) {
			int i = 0;
			polygons[i] = new Polygon(k);
			System.out.println(polygons[i]);
			i++;			
		}
		
	}

}
