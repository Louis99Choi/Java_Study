package dto;

// �ڽ� ��ü�� ��ȯ�ϸ� UpCasting�� �����ϴ� Ŭ����
public class WeatherCalculatorFactory {

	/*
	 * getInstance �ż����� ��ȯ ���� WeatherCalculator Ÿ�������� ���� ��ü�� ������ mode���� ����
	 * DEW_POINT, WIND_CHILL_TEMPERATURE, HEAT_INDEX, DISCOMFORT_INDEX,
	 * DECOMPOSITION_INDEX �̹Ƿ� �ż��尡 ����Ǿ� ��ü�� ��ȯ�ϴ� ���� UpCasting�� �̷������.
	 */
	public static WeatherCalculator getInstance(Mode mode) {
		// ������ case���� mode���� ���� �ش��ϴ� Ŭ���� ��ü�� ��ȯ�ϸ� UpCasting.
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

	public static WeatherCalculator getInstance(Mode mode, WeatherData data) {
		// ������ case���� mode���� ���� �ش��ϴ� Ŭ���� ��ü�� ��ȯ�ϸ� UpCasting.
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
