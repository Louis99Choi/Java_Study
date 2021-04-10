
public class WindChillTemperatureCalculator {
	private double temperature; // F
	private double windVelocity; // mph
	private double value; // WindChillTemperature 값
	
	public WindChillTemperatureCalculator(double temperature, double windVelocity, double value) {
		this.temperature = temperature;
		this.windVelocity = windVelocity;
		this.value = value;
	}
	public WindChillTemperatureCalculator() {
		this(0.0, 0.0, 0.0);
	}

	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getWindVelocity() {
		return windVelocity;
	}
	public void setWindVelocity(double windVelocity) {
		this.windVelocity = windVelocity;
	}

	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "WindChillTemperatureCalculator [temperature=" + temperature + ", windVelocity=" + windVelocity
				+ ", value=" + value + "]";
	}
	
	public static double calculate(double F, double V) {
		// 체감온도 공식
		return 0.0; //!!!!!!
	}
	
	public void calculate() {
		value = calculate(temperature, windVelocity);
	}
	
	public static void printTable() {
		// 체감온도 테이블 출력 - 중첩 for
		
	}
	
	public void getUserInput() {
		// 체감온도 계산을 위한 온도(F), 풍속(mph) 사용자 입력
		System.out.println("WindChillTemperatureCalculater 입니다. ");
		System.out.print("temperature(F) 입력 :");
		temperature = UserInput.getDouble();
		
		System.out.print("windVelocity(mph) 입력 :");
		windVelocity = UserInput.getDouble();
	}
}
