// Lab5_32184731_최창환

package controller;
import java.util.Scanner;

public class UserInput {
	private static Scanner input = new Scanner(System.in); 
	
	public static String getString() { 
		return input.nextLine(); 
	}
	
	//입력 받은 값을 줄 단위로 읽어 Double형으로 변환하는 매서드.
	public static double getDouble() { 
		double value = 0.0; 
		while (true) {
			try {
				value = Double.parseDouble(input.nextLine()); //사용자로부터 입력받은 값을 double로 변환하여 대입한다
				return value; 
			}
			catch (Exception e) {
				System.out.printf("Error! Please re-enter double\n");
				continue;
			}
		}
	}

	//입력 받은 값을 줄 단위로 읽어 Integer형으로 변환하는 매서드. 
	public static int getInteger() { 
		int value = 0;
		while (true) {
			try {
				value = Integer.parseInt(input.nextLine()); //사용자한테 받은 값을 정수로 변환하여 value에 대입한다			
				return value; 
			}
			catch (Exception e) {
				System.out.printf("Error! Please re-enter integer\n");
				continue;
			}
		}
	}

	//입력한 값이 min값과 max값 사이의 값이 아닌 경우 재입력 지시문을 출력하고 해당 값이 입력될때까지 반복
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

	/*
	 * q를 입력해 프로그램을 종료하거나 엔터키를 눌러서 계속 실행하라는 안내문과 q 를 입력 받았을 경우
	 * 안내문과 함께 프로그램을 종료하도록 각각 true와 false를 반환하는 매서드
	 */
	public static boolean getExitKey() { 
		System.out.print("Press q-key to exit or enter-key to continue: "); 
		String str = input.nextLine(); 
		if(str.contentEquals("q")) //만약 str변수의 문자열과 "q"값이 같다면 true 리턴
			return true; 
		else
			return false; //str변수의 문자열이 "q"와 값이 같지 않다면 false 리턴 
	}
	
	
}