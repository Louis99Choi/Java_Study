
public class WindChillTemperatureCalculator {
	private double temperature; // F
	private double windVelocity; // mph
	private double value; // WindChillTemperature 값
	
	public WindChillTemperatureCalculator(double temperature, double windVelocity, double value) {
		//객체 생성시 파라미터로 객체의 인스턴스 변수를 초기화하는 생성자
		this.temperature = temperature;
		this.windVelocity = windVelocity;
		this.value = value;
	}
	public WindChillTemperatureCalculator() {
		//객체 생성시 파라미터를 받지 않으며 default값인 0.0으로 초기화하는 생성자
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
		//매개변수로 받은 온도와 풍속 값으로 체감온도를 계산해 double형으로 반환하는 static 메서드
		double WindChill = 35.74 + 0.6125 * F + (0.4275 * F - 35.75) * Math.pow(V, 0.16);
		
		return Math.round(WindChill * 10) /10;
	}
	
	public void calculate() {
		//인스턴스 변수 온도와, 풍속으로 계산한 체감온도 값으로 value 값을 초기화하는 인스턴스 메서드.
		value = calculate(temperature, windVelocity);
	}
	
	public static void printTable() {
		// 체감온도 테이블을 출력하는 static 메서드.
		
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
		// 체감온도 계산을 위한 온도(F), 풍속(mph) 값을 User에게 입력 받는 메서드.
		System.out.println("\nWindChillTemperatureCalculater 입니다. ");
		System.out.print("temperature(F) 입력 :");
		temperature = UserInput.getDouble();
		
		System.out.print("windVelocity(mph) 입력 :");
		windVelocity = UserInput.getDouble();
	}
}
