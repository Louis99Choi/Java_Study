// 자바프로그래밍_1분반_2021_06_09_최창환_32184731

import java.util.Scanner;

public class UserInput {
  // Scanner instance used for console input
	private static Scanner input = new Scanner(System.in); 
	
  // get String input
	public static String getString() { 
		return input.nextLine(); 
	}
	
  // get integer input
	public static int getInteger() { 
		int value = 0; 
		value = Integer.parseInt(input.nextLine()); //사용자한테 받은 값을 정수로 변환하여 value에 대입한다
		return value; 
	}

  // get integer input between min-max
	public static int getIntegerBetween(int min, int max) { 
		int value = 0;
		do {
			try {
				value = Integer.parseInt(input.nextLine());
			}
			catch (Exception e) {
				System.out.printf("Error! Please re-enter value [%d-%d]:\n", min, max);
				continue;
			}
		} while (value < min || value > max);
		return value;
	}
	
  // get double input
	public static double getDouble() { 
		double value = 0.0; 
		value = Double.parseDouble(input.nextLine()); //사용자로부터 받은 값을 double로 변환하여 대입한다
		return value; 
	}

  // return if 'q'-key or not
	public static boolean getExitKey() { 
		System.out.print("Press q-key to calculate Polygon or enter-key to continue input Point : "); 
		String str = input.nextLine(); 
		if(str.contentEquals("q")) //만약 str변수의 문자열과 "q"값이 같다면 true 리턴
			return true; 
		else
			return false; //str변수의 문자열이 "q"와 값이 같지 않다면 false 리턴 
	}
	
  // get Point input
	public static Point getPoint() { 
    Point point = new Point();
    System.out.print("\nPlease enter the Polygon point.x: ");
    point.setX(UserInput.getDouble());
    System.out.print("Please enter the Polygon point.y: ");
    point.setY(UserInput.getDouble());
		return point; 
	}

	public static PolygonType getUserPolygonType() {
		
		System.out.println("\n[ TRIANGLE : 3, QUADRILATERAL : 4, PENTAGON : 5, HEXAGON : 6, HEPTAGON : 7, OCTAGON : 8, NONAGON : 9 ]"
				+ "\n Input PolygonType Num : ");
		
		return PolygonType.valueOf(UserInput.getInteger());
	}


	
}