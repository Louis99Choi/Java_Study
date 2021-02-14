package Lab2_1;

import java.util.Scanner;

public class UserInput {

	static Scanner scan = new Scanner(System.in);
	
	public static double getDouble() {
		return Double.parseDouble(scan.nextLine());
	}
	
}
