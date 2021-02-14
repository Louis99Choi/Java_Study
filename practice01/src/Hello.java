
import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
		String[][] sen = new String[2][5];
		Scanner in = new Scanner(System.in);
		System.out.println("다섯 단어 입력");
		for(int i=0; i<sen[1].length; i++) {
			sen[1][i] = in.next(); 
		}
		for(String s : sen[1]) {
			System.out.printf(s + " ");
		}
		
	}
	
}
	


