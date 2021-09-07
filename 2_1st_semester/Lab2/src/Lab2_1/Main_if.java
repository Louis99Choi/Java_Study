package Lab2_1;
import java.util.Scanner;

public class Main_if {
	
	public static void main(String[] args) {
		System.out.printf("Please input type of shape [Ex)CIRCLE] : ");
		Scanner shape = new Scanner(System.in);
		String name = shape.next();
		System.out.printf("Area of the shape : %f\n", area(name));
		System.out.println("-------------------------------------------");
		shape.close();
	}

	public static double area(String name) {
		if(name.contentEquals("CIRCLE")) {
			System.out.print("Please input circle radius :  ");
			double radius = UserInput.getDouble();
			return AreaCalculator.circleArea(radius);

		} else if(name.contentEquals("RECTANGLE")) {
			System.out.print("Please input rectangle length :  ");
			double length = UserInput.getDouble();
			System.out.print("Please input rectangle width :  ");
			double width = UserInput.getDouble();
			return AreaCalculator.rectangleArea(length, width);
			
		}else if(name.contentEquals("TRIANGLE")) {
			System.out.print("Please input triangle bottom :  ");
			double bottom = UserInput.getDouble();
			System.out.print("Please input triangle height :  ");
			double height = UserInput.getDouble();
			return AreaCalculator.triangleArea(bottom, height);
			
		} else if(name.contentEquals("TRAPEZOID")) {
			System.out.print("Please input triangle top :  ");
			double top = UserInput.getDouble();
			System.out.print("Please input triangle bottom :  ");
			double bottom = UserInput.getDouble();
			System.out.print("Please input triangle height :  ");
			double height = UserInput.getDouble();
			return AreaCalculator.trapezoidArea(top, bottom, height);
			
		}else {
			return -1.0;
		}
	}
	
}

