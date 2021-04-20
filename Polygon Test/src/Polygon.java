import java.util.Arrays;

public class Polygon {
	private Point[] points;
	private Bound bound;
	private PolygonType type;
	
	public Polygon(Point[] points) {
		this.points = points;
		this.bound = Bound.findBound(points);
		this.type = PolygonType.valueOf(points.length);
	}

	public Point[] getPoints() {
		return points;
	}
	public void setPoints(Point[] points) {
		this.points = points;
	}
	public Bound getBound() {
		return bound;
	}
	public PolygonType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Polygon [points=" + Arrays.toString(points) + ", bound=" + bound + ", type=" + type + "]";
	}

	
	
}
