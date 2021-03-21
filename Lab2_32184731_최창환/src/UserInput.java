import java.util.*;

public class UserInput {

	static Scanner scan = new Scanner(System.in); 
	public static double getDouble() { return Double.parseDouble(scan.nextLine()); }
	public static int getInteger() { return Integer.parseInt(scan.nextLine()); }
	
	public static int getIntegerBetween(int min, int max) { 
	// 내부 구현 필요 do-while
		
	} 
	public static boolean getExitKey() {
	System.out.print("Press q-key to exit or enter-key to continue: ");
	String s = scan.nextLine();
	if (s.contentEquals("q")) return true;
	else return false;
	} 
	

}
