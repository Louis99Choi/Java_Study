
public class HeatIndexCalculator {
	private double temperature; // fahrenheit
	private double relativeHumidity; // %
	private double value; // HeatIndex ��
	
	public HeatIndexCalculator(double temperature, double relativeHumidity, double value) {
		this.temperature = temperature;
		this.relativeHumidity = relativeHumidity;
		this.value = value;
	}
	public HeatIndexCalculator() {
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
		return "HeatIndexCalculator [temperature=" + temperature + ", relativeHumidity=" + relativeHumidity + ", value="
				+ value + "]";
	}
	
	public static double calculate(double F, double RH) {
		// ü���µ� ����
		return 0.0; //!!!!!!
	}
	
	public void calculate() {
		value = calculate(temperature, relativeHumidity);
	}
	
	public static void printTable() {
		// ������ ���̺� ��� - ��ø for
		
	}
	
	public void getUserInput() {
		// ������ ����� ���� �µ�(F), ������(%) ����� �Է�
		System.out.println("HeatIndexCalculator �Դϴ�. ");
		System.out.print("temperature(F) �Է� :");
		temperature = UserInput.getDouble();
		
		System.out.print("relativeHumidity(%) �Է� :");
		relativeHumidity = UserInput.getDouble();
	}
	
}
