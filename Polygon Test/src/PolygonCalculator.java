//자바프로그래밍 1분반 32184731 최창환
//중간고사 대체 과제_

import java.util.Arrays;

//좌표들이 입력된 순서가 시계방향 또는 반시계방향일 경우로 가정.
public class PolygonCalculator extends Polygon {
	private Triangle[] triangles;
	private double area;
	private int typenum;

	public PolygonCalculator(Point[] points) {
		super(points);
		typenum = points.length;
		triangles = new Triangle[points.length - 2]; //멤버필드삼각형 배열의 크기를 분할 삼각형 개수로 초기화.
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
	 * Triangle 배열에 담긴 분할 삼각형의 넒이를 모두 더해 n각형의 영역을 구하는 메서드로
	 * n각형 polygonCalculator 의 인스턴스 변수 area에 분할삼각형을 다 더한 값을 저장한다.
	 */
	public void setArea() {
		for (Triangle triangle : triangles) {
			area += triangle.getArea();
		}
	}
	
	
	public static Triangle[] findTriangles(Point[] points) {
		//Point[] threePoints = new Point[3]; //n각형의 분할 삼각형의 꼭짓점 3개를 저장할 Point[] 배열 초기화.
		Triangle[] triangles = new Triangle[points.length - 2]; //삼각형 배열의 크기를 분할 삼각형의 개수로 초기화. (n각형의 분할 삼각형 개수는 n-2개임)
		
		int indexTriangle = 0;
		
		/*
		 * n각형의 첫번째 꼭짓점의 points[]배열의 index가 0이므로 그 꼭짓점을 기준으로 한 분할 삼각형의 꼭짓점 index 쌍은 다음과 같다.
		 * (0,1,2), (0,2,3), (0,3,4),,,(0,n-2,n-1)
		 * 위의 쌍들을 각각 꼭짓점으로 하는 삼각형을 Triangle 클래스의 객체로 생성해 triangles 배열의 원소로 저장.
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
