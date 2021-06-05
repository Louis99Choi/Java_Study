package dto;
// �߻� Ŭ������ ��� ���� Ŭ�������� ���� ���� value�� process �ż��带 �ν��Ͻ��� ����,
// �߻� �ż���� ����ǥ ���, ����� �Է�, ������ ��� �ż��带 ������ 
// ������ ������ ��� Ŭ�������� �θ� Ŭ�����̴�.
public abstract class WeatherCalculator {
	protected double value;
	
	// �ڽ� Ŭ������ ���� ǥ�� ����ϰ� 
	//������� �Է��� �޾� �� �������� ����ϰ� ����ϴ� �ż���
	public final void process() {
		printTable();
		getUserInput();
		calculate();
		System.out.println(this);
	}
	
	protected abstract void printTable();
	protected abstract void getUserInput();
	protected abstract void calculate();
}
