// ������ Table ��� �� ������ ����� ���� �Է�, ������ ����� ����� ���� Ŭ����
public class HeatIndexCalculator extends WeatherCalculator{
	private double temperature; // fahrenheit
	private double relativeHumidity; // %

	// ��ü ������ �Ķ���͸� ���� ������ default���� 0.0���� �ʱ�ȭ�ϴ� ������
	public HeatIndexCalculator() {
		this(0.0, 0.0);
	}
	
	// ��ü ������ �Ķ���ͷ� ��ü�� �ν��Ͻ� ������ �ʱ�ȭ�ϴ� ������
	public HeatIndexCalculator(double temperature, double relativeHumidity) {
		this.temperature = temperature;
		this.relativeHumidity = relativeHumidity;
		this.value = calculate(temperature, relativeHumidity);
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

	public double getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(double relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	public double getValue() {
		return value;
	}

	// ȭ���µ��� �������� �Է� �ް�, ������ ������ �̿��� ������ ���� ���� ��ȯ�ϴ� �޼���.
	public static double calculate(double F, double RH) {
		if (F < 80.0) return 0.0;
		
		double value = -42.379 + (2.04901523*F) + (10.14333127*RH) - (0.22475541*F*RH) - (0.00683770*F*F) - 
				(0.05481717*RH*RH) + (0.00122874*F*F*RH) + (0.00085282*F*RH*RH) - (0.00000199*F*F*RH*RH);	
		
		return Math.round(value*10)/10.0;
	}

	@Override
	public void calculate() {
		this.value = calculate(temperature, relativeHumidity);
	}
	
	// ������ ���̺��� ����ϴ� �޼���.
	@Override
	public void printTable() {
		int[] fahrenheit = {80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 100, 102, 104, 106, 108, 110};
		int[] humidities = {40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100};
		
		System.out.println("\n{HeatIndex_Table}");
		System.out.print("RH/F\t80\t82\t84\t86\t88\t90\t92\t94\t96\t98\t100\t102\t104\t106\t108\t110\n");
		
		for (int i = 0; i < humidities.length; i++) {
			System.out.print(humidities[i] + "\t");
			
			for (int j = 0; j < fahrenheit.length; j++) {
				double value = calculate(fahrenheit[j], humidities[i]);
				
				if (value < 137) System.out.print(value + "\t");
				else System.out.print("\t\t");
			}
			
			System.out.print("\n");
		}
	}

	// ������ ����� ���� �µ�(F), ������(%) ���� User���� �Է� �޴� �޼���.
	@Override
	public void getUserInput() {
		System.out.println("HeatIndex");
		System.out.print("Please enter temperature (F): ");
		setTemperature(UserInput.getDouble());
		
		System.out.print("Please enter relative humidity (%): ");
		setRelativeHumidity(UserInput.getDouble());	
	}

	@Override
	public String toString() {
		return "HeatIndexCalculator [temperature=" + temperature + "F, relativeHumidity=" + relativeHumidity 
				+ "%, value=" + value + "F, index=" + HeatIndex.getIndex(value) + "]";
	}

}

	
