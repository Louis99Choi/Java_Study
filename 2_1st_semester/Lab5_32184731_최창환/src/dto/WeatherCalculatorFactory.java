package dto;

// 자식 객체를 반환하며 UpCasting을 구현하는 클래스
//Lab5_32184731_최창환

public class WeatherCalculatorFactory {

	/*
	 * getInstance 매서드의 반환 값은 WeatherCalculator 타입이지만 실제 객체는 열거형 mode값에 따라
	 * DEW_POINT, WIND_CHILL_TEMPERATURE, HEAT_INDEX, DISCOMFORT_INDEX,DECOMPOSITION_INDEX 
	 * 이므로 매서드가 실행되어 객체를 반환하는 순간 UpCasting이 이루어진다.
	 */
	public static WeatherCalculator getInstance(Mode mode) {
		// 각각의 case에서 mode값에 따라 해당하는 클래스 객체를 반환하며 UpCasting.
		switch (mode) {

		case DEW_POINT:
			return new DewPointCalculator();

		case WIND_CHILL_TEMPERATURE:
			return new WindChillTemperatureCalculator();

		case HEAT_INDEX:
			return new HeatIndexCalculator();

		case DISCOMFORT_INDEX:
			return new DiscomfortIndexCalculator();

		case DECOMPOSITION_INDEX:
			return new DecompositionIndexCalculator();

		default:
			return null;

		}

	}

	// getInstance() static 매소드를 오버로딩을 통해 WeatherData도 매개변수로 받아 해당 
	// Mode의 객체를 WeatherCalculator 타입으로 UpCasting 해서 반환.
	public static WeatherCalculator getInstance(Mode mode, WeatherData data) {
		// 각각의 case에서 mode값에 따라 해당하는 클래스 객체를 반환하며 UpCasting.
		switch (mode) {

		case DEW_POINT:
			return new DewPointCalculator(data);

		case WIND_CHILL_TEMPERATURE:
			return new WindChillTemperatureCalculator(data);

		case HEAT_INDEX:
			return new HeatIndexCalculator(data);

		case DISCOMFORT_INDEX:
			return new DiscomfortIndexCalculator(data);

		case DECOMPOSITION_INDEX:
			return new DecompositionIndexCalculator(data);

		default:
			return null;

		}
	}

}
