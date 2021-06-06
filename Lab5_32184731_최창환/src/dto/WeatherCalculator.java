package dto;

// �߻� Ŭ������ ��� ���� Ŭ�������� ���� ���� value�� process �ż��带 �ν��Ͻ��� ����,
// �߻� �ż���� ����ǥ ���, ����� �Է�, ������ ��� �ż��带 ������ 
// ������ ������ ��� Ŭ�������� �θ� Ŭ�����̴�.
public abstract class WeatherCalculator implements IWeatherCalculator {
	protected WeatherData weatherData;
	protected double value;

	protected WeatherCalculator(WeatherData weatherData) {
		this.weatherData = weatherData;
		calculate(); //
	}

	// �ڽ� Ŭ������ ���� ǥ�� ����ϰ�
	// ������� �Է��� �޾� �� �������� ����ϰ� ����ϴ� �ż���
	public final void process() {
		printTable();
		getUserInput();
		calculate();
		System.out.println(this);
	}

	// ȭ���µ��� �����µ��� ��ȯ�ϴ� static �޼���.
	public static double fromFahrenheitToCelsius(double F) {
		return (F - 32.0) * (5.0 / 9.0);
	}

	// �����µ��� ȭ���µ��� static �޼���.
	public static double fromCelsiusToFahrenheit(double C) {
		return ((9.0 / 5.0) * C + 32.0);
	}
}
