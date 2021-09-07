// 자바프로그래밍_1분반_2021_06_09_최창환_32184731

public class Point {
	private double x; // x member
	private double y; // y member
	private static int count = 0; // count static member
 	private static final Point Zero = new Point(0.0, 0.0); // (0,0) point static member
	private static final Point One = new Point(1.0, 1.0); // (1,1) point static member

  // default constructor set as (0,0)
	public Point() { 
		this(0.0, 0.0);
	}

  // constructor(double,double) set as (x,y) & increase count
	public Point(double x, double y) { 
		set(x, y); 
		count++; 
	}
    
  // constructor(double[]) set as (x,y) & increase count
	public Point(double[] xy) { 
		set(xy); 
		count++; 
	}

  // constructor(Point) set as (x,y) & increase count
	public Point(Point other) { 
		set(other);
		count++; 
	}

  // x getter
	public double getX() {
		return x;
	}

  // x setter
	public void setX(double x) {
		this.x = x;
	}

  // y getter
	public double getY() {
		return y;
	}

  // y setter
	public void setY(double y) {
		this.y = y;
	}

  // (0,0) getter
	public static Point getZero() {
		return Zero;
	}

  // (1,1) getter
	public static Point getOne() {
		return One;
	}

  // count static getter
	public static int getCount() {
    	return count; 
	}
	    
  // count static setter
	public static void setCount(int count) {
		Point.count = count;
	}

  // clone - deep copy
	public Point clone() {
		Point p = new Point(this.x, this.y);
		System.out.println("Point clone(): " + p.toString());
		return p;
	}

  // (x,y) double[] get
	public double[] get() {
		double[] xy = new double[2];
		xy[0] = this.x;
		xy[1] = this.y;
		//System.out.println("get(): " + "(" + xy[0] + ", " + xy[1] + ")");
		return xy;
	}

  // (x,y) double[] set
	public void set(double[] xy) {
		if (xy.length == 2) {
			this.x = xy[0];
			this.y = xy[1];
			//System.out.println("set(xy[]): " + this);    		
		}
	}

  // set(x,y) - set x, y
	public void set(double x, double y) { 
		this.x = x; 
		this.y = y; 
		//System.out.println("Point::set(x,y): " + this);
	}

  // set() - set as x=1, y=2 
	public void set() {
		this.x = 1.0f;
		this.y = 2.0f;
		//System.out.println("Point::set(): " + this);
	}
    
  // set(other) - set x, y with other point
	public void set(Point other) {
		this.x = other.x;
		this.y = other.y;
		//System.out.println("Point::set(Point): " + this);
	}

  // set(d) - return a Point with (d, d)
	public Point set(double d) {
		Point point = new Point(d, d);
		//System.out.println("Point::set(i): " + point.toString());
		return point;
	}

  // move(x, y) - move this Point by x, y
	public void move(double x, double y) { 
		this.x += x; 
		this.y += y; 
	}

  // move(other) - move this Point by other.x, other.y
	public void move(Point other) { 
		this.x += other.x; 
		this.y += other.y; 
	}
 
  // static utility method - getDistance(p, q) return the distance between p and q
	public static double getDistance(Point p, Point q) { 
		return Math.sqrt((p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y)); 
	}
	
  // getDistance(other) return the distance between this and other
	public double getDistance(Point other) { 
		return getDistance(this, other); 
	}

  // getMagnitude() return the distance between this and (0,0)
	public double getMagnitude() {
		return getDistance(this, Zero);
	}

  // static utility method  - swap(p, q) swap between p and q
	public static void swap(Point p, Point q) { 
		Point temp = new Point(p);
		p.set(q);
		q.set(temp);
	}

  // static utility method  - swap2(p, q) swap between p and q
	public static void swap2(Point p, Point q) { 
		double[] temp = p.get();
		p.set(q.get());
		q.set(temp);
	}

  // Object toString() method overriding
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
