// Lab5_32184731_��âȯ

package Enum_Index;
//����(���ߵ�)���� ���� ������ ���� ����� ��� ������ �ٸ��� �ϱ� ���� ����� ������ ���� ����.
public enum DecompositionIndex {
	// DANGER value > 7.0
	// WARNING 5.0 ~ 7.0
	// CAUTION 3.0 ~ 5.0
	// AWARE value < 3.0
	
	DANGER, WARNING, CAUTION, AWARE;

	/*
	 * �Ű������� ü���µ� ���� double������ �ް� �ش� ���� ���ԵǴ� ������ ������ ���� WindChillTemperatureIndex
	 * ��(ex_ CAUTION)���� ��ȯ�ϴ� static �޼���.
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
