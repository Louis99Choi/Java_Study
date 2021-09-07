// Lab5_32184731_최창환

package Enum_Index;
//열지수 값의 범위에 따라 출력할 경고 문구를 다르게 하기 위해 사용할 열거형 변수 생성.
public enum HeatIndex {
	EXTREME_DANGER, DANGER, EXTREME_CAUTION, CAUTION;

	// EXTREME_DANGER 130 F ~ (54 C ~)  
	// DANGER 105 ~ 130 F (41 ~ 54 C)   
	// EXTREME_CAUTION 90 ~ 105 F (32 ~ 41 C)   
	// CAUTION 80 ~ 90 F (27 ~ 32 C)
	public static HeatIndex getIndex(double value) {
		if (value > 130.0) 
			return HeatIndex.EXTREME_DANGER;
		
		else if (value >= 105.0 && value < 130.0) 
			return HeatIndex.DANGER;
		
		else if (value >= 90.0 && value < 105.0) 
			return HeatIndex.EXTREME_CAUTION;
		
		else if (value >= 80.0 && value < 90)
			return HeatIndex.CAUTION;
		
		else
			return null;
	}
}
