import java.util.Scanner;

public class Main_Menu {

	public static void main(String[] args) {
		System.out.println("시간 환산 프로그램입니다.");
		System.out.println("-----------------------");
		System.out.println("1. Hours   -> Minutes");
		System.out.println("2. Hours   -> Seconds");
		System.out.println("3. Minutes -> Hours");
		System.out.println("4. Minutes -> Seconds");
		System.out.println("5. Seconds -> Hours");
		System.out.println("6. Seconds -> Minutes");
		System.out.println("-----------------------");
		System.out.printf("메뉴를 선택하시오 : ");
		
		Scanner Menu = new Scanner(System.in);
		int menu = Menu.nextInt();
		
		switch (menu) {
		case 1:
			System.out.printf("시간을 입력하시오 : ");
			Scanner InputHour = new Scanner(System.in);
			int Hours = InputHour.nextInt();
			int OutMin = Hours * 60;
			System.out.printf("\n%d 시간은 %d 분입니다.",Hours,OutMin);
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
			System.out.printf("메뉴를 잘못 입력하셨습니다.");
			
			break;
		}
		
	}
	
}
