// Lab5_32184731_최창환

package dto;

import java.util.Objects;

import controller.UserInput;

// WeatherCalculator 클래스를 상속받고
// 이슬점 온도 Table 출력 및 이슬점 계산을 위한 입력, 이슬점 결과값 출력을 위한 클래스
public class DewPointCalculator extends WeatherCalculator {
	
	/* 
	 * 객체 생성시 각각의 인스턴스 변수를 null과 0.0으로 초기화한 
	 * WeatherData 클래스 객체를 파라미터로 본 클래스의 부모 클래스인 
	 * WeatherCalculator 클래스의 생성자를 호출해 객체 초기화.
	 */
	public DewPointCalculator() {
		super(new WeatherData());
	}

	/*
	 *  WeatherData 객체를 매개변수로 받는 본 클래스의 
	 *  부모 클래스의 생성자를 호출해 본 클래스의 객체를 초기화. 
	 */
	public DewPointCalculator(WeatherData weatherData) {
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

	// 매개변수로 받은 온도와 상대습도 값으로 이슬점을 계산해 double형으로 반환하는 static 메서드
	public static double calculate(double F, double RH) {
		double T = fromFahrenheitToCelsius(F);
		double value = (243.12 * (Math.log(RH / 100) + 17.62 * T / (243.12 + T)))
				/ (17.62 - (Math.log(RH / 100) + 17.62 * T / (243.12 + T)));
		value = fromCelsiusToFahrenheit(value);
		return Math.round(value * 10) / 10.0;
	}

	//부모클래스가 구현한 인터페이스의 매소드를 Overriding.
	@Override
	public void calculate() {
		this.value = calculate(weatherData.getTemperature(), weatherData.getRelativeHumidity());
	}

	//부모클래스가 구현한 인터페이스의 매소드를 Overriding.
	// 이슬점 테이블을 출력하는 메서드 Override.
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

	//부모클래스가 구현한 인터페이스의 매소드를 Overriding.
	// 이슬점 계산을 위한 온도(F), 상대습도(%) 값을 User에게 입력 받는 메서드.
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
