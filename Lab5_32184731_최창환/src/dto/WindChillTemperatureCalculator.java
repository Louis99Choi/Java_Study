// Lab5_32184731_��âȯ

package dto;

import java.util.Objects;

import Enum_Index.WindChillTemperatureIndex;
import controller.UserInput;

//WeatherCalculator Ŭ������ ��ӹް�
// ü���µ� Table ��� �� ü���µ� ����� ���� �Է�, ü���µ� ����� ����� ���� Ŭ����
public class WindChillTemperatureCalculator extends WeatherCalculator {

	/* 
	 * ��ü ������ ������ �ν��Ͻ� ������ null�� 0.0���� �ʱ�ȭ�� WeatherData Ŭ���� ��ü�� 
	 * �Ķ���ͷ� �� Ŭ������ �θ� Ŭ������ WeatherCalculator Ŭ������ �����ڸ� ȣ���� ��ü �ʱ�ȭ.
	 */
	public WindChillTemperatureCalculator() {
		super(new WeatherData());
	}

	/*
	 *  WeatherData ��ü�� �Ű������� �޴� �� Ŭ������ 
	 *  �θ� Ŭ������ �����ڸ� ȣ���� �� Ŭ������ ��ü�� �ʱ�ȭ. 
	 */
	public WindChillTemperatureCalculator(WeatherData weatherData) {
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

	public double getWindVelocity() {
		return weatherData.getWindVelocity();
	}

	public void setWindVelocity(double windVelocity) {
		this.weatherData.setWindVelocity(windVelocity);
	}

	public double getValue() {
		return value;
	}

	// �Ű������� ���� �µ��� ǳ�� ������ ü���µ��� ����� double������ ��ȯ�ϴ� static �޼���
	// WCT = 35.74 + 0.6215*F - 35.75*V^0.16 + 0.4275*F*V^0.16
	public static double calculate(double F, double V) {
		double value = 35.74 + 0.6215 * F - 35.75 * Math.pow(V, 0.16) + 0.4275 * F * Math.pow(V, 0.16);

		return Math.round(value * 10) / 10.0;
	}

	//�θ�Ŭ������ ������ �������̽��� �żҵ带 Overriding.
	@Override
	public void calculate() {
		this.value = calculate(weatherData.getTemperature(), weatherData.getWindVelocity());
	}

	//�θ�Ŭ������ ������ �������̽��� �żҵ带 Overriding.
	// ü���µ� ���̺��� ����ϴ� �޼���.
	@Override
	public void printTable() {
		System.out.println("\n{WindChillTemperature_Table}");
		System.out.print("W/F\t40\t35\t30\t25\t20\t15\t10\t5\t0\t-5\t-10\t-15\t-20\t-25\t-30\t-35\t-40\t-45\n");

		for (int wind = 5; wind < 65; wind += 5) {
			System.out.print(wind + "\t");

			for (int fahrenheit = 40; fahrenheit > -50; fahrenheit -= 5) {
				double value = calculate(fahrenheit, wind);
				System.out.print(value + "\t");
			}

			System.out.print("\n");
		}
	}

	//�θ�Ŭ������ ������ �������̽��� �żҵ带 Overriding.
	// ü���µ� ����� ���� �µ�(F), ǳ��(mph) ���� User���� �Է� �޴� �޼���.
	@Override
	public void getUserInput() {
		System.out.println("\n[Calculate WindChillTemperature]");
		System.out.print("Please enter temperature (F): ");
		setTemperature(UserInput.getDouble());

		System.out.print("Please enter wind velocity (mph): ");
		setWindVelocity(UserInput.getDouble());
	}

	// Object.equals overriding
	@Override
	public boolean equals(Object other) { 
		if (this == other)
			return true;
		if (other instanceof WindChillTemperatureCalculator) {
			WindChillTemperatureCalculator that = (WindChillTemperatureCalculator) other;
			return this.getTemperature() == that.getTemperature()
					&& this.getWindVelocity() == that.getWindVelocity()
					&& this.getValue() == that.getValue();
		}
		return false;
	}

	// Object.hashCode overriding
	@Override
	public int hashCode() { 
		return Objects.hash(weatherData.getTemperature(), weatherData.getWindVelocity(), getValue());
	}

	@Override
	public String toString() {
		return "WindChillTemperatureCalculator [temperature=" + getTemperature() + "F, windVelocity=" + getWindVelocity()
				+ "mph, value=" + value + "F, index=" + WindChillTemperatureIndex.getIndex(value) + "]";
	}

}
