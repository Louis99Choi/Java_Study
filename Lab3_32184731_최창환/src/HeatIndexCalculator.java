
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
		return "HeatIndexCalculator [temperature=" + temperature + ", relativeHumidity=" + relativeHumidity + ", value="
				+ value + "]";
	}
	
	public static double calculate(double F, double RH) {
		// 체감온도 공식
		return 0.0; //!!!!!!
	}
	
	public void calculate() {
		value = calculate(temperature, relativeHumidity);
	}
	
	public static void printTable() {
		// 열지수 테이블 출력 - 중첩 for
		
	}
	
	public void getUserInput() {
		// 열지수 계산을 위한 온도(F), 상대습도(%) 사용자 입력
		System.out.println("HeatIndexCalculator 입니다. ");
		System.out.print("temperature(F) 입력 :");
		temperature = UserInput.getDouble();
		
		System.out.print("relativeHumidity(%) 입력 :");
		relativeHumidity = UserInput.getDouble();
	}
	
}
