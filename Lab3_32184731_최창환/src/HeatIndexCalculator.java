
public class HeatIndexCalculator {
	private double temperature; // fahrenheit
	private double relativeHumidity; // %
	private double value; // HeatIndex 값
	
	public HeatIndexCalculator(double temperature, double relativeHumidity, double value) {
		this.temperature = temperature;
		this.relativeHumidity = relativeHumidity;
		this.value = value;
	}
	public HeatIndexCalculator() {
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
		// 열지수 테이블 출력 - 중첩 for
		int[] rhList = new int[13];
		int[] tfList = new int[16];
		
		for (int i = 0; i < 100; i++)
			System.out.printf("="); // HeatIndex Table boundary
		
		System.out.print("\nRH(%%) \\ T(˚F)_");
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
		// 열지수 계산을 위한 온도(F), 상대습도(%) 사용자 입력
		System.out.println("\nHeatIndexCalculator 입니다. ");
		System.out.print("temperature(F) 입력 :");
		temperature = UserInput.getDouble();
		
		System.out.print("relativeHumidity(%) 입력 :");
		relativeHumidity = UserInput.getDouble();
	}
	
}
