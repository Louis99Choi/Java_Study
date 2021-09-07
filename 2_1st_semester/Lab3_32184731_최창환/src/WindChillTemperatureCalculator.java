
public class WindChillTemperatureCalculator {
	private double temperature; // F
	private double windVelocity; // mph
	private double value; // WindChillTemperature ��
	
	public WindChillTemperatureCalculator(double temperature, double windVelocity, double value) {
		//��ü ������ �Ķ���ͷ� ��ü�� �ν��Ͻ� ������ �ʱ�ȭ�ϴ� ������
		this.temperature = temperature;
		this.windVelocity = windVelocity;
		this.value = value;
	}
	public WindChillTemperatureCalculator() {
		//��ü ������ �Ķ���͸� ���� ������ default���� 0.0���� �ʱ�ȭ�ϴ� ������
		this(0.0, 0.0, 0.0);
	}

	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getWindVelocity() {
		return windVelocity;
	}
	public void setWindVelocity(double windVelocity) {
		this.windVelocity = windVelocity;
	}

	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "WindChillTemperatureCalculator [temperature=" + temperature + "F, windVelocity=" + windVelocity
				+ "mph, value=" + value + "F]";
	}
	
	public static double calculate(double F, double V) {
		//�Ű������� ���� �µ��� ǳ�� ������ ü���µ��� ����� double������ ��ȯ�ϴ� static �޼���
		double WindChill = 35.74 + 0.6125 * F + (0.4275 * F - 35.75) * Math.pow(V, 0.16);
		
		return Math.round(WindChill * 10) /10;
	}
	
	public void calculate() {
		//�ν��Ͻ� ���� �µ���, ǳ������ ����� ü���µ� ������ value ���� �ʱ�ȭ�ϴ� �ν��Ͻ� �޼���.
		value = calculate(temperature, windVelocity);
	}
	
	public static void printTable() {
		// ü���µ� ���̺��� ����ϴ� static �޼���.
		
		int[] tfList = new int[18];
		int[] vList = new int[12];
		
		for (int i = 0; i < 100; i++)
			System.out.printf("="); // Wind Chill Table boundary
		
		System.out.print("\nWind(mph)\\ T(��F)_");
		for (int i = 0; i < tfList.length; i++) {
			System.out.printf("%4d", tfList[i] = 40 - i*5);
		}
		System.out.println("");
		
		for(int i = 0; i<vList.length; i++) {
			System.out.printf("%10d       ", vList[i] = 5 + i*5);
			
			for(int k = 0; k<tfList.length; k++)
				System.out.printf("%4d", (int)Math.round(calculate(tfList[k], vList[i])) );
			
			System.out.println("");	
		}
		
		for (int i = 0; i < 100; i++)
			System.out.printf("="); // Wind Chill Table boundary
		
	}
	
	public void getUserInput() {
		// ü���µ� ����� ���� �µ�(F), ǳ��(mph) ���� User���� �Է� �޴� �޼���.
		System.out.println("\nWindChillTemperatureCalculater �Դϴ�. ");
		System.out.print("temperature(F) �Է� :");
		temperature = UserInput.getDouble();
		
		System.out.print("windVelocity(mph) �Է� :");
		windVelocity = UserInput.getDouble();
	}
}
