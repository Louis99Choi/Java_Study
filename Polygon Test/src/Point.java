//자바프로그래밍 1분반 32184731 최창환
//중간고사 대체 과제_

/*
 * 각각의 생성자의 매개변수를 통해 x,y 2차평명에서의 좌표인 점  Point 객체를 생성하는 클래스.
 * 객체를 생성하고 static 변수 count를 1증가시킴. 
 */
public class Point {
	private double x;
	private double y;
	private static int count = 0;
	private static final Point Zero = new Point(0.0, 0.0); //원점을 나타냄.
	private static final Point One = new Point(1.0, 1.0); //(1,1)을 나타냄.

	public Point() { 
		this(0.0, 0.0); //객체 생성시 매개변수를 받지 않으면 x,y 모두 0으로 초기화하는 생성자
	}

	/*
	 * 밑의 생성자들은 오버로딩 되어 각각 x,y 값 또는 xy[] 배열 또는 다른 좌표 객체 등을 매개변수로 하며
	 * 객체를 생성할때 count를 1 증가시킴.
	 */
	public Point(double x, double y) { 
		set(x, y); 
		count++; 
	}
	
	public Point(double[] xy) { 
		set(xy); 
		count++; 
	}

	public Point(Point other) { 
		set(other);
		count++; 
	}

	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

	public static Point getZero() {
		return Zero;
	}
	public static Point getOne() {
		return One;
	}

	public static int getCount() {
    	return count; 
	} 
	public static void setCount(int count) {
		Point.count = count;
	}

	public Point clone() {
		Point p = new Point(this.x, this.y);
		System.out.println("Point clone(): " + p.toString());
		return p;
	}

	//Point 객체의 x,y 좌표를 1차원 배열의 형태 {x,y}로 반환하는 메서드.
	public double[] get() {
		double[] xy = new double[2];
		xy[0] = this.x;
		xy[1] = this.y;
		
		return xy;
	}

	//1차원 배열의 형태 {x,y}로 Point 객체의 x,y 값을 초기화 하는 메서드.
	public void set(double[] xy) {
		if (xy.length == 2) {
			this.x = xy[0];
			this.y = xy[1];
		}
	}

	//x, y값을 매개변수로 받은 x, y 값으로 변환하는 메서드.
	public void set(double x, double y) { 
		this.x = x; 
		this.y = y; 
	}
    
	//객체의 x,y값을 다른 점(좌표)객체의 x, y 값으로 강제 변환.
	public void set(Point other) {
		this.x = other.x;
		this.y = other.y;
	}

	//객체의 x,y 값을 모두 d로 강제 변환.
	public Point set(double d) {
		Point point = new Point(d, d);
		return point;
	}
	
	//객체의 현재 좌표를 X축은 x, Y축은 y 만큼 평행이동 시키는 메서드.
	public void move(double x, double y) { 
		this.x += x; 
		this.y += y; 
	}

	//다른 객체의 x값 만큼 x좌표를, y값 만큼 y좌표를 평행이동 시키는 메서드.
	public void move(Point other) { 
		this.x += other.x; 
		this.y += other.y; 
	}
 
	//두 객체 좌표 p, q 사이의 거리를 구하는 static 메서드.
	public static double getDistance(Point p, Point q) { 
		return Math.sqrt((p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y)); 
	}
	
	//다른 객체와의 거리를 반환하는 인스턴스 메서드.
	public double getDistance(Point other) { 
		return getDistance(this, other); 
	}
	
	//원점에서부터의 거리를 반환하는 인스턴스 메서드.
	public double getMagnitude() {
		return getDistance(this, Zero);
	}

	//두 점 좌표 p와 q의 위치 정보를 바꾸는 메서드.
	public static void swap(Point p, Point q) { 
		Point temp = new Point(p);
		p.set(q);
		q.set(temp);
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
 
 

}
