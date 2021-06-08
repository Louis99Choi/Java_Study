// Lab5_32184731_��âȯ

package dto;

public enum Mode {
	DEW_POINT,
	WIND_CHILL_TEMPERATURE,
	HEAT_INDEX,
	DISCOMFORT_INDEX,
	DECOMPOSITION_INDEX;

	/*
	 * User�κ��� �޴� ���� ��ȣ�� int�� �Ű������� �޾� �� ���� �ش��ϴ� ������ Mode ������ ��ȯ�ϴ� �޼���.
	 */
	public static Mode valueOf(int mode) {
		
		switch (mode) {
		case 1:
			return DEW_POINT;
		case 2:
			return WIND_CHILL_TEMPERATURE;
		case 3:
			return HEAT_INDEX;
		case 4:
			return DISCOMFORT_INDEX;
		case 5:
			return DECOMPOSITION_INDEX;

		}
		
		return null;
	}
}
