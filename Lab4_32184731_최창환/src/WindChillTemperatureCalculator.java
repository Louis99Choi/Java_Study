// ü���µ� Table ��� �� ü���µ� ����� ���� �Է�, ü���µ� ����� ����� ���� Ŭ����
public class WindChillTemperatureCalculator extends WeatherCalculator{
	private double temperature; // fahrenheit
	private double windVelocity; // mph

	//��ü ������ �Ķ���͸� ���� ������ default���� 0.0���� �ʱ�ȭ�ϴ� ������
	public WindChillTemperatureCalculator() {
		this(0.0, 0.0);
	}
	
	//��ü ������ �Ķ���ͷ� ��ü�� �ν��Ͻ� ������ �ʱ�ȭ�ϴ� ������
	public WindChillTemperatureCalculator(double temperature, double windVelocity) {
		this.temperature = temperature;
		this.windVelocity = windVelocity;
		this.value = calculate(temperature, windVelocity);
	}
	
	/*
	 * ������ �ν��Ͻ� ������ ���� ��ȯ, �����ϴ� �޼���.
	 */
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
	
	//�Ű������� ���� �µ��� ǳ�� ������ ü���µ��� ����� double������ ��ȯ�ϴ� static �޼���
	// WCT = 35.74 + 0.6215*F - 35.75*V^0.16 + 0.4275*F*V^0.16
	public static double calculate(double F, double V) {
		double value = 35.74 + 0.6215*F - 35.75*Math.pow(V, 0.16) + 0.4275*F*Math.pow(V, 0.16);
		
		return Math.round(value*10)/10.0;
	}

	@Override
	public void calculate() {
		this.value = calculate(temperature, windVelocity);
	}
	
	// ü���µ� ���̺��� ����ϴ� �޼���.
	@Override
	public void printTable() {
		System.out.println("\n{WindChillTemperature_Table}");
		System.out.print("W/F\t40\t35\t30\t25\t20\t15\t10\t5\t0\t-5\t-10\t-15\t-20\t-25\t-30\t-35\t-40\t-45\n");
		
		for (int wind = 5; wind < 65; wind += 5) {
			System.out.print(wind + "\t");
			
			for (int fahrenheit = 40; fahrenheit > - 50; fahrenheit -= 5) {
				double value = calculate(fahrenheit, wind);
				System.out.print(value + "\t");
			}
			
			System.out.print("\n");
		}
	}

	// ü���µ� ����� ���� �µ�(F), ǳ��(mph) ���� User���� �Է� �޴� �޼���.
	@Override
	public void getUserInput() {
		System.out.println("WindChillTemperature");	
		System.out.print("Please enter temperature (F): ");
		setTemperature(UserInput.getDouble());
		
		System.out.print("Please enter wind velocity (mph): ");
		setWindVelocity(UserInput.getDouble());
	}

	@Override
	public String toString() {
		return "WindChillTemperatureCalculator [temperature=" + temperature + "F, windVelocity=" + windVelocity
				+ "mph, value=" + value + "F, index=" + WindChillTemperatureIndex.getIndex(value) + "]";
	}

}
