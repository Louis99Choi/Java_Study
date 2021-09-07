
public class HeatIndexCalculator {
	private double temperature; // F
	private double relativeHumidity; // %
	private double value; // HeatIndex ��
	
	public HeatIndexCalculator(double temperature, double relativeHumidity, double value) {
		//��ü ������ �Ķ���ͷ� ��ü�� �ν��Ͻ� ������ �ʱ�ȭ�ϴ� ������
		this.temperature = temperature;
		this.relativeHumidity = relativeHumidity;
		this.value = value;
	}
	public HeatIndexCalculator() {
		//��ü ������ �Ķ���͸� ���� ������ default���� 0.0���� �ʱ�ȭ�ϴ� ������
		this(0.0, 0.0, 0.0);
	}
	
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	public double getRelativeHumidity() {
		return relativeHumidity;
	}
	public void setRelativeHumidity(double relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "HeatIndexCalculator [temperature=" + temperature + "F, "
				+ "relativeHumidity=" + relativeHumidity + "%, value=" + value + "F]";
	}
	
	public static double calculate(double F, double RH) {
		double heatIndex;
		
		if(F < 80) heatIndex = F;
		else{
			heatIndex = -42.379 + (2.04901523*F) + (10.14333127*RH) - 
				(0.22475541*F*RH) - (0.00683770*F*F) - (0.05481717*RH*RH) + 
				(0.00122874*F*F*RH) + (0.00085282*F*RH*RH) - (0.00000199*F*F*RH*RH);
		}
		
		return Math.round(heatIndex * 10) /10;
	}
	
	public void calculate() {
		value = calculate(temperature, relativeHumidity);
	}
	
	public static void printTable() {
		// ������ ���̺��� ����ϴ� static �޼���.
		int[] rhList = new int[13];
		int[] tfList = new int[16];
		
		for (int i = 0; i < 100; i++)
			System.out.printf("="); // HeatIndex Table boundary
		
		System.out.print("\nRH(%%) \\ T(��F)_");
		for (int i = 0; i < tfList.length; i++) {
			System.out.printf("%4d", tfList[i] = 80 + i*2);
		}
		System.out.println("");
		
		for(int i = 0; i<rhList.length; i++) {			
			System.out.printf("%7d        ", rhList[i] = 40 + i*5);
			
			for(int k = 0; k<tfList.length; k++) {
				if((int)Math.round(calculate(tfList[k], rhList[i])) <= 137)
					System.out.printf("%4d", (int)Math.round(calculate(tfList[k], rhList[i])) );
			}
			
			System.out.println("");	
		}
		
		for (int i = 0; i < 100; i++)
			System.out.printf("="); // HeatIndex Table boundary
		
	}
	
	public void getUserInput() {
		// ������ ����� ���� �µ�(F), ������(%) ���� User���� �Է� �޴� �޼���.
		System.out.println("\nHeatIndexCalculator �Դϴ�. ");
		System.out.print("temperature(F) �Է� :");
		temperature = UserInput.getDouble();
		
		System.out.print("relativeHumidity(%) �Է� :");
		relativeHumidity = UserInput.getDouble();
	}
	
}
