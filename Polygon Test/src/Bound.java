//자바프로그래밍 1분반 32184731 최창환
//중간고사 대체 과제_

/*
 * bottomLeft, bottomRight, topLeft, topRight 를 인스턴스 변수로 하고
 * n각형을 둘러싼 최소 크기의 직사각형을 이루는 4개의 꼭짓점을 찾아 인스턴스 변수에 저장하고 반환한다.
 * 객체가 생성될 때 각각의 생성자들은 오버로딩을 통해 다양한 값(맨왼쪽 아래 좌표, 맨오른쪽 위 좌표 등)을 매개변수로 받을 수 있다.
 */

public class Bound {
	private Point bottomLeft;
	private Point bottomRight;
	private Point topLeft;
	private Point topRight;
	
	//생성자의 매개변수가 default 이면 가로 세로가 각각 1인 Bound 객체 생성.
	public Bound() {
		this(Point.getZero(), Point.getOne());											   
	}
 
	//맨왼쪽 아래 좌표를 기준으로 width와 height를 이용해 인스턴스 변수들을 초기화.
	public Bound(Point origin, double width, double height)	{
		this.bottomLeft = origin;
		this.bottomRight = new Point(origin.getX() + width, origin.getY());
		this.topLeft = new Point(origin.getX(), origin.getY() + height);
		this.topRight = new Point(origin.getX() + width, origin.getY() + height);
	}
	
	//맨 왼쪽 아래 좌표의 x, y 좌표 값과 width, height 를 이용해 인스턴스 변수들을 초기화.
	public Bound(double x, double y, double width, double height) {
		this.bottomLeft = new Point(x, y);
		this.bottomRight = new Point(x + width, y);
		this.topLeft = new Point(x, y + height);
		this.topRight = new Point(x + width, y + height);
	}
	
	//맨왼쪽 아래 좌표와, 맨 오른쪽 위 좌표를 이용해 나머지 인스턴스 변수를 초기화.
	public Bound(Point bottomLeft, Point topRight) {
		
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
		
		this.bottomRight = new Point(topRight.getX(), bottomLeft.getY());
		this.topLeft = new Point(bottomLeft.getX(), topRight.getY());
		
	}
	
	public Point getBottomLeft() {
		return bottomLeft;
	}

	public Point getBottomRight() {
		return bottomRight;
	}

	public Point getTopLeft() {
		return topLeft;
	}

	public Point getTopRight() {
		return topRight;
	}
	
	public double getWidth() {
		return topRight.getX() - bottomLeft.getX();
	}
	
	public double getHeight() {
		return topRight.getY() - bottomRight.getY();
	}
	

	//Point[] 배열의 점들로 이루어진 다각형의 Bound를 구하는 메서드.
	public static Bound findBound(Point[] points) {
		if (points == null) return null;
		
		double xmin = points[0].getX();
		double xmax = points[0].getX();
		double ymin = points[0].getY();
		double ymax = points[0].getY();
		
		//최소와 최대의 x와 y 값을 가지는 좌표를 비교를 통해 각각 구하고 Bound를 구해 반환한다.
		for (int i = 0; i < points.length; i++) {
			xmin = Math.min(points[i].getX(), xmin);
			xmax = Math.max(points[i].getX(), xmax);
			ymin = Math.min(points[i].getY(), ymin);
			ymax = Math.max(points[i].getY(), ymax);
		}
		
		return new Bound(xmin, ymin, xmax - xmin, ymax - ymin);
	}
	
	
	@Override
	public String toString() {
		return "Bound [bottomLeft=" + bottomLeft + ", bottomRight=" + bottomRight + ", topLeft=" + topLeft
				+ ", topRight=" + topRight + "]";
	}
}
