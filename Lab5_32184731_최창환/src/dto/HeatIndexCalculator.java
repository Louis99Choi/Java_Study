package dto;

import java.util.Objects;

import Enum_Index.HeatIndex;
import controller.UserInput;

// 열지수 Table 출력 및 열지수 계산을 위한 입력, 열지수 결과값 출력을 위한 클래스
public class HeatIndexCalculator extends WeatherCalculator {

	// 객체 생성시 파라미터를 받지 않으며 default값인 0.0으로 초기화하는 생성자
	public HeatIndexCalculator() {
		super(new WeatherData());
	}

	// 객체 생성시 파라미터로 객체의 인스턴스 변수를 초기화하는 생성자
	public HeatIndexCalculator(WeatherData weatherData) {
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

	// 화씨온도와 상대습도를 입력 받고, 열지수 공식을 이용해 열지수 값을 구해 반환하는 메서드.
	public static double calculate(double F, double RH) {
		if (F < 80.0)
			return 0.0;

		double value = -42.379 + (2.04901523 * F) + (10.14333127 * RH) - (0.22475541 * F * RH) - (0.00683770 * F * F)
				- (0.05481717 * RH * RH) + (0.00122874 * F * F * RH) + (0.00085282 * F * RH * RH)
				- (0.00000199 * F * F * RH * RH);

		return Math.round(value * 10) / 10.0;
	}

	@Override
	public void calculate() {
		this.value = calculate(weatherData.getTemperature(), weatherData.getRelativeHumidity());
	}

	// 열지수 테이블을 출력하는 메서드.
	@Override
	public void printTable() {
		int[] fahrenheit = { 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 100, 102, 104, 106, 108, 110 };
		int[] humidities = { 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100 };

		System.out.println("\n{HeatIndex_Table}");
		System.out.print("RH/F\t80\t82\t84\t86\t88\t90\t92\t94\t96\t98\t100\t102\t104\t106\t108\t110\n");

		for (int i = 0; i < humidities.length; i++) {
			System.out.print(humidities[i] + "\t");

			for (int j = 0; j < fahrenheit.length; j++) {
				double value = calculate(fahrenheit[j], humidities[i]);

				if (value < 137)
					System.out.print(value + "\t");
				else
					System.out.print("\t\t");
			}

			System.out.print("\n");
		}
	}

	// 열지수 계산을 위한 온도(F), 상대습도(%) 값을 User에게 입력 받는 메서드.
	@Override
	public void getUserInput() {
		System.out.println("\n[Calculate HeatIndex]");
		System.out.print("Please enter temperature (F): ");
		setTemperature(UserInput.getDouble());

		System.out.print("Please enter relative humidity (%): ");
		setRelativeHumidity(UserInput.getDouble());
	}

	@Override
	public boolean equals(Object other) { // Object.equals overriding
		if (this == other)
			return true;
		if (other instanceof HeatIndexCalculator) {
			HeatIndexCalculator that = (HeatIndexCalculator) other;
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
		return "HeatIndexCalculator [temperature=" + weatherData.getTemperature() + "F, relativeHumidity=" + getRelativeHumidity()
				+ "%, value=" + value + "F, index=" + HeatIndex.getIndex(value) + "]";
	}

}
