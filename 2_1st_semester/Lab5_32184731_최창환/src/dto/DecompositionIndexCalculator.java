// Lab5_32184731_��âȯ

package dto;

import java.util.Objects;

import Enum_Index.DecompositionIndex;
import controller.UserInput;

// WeatherCalculator Ŭ������ ��ӹް�
// ����(���ߵ�)���� Table ��� �� ����(���ߵ�)���� ����� ���� �Է�, ����(���ߵ�)���� ����� ����� ���� Ŭ����
public class DecompositionIndexCalculator extends WeatherCalculator {

	/* 
	 * ��ü ������ ������ �ν��Ͻ� ������ null�� 0.0���� �ʱ�ȭ�� 
	 * WeatherData Ŭ���� ��ü�� �Ķ���ͷ� �� Ŭ������ �θ� Ŭ������ 
	 * WeatherCalculator Ŭ������ �����ڸ� ȣ���� ��ü �ʱ�ȭ.
	 */
	public DecompositionIndexCalculator() {
		super(new WeatherData());
	}

	/*
	 *  WeatherData ��ü�� �Ű������� �޴� �� Ŭ������ 
	 *  �θ� Ŭ������ �����ڸ� ȣ���� �� Ŭ������ ��ü�� �ʱ�ȭ. 
	 */
	public DecompositionIndexCalculator(WeatherData weatherData) {
		super(weatherData);
	}

	/*
	 * ������ �ν��Ͻ� ������ ���� ��ȯ, �����ϴ� �޼���.
	 */
	public double getTemperature() {
		return weatherData.getTemperature();
	}

	public void setTemperature(double temperature) {
		this.weatherData.setTemperature(temperature);
	}

	public double getRelativeHumidity() {
		return weatherData.getRelativeHumidity();
	}

	public void setRelativeHumidity(double relativeHumidity) {
		this.weatherData.setRelativeHumidity(relativeHumidity);
	}

	public double getValue() {
		return value;
	}

	// ȭ���µ��� �������� �Է� �ް�, ����(���ߵ�)���� ������ �̿��� ����(���ߵ�)���� ���� ���� ��ȯ�ϴ� �޼���.
	public static double calculate(double F, double RH) {
		// ����(���ߵ�)���� ��� ���� DI = ((RH - 65) / 14) * (1.054)^T [T: celsius]
		double T = fromFahrenheitToCelsius(F);

		if (T <= 0 || RH < 65.0)
			return 0.0; // ����� �����̰ų� ������ 65% ���� �̸� ���������� 0�� ����.

		else {
			double value = ((RH - 65) / 14) * Math.pow(1.054, T);

			return Math.round(value * 10) / 10.0;
		}

	}

	// �θ�Ŭ������ ������ �������̽��� �żҵ带 Overriding.
	// ��� �ʵ� �µ��� �������� ����(���ߵ�)���� ��� �ż���.
	@Override
	public void calculate() {
		this.value = calculate(weatherData.getTemperature(), weatherData.getRelativeHumidity());
	}

	// �θ�Ŭ������ ������ �������̽��� �żҵ带 Overriding.
	// ����(���ߵ�)���� ���̺� ��� �ż���.
	@Override
	public void printTable() {
		int[] fahrenheit = { 68, 71, 74, 77, 80, 83, 86, 89, 92, 95, 98, 101, 104, 107, 110 };
		int[] humidities = { 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 100 };

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

	// �θ�Ŭ������ ������ �������̽��� �żҵ带 Overriding.
	// ����(���ߵ�)���� ����� ���� �µ�(F), ������(%) ����� �Է� �ż���.
	@Override
	public void getUserInput() {
		System.out.println("\n[Calculate DiscomfortIndex]");
		System.out.print("Please enter temperature (F): ");
		setTemperature(UserInput.getDouble());

		System.out.print("Please enter relative humidity (%): ");
		setRelativeHumidity(UserInput.getDouble());
	}

	// Object.equals overriding
	@Override
	public boolean equals(Object other) { 
		if (this == other)
			return true;
		if (other instanceof DecompositionIndexCalculator) {
			DecompositionIndexCalculator that = (DecompositionIndexCalculator) other;
			return (this.getTemperature() == that.getTemperature())
					&& (this.getRelativeHumidity() == that.getRelativeHumidity())
					&& (this.getValue() == that.getValue());
		}
		return false;
	}

	// Object.hashCode overriding
	@Override
	public int hashCode() { 
		return Objects.hash(weatherData.getTemperature(), weatherData.getRelativeHumidity(), getValue());
	}

	@Override
	public String toString() {
		return "DecompositionIndexCalculator [temperature=" + getTemperature() + "F, relativeHumidity="
				+ weatherData.getRelativeHumidity() + "%, value=" + value + ", index="
				+ DecompositionIndex.getIndex(value) + "]";
	}

}
