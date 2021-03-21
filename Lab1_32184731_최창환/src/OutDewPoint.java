import java.util.*; //Scanner Ŭ������ ����ϱ� ���� Scanner Ŭ������ �����ϴ� ���̺귯���� import.

//Lab1_32184731_��âȯ
//cmd_Line args[](����� ����)���� �ִٸ� �� ���� �̿��� ���� �̽����� ���α׷� ����� �Է¹��� ������ ���� �̽����� ���� ����ϴ� class
public class OutDewPoint {

	public static void main(String[] args) {
		double inputT, inputRH; //�Է� ���� �µ��� �������� ������ �Ǽ��� ���� ����.
		double cmdDewPoint, scanDewPoint; //cmd_Line args[](����� ����)�� ������ ���� �̽����� �Է¹��� ������ ���� �̽����� ���� ���� ������ �Ǽ��� ���� ����.
		Scanner scanner = new Scanner(System.in); //java.util�� Scanner Ŭ���� ��ü ����.
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.printf("Input 'Temperature'(��C) and 'Realative Humidity' for calculate Dew Point : "); //�µ�(��C)�� �������� �Է��϶�� �ȳ����� ���.
		inputT = scanner.nextDouble(); //�Է� ���� ù��° ���� inputT ������ �Ǽ������� �����ϴ� scanner ��ü�� �޼ҵ�.
		inputRH = scanner.nextDouble(); //�Է� ���� �ι�° ���� inputRH ������ �Ǽ������� �����ϴ� scanner ��ü�� �޼ҵ�.
		
		scanDewPoint = calculateDewPoint(inputT, inputRH); //�̽����� ���ϴ� �żҵ忡 ���ڷ� inputT�� inputRH�� �ְ� ���� �̽����� scanDewPoint ������ ����.
		System.out.println("----------------------------------------------------------------------------");

		if(args.length == 2) //���� cmd_Line args[](���������)�� �µ�, ���� ������ �ʱ�ȭ�Ǿ� �迭�� ũ�Ⱑ 2��� �� ����� ���� �̽��� ���� ����ϴ� ���ǹ�.
		{
			cmdDewPoint = calculateDewPoint(Double.parseDouble(args[0]), Double.parseDouble(args[1])); //�̽����� ���ϴ� �ż��忡 ���ڿ��� ��������� ���� Double������ ��ȯ�Ͽ� ���ڷ� �ְ� ���� �̽����� cmdDewPoint�� ����.
			System.out.println("Dew Point through cmd_Line args[] : " + Math.round(cmdDewPoint* 10)/ 10.0); //��������ڸ� �̿��� ���� �̽����� �Ҽ��� ù°�ڸ����� �ݿø��ؼ� ���.
		}
		
		System.out.println("Dew Point through your 'Input' : " + Math.round(scanDewPoint* 10)/ 10.0); //�ȳ����� ���� �Է¹��� �µ��� �������� ���� �̽����� �ݿø��ؼ� �Ҽ��� ù° �ڸ����� ���.
		System.out.println("----------------------------------------------------------------------------");
	}
	
	public static double calculateDewPoint(double T, double RH) //���� �µ��� �������� ��Ÿ���� �Ǽ��� ���� 2���� ���ڷ� �޾� �̽����� ���ϰ� �Ǽ������� ��ȯ�ϴ� �Լ�.
	{
		double k = (17.62 * T)/ (243.12 + T); //�̽����� ���ϴ� ���Ŀ��� �ݺ��Ǵ� �κ��� �Ǽ��� ������ ����.
		double DewPoint = (243.12 * (Math.log(RH /100) + k))/ 
				(17.62 - (Math.log(RH/100) + k)); //�̽����� ���ϴ� �������� ���� ���� �Ǽ��� ���� DewPoint�� ����.
		
		return DewPoint; //������ ���� ���� �̽����� �Ǽ������� ��ȯ
	}

}
