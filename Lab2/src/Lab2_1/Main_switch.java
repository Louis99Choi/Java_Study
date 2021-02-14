package Lab2_1;

public class Main_switch {
	
	static double outputArea = 0;
	static boolean off_Program = false;
	static boolean WrongInput = false;
	
	public static void main(String[] args) {
		
		while(!off_Program){
			Menu.show_menu();
			outputArea = area((int)UserInput.getDouble());
			
			if(off_Program == true)
				break;
			else if(WrongInput == true)
				System.out.println("Wrong, Plz Input Correct Num. \n");
			
			System.out.printf("\nArea of the shape : %f\n", outputArea);
		}
	
		System.out.println("Off the Program.");
		System.exit(0);
		
	}

	public static double area(int mode) {
		switch(mode) {
		case AreaCalculator.CIRCLE:
			System.out.print("Please input circle radius :  ");
			double radius = UserInput.getDouble();
			return AreaCalculator.circleArea(radius);
			
		case AreaCalculator.RECTANGLE:
			System.out.print("Please input rectangle length :  ");
			double length = UserInput.getDouble();
			System.out.print("Please input rectangle width :  ");
			double width = UserInput.getDouble();
			return AreaCalculator.rectangleArea(length, width);
			
		case AreaCalculator.TRIANGLE:
			System.out.print("Please input triangle bottom :  ");
			double bottom = UserInput.getDouble();
			System.out.print("Please input triangle height :  ");
			double height = UserInput.getDouble();
			return AreaCalculator.triangleArea(bottom, height);
			
		case AreaCalculator.TRAPEZOID:
			System.out.print("Please input trapezoid top :  ");
			double top = UserInput.getDouble();
			System.out.print("Please input trapezoid bottom :  ");
			double Bottom = UserInput.getDouble();
			System.out.print("Please input trapezoid height :  ");
			double Height = UserInput.getDouble();
			return AreaCalculator.trapezoidArea(top, Bottom, Height);
			
		case 5:
			off_Program = true;
			return -1;
			
		default:
			WrongInput = true;
			return -2;
		}
		
	}
}
