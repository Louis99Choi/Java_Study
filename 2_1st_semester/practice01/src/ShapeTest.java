
public class ShapeTest {

	public static void main(String[] args) {
		
		Shape[] shapeList = {	
				new Triangle(ShapeColor.RED, new ShapeRect(0, 0, 10, 30)),
				new Rectangle(ShapeColor.GREEN, new ShapeRect(30, 30, 40, 50)),
				new Square(ShapeColor.BLUE, new ShapeRect(10, 20, 40, 30)),
				new Circle(ShapeColor.BLUE, new ShapeRect(10, 20, 40, 50))
		};
		
		for(Shape s : shapeList) {
			s.move(10, 10);
			s.print();
			s.area();
			System.out.println();
		}
		
	}

}
