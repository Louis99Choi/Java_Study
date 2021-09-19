public class MainTest {
	// LSP - Liskov Substitution Principle
	// 자식 클래스는 언제나 자신의 부모 클래스를 대체할 수 있어야한다. 즉 부모 클래스가 들어갈 자리에 자식 클래스를 넣어도 계획대로 잘 작동해야 한다.
	// 자식클래스는 부모클래스의 책임을 무시하거나 재정의하지 않고 확장만 수행하도록 해야 LSP를 만족한다.
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
