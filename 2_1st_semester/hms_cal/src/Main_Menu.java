import java.util.Scanner;

public class Main_Menu {

	public static void main(String[] args) {
		System.out.println("�ð� ȯ�� ���α׷��Դϴ�.");
		System.out.println("-----------------------");
		System.out.println("1. Hours   -> Minutes");
		System.out.println("2. Hours   -> Seconds");
		System.out.println("3. Minutes -> Hours");
		System.out.println("4. Minutes -> Seconds");
		System.out.println("5. Seconds -> Hours");
		System.out.println("6. Seconds -> Minutes");
		System.out.println("-----------------------");
		System.out.printf("�޴��� �����Ͻÿ� : ");
		
		Scanner Menu = new Scanner(System.in);
		int menu = Menu.nextInt();
		
		switch (menu) {
		case 1:
			System.out.printf("�ð��� �Է��Ͻÿ� : ");
			Scanner InputHour = new Scanner(System.in);
			int Hours = InputHour.nextInt();
			int OutMin = Hours * 60;
			System.out.printf("\n%d �ð��� %d ���Դϴ�.",Hours,OutMin);
			break;
		case 2:
					
			break;
		case 3:
			
			break;
		case 4:
			
			break;
			
		case 5:
			
			break;
		case 6:
			
			break;

			
		default:
			System.out.printf("�޴��� �߸� �Է��ϼ̽��ϴ�.");
			
			break;
		}
		
	}
	
}