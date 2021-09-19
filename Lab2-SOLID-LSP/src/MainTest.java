public class MainTest {
	// LSP - Liskov Substitution Principle
	// �ڽ� Ŭ������ ������ �ڽ��� �θ� Ŭ������ ��ü�� �� �־���Ѵ�. �� �θ� Ŭ������ �� �ڸ��� �ڽ� Ŭ������ �־ ��ȹ��� �� �۵��ؾ� �Ѵ�.
	// �ڽ�Ŭ������ �θ�Ŭ������ å���� �����ϰų� ���������� �ʰ� Ȯ�常 �����ϵ��� �ؾ� LSP�� �����Ѵ�.
	static void checkAreaPerimeter(Rectangle rectangle) {
		rectangle.setWidth(4);
		rectangle.setHeight(5);		
		System.out.println(rectangle.getArea());
		System.out.println(rectangle.getPerimeter());
	}
	
	public static void main(String[] args) {
		// example of LSP violation
		checkAreaPerimeter(new Rectangle()); // 20 & 18
		checkAreaPerimeter(new Square()); // 25 & 20 LSP violation - It should work the same as the Rectangle
		
		// example of LSP
		Shape shape = new Rectangle2(4, 5);
		System.out.println(shape.getArea()); // 20
		System.out.println(shape.getPerimeter()); // 18
		shape = new Square2(5);
		System.out.println(shape.getArea()); // 25
		System.out.println(shape.getPerimeter()); // 20
	}
}
