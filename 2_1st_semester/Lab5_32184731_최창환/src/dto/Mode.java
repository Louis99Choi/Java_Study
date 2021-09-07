// Lab5_32184731_최창환

package dto;

public enum Mode {
	DEW_POINT,
	WIND_CHILL_TEMPERATURE,
	HEAT_INDEX,
	DISCOMFORT_INDEX,
	DECOMPOSITION_INDEX;

	/*
	 * User로부터 메뉴 선택 번호로 int형 매개변수를 받아 그 값에 해당하는 열거형 Mode 변수를 반환하는 메서드.
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
