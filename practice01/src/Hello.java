
import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
		String[][] sen = new String[2][5];
		Scanner in = new Scanner(System.in);
		System.out.println("�ټ� �ܾ� �Է�");
		for(int i=0; i<sen[1].length; i++) {
			sen[1][i] = in.next(); 
		}
		for(String s : sen[1]) {
			System.out.printf(s + " ");
		}
		
	}
	
}
	


