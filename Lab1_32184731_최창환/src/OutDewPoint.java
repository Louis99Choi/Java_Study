import java.util.*; //Scanner 클래스를 사용하기 위해 Scanner 클래스를 포함하는 라이브러리를 import.

//Lab1_32184731_최창환
//cmd_Line args[](명령행 인자)값이 있다면 그 값을 이용해 구한 이슬점과 프로그램 실행시 입력받은 값으로 구한 이슬점을 각각 출력하는 class
public class OutDewPoint {

	public static void main(String[] args) {
		double inputT, inputRH; //입력 받을 온도와 상대습도를 저장할 실수형 변수 선언.
		double cmdDewPoint, scanDewPoint; //cmd_Line args[](명령행 인자)의 값으로 구한 이슬점과 입력받은 값으로 구한 이슬점을 각각 따로 저장할 실수형 변수 선언.
		Scanner scanner = new Scanner(System.in); //java.util의 Scanner 클래스 객체 생성.
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.printf("Input 'Temperature'(°C) and 'Realative Humidity' for calculate Dew Point : "); //온도(°C)와 상대습도를 입력하라는 안내문을 출력.
		inputT = scanner.nextDouble(); //입력 받은 첫번째 값을 inputT 변수에 실수형으로 저장하는 scanner 객체의 메소드.
		inputRH = scanner.nextDouble(); //입력 받은 두번째 값을 inputRH 변수에 실수형으로 저장하는 scanner 객체의 메소드.
		
		scanDewPoint = calculateDewPoint(inputT, inputRH); //이슬점을 구하는 매소드에 인자로 inputT와 inputRH를 넣고 얻은 이슬점을 scanDewPoint 변수에 저장.
		System.out.println("----------------------------------------------------------------------------");

		if(args.length == 2) //만약 cmd_Line args[](명령행인자)가 온도, 습도 값으로 초기화되어 배열의 크기가 2라면 그 값들로 구한 이슬점 또한 출력하는 조건문.
		{
			cmdDewPoint = calculateDewPoint(Double.parseDouble(args[0]), Double.parseDouble(args[1])); //이슬점을 구하는 매서드에 문자열인 명령행인자 값을 Double형으로 변환하여 인자로 주고 구한 이슬점을 cmdDewPoint에 저장.
			System.out.println("Dew Point through cmd_Line args[] : " + Math.round(cmdDewPoint* 10)/ 10.0); //명령행인자를 이용해 구한 이슬점을 소수점 첫째자리에서 반올림해서 출력.
		}
		
		System.out.println("Dew Point through your 'Input' : " + Math.round(scanDewPoint* 10)/ 10.0); //안내문을 통해 입력받은 온도와 상대습도로 구한 이슬점을 반올림해서 소수점 첫째 자리까지 출력.
		System.out.println("----------------------------------------------------------------------------");
	}
	
	public static double calculateDewPoint(double T, double RH) //각각 온도와 상대습도를 나타내는 실수형 변수 2개를 인자로 받아 이슬점을 구하고 실수형으로 반환하는 함수.
	{
		double k = (17.62 * T)/ (243.12 + T); //이슬점을 구하는 공식에서 반복되는 부분을 실수형 변수에 저장.
		double DewPoint = (243.12 * (Math.log(RH /100) + k))/ 
				(17.62 - (Math.log(RH/100) + k)); //이슬점을 구하는 공식으로 구한 값을 실수형 변수 DewPoint에 저장.
		
		return DewPoint; //공식을 통해 구한 이슬점을 실수형으로 반환
	}

}
