//자바프로그래밍 1분반 32184731 최창환
//중간고사 대체 과제_

import enumulation.PolygonType;

/* 
 * center 좌표를 기준으로 반지름이 radius인 원에 내접하는 최대 크기의 정n각형을 구하고 그 넓이를 구하는 클래스
 */
public class RegularPolygonCalculator {
	private int degree; //n각형의 각 개수로 n을 의미.
	private double radius; //반지름.
	private Point center; //원의 중심.
	private double angle; 
	private Point[] points; //정n각형의 꼭짓점의 좌표들을 원소로 갖는 배열.
   
	/*
	 * 오버로딩된 생성자들을 보면 radius는 초기화되지 않으면 1.0으로, 
	 * center 좌표는 초기화되지 않으면 원점으로 default값이 설정 되었다.
	 * 
	 */
	public RegularPolygonCalculator(int degree) {
		this(degree, 1.0, Point.getZero());
	}
    
    public RegularPolygonCalculator(int degree, double radius) {
        this(degree, radius, Point.getZero());
    }
    
    public RegularPolygonCalculator(int degree, double radius, Point center) {
       
		this.degree = Math.max(3, Math.min(8, degree)); //3 <= degree <= 8 이면 degree를, degree < 3 이거나 degree > 8이면 3 또는 8로 반환.
        this.radius = radius;
        this.center = center;       
    	this.angle = 2 * Math.PI / this.degree;
        this.points = createPoints();        
    }
    
    //해당하는 정n각형의 꼭짓점의 좌표들을 원의 성질을 이용해 구하고 배열 Point[]에 저장.
    private Point[] createPoints() {
        Point[] points = new Point[degree];

        double radian = Math.PI / 2.0; // -90
        for (int i = 0; i < degree; i++) {
        	points[i] = getPoint(radian, radius, center);
        	radian += angle;
        }
        return points;
    }
    
    //원의 성질과 코사인, 사인 법칙을 이용해 해당 정n각형의 꼭짓점의 좌표를 구하는 메서드.
    private static Point getPoint(double radian, double radius, Point offset) {
        return new Point(radius * Math.cos(radian) + offset.getX(), radius * Math.sin(radian) + offset.getY());
    }
    
    //어떤 도형인지 PolygonType 자료형으로 반환하는 메서드.
    public PolygonType getPolygonType() {
    	return PolygonType.valueOf(degree);
    }
    
    public Point[] getPoints() {
    	return points;
    }
    
    public Bound getBound() {
    	return Bound.findBound(points);
    }

    public double getArea() {
        return radius * radius * degree * Math.sin(angle) / 2.0;
    }
    
    @Override
    public String toString() { 
    	String s = getPolygonType().toString() + " [radius=" + radius + ", center=" + center.toString() + "]\n";
        for (int i = 0; i < degree; i++) {
        	s += (points[i].toString() + "\n");
        }
    	return s; 
    }    
}
