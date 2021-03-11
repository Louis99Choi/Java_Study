import java.util.*;

public class OutDewPoint {

	public static void main(String[] args) {
		double inputT, inputRH; //입력 받을 온도와 상대습도를 저장할 실수형 변수 선언.
		double cmdDewPoint, scanDewPoint; //args[]와 입력받은 온도 및 상대습도로 구한 이슬점을 각각 따로 저장할 실수형 변수 선언.
		Scanner scanner = new Scanner(System.in); //Scanner 객체 생성.
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.printf("Input 'Temperature'(°C) and 'Realative Humidity' for calculate Dew Point : ");
		//온도(°C)와 상대습도를 입력하라는 안내문.
		inputT = scanner.nextDouble(); //입력 받은 첫번째 실수를 inputT 변수에 저장.
		inputRH = scanner.nextDouble(); //입력 받은 두번째 실수를 inputRH 변수에 저장.
		
		scanDewPoint = calculateDewPoint(inputT, inputRH); //이슬점을 구하는 매서드에 인자로 inputT와 inputRH를 주고 얻은 이슬점을 scanDewPoint 변수에 저장.
		
		if(args.length == 2) //만약 args[] 배열에 온도, 습도 2가지 값을 입력해 배열의 길이가 2라면 이슬점을 구하고 이슬점을 출력하는 조건문.
		{
			cmdDewPoint = calculateDewPoint(Double.parseDouble(args[0]), Double.parseDouble(args[1])); //이슬점을 구하는 매서드에 args[]로 받은 값을 Double형으로 변환하여 인자로 주고 구한 이슬점을 cmdDewPoint에 저장.
			System.out.printf("\nDew Point through args[] : %d \n", Math.round(cmdDewPoint)); //args[]로 받은 값을 통해 구한 이슬점을 소수점 첫째자리에서 반올림해서 출력.
		}
		
		System.out.printf("\nDew Point through your 'Input' : %d \n\n", Math.round(scanDewPoint)); //안내문을 통해 입력받은 온도와 상대습도로 구한 이슬점을 출력
	}
	
	public static double calculateDewPoint(double T, double RH) //각각 온도와 상대습도를 나타내는 실수형 변수 2개를 인자로 받아 이슬점을 구하고 실수형 값을 반환하는 함수.
	{
		double k = (17.62 * T)/ (243.12 + T); //이슬점을 구하는 공식에서 반복되는 부분을 실수형 변수에 저장.
		double DewPoint = (243.12 * (Math.log(RH /100) + k))/ 
				(17.62 - (Math.log(RH/100) + k)); //이슬점을 구하는 공식으로 구한 값을 실수형 변수에 저장.
		
		return DewPoint; //공식을 통해 구한 이슬점을 실수형으로 반환
	}

}
