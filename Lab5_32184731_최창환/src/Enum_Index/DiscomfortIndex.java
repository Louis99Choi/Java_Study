// Lab5_32184731_최창환

package Enum_Index;
//불쾌지수 값의 범위에 따라 출력할 경고 문구를 다르게 하기 위해 사용할 열거형 변수 생성.
public enum DiscomfortIndex {

//	EXTREME_DISCOMFORT 89.6 F (32 C ~)
//	VERY_HIGH_DISCOMFORT 86 ~ 89.6 F (30 ~ 32 C)
//	HIGH_DISCOMFORT 82.4 ~ 86 F (28 ~ 30 C)
//	MODERATE_DISCOMFORT 77 ~ 82.4 F (25 ~ 28 C)
//	LOW_DISCOMFORT 69.8 ~ 77 F (21 ~ 25 C)
//	NO_DISCOMFORT ~ 69.8 F (~ 21 C)
	
	EXTREME_DISCOMFORT, 
	VERY_HIGH_DISCOMFORT, 
	HIGH_DISCOMFORT, 
	MODERATE_DISCOMFORT, 
	LOW_DISCOMFORT, 
	NO_DISCOMFORT;

	public static DiscomfortIndex getIndex(double value) {
		if (value >= 89.6)
			return DiscomfortIndex.EXTREME_DISCOMFORT;
		
		else if (value >= 86.0 && value < 89.6)
			return DiscomfortIndex.VERY_HIGH_DISCOMFORT;
		
		else if (value >= 82.4 && value < 86.0)
			return DiscomfortIndex.HIGH_DISCOMFORT;
		
		else if (value >= 77.0 && value < 82.4)
			return DiscomfortIndex.MODERATE_DISCOMFORT;
		
		else if (value >= 69.8 && value < 77.0)
			return DiscomfortIndex.LOW_DISCOMFORT;
		
		else if (value < 69.8)
			return DiscomfortIndex.NO_DISCOMFORT;
		
		else
			return null;
	}
	
}
