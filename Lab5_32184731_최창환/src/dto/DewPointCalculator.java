// Lab5_32184731_��âȯ

package dto;

import java.util.Objects;

import controller.UserInput;

// WeatherCalculator Ŭ������ ��ӹް�
// �̽��� �µ� Table ��� �� �̽��� ����� ���� �Է�, �̽��� ����� ����� ���� Ŭ����
public class DewPointCalculator extends WeatherCalculator {
	
	/* 
	 * ��ü ������ ������ �ν��Ͻ� ������ null�� 0.0���� �ʱ�ȭ�� 
	 * WeatherData Ŭ���� ��ü�� �Ķ���ͷ� �� Ŭ������ �θ� Ŭ������ 
	 * WeatherCalculator Ŭ������ �����ڸ� ȣ���� ��ü �ʱ�ȭ.
	 */
	public DewPointCalculator() {
		super(new WeatherData());
	}

	/*
	 *  WeatherData ��ü�� �Ű������� �޴� �� Ŭ������ 
	 *  �θ� Ŭ������ �����ڸ� ȣ���� �� Ŭ������ ��ü�� �ʱ�ȭ. 
	 */
	public DewPointCalculator(WeatherData weatherData) {
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

	// �Ű������� ���� �µ��� ������ ������ �̽����� ����� double������ ��ȯ�ϴ� static �޼���
	public static double calculate(double F, double RH) {
		double T = fromFahrenheitToCelsius(F);
		double value = (243.12 * (Math.log(RH / 100) + 17.62 * T / (243.12 + T)))
				/ (17.62 - (Math.log(RH / 100) + 17.62 * T / (243.12 + T)));
		value = fromCelsiusToFahrenheit(value);
		return Math.round(value * 10) / 10.0;
	}

	//�θ�Ŭ������ ������ �������̽��� �żҵ带 Overriding.
	@Override
	public void calculate() {
		this.value = calculate(weatherData.getTemperature(), weatherData.getRelativeHumidity());
	}

	//�θ�Ŭ������ ������ �������̽��� �żҵ带 Overriding.
	// �̽��� ���̺��� ����ϴ� �޼��� Override.
	@Override
	public void printTable() {
		int[] humidities = { 100, 95, 90, 85, 80, 75, 70, 65, 60, 55, 50, 45, 40, 35, 30, 25, 20, 15, 10 };
		int[] fahrenheit = { 110, 105, 100, 95, 90, 85, 80, 75, 70, 65, 60, 55, 50, 45, 40, 35, 32 };

		System.out.print("F/RH\t100\t95\t90\t85\t80\t75\t70\t65\t60\t55\t50\t45\t40\t35\t30\t25\t20\t15\t10\n");

		for (int i = 0; i < fahrenheit.length; i++) {
			System.out.print(fahrenheit[i] + "\t");

			for (int j = 0; j < humidities.length; j++) {
				double dpt = calculate(fahrenheit[i], humidities[j]);

				if (dpt >= 32)
					System.out.print(dpt + "\t");
				else
					System.out.print("\t\t");
			}

			System.out.print("\n");
		}

	}

	//�θ�Ŭ������ ������ �������̽��� �żҵ带 Overriding.
	// �̽��� ����� ���� �µ�(F), ������(%) ���� User���� �Է� �޴� �޼���.
	@Override
	public void getUserInput() {
		System.out.println("\n[Calculate DewPoint]");
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
		if (other instanceof DewPointCalculator) {
			DewPointCalculator that = (DewPointCalculator) other;
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
		return "DewPointCalculator [temperature=" + getTemperature() + ", relativeHumidity=" + getRelativeHumidity() + ", value="
				+ value + "]";
	}
}
