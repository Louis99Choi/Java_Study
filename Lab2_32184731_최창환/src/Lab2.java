
public class Lab2 {
	//이슬점 공식을 이용해 섭씨온도와 상대습도를 매개변수로 받아 이슬점을 실수형으로 반환하는 매서드.
	public static double calculateDewPointTemperature(double TC, double RH) {
		double k = (17.62 * TC)/ (243.12 + TC); 
		double DewPoint = (243.12 * (Math.log(RH /100) + k))/ 
				(17.62 - (Math.log(RH/100) + k)); 
		return DewPoint; 
	}
	//체감온도 공식을 이용해 화씨온도와 풍속을 매개변수로 받아 체감온도를 실수형으로 반환하는 매서드.
	public static double calculateWindChillTemperature(double TF, double V) {
		double WindChill = 35.74 + 0.6125 * TF + (0.4275 * TF - 35.75) * Math.pow(V, 0.16);
		return WindChill;
	}
	//매개변수로 받은 정수값(value)가 매개변수로 받은 배열(arr[])의 몇번째에 있는지 인덱스를 반환하는 매서드.
	public static int findValueIndex(int[] arr, int value) {
		int valueIndex = 0;
		for(int i=0; i <arr.length; i++) {
			if(arr[i] == value) {
				valueIndex = i; 
				break;
			}
		}
		return valueIndex;
	}
	//매개변수로 받은 배열(arr[])의 원소 중에서 매개변수로 받은 정수(value)값과 가장 근사한 값의 인덱스를 반환하는 매서드.
	public static int findSimilarValueIndex(int[] arr, int value) {
		int index = 0;
		int diff = 100;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] - value < 0) {
				if(diff > (value - arr[i])) index = i; diff = value -arr[i];
			}
			else {
				if(diff > (arr[i] - value)) index = i; diff = arr[i] - value;
			}
		}
		return index;
	}
	/*배열과 for문을 이용해 섭씨온도와 상대습도를 행과 열로 하는 간단한 이슬점 표를 출력하며
	  입력값 섭씨온도와 상대습도를 정규화시켜 매개변수로 받고 그 값을 통해 표에서 입력값과 근사한 값을 표시하는 매서드*/
	public static void printDewPointTemperatureTable(int stdTC, int stdRH) {
		String tab = "\t";
		String starIndex = "*\t";
		
		int[] rhList = new int[19];
		for(int i=0; i<rhList.length; i++) rhList[i] = 100 - i*5;
		int[] tcList = {43,41,38,35,32,29,27,24,21,18,16,13,10,7,4,2,0};
		int stdTCindex = findSimilarValueIndex(tcList, stdTC);
		int stdRHindex = findValueIndex(rhList, stdRH);
			
		System.out.printf("\n");
		for(int i = 0; i<164; i++) System.out.printf("="); //Dew Point Table boundary
		System.out.printf("\nT(˚C) \\ RH(%%)_ ");
		//입력받은 상대습도와 근사한 값의 인덱스를 찾아 표에서 표시한다.
		for(int i=0; i<rhList.length; i++) {
			if(i == stdRHindex) System.out.printf("%d%s",rhList[i],starIndex);
			else System.out.printf("%d%s",rhList[i],tab);
		}
		System.out.printf("\n");
		//표 안의 값들 중 입력 받은 값과 관련 있는 값과 근사값을 표시한다.
		for(int i=0;i<tcList.length;i++) {
			if(i == stdTCindex) System.out.printf("\n      %d %s",tcList[i],starIndex);
			else System.out.printf("\n      %d %s",tcList[i],tab);
			for(int k = 0;k<rhList.length;k++) {
				if(Math.round(calculateDewPointTemperature(tcList[i], rhList[k]))<0) break;
				else if((k==stdRHindex && i <= stdTCindex) || (i==stdTCindex && k < stdRHindex)) 
					System.out.printf("%d%s",Math.round(calculateDewPointTemperature(tcList[i], rhList[k])),starIndex);
				else System.out.printf("%d%s",Math.round(calculateDewPointTemperature(tcList[i], rhList[k])),tab);
			}
		}
		System.out.printf("\n");
		for(int i = 0; i<164; i++) System.out.printf("="); //Dew Point Table boundary
	}
	/*배열과 for문을 이용해 풍속과 화씨온도를 행과 열로 하는 간단한 체감온도 표를 출력하며
	  입력값 화씨온도와 풍속을 정규화시켜 매개변수로 받고 그 값을 통해 표에서 입력값과 근사한 값을 표시하는 매서드*/
	public static void printWindChillTemperatureTable(int stdTF, int stdV) {
		String tab = "\t";
		String starIndex = "*\t";

		int[] tfList = new int[18];
		for(int i=0; i<tfList.length; i++) tfList[i] = 40 - i*5;
		int[] vList = new int[12];
		for(int i=0; i<vList.length;i++) vList[i] = 5 + i*5;
		
		int stdTFindex = findValueIndex(tfList, stdTF);
		int stdVindex = findValueIndex(vList, stdV);
		
		System.out.printf("\n");
		for(int i = 0; i<158; i++) System.out.printf("="); //Wind Chill Table boundary
		System.out.printf("\nWind(mph)\\T(˚F)_");
		for(int i=0;i<tfList.length;i++) {
			if(i == stdTFindex) System.out.printf("%d%s", tfList[i], starIndex);
			else System.out.printf("%d%s", tfList[i], tab);
		}
		System.out.printf("\n");
		for(int i=0; i<vList.length;i++) {
			if(i==stdVindex) System.out.printf("\n      %d %s",vList[i],starIndex);
			else System.out.printf("\n      %d %s",vList[i],tab);
			for(int k=0; k<tfList.length; k++) {
				if((k==stdTFindex && i <= stdVindex) || (i==stdVindex && k < stdTFindex)) 
					System.out.printf("%d%s",Math.round(calculateWindChillTemperature(tfList[k], vList[i])),starIndex);
				else System.out.printf("%d%s",Math.round(calculateWindChillTemperature(tfList[k], vList[i])),tab);
			}
		}
		System.out.printf("\n");
		for(int i = 0; i<158; i++) System.out.printf("="); //WindChill Table boundary
	}
	/*프로그램 실행 중 1을 입력해 이슬점 메뉴를 선택할 경우 실행되는 매서드로 
	공식에 필요한 섭씨온도와 상대습도를 입력받아 calculate_ 매서드로 전달하고 구한 이슬점을 출력하는 매서드*/
	public static void selectedDewPoint() {
		double inputTC, inputRH; //입력 받을 온도와 상대습도를 저장할 실수형 변수 선언.
		double outDewPoint; //입력받은 값으로 구한 이슬점을 저장할 실수형 변수 선언.
				
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.printf("Input 'Temperature'(°C) and 'Realative Humidity' to calculate Dew Point Temperature: "); //온도(°C)와 상대습도를 입력하라는 안내문을 출력.
		inputTC = UserInput.getDouble(); //줄단위로 입력 받은 값을 inputT 변수에 실수형으로 저장하는 UserInput 클래스의 메소드.
		inputRH = UserInput.getDouble(); //줄단위로 입력 받은 값을 inputRH 변수에 실수형으로 저장하는 UserInput 클래스의 메소드.
		
		outDewPoint = calculateDewPointTemperature(inputTC, inputRH); //이슬점을 구하는 매소드에 인자로 inputTC와 inputRH를 넣고 얻은 이슬점을 outDewPoint 변수에 저장.
		
		System.out.println("Dew Point Temperature : " + Math.round(outDewPoint* 10)/ 10.0); //안내문을 통해 입력받은 온도와 상대습도로 구한 이슬점을 반올림해서 소수점 첫째 자리까지 출력.
		printDewPointTemperatureTable((int)Math.round(inputTC), (int)Math.round(inputRH - inputRH % 5));
	}
	/*프로그램 실행 중 2를 입력해 체감온도 메뉴를 선택할 경우 실행되는 매서드로 
	공식에 필요한 화씨온도와 풍속 입력받아 calculate_ 매서드로 전달하고 구한 체감온도를 출력하는 매서드*/
	public static void selectedWindChill() {
		double inputTF, inputV; //입력 받을 온도와 바람의 속도를 저장할 실수형 변수 선언.
		double outWindChill; //입력받은 값으로 구한 제감온도를 저장할 실수형 변수 선언.
		
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.printf("Input 'Temperature'(°F) and 'Vector of wind' to calculate WInd Chill Temperature: "); //온도(°F)와 바람의 속도를 입력하라는 안내문을 출력.
		inputTF = UserInput.getDouble(); //줄단위로 입력 받은 값을 inputTF 변수에 실수형으로 저장하는 UserInput 클래스의 메소드.
		inputV = UserInput.getDouble(); //줄단위로 입력 받은 값을 inputV 변수에 실수형으로 저장하는 UserInput 클래스의 메소드.
		
		outWindChill = calculateWindChillTemperature(inputTF, inputV); //이슬점을 구하는 매소드에 인자로 inputTF와 inputV를 넣고 얻은 체감온도를 outWindChill 변수에 저장.
		
		System.out.println("Wind Chill Temperature : " + Math.round(outWindChill* 10)/ 10.0); //입력을 통해 구한 체감온도를 반올림해서 소수점 첫째 자리까지 출력.
		printWindChillTemperatureTable((int)Math.round(inputTF - inputTF % 5), (int)Math.round(inputV - inputV % 5 + 5));
		showResponseAdvice(outWindChill);
	}
	//매개변수로 받은 체감온도의 값에 따라 외출시 조언을 출력하는 매서드.
	public static void showResponseAdvice(double wcTemperature) {
		String[] advice = {"옷을 따뜻하게 입음", "모자, 벙어리 장갑, 목도리, 방수 신발 등을 착용함", "방풍기능이 있는 겉옷을 입고, 안에 겹겹이 옷을 입어야 함", "장시간 야외 활동 시 저체온증과 더불어 동상의 위험이 있음"};
		int index = (wcTemperature >= -3.2)? 0 : (wcTemperature >= -10.5)? 1 : (wcTemperature >= -15.4)? 2 : (wcTemperature < -15.4)? 3 : 3;
		System.out.println("\n<외출 시 주의 및 권고사항>");
		for(int i=0; i<(index+1);i++) System.out.println(advice[i]);
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
