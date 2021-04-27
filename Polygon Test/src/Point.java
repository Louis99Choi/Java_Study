//�ڹ����α׷��� 1�й� 32184731 ��âȯ
//�߰���� ��ü ����_

/*
 * ������ �������� �Ű������� ���� x,y 2��������� ��ǥ�� ��  Point ��ü�� �����ϴ� Ŭ����.
 * ��ü�� �����ϰ� static ���� count�� 1������Ŵ. 
 */
public class Point {
	private double x;
	private double y;
	private static int count = 0;
	private static final Point Zero = new Point(0.0, 0.0); //������ ��Ÿ��.
	private static final Point One = new Point(1.0, 1.0); //(1,1)�� ��Ÿ��.

	public Point() { 
		this(0.0, 0.0); //��ü ������ �Ű������� ���� ������ x,y ��� 0���� �ʱ�ȭ�ϴ� ������
	}

	/*
	 * ���� �����ڵ��� �����ε� �Ǿ� ���� x,y �� �Ǵ� xy[] �迭 �Ǵ� �ٸ� ��ǥ ��ü ���� �Ű������� �ϸ�
	 * ��ü�� �����Ҷ� count�� 1 ������Ŵ.
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

	//Point ��ü�� x,y ��ǥ�� 1���� �迭�� ���� {x,y}�� ��ȯ�ϴ� �޼���.
	public double[] get() {
		double[] xy = new double[2];
		xy[0] = this.x;
		xy[1] = this.y;
		
		return xy;
	}

	//1���� �迭�� ���� {x,y}�� Point ��ü�� x,y ���� �ʱ�ȭ �ϴ� �޼���.
	public void set(double[] xy) {
		if (xy.length == 2) {
			this.x = xy[0];
			this.y = xy[1];
		}
	}

	//x, y���� �Ű������� ���� x, y ������ ��ȯ�ϴ� �޼���.
	public void set(double x, double y) { 
		this.x = x; 
		this.y = y; 
	}
    
	//��ü�� x,y���� �ٸ� ��(��ǥ)��ü�� x, y ������ ���� ��ȯ.
	public void set(Point other) {
		this.x = other.x;
		this.y = other.y;
	}

	//��ü�� x,y ���� ��� d�� ���� ��ȯ.
	public Point set(double d) {
		Point point = new Point(d, d);
		return point;
	}
	
	//��ü�� ���� ��ǥ�� X���� x, Y���� y ��ŭ �����̵� ��Ű�� �޼���.
	public void move(double x, double y) { 
		this.x += x; 
		this.y += y; 
	}

	//�ٸ� ��ü�� x�� ��ŭ x��ǥ��, y�� ��ŭ y��ǥ�� �����̵� ��Ű�� �޼���.
	public void move(Point other) { 
		this.x += other.x; 
		this.y += other.y; 
	}
 
	//�� ��ü ��ǥ p, q ������ �Ÿ��� ���ϴ� static �޼���.
	public static double getDistance(Point p, Point q) { 
		return Math.sqrt((p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y)); 
	}
	
	//�ٸ� ��ü���� �Ÿ��� ��ȯ�ϴ� �ν��Ͻ� �޼���.
	public double getDistance(Point other) { 
		return getDistance(this, other); 
	}
	
	//�������������� �Ÿ��� ��ȯ�ϴ� �ν��Ͻ� �޼���.
	public double getMagnitude() {
		return getDistance(this, Zero);
	}

	//�� �� ��ǥ p�� q�� ��ġ ������ �ٲٴ� �޼���.
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
