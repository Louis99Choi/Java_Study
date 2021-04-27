//�ڹ����α׷��� 1�й� 32184731 ��âȯ
//�߰���� ��ü ����_

import java.util.Arrays;

//��ǥ���� �Էµ� ������ �ð���� �Ǵ� �ݽð������ ���� ����.
public class PolygonCalculator extends Polygon {
	private Triangle[] triangles;
	private double area;
	private int typenum;

	public PolygonCalculator(Point[] points) {
		super(points);
		typenum = points.length;
		triangles = new Triangle[points.length - 2]; //����ʵ�ﰢ�� �迭�� ũ�⸦ ���� �ﰢ�� ������ �ʱ�ȭ.
		setTriangles(findTriangles(points));
		setArea();
	}

	public Triangle[] getTriangles() {
		return triangles;
	}
	public void setTriangles(Triangle[] triangles) {
		this.triangles = triangles;
	}

	public double getArea() {
		return area;
	}
	
	/*
	 * Triangle �迭�� ��� ���� �ﰢ���� ���̸� ��� ���� n������ ������ ���ϴ� �޼����
	 * n���� polygonCalculator �� �ν��Ͻ� ���� area�� ���һﰢ���� �� ���� ���� �����Ѵ�.
	 */
	public void setArea() {
		for (Triangle triangle : triangles) {
			area += triangle.getArea();
		}
	}
	
	
	public static Triangle[] findTriangles(Point[] points) {
		//Point[] threePoints = new Point[3]; //n������ ���� �ﰢ���� ������ 3���� ������ Point[] �迭 �ʱ�ȭ.
		Triangle[] triangles = new Triangle[points.length - 2]; //�ﰢ�� �迭�� ũ�⸦ ���� �ﰢ���� ������ �ʱ�ȭ. (n������ ���� �ﰢ�� ������ n-2����)
		
		int indexTriangle = 0;
		
		/*
		 * n������ ù��° �������� points[]�迭�� index�� 0�̹Ƿ� �� �������� �������� �� ���� �ﰢ���� ������ index ���� ������ ����.
		 * (0,1,2), (0,2,3), (0,3,4),,,(0,n-2,n-1)
		 * ���� �ֵ��� ���� ���������� �ϴ� �ﰢ���� Triangle Ŭ������ ��ü�� ������ triangles �迭�� ���ҷ� ����.
		 */
		for(int i = 0; i < points.length - 2; i++) {
			int secondPointIndex = i + 1;
			int thirdPointIndex = i + 2;
			
			triangles[indexTriangle] = new Triangle(points[0], points[secondPointIndex], points[thirdPointIndex]);
			indexTriangle++;

		}
		
		return triangles;
	}

	
	@Override
    public String toString() { 
    	String s = getPolygonType().toString() + " [triangles=" + Arrays.toString(triangles) + ", area=" + area + "]\n";
        for (int i = 0; i < typenum; i++) {
        	s += (getPoints()[i].toString() + "\n");
        }
    	return s; 
    }    

		
}
