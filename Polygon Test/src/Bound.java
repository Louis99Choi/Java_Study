//�ڹ����α׷��� 1�й� 32184731 ��âȯ
//�߰���� ��ü ����_

/*
 * bottomLeft, bottomRight, topLeft, topRight �� �ν��Ͻ� ������ �ϰ�
 * n������ �ѷ��� �ּ� ũ���� ���簢���� �̷�� 4���� �������� ã�� �ν��Ͻ� ������ �����ϰ� ��ȯ�Ѵ�.
 * ��ü�� ������ �� ������ �����ڵ��� �����ε��� ���� �پ��� ��(�ǿ��� �Ʒ� ��ǥ, �ǿ����� �� ��ǥ ��)�� �Ű������� ���� �� �ִ�.
 */

public class Bound {
	private Point bottomLeft;
	private Point bottomRight;
	private Point topLeft;
	private Point topRight;
	
	//�������� �Ű������� default �̸� ���� ���ΰ� ���� 1�� Bound ��ü ����.
	public Bound() {
		this(Point.getZero(), Point.getOne());											   
	}
 
	//�ǿ��� �Ʒ� ��ǥ�� �������� width�� height�� �̿��� �ν��Ͻ� �������� �ʱ�ȭ.
	public Bound(Point origin, double width, double height)	{
		this.bottomLeft = origin;
		this.bottomRight = new Point(origin.getX() + width, origin.getY());
		this.topLeft = new Point(origin.getX(), origin.getY() + height);
		this.topRight = new Point(origin.getX() + width, origin.getY() + height);
	}
	
	//�� ���� �Ʒ� ��ǥ�� x, y ��ǥ ���� width, height �� �̿��� �ν��Ͻ� �������� �ʱ�ȭ.
	public Bound(double x, double y, double width, double height) {
		this.bottomLeft = new Point(x, y);
		this.bottomRight = new Point(x + width, y);
		this.topLeft = new Point(x, y + height);
		this.topRight = new Point(x + width, y + height);
	}
	
	//�ǿ��� �Ʒ� ��ǥ��, �� ������ �� ��ǥ�� �̿��� ������ �ν��Ͻ� ������ �ʱ�ȭ.
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
	

	//Point[] �迭�� ����� �̷���� �ٰ����� Bound�� ���ϴ� �޼���.
	public static Bound findBound(Point[] points) {
		if (points == null) return null;
		
		double xmin = points[0].getX();
		double xmax = points[0].getX();
		double ymin = points[0].getY();
		double ymax = points[0].getY();
		
		//�ּҿ� �ִ��� x�� y ���� ������ ��ǥ�� �񱳸� ���� ���� ���ϰ� Bound�� ���� ��ȯ�Ѵ�.
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
