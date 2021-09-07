// Lab5_32184731_최창환

package Enum_Index;
//부패(식중독)지수 값의 범위에 따라 출력할 경고 문구를 다르게 하기 위해 사용할 열거형 변수 생성.
public enum DecompositionIndex {
	// DANGER value > 7.0
	// WARNING 5.0 ~ 7.0
	// CAUTION 3.0 ~ 5.0
	// AWARE value < 3.0
	
	DANGER, WARNING, CAUTION, AWARE;

	/*
	 * 매개변수로 체감온도 값을 double형으로 받고 해당 값이 포함되는 범위의 열거형 변수 WindChillTemperatureIndex
	 * 형(ex_ CAUTION)으로 반환하는 static 메서드.
	 */
	public static DecompositionIndex getIndex(double value) {
		if (value < 3.0)
			return DecompositionIndex.AWARE;
		
		else if (value >= 3.0 && value < 5.0)
			return DecompositionIndex.CAUTION;
		
		else if (value >= 5.0 && value < 7.0)
			return DecompositionIndex.WARNING;
		
		else if (value >= 7.0)
			return DecompositionIndex.DANGER;
		
		else
			return null;
	}
	
}
