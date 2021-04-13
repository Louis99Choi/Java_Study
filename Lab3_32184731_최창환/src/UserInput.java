import java.util.*;

public class UserInput {

	static Scanner scan = new Scanner(System.in);
	
	//�Է� ���� ���� �� ������ �о� ���� Double���� Integer������ ��ȯ�ϴ� �ż���
	public static double getDouble() { return Double.parseDouble(scan.nextLine()); }
	public static int getInteger() { return Integer.parseInt(scan.nextLine()); }
	
	/*
	 * ȭ���µ��� �����µ���, �����µ��� ȭ���µ��� ��ȯ�ϴ� static �޼���.
	 */
	public static double convertFtoC(double F) {
		return (F - 32)/1.8;
	}
	public static double convertCtoF(double C) {
		return (C * 1.8 + 32);
	}
	
	//�Է��� ���� min���� max�� ������ ���� �ƴ� ��� ���Է� ���ù��� ����ϰ� �ش� ���� �Էµɶ����� �ݺ�
	public static int getIntegerBetween(int min, int max) { 
		int selectedNum;
		do {
			selectedNum = getInteger();
			if(min > selectedNum || selectedNum > max) System.out.printf("�߸��� �Է��Դϴ�! ���ϴ� �޴��� ���ڸ� �ٽ� �Է��Ͻÿ�(1~3) : ");
		}while(min > selectedNum || selectedNum > max);
		
		return selectedNum;
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
