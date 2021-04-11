
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
		return "WindChillTemperatureCalculator [temperature=" + temperature + "F, windVelocity=" + windVelocity
				+ "mph, value=" + value + "F]";
	}
	
	public static double calculate(double F, double V) {
		double WindChill = 35.74 + 0.6125 * F + (0.4275 * F - 35.75) * Math.pow(V, 0.16);
		
		return Math.round(WindChill * 10) /10;
	}
	
	public void calculate() {
		value = calculate(temperature, windVelocity);
	}
	
	public static void printTable() {
		// 체감온도 테이블 출력 - 중첩 for
		
		int[] tfList = new int[18];
		int[] vList = new int[12];
		
		for (int i = 0; i < 100; i++)
			System.out.printf("="); // Wind Chill Table boundary
		
		System.out.print("\nWind(mph)\\ T(˚F)_");
		for (int i = 0; i < tfList.length; i++) {
			System.out.printf("%4d", tfList[i] = 40 - i*5);
		}
		System.out.println("");
		
		for(int i = 0; i<vList.length; i++) {
			System.out.printf("%10d       ", vList[i] = 5 + i*5);
			
			for(int k = 0; k<tfList.length; k++)
				System.out.printf("%4d", (int)Math.round(calculate(tfList[k], vList[i])) );
			
			System.out.println("");	
		}
		
		for (int i = 0; i < 100; i++)
			System.out.printf("="); // Wind Chill Table boundary
		
	}
	
	public void getUserInput() {
		// 체감온도 계산을 위한 온도(F), 풍속(mph) 사용자 입력
		System.out.println("\nWindChillTemperatureCalculater 입니다. ");
		System.out.print("temperature(F) 입력 :");
		temperature = UserInput.getDouble();
		
		System.out.print("windVelocity(mph) 입력 :");
		windVelocity = UserInput.getDouble();
	}
}
