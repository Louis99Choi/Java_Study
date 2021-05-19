
public class WeatherCalculatorFactory {

	public static WeatherCalculator getInstance(Mode mode) {

		/*
		 * 각각의 case에서 mode값에 따라 해당하는 클래스 객체를 반환하며 UpCasting.
		 */
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
