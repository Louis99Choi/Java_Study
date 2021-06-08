package dto;

// �ڽ� ��ü�� ��ȯ�ϸ� UpCasting�� �����ϴ� Ŭ����
//Lab5_32184731_��âȯ

public class WeatherCalculatorFactory {

	/*
	 * getInstance �ż����� ��ȯ ���� WeatherCalculator Ÿ�������� ���� ��ü�� ������ mode���� ����
	 * DEW_POINT, WIND_CHILL_TEMPERATURE, HEAT_INDEX, DISCOMFORT_INDEX,DECOMPOSITION_INDEX 
	 * �̹Ƿ� �ż��尡 ����Ǿ� ��ü�� ��ȯ�ϴ� ���� UpCasting�� �̷������.
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

	// getInstance() static �żҵ带 �����ε��� ���� WeatherData�� �Ű������� �޾� �ش� 
	// Mode�� ��ü�� WeatherCalculator Ÿ������ UpCasting �ؼ� ��ȯ.
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
