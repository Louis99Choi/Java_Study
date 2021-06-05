package dto;

import Enum_Index.DecompositionIndex;
import controller.UserInput;

// ����(���ߵ�)���� Table ��� �� ����(���ߵ�)���� ����� ���� �Է�, ����(���ߵ�)���� ����� ����� ���� Ŭ����
public class DecompositionIndexCalculator extends WeatherCalculator {
	
	private double temperature; // fahrenheit
	private double relativeHumidity; // %
	
	//��ü ������ �Ķ���͸� ���� ������ default���� 0.0���� �ʱ�ȭ�ϴ� ������
	public DecompositionIndexCalculator() {
		this(0.0, 0.0);
	}
	
	//��ü ������ �Ķ���ͷ� ��ü�� �ν��Ͻ� ������ �ʱ�ȭ�ϴ� ������
	public DecompositionIndexCalculator(double temperature, double relativeHumidity) {
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

	// ȭ���µ��� �����µ��� ��ȯ�ϴ� static �޼���.
	public static double fromFahrenheitToCelsius(double F) {
		return (F - 32.0) * (5.0 / 9.0);
	}

	// �����µ��� ȭ���µ��� static �޼���.
	public static double fromCelsiusToFahrenheit(double C) {
		return ((9.0 / 5.0) * C + 32.0);
	}

	// ȭ���µ��� �������� �Է� �ް�, ����(���ߵ�)���� ������ �̿��� ����(���ߵ�)���� ���� ���� ��ȯ�ϴ� �޼���.
	public static double calculate(double F, double RH) {
		// ����(���ߵ�)���� ��� ���� DI = ((RH - 65) / 14) * (1.054)^T [T: celsius]
		double T = fromFahrenheitToCelsius(F);
		
		if(T <= 0 || RH < 65.0) return 0.0; // ����� �����̰ų� ������ 65% ���� �̸� ���������� 0�� ����.
		
		else {
			double value = ((RH - 65) / 14) * Math.pow(1.054, T);
			
			return Math.round(value*10)/10.0;
		}
		
	}
		
	// ��� �ʵ� �µ��� �������� ����(���ߵ�)���� ��� �ż���.
	@Override
	protected void calculate() {
		this.value = calculate(temperature, relativeHumidity);
	}
	
	// ����(���ߵ�)���� ���̺� ��� �ż���.
	@Override
	protected void printTable() {
		int[] fahrenheit = {68, 71, 74, 77, 80, 83, 86, 89, 92, 95, 98, 101, 104, 107, 110};
		int[] humidities = {66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 100};

		System.out.println("\n{DecompositionIndex_Table}");
		System.out.print("RH/F\t68\t71\t74\t77\t80\t83\t86\t89\t92\t95\t98\t101\t104\t107\t110\n");
		
		for (int i = 0; i < humidities.length; i++) {
			System.out.print(humidities[i] + "\t");
			
			for (int j = 0; j < fahrenheit.length; j++) {
				double value = calculate(fahrenheit[j], humidities[i]);
				System.out.print(value + "\t");
			}
			
			System.out.print("\n");
		}
		
	}

	// ����(���ߵ�)���� ����� ���� �µ�(F), ������(%) ����� �Է� �ż���.
	@Override
	protected void getUserInput() {
		System.out.println("\n[Calculate DiscomfortIndex]");
		System.out.print("Please enter temperature (F): ");
		setTemperature(UserInput.getDouble());
		
		System.out.print("Please enter relative humidity (%): ");
		setRelativeHumidity(UserInput.getDouble());
	}

	@Override
	public String toString() {
		return "DecompositionIndexCalculator [temperature=" + temperature + "F, relativeHumidity=" + relativeHumidity
				+ "%, value=" + value + ", index=" + DecompositionIndex.getIndex(value) + "]";
	}
	
}
