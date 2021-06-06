package dto;

// 추상 클래스로 기상 지수 클래스들의 공통 변수 value와 process 매서드를 인스턴스로 갖고,
// 추상 매서드로 지수표 출력, 사용자 입력, 지수값 계산 매서드를 가지는 
// 각각의 지수값 계산 클래스들의 부모 클래스이다.
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
