import java.util.*;

public class OutDewPoint {

	public static void main(String[] args) {
		double inputT, inputRH; //�Է� ���� �µ��� �������� ������ �Ǽ��� ���� ����.
		double cmdDewPoint, scanDewPoint; //args[]�� �Է¹��� �µ� �� �������� ���� �̽����� ���� ���� ������ �Ǽ��� ���� ����.
		Scanner scanner = new Scanner(System.in); //Scanner ��ü ����.
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.printf("Input 'Temperature'(��C) and 'Realative Humidity' for calculate Dew Point : ");
		//�µ�(��C)�� �������� �Է��϶�� �ȳ���.
		inputT = scanner.nextDouble(); //�Է� ���� ù��° �Ǽ��� inputT ������ ����.
		inputRH = scanner.nextDouble(); //�Է� ���� �ι�° �Ǽ��� inputRH ������ ����.
		
		scanDewPoint = calculateDewPoint(inputT, inputRH); //�̽����� ���ϴ� �ż��忡 ���ڷ� inputT�� inputRH�� �ְ� ���� �̽����� scanDewPoint ������ ����.
		
		if(args.length == 2) //���� args[] �迭�� �µ�, ���� 2���� ���� �Է��� �迭�� ���̰� 2��� �̽����� ���ϰ� �̽����� ����ϴ� ���ǹ�.
		{
			cmdDewPoint = calculateDewPoint(Double.parseDouble(args[0]), Double.parseDouble(args[1])); //�̽����� ���ϴ� �ż��忡 args[]�� ���� ���� Double������ ��ȯ�Ͽ� ���ڷ� �ְ� ���� �̽����� cmdDewPoint�� ����.
			System.out.printf("\nDew Point through args[] : %d \n", Math.round(cmdDewPoint)); //args[]�� ���� ���� ���� ���� �̽����� �Ҽ��� ù°�ڸ����� �ݿø��ؼ� ���.
		}
		
		System.out.printf("\nDew Point through your 'Input' : %d \n\n", Math.round(scanDewPoint)); //�ȳ����� ���� �Է¹��� �µ��� �������� ���� �̽����� ���
	}
	
	public static double calculateDewPoint(double T, double RH) //���� �µ��� �������� ��Ÿ���� �Ǽ��� ���� 2���� ���ڷ� �޾� �̽����� ���ϰ� �Ǽ��� ���� ��ȯ�ϴ� �Լ�.
	{
		double k = (17.62 * T)/ (243.12 + T); //�̽����� ���ϴ� ���Ŀ��� �ݺ��Ǵ� �κ��� �Ǽ��� ������ ����.
		double DewPoint = (243.12 * (Math.log(RH /100) + k))/ 
				(17.62 - (Math.log(RH/100) + k)); //�̽����� ���ϴ� �������� ���� ���� �Ǽ��� ������ ����.
		
		return DewPoint; //������ ���� ���� �̽����� �Ǽ������� ��ȯ
	}

}
