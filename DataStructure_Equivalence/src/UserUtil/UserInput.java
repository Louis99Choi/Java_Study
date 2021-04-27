//자료구조_1분반_32184731_최창환_동치클래스구현과제

package UserUtil;

import java.util.*;

public class UserInput {

	static Scanner scan = new Scanner(System.in);
	
	//줄단위로 문자열을 입력 받아 반환.
	public static String getNextLine() { return scan.nextLine(); }
	
	//입력 받은 값을 줄 단위로 읽어 각각 Double형과 Integer형으로 변환하는 매서드
	public static double getDouble() { return Double.parseDouble(scan.nextLine()); }
	public static int getInteger() { return Integer.parseInt(scan.nextLine()); }
	
	//공백단위 입력
	public static double nextDouble() {return scan.nextDouble(); }
	public static int nextInt() {return scan.nextInt(); }
	
	/*
	 * 	줄단위로 입력받은 문자열을 '=' 를 공백문자로 변환하여 문자열을 반환.
	 */
	public static String replaceEqual(String str) {
		str = str.replace("=", " ");
		
		return str;
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
