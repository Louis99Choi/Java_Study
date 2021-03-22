import java.util.*;

public class Lab2 {
	//이슬점 공식을 이용해 섭씨온도와 상대습도를 매개변수로 받아 이슬점을 실수형으로 반환하는 매서드
	public static double calculateDewPointTemperature(double TC, double RH) {
		double k = (17.62 * TC)/ (243.12 + TC); 
		double DewPoint = (243.12 * (Math.log(RH /100) + k))/ 
				(17.62 - (Math.log(RH/100) + k)); 
		return DewPoint; 
	}
	//체감온도 공식을 이용해 화씨온도와 풍속을 매개변수로 받아 체감온도를 실수형으로 반환하는 매서드
	public static double calculateWindChillTemperature(double TF, double V) {
		double WindChill = 35.74 + 0.6125 * TF + (0.4275 * TF - 35.75) * Math.pow(V, 0.16);
		return WindChill;
	}
	//섭씨온도와 상대습도를 각각 행과 열로 하는 간단한 이슬점 표를 출력하는 매서드
	public static void printDewPointTemperatureTable() {
		int[] rhList = new int[19];
		int[] tcList = {43,41,38,35,32,29,27,24,21,18,16,13,10,7,4,2,0};
		
		System.out.printf("\n");
		for(int i = 0; i<164; i++) System.out.printf("="); //Dew Point Table boundary
		System.out.printf("\nT(˚C) \\ RH(%%)_ ");
		for(int i=0; i<rhList.length; i++) System.out.printf("%d\t",rhList[i] = 100 - i*5);
		System.out.printf("\n");
		//상대습도 행의 배열 rhList 초기화와 출력을 동시에 진행
		for(int i=0;i<tcList.length;i++) {
			System.out.printf("\n      %d \t",tcList[i]);
			for(int k = 0;k<rhList.length;k++) {
				if(Math.round(calculateDewPointTemperature(tcList[i], rhList[k]))<0) break;
				else System.out.printf("%d\t",Math.round(calculateDewPointTemperature(tcList[i], rhList[k])));
			}
		}
		System.out.printf("\n");
		for(int i = 0; i<164; i++) System.out.printf("="); //Dew Point Table boundary
	}
	//for문을 이용해 풍속과 화씨온도를 각각 행과 열로 하는 간단한 체감온도 표를 출력하는 매서드.
	public static void printWindChillTemperatureTable() {

		int[] tfList = new int[18];
		for(int i=0; i<tfList.length; i++) tfList[i] = 40 - i*5;
		int[] vList = new int[12];
		for(int i=0; i<vList.length;i++) vList[i] = 5 + i*5;
		
		System.out.printf("\n");
		for(int i = 0; i<158; i++) System.out.printf("="); //WindChill Table boundary
		System.out.printf("\nWind(mph)\\T(˚F)_");
		for(int k : tfList) System.out.printf("%d\t", k);//for-each문
		System.out.printf("\n");
		for(int i=0; i<vList.length;i++) {
			if(vList[i] == 5) System.out.printf("\n       %d\t",vList[i]);
			else System.out.printf("\n      %d\t",vList[i]);
			for(int k=0; k<tfList.length; k++) System.out.printf("%d\t",Math.round(calculateWindChillTemperature(tfList[k], vList[i])));
		}
		System.out.printf("\n");
		for(int i = 0; i<158; i++) System.out.printf("="); //WindChill Table boundary
	}
	/*프로그램 실행 중 1을 입력해 이슬점 메뉴를 선택할 경우 실행되는 매서드로 
	공식에 필요한 섭씨온도와 상대습도를 입력받아 calculate_ 매서드로 전달하고 구한 이슬점을 출력하는 매서드*/
	public static void selectedDewPoint() {
		double inputTC, inputRH; //입력 받을 온도와 상대습도를 저장할 실수형 변수 선언.
		double outDewPoint; //입력받은 값으로 구한 이슬점을 저장할 실수형 변수 선언.
		Scanner scanner = new Scanner(System.in); //java.util의 Scanner 클래스 객체 생성.
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.printf("Input 'Temperature'(°C) and 'Realative Humidity' to calculate Dew Point Temperature: "); //온도(°C)와 상대습도를 입력하라는 안내문을 출력.
		inputTC = scanner.nextDouble(); //입력 받은 첫번째 값을 inputT 변수에 실수형으로 저장하는 scanner 객체의 메소드.
		inputRH = scanner.nextDouble(); //입력 받은 두번째 값을 inputRH 변수에 실수형으로 저장하는 scanner 객체의 메소드.
		
		outDewPoint = calculateDewPointTemperature(inputTC, inputRH); //이슬점을 구하는 매소드에 인자로 inputTC와 inputRH를 넣고 얻은 이슬점을 outDewPoint 변수에 저장.
		
		System.out.println("Dew Point Temperature : " + Math.round(outDewPoint* 10)/ 10.0); //안내문을 통해 입력받은 온도와 상대습도로 구한 이슬점을 반올림해서 소수점 첫째 자리까지 출력.
		printDewPointTemperatureTable();
	}
	/*프로그램 실행 중 2를 입력해 체감온도 메뉴를 선택할 경우 실행되는 매서드로 
	공식에 필요한 화씨온도와 풍속 입력받아 calculate_ 매서드로 전달하고 구한 체감온도를 출력하는 매서드*/
	public static void selectedWindChill() {
		double inputTF, inputV; //입력 받을 온도와 바람의 속도를 저장할 실수형 변수 선언.
		double outWindChill; //입력받은 값으로 구한 제감온도를 저장할 실수형 변수 선언.
		Scanner scanner = new Scanner(System.in); //java.util의 Scanner 클래스 객체 생성.
		
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.printf("Input 'Temperature'(°F) and 'Vector of wind' to calculate WInd Chill Temperature: "); //온도(°F)와 바람의 속도를 입력하라는 안내문을 출력.
		inputTF = scanner.nextDouble(); //입력 받은 첫번째 값을 inputTF 변수에 실수형으로 저장하는 scanner 객체의 메소드.
		inputV = scanner.nextDouble(); //입력 받은 두번째 값을 inputV 변수에 실수형으로 저장하는 scanner 객체의 메소드.
		
		outWindChill = calculateWindChillTemperature(inputTF, inputV); //이슬점을 구하는 매소드에 인자로 inputTF와 inputV를 넣고 얻은 체감온도를 outWindChill 변수에 저장.
		
		System.out.println("Wind Chill Temperature : " + Math.round(outWindChill* 10)/ 10.0); //입력을 통해 구한 체감온도를 반올림해서 소수점 첫째 자리까지 출력.
		printWindChillTemperatureTable();
	}
	/*각각 이슬점과 체감온도를 구하는 메뉴 안내문을 출력하고 UserInput.getIntegerBetween 매서드를 통해 
	메뉴를 선택한 후 switch문을 이용해 해당 메뉴(selectedDewPoint 또는 selectedWindChill) 매서드를 실행.*/
	public static void inputMenu() {
		for(int i = 0; i<50; i++) System.out.printf("-");
		System.out.println("\n# Input '1' to get Dew_Point_Temperature.");
		System.out.println("# Input '2' to get Wind_Chill_Temperature.");
		System.out.printf("# Menu Num : ");
		
		switch(UserInput.getIntegerBetween(1, 2)){
			case 1: 
				selectedDewPoint();	
				break;
			case 2: 
				selectedWindChill(); 
				break;
		}
	}
	/*해당 프로그램이 시작되는 main 매서드로 do-while문을 이용해 InputMenu 매서드를 실행 한 후 
	UserInput.getExitKey() 매서드를 통해 반복 실행 및 프로그램 종료 여부를 판단. */
	public static void main(String[] args) {
		do {
			inputMenu();
		}while(!UserInput.getExitKey());
	}

}
