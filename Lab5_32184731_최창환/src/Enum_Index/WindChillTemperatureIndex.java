package Enum_Index;
//ü���µ� ���� ������ ���� ����� ��� ������ �ٸ��� �ϱ� ���� ����� ������ ���� ����.
public enum WindChillTemperatureIndex {
	EXTREME_DANGER, DANGER, WARNING, CAUTION, AWARE;

	// EXTREME_DANGER -75 F (-60 C)
	// DANGER -75 ~ -50 F (-60 ~ -45 C) 
	// WARNING -50 ~ -15 F (-45 ~ -25 C)  
	// CAUTION -15 ~ 15 F (-25 ~ -10 C)  
	// AWARE 15 ~ 32 F (-10 ~ 0 C)  
	
	/*
	 * �Ű������� ü���µ� ���� double������ �ް� �ش� ���� ���ԵǴ� ������
	 * ������ ���� WindChillTemperatureIndex ��(ex_ CAUTION)���� ��ȯ�ϴ� static �޼���.
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
