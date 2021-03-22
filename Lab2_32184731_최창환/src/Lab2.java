
public class Lab2 {
	//�̽��� ������ �̿��� �����µ��� �������� �Ű������� �޾� �̽����� �Ǽ������� ��ȯ�ϴ� �ż���.
	public static double calculateDewPointTemperature(double TC, double RH) {
		double k = (17.62 * TC)/ (243.12 + TC); 
		double DewPoint = (243.12 * (Math.log(RH /100) + k))/ 
				(17.62 - (Math.log(RH/100) + k)); 
		return DewPoint; 
	}
	//ü���µ� ������ �̿��� ȭ���µ��� ǳ���� �Ű������� �޾� ü���µ��� �Ǽ������� ��ȯ�ϴ� �ż���.
	public static double calculateWindChillTemperature(double TF, double V) {
		double WindChill = 35.74 + 0.6125 * TF + (0.4275 * TF - 35.75) * Math.pow(V, 0.16);
		return WindChill;
	}
	//�Ű������� ���� ������(value)�� �Ű������� ���� �迭(arr[])�� ���°�� �ִ��� �ε����� ��ȯ�ϴ� �ż���.
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
	//�Ű������� ���� �迭(arr[])�� ���� �߿��� �Ű������� ���� ����(value)���� ���� �ٻ��� ���� �ε����� ��ȯ�ϴ� �ż���.
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
	/*�迭�� for���� �̿��� �����µ��� �������� ��� ���� �ϴ� ������ �̽��� ǥ�� ����ϸ�
	  �Է°� �����µ��� �������� ����ȭ���� �Ű������� �ް� �� ���� ���� ǥ���� �Է°��� �ٻ��� ���� ǥ���ϴ� �ż���*/
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
		System.out.printf("\nT(��C) \\ RH(%%)_ ");
		//�Է¹��� �������� �ٻ��� ���� �ε����� ã�� ǥ���� ǥ���Ѵ�.
		for(int i=0; i<rhList.length; i++) {
			if(i == stdRHindex) System.out.printf("%d%s",rhList[i],starIndex);
			else System.out.printf("%d%s",rhList[i],tab);
		}
		System.out.printf("\n");
		//ǥ ���� ���� �� �Է� ���� ���� ���� �ִ� ���� �ٻ簪�� ǥ���Ѵ�.
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
	/*�迭�� for���� �̿��� ǳ�Ӱ� ȭ���µ��� ��� ���� �ϴ� ������ ü���µ� ǥ�� ����ϸ�
	  �Է°� ȭ���µ��� ǳ���� ����ȭ���� �Ű������� �ް� �� ���� ���� ǥ���� �Է°��� �ٻ��� ���� ǥ���ϴ� �ż���*/
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
		System.out.printf("\nWind(mph)\\T(��F)_");
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
	/*���α׷� ���� �� 1�� �Է��� �̽��� �޴��� ������ ��� ����Ǵ� �ż���� 
	���Ŀ� �ʿ��� �����µ��� �������� �Է¹޾� calculate_ �ż���� �����ϰ� ���� �̽����� ����ϴ� �ż���*/
	public static void selectedDewPoint() {
		double inputTC, inputRH; //�Է� ���� �µ��� �������� ������ �Ǽ��� ���� ����.
		double outDewPoint; //�Է¹��� ������ ���� �̽����� ������ �Ǽ��� ���� ����.
				
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.printf("Input 'Temperature'(��C) and 'Realative Humidity' to calculate Dew Point Temperature: "); //�µ�(��C)�� �������� �Է��϶�� �ȳ����� ���.
		inputTC = UserInput.getDouble(); //�ٴ����� �Է� ���� ���� inputT ������ �Ǽ������� �����ϴ� UserInput Ŭ������ �޼ҵ�.
		inputRH = UserInput.getDouble(); //�ٴ����� �Է� ���� ���� inputRH ������ �Ǽ������� �����ϴ� UserInput Ŭ������ �޼ҵ�.
		
		outDewPoint = calculateDewPointTemperature(inputTC, inputRH); //�̽����� ���ϴ� �żҵ忡 ���ڷ� inputTC�� inputRH�� �ְ� ���� �̽����� outDewPoint ������ ����.
		
		System.out.println("Dew Point Temperature : " + Math.round(outDewPoint* 10)/ 10.0); //�ȳ����� ���� �Է¹��� �µ��� �������� ���� �̽����� �ݿø��ؼ� �Ҽ��� ù° �ڸ����� ���.
		printDewPointTemperatureTable((int)Math.round(inputTC), (int)Math.round(inputRH - inputRH % 5));
	}
	/*���α׷� ���� �� 2�� �Է��� ü���µ� �޴��� ������ ��� ����Ǵ� �ż���� 
	���Ŀ� �ʿ��� ȭ���µ��� ǳ�� �Է¹޾� calculate_ �ż���� �����ϰ� ���� ü���µ��� ����ϴ� �ż���*/
	public static void selectedWindChill() {
		double inputTF, inputV; //�Է� ���� �µ��� �ٶ��� �ӵ��� ������ �Ǽ��� ���� ����.
		double outWindChill; //�Է¹��� ������ ���� �����µ��� ������ �Ǽ��� ���� ����.
		
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.printf("Input 'Temperature'(��F) and 'Vector of wind' to calculate WInd Chill Temperature: "); //�µ�(��F)�� �ٶ��� �ӵ��� �Է��϶�� �ȳ����� ���.
		inputTF = UserInput.getDouble(); //�ٴ����� �Է� ���� ���� inputTF ������ �Ǽ������� �����ϴ� UserInput Ŭ������ �޼ҵ�.
		inputV = UserInput.getDouble(); //�ٴ����� �Է� ���� ���� inputV ������ �Ǽ������� �����ϴ� UserInput Ŭ������ �޼ҵ�.
		
		outWindChill = calculateWindChillTemperature(inputTF, inputV); //�̽����� ���ϴ� �żҵ忡 ���ڷ� inputTF�� inputV�� �ְ� ���� ü���µ��� outWindChill ������ ����.
		
		System.out.println("Wind Chill Temperature : " + Math.round(outWindChill* 10)/ 10.0); //�Է��� ���� ���� ü���µ��� �ݿø��ؼ� �Ҽ��� ù° �ڸ����� ���.
		printWindChillTemperatureTable((int)Math.round(inputTF - inputTF % 5), (int)Math.round(inputV - inputV % 5 + 5));
		showResponseAdvice(outWindChill);
	}
	//�Ű������� ���� ü���µ��� ���� ���� ����� ������ ����ϴ� �ż���.
	public static void showResponseAdvice(double wcTemperature) {
		String[] advice = {"���� �����ϰ� ����", "����, ��� �尩, �񵵸�, ��� �Ź� ���� ������", "��ǳ����� �ִ� �ѿ��� �԰�, �ȿ� ����� ���� �Ծ�� ��", "��ð� �߿� Ȱ�� �� ��ü������ ���Ҿ� ������ ������ ����"};
		int index = (wcTemperature >= -3.2)? 0 : (wcTemperature >= -10.5)? 1 : (wcTemperature >= -15.4)? 2 : (wcTemperature < -15.4)? 3 : 3;
		System.out.println("\n<���� �� ���� �� �ǰ����>");
		for(int i=0; i<(index+1);i++) System.out.println(advice[i]);
	}
	/*���� �̽����� ü���µ��� ���ϴ� �޴� �ȳ����� ����ϰ� UserInput.getIntegerBetween �ż��带 ���� 
	�޴��� ������ �� switch���� �̿��� �ش� �޴�(selectedDewPoint �Ǵ� selectedWindChill) �ż��带 ����.*/
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
	/*�ش� ���α׷��� ���۵Ǵ� main �ż���� do-while���� �̿��� InputMenu �ż��带 ���� �� �� 
	UserInput.getExitKey() �ż��带 ���� �ݺ� ���� �� ���α׷� ���� ���θ� �Ǵ�. */
	public static void main(String[] args) {
		do {
			inputMenu();
		}while(!UserInput.getExitKey());
	}

}
