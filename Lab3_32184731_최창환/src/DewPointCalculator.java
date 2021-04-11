
public class DewPointCalculator {
	private double temperature; //F
	private double relativeHumidity; //%
	private double value; //DP
	
	public DewPointCalculator(double temperature, double relativeHumidity, double value) {
		super();
		this.temperature = temperature;
		this.relativeHumidity = relativeHumidity;
		this.value = value;
	}
	
	public DewPointCalculator() {
		this(0.0, 0.0, 0.0);
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getRelativeHumidity() {
		return relativeHumidity;
	}
	public void setRelativeHumidity(double relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "DewPointCalculator [temperature=" + temperature + "F, relativeHumidity=" + relativeHumidity + "%, value="
				+ value + "F]";
	}
	
	public static double calculate(double F, double RH) {
		//�̽��� ����
		double k = (17.62 * UserInput.convertFtoC(F)) / (243.12 + UserInput.convertFtoC(F));
		
		double DewPointC = (243.12 * (Math.log(RH / 100) + k)) / (17.62 - (Math.log(RH / 100) + k));
		double DewPointF = UserInput.convertCtoF(DewPointC);
		
		return Math.round(DewPointF*10) / 10;
	}

	public void calculate() {
		value = calculate(temperature, relativeHumidity);
	}
	
	public static void printTable() {
		//�̽��� ���̺� ��� - ��ø for

		int[] rhList = new int[19];
		int[] tfList = new int[17];
		
		for (int i = 0; i < 100; i++)
			System.out.printf("="); // Dew Point Table boundary
		
		System.out.print("\nT(��F) \\ RH(%%)_");
		for (int i = 0; i < rhList.length; i++) {
			System.out.printf("%4d", rhList[i] = 100 - i*5);
		}
		System.out.println("");
		
		for(int i = 0; i<tfList.length; i++) {
			
			if(i == 16) System.out.printf("%7d        ", tfList[i] = 32);
			else System.out.printf("%7d        ", tfList[i] = 110 - i*5);
			
			for(int k = 0; k<rhList.length; k++) {
				if((int)Math.round(calculate(tfList[i], rhList[k])) >= 32)
					System.out.printf("%4d", (int)Math.round(calculate(tfList[i], rhList[k])) );
			}
			
			System.out.println("");	
		}
		
		for (int i = 0; i < 100; i++)
			System.out.printf("="); // Dew Point Table boundary
	}
	
	public void getUserInput() {
		//�̽��� ����� ���� �µ�(F), ������(%) ����� �Է�
		System.out.println("\nDewPointCalculater �Դϴ�. ");
		System.out.print("temperature(F) �Է� :");
		temperature = UserInput.getDouble();
		
		System.out.print("relativeHumidity(%) �Է� :");
		relativeHumidity = UserInput.getDouble();
	}
	
}
