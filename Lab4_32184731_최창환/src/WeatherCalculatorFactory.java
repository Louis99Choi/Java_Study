// 자식 객체를 반환하며 UpCasting을 구현하는 클래스
public class WeatherCalculatorFactory {

	/*
	 * getInstance 매서드의 반환 값은 WeatherCalculator 타입이지만 
	 * 실제 객체는 열거형 mode값에 따라 
	 * DEW_POINT, WIND_CHILL_TEMPERATURE, HEAT_INDEX, DISCOMFORT_INDEX, DECOMPOSITION_INDEX
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

}
