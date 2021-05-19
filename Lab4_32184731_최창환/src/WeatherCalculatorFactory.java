
public class WeatherCalculatorFactory {

	public static WeatherCalculator getInstance(Mode mode) {

		/*
		 * ������ case���� mode���� ���� �ش��ϴ� Ŭ���� ��ü�� ��ȯ�ϸ� UpCasting.
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
