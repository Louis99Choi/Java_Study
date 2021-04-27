//�ڹ����α׷��� 1�й� 32184731 ��âȯ
//�߰���� ��ü ����_

import java.util.Arrays;
import enumulation.PolygonType;

public class Polygon {
	private Point[] points;
	private Bound bound;
	private PolygonType polygonType;
	
	public Polygon() {
	}
	public Polygon(Point[] points) {
		this.points = points;
		this.bound = Bound.findBound(points);
		this.polygonType = PolygonType.valueOf(points.length);
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
	public PolygonType getPolygonType() {
		return polygonType;
	}

	@Override
	public String toString() {
		return "Polygon [points=" + Arrays.toString(points) + ", bound=" + bound + ", type=" + polygonType + "]";
	}

	
	
}
