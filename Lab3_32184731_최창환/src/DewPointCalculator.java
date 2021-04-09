
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
		return "DewPointCalculator [temperature=" + temperature + ", relativeHumidity=" + relativeHumidity + ", value="
				+ value + "]";
	}
	
	
	public static double calculate(double F, double RH) {
		//�̽��� ����
		return 0.0;
	}

	public void calculate() {
		value = calculate(temperature, relativeHumidity);
	}
	
	public static void printTable() {
		//�̽��� ���̺� ��� - ��ø for
		
	}
	
	public void getUserInput() {
		//�̽��� ����� ���� �µ�(F), ������(%) ����� �Է�
		System.out.println("DewPointCalculater �Դϴ�. ");
		System.out.print("temperature(F) �Է� :");
		//temperature = UserInput.getDouble();
	}
	
}
