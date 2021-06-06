package dto;

import java.util.Objects;

import Enum_Index.DiscomfortIndex;
import controller.UserInput;

// �������� Table ��� �� �������� ����� ���� �Է�, �������� ����� ����� ���� Ŭ����
public class DiscomfortIndexCalculator extends WeatherCalculator {

	// ��ü ������ �Ķ���͸� ���� ������ default���� 0.0���� �ʱ�ȭ�ϴ� ������
	public DiscomfortIndexCalculator() {
		super(new WeatherData());
	}

	// ��ü ������ �Ķ���ͷ� ��ü�� �ν��Ͻ� ������ �ʱ�ȭ�ϴ� ������
	public DiscomfortIndexCalculator(WeatherData weatherData) {
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

	// ȭ���µ��� �����µ��� ��ȯ�ϴ� static �޼���.
	public static double fromFahrenheitToCelsius(double F) {
		return (F - 32.0) * (5.0 / 9.0);
	}

	// �����µ��� ȭ���µ��� static �޼���.
	public static double fromCelsiusToFahrenheit(double C) {
		return ((9.0 / 5.0) * C + 32.0);
	}

	// ȭ���µ��� �������� �Է� �ް�, �������� ������ �̿��� �������� ���� ���� ��ȯ�ϴ� �޼���.
	public static double calculate(double F, double RH) {
		// �������� ��� ���� DI = T - 0.55*(1 - 0.01*RH)*(T - 14.5) [T: celsius]
		double T = fromFahrenheitToCelsius(F);
		double value = T - 0.55 * (1 - 0.01 * RH) * (T - 14.5);

		value = fromCelsiusToFahrenheit(value);

		return Math.round(value * 10) / 10.0;

	}

	// ��� �ʵ� �µ��� �������� �������� ��� �ż���.
	@Override
	public void calculate() {
		this.value = calculate(weatherData.getTemperature(), weatherData.getRelativeHumidity());
	}

	// �������� ���̺� ��� �ż���.
	@Override
	public void printTable() {
		int[] fahrenheit = { 68, 71, 74, 77, 80, 83, 86, 89, 92, 95, 98, 101, 104, 107, 110 };
		int[] humidities = { 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100 };

		System.out.println("\n{DiscomfortIndex_Table}");
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

	// �������� ����� ���� �µ�(F), ������(%) ����� �Է� �ż���.
	@Override
	public void getUserInput() {
		System.out.println("\n[Calculate DiscomfortIndex]");
		System.out.print("Please enter temperature (F): ");
		setTemperature(UserInput.getDouble());

		System.out.print("Please enter relative humidity (%): ");
		setRelativeHumidity(UserInput.getDouble());
	}

	@Override
	public boolean equals(Object other) { // Object.equals overriding
		if (this == other)
			return true;
		if (other instanceof DiscomfortIndexCalculator) {
			DiscomfortIndexCalculator that = (DiscomfortIndexCalculator) other;
			return (this.getTemperature() == that.getTemperature())
					&& (this.getRelativeHumidity() == that.getRelativeHumidity())
					&& (this.getValue() == that.getValue());
		}
		return false;
	}

	@Override
	public int hashCode() { // Object.hashCode overriding
		return Objects.hash(weatherData.getTemperature(), weatherData.getRelativeHumidity(), getValue());
	}

	@Override
	public String toString() {
		return "DiscomfortIndexCalculator [temperature=" + getTemperature() + "F, relativeHumidity=" + getRelativeHumidity()
				+ "%, value=" + value + ", index=" + DiscomfortIndex.getIndex(value) + "]";
	}

}
