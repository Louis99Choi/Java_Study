package Enum_Index;
//체감온도 값의 범위에 따라 출력할 경고 문구를 다르게 하기 위해 사용할 열거형 변수 생성.
public enum WindChillTemperatureIndex {
	EXTREME_DANGER, DANGER, WARNING, CAUTION, AWARE;

	// EXTREME_DANGER -75 F (-60 C)
	// DANGER -75 ~ -50 F (-60 ~ -45 C) 
	// WARNING -50 ~ -15 F (-45 ~ -25 C)  
	// CAUTION -15 ~ 15 F (-25 ~ -10 C)  
	// AWARE 15 ~ 32 F (-10 ~ 0 C)  
	
	/*
	 * 매개변수로 체감온도 값을 double형으로 받고 해당 값이 포함되는 범위의
	 * 열거형 변수 WindChillTemperatureIndex 형(ex_ CAUTION)으로 반환하는 static 메서드.
	 */
	public static WindChillTemperatureIndex getIndex(double value) {
		if (value < -75.0) 
			return WindChillTemperatureIndex.EXTREME_DANGER;
		
		else if (value >= -75.0 && value < -50.0) 
			return WindChillTemperatureIndex.DANGER;
		
		else if (value >= -50.0 && value < -15.0) 
			return WindChillTemperatureIndex.WARNING;
		
		else if (value >= -15.0 && value < 15.0) 
			return WindChillTemperatureIndex.CAUTION;
		
		else if (value >= 15.0 && value < 32.0)
			return WindChillTemperatureIndex.AWARE;
		
		else
			return null;
	}
}
