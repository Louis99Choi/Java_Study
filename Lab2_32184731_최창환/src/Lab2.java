import java.util.*;

public class Lab2 {
	//�̽��� ������ �̿��� �����µ��� �������� �Ű������� �޾� �̽����� �Ǽ������� ��ȯ�ϴ� �ż���
	public static double calculateDewPointTemperature(double TC, double RH) {
		double k = (17.62 * TC)/ (243.12 + TC); 
		double DewPoint = (243.12 * (Math.log(RH /100) + k))/ 
				(17.62 - (Math.log(RH/100) + k)); 
		return DewPoint; 
	}
	//ü���µ� ������ �̿��� ȭ���µ��� ǳ���� �Ű������� �޾� ü���µ��� �Ǽ������� ��ȯ�ϴ� �ż���
	public static double calculateWindChillTemperature(double TF, double V) {
		double WindChill = 35.74 + 0.6125 * TF + (0.4275 * TF - 35.75) * Math.pow(V, 0.16);
		return WindChill;
	}
	//�����µ��� �������� ���� ��� ���� �ϴ� ������ �̽��� ǥ�� ����ϴ� �ż���
	public static void printDewPointTemperatureTable() {
		int[] rhList = new int[19];
		int[] tcList = {43,41,38,35,32,29,27,24,21,18,16,13,10,7,4,2,0};
		
		System.out.printf("\n");
		for(int i = 0; i<164; i++) System.out.printf("="); //Dew Point Table boundary
		System.out.printf("\nT(��C) \\ RH(%%)_ ");
		for(int i=0; i<rhList.length; i++) System.out.printf("%d\t",rhList[i] = 100 - i*5);
		System.out.printf("\n");
		//������ ���� �迭 rhList �ʱ�ȭ�� ����� ���ÿ� ����
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
	//for���� �̿��� ǳ�Ӱ� ȭ���µ��� ���� ��� ���� �ϴ� ������ ü���µ� ǥ�� ����ϴ� �ż���.
	public static void printWindChillTemperatureTable() {

		int[] tfList = new int[18];
		for(int i=0; i<tfList.length; i++) tfList[i] = 40 - i*5;
		int[] vList = new int[12];
		for(int i=0; i<vList.length;i++) vList[i] = 5 + i*5;
		
		System.out.printf("\n");
		for(int i = 0; i<158; i++) System.out.printf("="); //WindChill Table boundary
		System.out.printf("\nWind(mph)\\T(��F)_");
		for(int k : tfList) System.out.printf("%d\t", k);//for-each��
		System.out.printf("\n");
		for(int i=0; i<vList.length;i++) {
			if(vList[i] == 5) System.out.printf("\n       %d\t",vList[i]);
			else System.out.printf("\n      %d\t",vList[i]);
			for(int k=0; k<tfList.length; k++) System.out.printf("%d\t",Math.round(calculateWindChillTemperature(tfList[k], vList[i])));
		}
		System.out.printf("\n");
		for(int i = 0; i<158; i++) System.out.printf("="); //WindChill Table boundary
	}
	/*���α׷� ���� �� 1�� �Է��� �̽��� �޴��� ������ ��� ����Ǵ� �ż���� 
	���Ŀ� �ʿ��� �����µ��� �������� �Է¹޾� calculate_ �ż���� �����ϰ� ���� �̽����� ����ϴ� �ż���*/
	public static void selectedDewPoint() {
		double inputTC, inputRH; //�Է� ���� �µ��� �������� ������ �Ǽ��� ���� ����.
		double outDewPoint; //�Է¹��� ������ ���� �̽����� ������ �Ǽ��� ���� ����.
		Scanner scanner = new Scanner(System.in); //java.util�� Scanner Ŭ���� ��ü ����.
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.printf("Input 'Temperature'(��C) and 'Realative Humidity' to calculate Dew Point Temperature: "); //�µ�(��C)�� �������� �Է��϶�� �ȳ����� ���.
		inputTC = scanner.nextDouble(); //�Է� ���� ù��° ���� inputT ������ �Ǽ������� �����ϴ� scanner ��ü�� �޼ҵ�.
		inputRH = scanner.nextDouble(); //�Է� ���� �ι�° ���� inputRH ������ �Ǽ������� �����ϴ� scanner ��ü�� �޼ҵ�.
		
		outDewPoint = calculateDewPointTemperature(inputTC, inputRH); //�̽����� ���ϴ� �żҵ忡 ���ڷ� inputTC�� inputRH�� �ְ� ���� �̽����� outDewPoint ������ ����.
		
		System.out.println("Dew Point Temperature : " + Math.round(outDewPoint* 10)/ 10.0); //�ȳ����� ���� �Է¹��� �µ��� �������� ���� �̽����� �ݿø��ؼ� �Ҽ��� ù° �ڸ����� ���.
		printDewPointTemperatureTable();
	}
	/*���α׷� ���� �� 2�� �Է��� ü���µ� �޴��� ������ ��� ����Ǵ� �ż���� 
	���Ŀ� �ʿ��� ȭ���µ��� ǳ�� �Է¹޾� calculate_ �ż���� �����ϰ� ���� ü���µ��� ����ϴ� �ż���*/
	public static void selectedWindChill() {
		double inputTF, inputV; //�Է� ���� �µ��� �ٶ��� �ӵ��� ������ �Ǽ��� ���� ����.
		double outWindChill; //�Է¹��� ������ ���� �����µ��� ������ �Ǽ��� ���� ����.
		Scanner scanner = new Scanner(System.in); //java.util�� Scanner Ŭ���� ��ü ����.
		
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.printf("Input 'Temperature'(��F) and 'Vector of wind' to calculate WInd Chill Temperature: "); //�µ�(��F)�� �ٶ��� �ӵ��� �Է��϶�� �ȳ����� ���.
		inputTF = scanner.nextDouble(); //�Է� ���� ù��° ���� inputTF ������ �Ǽ������� �����ϴ� scanner ��ü�� �޼ҵ�.
		inputV = scanner.nextDouble(); //�Է� ���� �ι�° ���� inputV ������ �Ǽ������� �����ϴ� scanner ��ü�� �޼ҵ�.
		
		outWindChill = calculateWindChillTemperature(inputTF, inputV); //�̽����� ���ϴ� �żҵ忡 ���ڷ� inputTF�� inputV�� �ְ� ���� ü���µ��� outWindChill ������ ����.
		
		System.out.println("Wind Chill Temperature : " + Math.round(outWindChill* 10)/ 10.0); //�Է��� ���� ���� ü���µ��� �ݿø��ؼ� �Ҽ��� ù° �ڸ����� ���.
		printWindChillTemperatureTable();
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
