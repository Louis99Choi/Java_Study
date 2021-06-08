// Lab5_32184731_��âȯ

package controller;
import java.util.Scanner;

public class UserInput {
	private static Scanner input = new Scanner(System.in); 
	
	public static String getString() { 
		return input.nextLine(); 
	}
	
	//�Է� ���� ���� �� ������ �о� Double������ ��ȯ�ϴ� �ż���.
	public static double getDouble() { 
		double value = 0.0; 
		while (true) {
			try {
				value = Double.parseDouble(input.nextLine()); //����ڷκ��� �Է¹��� ���� double�� ��ȯ�Ͽ� �����Ѵ�
				return value; 
			}
			catch (Exception e) {
				System.out.printf("Error! Please re-enter double\n");
				continue;
			}
		}
	}

	//�Է� ���� ���� �� ������ �о� Integer������ ��ȯ�ϴ� �ż���. 
	public static int getInteger() { 
		int value = 0;
		while (true) {
			try {
				value = Integer.parseInt(input.nextLine()); //��������� ���� ���� ������ ��ȯ�Ͽ� value�� �����Ѵ�			
				return value; 
			}
			catch (Exception e) {
				System.out.printf("Error! Please re-enter integer\n");
				continue;
			}
		}
	}

	//�Է��� ���� min���� max�� ������ ���� �ƴ� ��� ���Է� ���ù��� ����ϰ� �ش� ���� �Էµɶ����� �ݺ�
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
	 * q�� �Է��� ���α׷��� �����ϰų� ����Ű�� ������ ��� �����϶�� �ȳ����� q �� �Է� �޾��� ���
	 * �ȳ����� �Բ� ���α׷��� �����ϵ��� ���� true�� false�� ��ȯ�ϴ� �ż���
	 */
	public static boolean getExitKey() { 
		System.out.print("Press q-key to exit or enter-key to continue: "); 
		String str = input.nextLine(); 
		if(str.contentEquals("q")) //���� str������ ���ڿ��� "q"���� ���ٸ� true ����
			return true; 
		else
			return false; //str������ ���ڿ��� "q"�� ���� ���� �ʴٸ� false ���� 
	}
	
	
}