// 체감온도 Table 출력 및 체감온도 계산을 위한 입력, 체감온도 결과값 출력을 위한 클래스
public class WindChillTemperatureCalculator extends WeatherCalculator{
	private double temperature; // fahrenheit
	private double windVelocity; // mph

	//객체 생성시 파라미터를 받지 않으며 default값인 0.0으로 초기화하는 생성자
	public WindChillTemperatureCalculator() {
		this(0.0, 0.0);
	}
	
	//객체 생성시 파라미터로 객체의 인스턴스 변수를 초기화하는 생성자
	public WindChillTemperatureCalculator(double temperature, double windVelocity) {
		this.temperature = temperature;
		this.windVelocity = windVelocity;
		this.value = calculate(temperature, windVelocity);
	}
	
	/*
	 * 각각의 인스턴스 변수의 값을 반환, 설정하는 메서드.
	 */
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
	
	//매개변수로 받은 온도와 풍속 값으로 체감온도를 계산해 double형으로 반환하는 static 메서드
	// WCT = 35.74 + 0.6215*F - 35.75*V^0.16 + 0.4275*F*V^0.16
	public static double calculate(double F, double V) {
		double value = 35.74 + 0.6215*F - 35.75*Math.pow(V, 0.16) + 0.4275*F*Math.pow(V, 0.16);
		
		return Math.round(value*10)/10.0;
	}

	@Override
	public void calculate() {
		this.value = calculate(temperature, windVelocity);
	}
	
	// 체감온도 테이블을 출력하는 메서드.
	@Override
	public void printTable() {
		System.out.println("\n{WindChillTemperature_Table}");
		System.out.print("W/F\t40\t35\t30\t25\t20\t15\t10\t5\t0\t-5\t-10\t-15\t-20\t-25\t-30\t-35\t-40\t-45\n");
		
		for (int wind = 5; wind < 65; wind += 5) {
			System.out.print(wind + "\t");
			
			for (int fahrenheit = 40; fahrenheit > - 50; fahrenheit -= 5) {
				double value = calculate(fahrenheit, wind);
				System.out.print(value + "\t");
			}
			
			System.out.print("\n");
		}
	}

	// 체감온도 계산을 위한 온도(F), 풍속(mph) 값을 User에게 입력 받는 메서드.
	@Override
	public void getUserInput() {
		System.out.println("\n[Calculate WindChillTemperature]");	
		System.out.print("Please enter temperature (F): ");
		setTemperature(UserInput.getDouble());
		
		System.out.print("Please enter wind velocity (mph): ");
		setWindVelocity(UserInput.getDouble());
	}

	@Override
	public String toString() {
		return "WindChillTemperatureCalculator [temperature=" + temperature + "F, windVelocity=" + windVelocity
				+ "mph, value=" + value + "F, index=" + WindChillTemperatureIndex.getIndex(value) + "]";
	}

}
