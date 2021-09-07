// �ڹ����α׷���_1�й�_2021_06_09_��âȯ_32184731

import java.util.ArrayList;
import java.util.Arrays;


public abstract class Polygon implements IPolygonCalculator {

	protected Point[] points; // �ٰ����� �̷�� ��� Point�� ���ҷ� �ϴ� �迭
	protected double[] sides; // �ٰ����� ��� ���� ���ҷ� �ϴ� �迭
	protected double[] diagonals; // �ٰ����� ��� �밢���� ���ҷ� �ϴ� �迭
	protected double[] angles; // �ٰ����� ��� ������ ���ҷ� �ϴ� �迭
	protected Bound bound; // �ٰ����� �����ϴ� �ּ� ũ���� �簢�� ���
	protected PolygonType type; // �ٰ����� ���� (ex_�ﰢ��, �簢��...)

	// ���ڰ� ���� ������ ȣ�� �� points �� null ���� �ִ´�.
	public Polygon() {
		this(null);
	}

	// 3.2
	// points[]�� ���ڷ� �����ڰ� ȣ��Ǹ� sides, diagonals, angles, bound, polygonType �ʱ�ȭ.
	public Polygon(Point[] points) {
		super();
		this.points = points;
		this.setPoints(this.points);
	}

	// 3.1
	// sides, diagonals, angles, bound, polygonType �ʱ�ȭ.
	public void setPoints(Point[] points) {
		this.points = points;

		// points �� null�� �ƴϰų� points�� ������ ������ 3�� �̻��̸� �ν��Ͻ�(sides, diagonals, angles,
		// bound, polygonType)�� ��� �ʱ�ȭ.
		if (points != null && points.length >= 3) {
			this.sides = PolygonMath.findSides(points); // ������ ���� ���̸� ���� �迭 sides[]�� points�� ���ڷ� �޾� �ʱ�ȭ.
			this.diagonals = PolygonMath.findDiagonals(points); // 0�� �ε����� ���� ���������� ��� �밢���� ���� �迭 diagonals[]�� points��
																// ���ڷ� �޾� �ʱ�ȭ.
			this.angles = PolygonMath.findAngles(points); // ��� ������ ���� �迭 sides[]�� points�� ���ڷ� �޾� �ʱ�ȭ.
			this.bound = Bound.findBound(points); // points�� ���ڷ� �޾� Bound.findBound()�� this.bound �ʱ�ȭ.
			this.type = PolygonType.valueOf(points.length); // PolygonType.valueOf(points.length)�� ���� this.type �ʱ�ȭ.
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
	// static �żҵ��� PolygonCalculator.findTriangles() �� Triangle Ŭ������ �ν��Ͻ� �żҵ�
	// getArea() �� �̿��� �ٰ����� ���̸� ����� ��ȯ.
	public double getArea() {

		// this.points�� 0�� �ε��� ���� ���������� ��� tessellated triangles�� �迭�� ����.
		Triangle[] triangles = PolygonCalculator.findTriangles(getPoints());
		double area = 0; // ����� �ٰ����� ���̸� ��ȯ�� ���� �ʱ�ȭ.

		// thi.points�� ���� ������ ��� tessellated triangles�� ������ ���� area ������ ����.
		for (Triangle t : triangles) {
			area += t.getArea();
		}

		return area; // ����� �ٰ����� ���̸� ��ȯ.
	}

	// # 4.3
	@Override
	public double getPerimeter() {
		double perimeter = 0; // ��ȯ �� �ѷ��� ���� ������ ����

		// �ٰ����� ��� ���� perimeter�� ���ϴ� foreach��.
		for (double s : sides) {
			perimeter += s;
		}

		return perimeter;
	}

	// # 4.4
	// ����ڿ��� ���ϴ� ��ŭ(Max:9_Nonagon) Point�� �Է¹ް� �ش� ����� �ٰ��� ��ü�� �����ϴ� �żҵ�.
	public void getUserInput() {
		
		ArrayList<Point> pointsList = new ArrayList<>(); // �Է¹��� Point���� ���� ����Ʈ ����.
		int degree_LoopCount = 0; // �Է� ���� ���׽��� �������� �Է� ������ ���� ī��Ʈ
		
		System.out.print("This Program is Polygon Calculator from Your Input {Max : Nonagon(9)}"
				+ "\nPlease enter the Point for Polygon ");
		
		do {
			pointsList.add(UserInput.getPoint()); // Point x�� y�� �Է¹���.
			
			// �ݺ��� �ݺ� �� 9���� ���� �Է� ������ Max ���̹Ƿ� �ݺ��� Ż��.
			if(++degree_LoopCount == 9) {
				System.out.println("\nEnd the Input by input Nonagon(Max)\n");
				break;
			}
			
		} while (!UserInput.getExitKey()); // �� �Է��� �����ϰ� calculator�� �����Ϸ��� q-key �Է�
		
		setPoints((Point[])pointsList.toArray()); // this.points�� pointsList ����Ʈ�� ���ҷ� ������� �ʱ�ȭ �� ��� �ν��Ͻ� ���� �� �迭 �ʱ�ȭ.
		
		System.out.println("\nUser Polygon = " + this);
	}

	// # 4.5
	@Override
	public boolean isRegular() {
		boolean yetRegular; // �ٰ����� ���ٰ��������� ���θ� ������ ����.
		int loopIndex = 0;

		// do-while���� ���� 0�� �ε������� �ٰ����� �̿��ϴ� �������� �������� ���� ���̰� ( (�ѷ�)/n )�� ������ �� �� �ϳ���
		// false�̸� false�� ��ȯ�ϸ� �żҵ� ����.
		do {
			// �ش� �ε��� ���� ���� ���ٰ����� �����Ѵٸ� yetRegular�� true�� �����ϰ� continue�� ���� ���Ǻη� ���� ���� �ε�����
			// ���ؼ� ����.
			if ((getPerimeter() == (sides[loopIndex] * points.length))
					&& (angles[loopIndex] == angles[(loopIndex + 1) % points.length])) {
				loopIndex++;
				yetRegular = true;
				continue;
			}
			// ���ٰ����� �ƴϹǷ� false�� ��ȯ�ϸ� �żҵ� ����.
			else {
				yetRegular = false;
				return yetRegular;
			}

		} while (yetRegular && (loopIndex != points.length)); // ������ �ε����� ���ؼ����� ���ٰ��� ���� �����ϸ� loopIndex == point.length�̱�
																// ������ �ݺ��� ����.

		return yetRegular; // ���ٰ����� ������ ��� true�� yetRegular ��ȯ.

	}

	// # 4.6
	@Override
	public String toString() {

		return "PolygonType =" + this.getType() + " :  [points=" + Arrays.toString(points) + ", sides="
				+ Arrays.toString(sides) + ", diagonals=" + Arrays.toString(diagonals) + ", angles="
				+ Arrays.toString(angles) + ", bound=" + bound + "]";
	}

}
