// Lab5_32184731_최창환

package dto;

import java.util.Objects;

import Enum_Index.WindChillTemperatureIndex;
import controller.UserInput;

//WeatherCalculator 클래스를 상속받고
// 체감온도 Table 출력 및 체감온도 계산을 위한 입력, 체감온도 결과값 출력을 위한 클래스
public class WindChillTemperatureCalculator extends WeatherCalculator {

	/* 
	 * 객체 생성시 각각의 인스턴스 변수를 null과 0.0으로 초기화한 WeatherData 클래스 객체를 
	 * 파라미터로 본 클래스의 부모 클래스인 WeatherCalculator 클래스의 생성자를 호출해 객체 초기화.
	 */
	public WindChillTemperatureCalculator() {
		super(new WeatherData());
	}

	/*
	 *  WeatherData 객체를 매개변수로 받는 본 클래스의 
	 *  부모 클래스의 생성자를 호출해 본 클래스의 객체를 초기화. 
	 */
	public WindChillTemperatureCalculator(WeatherData weatherData) {
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

	public double getWindVelocity() {
		return weatherData.getWindVelocity();
	}

	public void setWindVelocity(double windVelocity) {
		this.weatherData.setWindVelocity(windVelocity);
	}

	public double getValue() {
		return value;
	}

	// 매개변수로 받은 온도와 풍속 값으로 체감온도를 계산해 double형으로 반환하는 static 메서드
	// WCT = 35.74 + 0.6215*F - 35.75*V^0.16 + 0.4275*F*V^0.16
	public static double calculate(double F, double V) {
		double value = 35.74 + 0.6215 * F - 35.75 * Math.pow(V, 0.16) + 0.4275 * F * Math.pow(V, 0.16);

		return Math.round(value * 10) / 10.0;
	}

	//부모클래스가 구현한 인터페이스의 매소드를 Overriding.
	@Override
	public void calculate() {
		this.value = calculate(weatherData.getTemperature(), weatherData.getWindVelocity());
	}

	//부모클래스가 구현한 인터페이스의 매소드를 Overriding.
	// 체감온도 테이블을 출력하는 메서드.
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

	//부모클래스가 구현한 인터페이스의 매소드를 Overriding.
	// 체감온도 계산을 위한 온도(F), 풍속(mph) 값을 User에게 입력 받는 메서드.
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
