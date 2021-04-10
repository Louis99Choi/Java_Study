
public class WindChillTemperatureCalculator {
	private double temperature; // F
	private double windVelocity; // mph
	private double value; // WindChillTemperature ��
	
	public WindChillTemperatureCalculator(double temperature, double windVelocity, double value) {
		this.temperature = temperature;
		this.windVelocity = windVelocity;
		this.value = value;
	}
	public WindChillTemperatureCalculator() {
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
		return "WindChillTemperatureCalculator [temperature=" + temperature + ", windVelocity=" + windVelocity
				+ ", value=" + value + "]";
	}
	
	public static double calculate(double F, double V) {
		// ü���µ� ����
		return 0.0; //!!!!!!
	}
	
	public void calculate() {
		value = calculate(temperature, windVelocity);
	}
	
	public static void printTable() {
		// ü���µ� ���̺� ��� - ��ø for
		
	}
	
	public void getUserInput() {
		// ü���µ� ����� ���� �µ�(F), ǳ��(mph) ����� �Է�
		System.out.println("WindChillTemperatureCalculater �Դϴ�. ");
		System.out.print("temperature(F) �Է� :");
		temperature = UserInput.getDouble();
		
		System.out.print("windVelocity(mph) �Է� :");
		windVelocity = UserInput.getDouble();
	}
}
