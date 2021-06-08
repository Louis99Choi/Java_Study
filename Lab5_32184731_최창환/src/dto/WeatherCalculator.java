// Lab5_32184731_최창환

package dto;

/*
 * 인스턴스로 각 생활기상 지수 결과값을 저장할 공통변수 value와 날짜와 기상 정보에 대한 
 * WeatherData 객체를 갖고 인스턴스 매서드인 process()와 static 매서드인 
 * 섭씨<->화씨 변환 매서드를 구현한 추상 클래스이며 각 생활기상 지수 계산기 클래스의 부모 클래스이다.
 */
public abstract class WeatherCalculator implements IWeatherCalculator {
	protected WeatherData weatherData;
	protected double value;

	protected WeatherCalculator(WeatherData weatherData) {
		this.weatherData = weatherData;
		calculate(); //
	}

	// 자식 클래스의 지수 표를 출력하고
	// 사용자의 입력을 받아 각 지수값을 계산하고 출력하는 매서드
	public final void process() {
		printTable();
		getUserInput();
		calculate();
		System.out.println(this);
	}

	// 화씨온도를 섭씨온도로 변환하는 static 메서드.
	public static double fromFahrenheitToCelsius(double F) {
		return (F - 32.0) * (5.0 / 9.0);
	}

	// 섭씨온도를 화씨온도로 static 메서드.
	public static double fromCelsiusToFahrenheit(double C) {
		return ((9.0 / 5.0) * C + 32.0);
	}
}
