// 자바프로그래밍_1분반_2021_06_09_최창환_32184731

import java.util.ArrayList;
import java.util.Arrays;


public abstract class Polygon implements IPolygonCalculator {

	protected Point[] points; // 다각형을 이루는 모든 Point를 원소로 하는 배열
	protected double[] sides; // 다각형의 모든 변을 원소로 하는 배열
	protected double[] diagonals; // 다각형의 모든 대각선을 원소로 하는 배열
	protected double[] angles; // 다각형의 모든 내각을 원소로 하는 배열
	protected Bound bound; // 다각형을 포함하는 최소 크기의 사각형 경계
	protected PolygonType type; // 다각형의 종류 (ex_삼각형, 사각형...)

	// 인자가 없는 생성자 호출 시 points 에 null 값을 넣는다.
	public Polygon() {
		this(null);
	}

	// 3.2
	// points[]를 인자로 생성자가 호출되면 sides, diagonals, angles, bound, polygonType 초기화.
	public Polygon(Point[] points) {
		super();
		this.points = points;
		this.setPoints(this.points);
	}

	// 3.1
	// sides, diagonals, angles, bound, polygonType 초기화.
	public void setPoints(Point[] points) {
		this.points = points;

		// points 가 null이 아니거나 points의 원소의 개수가 3개 이상이면 인스턴스(sides, diagonals, angles,
		// bound, polygonType)를 모두 초기화.
		if (points != null && points.length >= 3) {
			this.sides = PolygonMath.findSides(points); // 각각의 변의 길이를 담은 배열 sides[]를 points를 인자로 받아 초기화.
			this.diagonals = PolygonMath.findDiagonals(points); // 0번 인덱스의 점을 기준으로한 모든 대각선을 담은 배열 diagonals[]를 points를
																// 인자로 받아 초기화.
			this.angles = PolygonMath.findAngles(points); // 모든 내각을 담은 배열 sides[]를 points를 인자로 받아 초기화.
			this.bound = Bound.findBound(points); // points를 인자로 받아 Bound.findBound()로 this.bound 초기화.
			this.type = PolygonType.valueOf(points.length); // PolygonType.valueOf(points.length)를 통해 this.type 초기화.
		}

	}

	// 3.2
	// return points of this polygon
	protected Point[] getPoints() {
		return points;
	}

	// return sides of this polygon
	protected double[] getSides() {
		return sides;
	}

	// return diagonals of this polygon
	protected double[] getDiagonals() {
		return diagonals;
	}

	// return angles of this polygon
	protected double[] getAngles() {
		return angles;
	}

	// return Bound of this polygon
	protected Bound getBound() {
		return bound;
	}

	// return PolygonType of this polygon
	protected PolygonType getType() {
		return type;
	}

	// # 4.2
	// static 매소드인 PolygonCalculator.findTriangles() 와 Triangle 클래스의 인스턴스 매소드
	// getArea() 를 이용해 다각형의 넓이를 계산해 반환.
	public double getArea() {

		// this.points의 0번 인덱스 점을 기준으로한 모든 tessellated triangles를 배열에 저장.
		Triangle[] triangles = PolygonCalculator.findTriangles(getPoints());
		double area = 0; // 계산한 다각형의 넓이를 반환할 변수 초기화.

		// thi.points로 부터 생성한 모든 tessellated triangles의 넓이의 합을 area 변수에 저장.
		for (Triangle t : triangles) {
			area += t.getArea();
		}

		return area; // 계산한 다각형의 넓이를 반환.
	}

	// # 4.3
	@Override
	public double getPerimeter() {
		double perimeter = 0; // 반환 할 둘레의 값을 저장할 변수

		// 다각형의 모든 변을 perimeter에 더하는 foreach문.
		for (double s : sides) {
			perimeter += s;
		}

		return perimeter;
	}

	// # 4.4
	// 사용자에게 원하는 만큼(Max:9_Nonagon) Point를 입력받고 해당 점들로 다각형 객체를 생성하는 매소드.
	public void getUserInput() {
		
		ArrayList<Point> pointsList = new ArrayList<>(); // 입력받을 Point들을 담을 리스트 생성.
		int degree_LoopCount = 0; // 입력 받을 다항식의 차수이자 입력 루프의 루프 카운트
		
		System.out.print("This Program is Polygon Calculator from Your Input {Max : Nonagon(9)}"
				+ "\nPlease enter the Point for Polygon ");
		
		do {
			pointsList.add(UserInput.getPoint()); // Point x와 y를 입력받음.
			
			// 반복문 반복 중 9개의 점을 입력 받으면 Max 값이므로 반복문 탈출.
			if(++degree_LoopCount == 9) {
				System.out.println("\nEnd the Input by input Nonagon(Max)\n");
				break;
			}
			
		} while (!UserInput.getExitKey()); // 점 입력을 종료하고 calculator를 실행하려면 q-key 입력
		
		setPoints((Point[])pointsList.toArray()); // this.points를 pointsList 리스트의 원소로 순서대로 초기화 후 모든 인스턴스 변수 및 배열 초기화.
		
		System.out.println("\nUser Polygon = " + this);
	}

	// # 4.5
	@Override
	public boolean isRegular() {
		boolean yetRegular; // 다각형이 정다각형인지의 여부를 저장할 변수.
		int loopIndex = 0;

		// do-while문을 통해 0번 인덱스부터 다각형의 이웃하는 내각끼리 같은지와 변의 길이가 ( (둘레)/n )과 같은지 비교 후 하나라도
		// false이면 false를 반환하며 매소드 종료.
		do {
			// 해당 인덱스 값에 대해 정다각형을 만족한다면 yetRegular를 true로 설정하고 continue를 통해 조건부로 가서 다음 인덱스에
			// 대해서 수행.
			if ((getPerimeter() == (sides[loopIndex] * points.length))
					&& (angles[loopIndex] == angles[(loopIndex + 1) % points.length])) {
				loopIndex++;
				yetRegular = true;
				continue;
			}
			// 정다각형이 아니므로 false를 반환하며 매소드 종료.
			else {
				yetRegular = false;
				return yetRegular;
			}

		} while (yetRegular && (loopIndex != points.length)); // 마지막 인덱스에 대해서까지 정다각형 조건 만족하면 loopIndex == point.length이기
																// 때문에 반복문 종료.

		return yetRegular; // 정다각형을 만족할 경우 true인 yetRegular 반환.

	}

	// # 4.6
	@Override
	public String toString() {

		return "PolygonType =" + this.getType() + " :  [points=" + Arrays.toString(points) + ", sides="
				+ Arrays.toString(sides) + ", diagonals=" + Arrays.toString(diagonals) + ", angles="
				+ Arrays.toString(angles) + ", bound=" + bound + "]";
	}

}
