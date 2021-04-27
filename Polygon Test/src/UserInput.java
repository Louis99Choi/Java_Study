//자바프로그래밍 1분반 32184731 최창환
//중간고사 대체 과제_

import java.util.*;

public class UserInput {

	static Scanner scan = new Scanner(System.in);
	
	//입력 받은 값을 줄 단위로 읽어 각각 Double형과 Integer형으로 변환하는 매서드
	public static double getDouble() { return Double.parseDouble(scan.nextLine()); }
	public static int getInteger() { return Integer.parseInt(scan.nextLine()); }
	
	//공백단위 입력
	public static double nextDouble() {return scan.nextDouble(); }
	public static int nextInt() {return scan.nextInt(); }
	
	//입력한 값이 min값과 max값 사이의 값이 아닌 경우 재입력 지시문을 출력하고 해당 값이 입력될때까지 반복
	public static int getIntegerBetween(int min, int max) { 
		int selectedNum;
		do {
			selectedNum = getInteger();
			if(min > selectedNum || selectedNum > max) System.out.printf("잘못된 입력입니다! 원하는 메뉴의 숫자를 다시 입력하시오(1~3) : ");
		}while(min > selectedNum || selectedNum > max);
		
		return selectedNum;
	}
	
	/*q를 입력해 프로그램을 종료하거나 엔터키를 눌러서 계속 실행하라는 안내문과 q 를 입력 받았을 경우 
	안내문과 함께 프로그램을 종료하도록 각각 true와 false를 반환하는 매서드*/
	public static boolean getExitKey() {
	System.out.print("\nPress q-key to Exit or Enter-key to Continue: ");
	String s = scan.nextLine();
	if (s.contentEquals("q")) { 
		System.out.println("====================Exit Program====================");
		return true;
	}
	else
		return false;
	} 
	
}
