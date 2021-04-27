//�ڷᱸ��_1�й�_32184731_��âȯ_��ġŬ������������

package UserUtil;

import java.util.*;

public class UserInput {

	static Scanner scan = new Scanner(System.in);
	
	//�ٴ����� ���ڿ��� �Է� �޾� ��ȯ.
	public static String getNextLine() { return scan.nextLine(); }
	
	//�Է� ���� ���� �� ������ �о� ���� Double���� Integer������ ��ȯ�ϴ� �ż���
	public static double getDouble() { return Double.parseDouble(scan.nextLine()); }
	public static int getInteger() { return Integer.parseInt(scan.nextLine()); }
	
	//������� �Է�
	public static double nextDouble() {return scan.nextDouble(); }
	public static int nextInt() {return scan.nextInt(); }
	
	/*
	 * 	�ٴ����� �Է¹��� ���ڿ��� '=' �� ���鹮�ڷ� ��ȯ�Ͽ� ���ڿ��� ��ȯ.
	 */
	public static String replaceEqual(String str) {
		str = str.replace("=", " ");
		
		return str;
	}
	
	
	/*q�� �Է��� ���α׷��� �����ϰų� ����Ű�� ������ ��� �����϶�� �ȳ����� q �� �Է� �޾��� ��� 
	�ȳ����� �Բ� ���α׷��� �����ϵ��� ���� true�� false�� ��ȯ�ϴ� �ż���*/
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
