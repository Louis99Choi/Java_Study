package dto;

import java.util.Objects;

import Enum_Index.DiscomfortIndex;
import controller.UserInput;

// 불쾌지수 Table 출력 및 불쾌지수 계산을 위한 입력, 불쾌지수 결과값 출력을 위한 클래스
public class DiscomfortIndexCalculator extends WeatherCalculator {

	// 객체 생성시 파라미터를 받지 않으며 default값인 0.0으로 초기화하는 생성자
	public DiscomfortIndexCalculator() {
		super(new WeatherData());
	}

	// 객체 생성시 파라미터로 객체의 인스턴스 변수를 초기화하는 생성자
	public DiscomfortIndexCalculator(WeatherData weatherData) {
		super(weatherData);
	}

	/*
	 * 각각의 인스턴스 변수의 값을 반환, 설정하는 메서드.
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

	// 화씨온도를 섭씨온도로 변환하는 static 메서드.
	public static double fromFahrenheitToCelsius(double F) {
		return (F - 32.0) * (5.0 / 9.0);
	}

	// 섭씨온도를 화씨온도로 static 메서드.
	public static double fromCelsiusToFahrenheit(double C) {
		return ((9.0 / 5.0) * C + 32.0);
	}

	// 화씨온도와 상대습도를 입력 받고, 불쾌지수 공식을 이용해 불쾌지수 값을 구해 반환하는 메서드.
	public static double calculate(double F, double RH) {
		// 불쾌지수 계산 공식 DI = T - 0.55*(1 - 0.01*RH)*(T - 14.5) [T: celsius]
		double T = fromFahrenheitToCelsius(F);
		double value = T - 0.55 * (1 - 0.01 * RH) * (T - 14.5);

		value = fromCelsiusToFahrenheit(value);

		return Math.round(value * 10) / 10.0;

	}

	// 멤버 필드 온도와 상대습도로 불쾌지수 계산 매서드.
	@Override
	public void calculate() {
		this.value = calculate(weatherData.getTemperature(), weatherData.getRelativeHumidity());
	}

	// 불쾌지수 테이블 출력 매서드.
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

	// 불쾌지수 계산을 위한 온도(F), 상대습도(%) 사용자 입력 매서드.
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
