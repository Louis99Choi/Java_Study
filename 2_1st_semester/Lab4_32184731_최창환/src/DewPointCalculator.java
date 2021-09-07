//이슬점 Table 출력 및 이슬점 계산을 위한 입력, 이슬점 결과값 출력을 위한 클래스
public class DewPointCalculator extends WeatherCalculator{
	private double temperature; // fahrenheit
	private double relativeHumidity; // %
	
	public DewPointCalculator() {
		//객체 생성시 파라미터를 받지 않으며 default값인 0.0으로 초기화하는 생성자
		this(0.0, 0.0);
	}
	
	public DewPointCalculator(double temperature, double relativeHumidity) {
		//객체 생성시 파라미터로 객체의 인스턴스 변수를 초기화하는 생성자
		this.temperature = temperature;
		this.relativeHumidity = relativeHumidity;
		this.value = calculate(temperature, relativeHumidity);
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

	public double getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(double relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	public double getValue() {
		return value;
	}

	// 화씨온도를 섭씨온도로 변환하는 static 메서드.
	public static double fromFahrenheitToCelsius(double F) {
        return (F - 32.0) * (5.0 / 9.0);
    }
	
	// 섭씨온도를 화씨온도로 변환하는 static 메서드.
	public static double fromCelsiusToFahrenheit(double C) {
        return ((9.0 / 5.0) * C + 32.0);
    }
	
	//매개변수로 받은 온도와 상대습도 값으로 이슬점을 계산해 double형으로 반환하는 static 메서드
	public static double calculate(double F, double RH) {
		double T = fromFahrenheitToCelsius(F);
		double value = (243.12*(Math.log(RH/100) + 17.62*T/(243.12+T)))/(17.62 - (Math.log(RH/100) + 17.62*T/(243.12+T)));		
		value = fromCelsiusToFahrenheit(value);
		return Math.round(value*10)/10.0;
	}
		
	@Override
	public void calculate() {
		this.value = calculate(temperature, relativeHumidity);
	}
	
	//이슬점 테이블을 출력하는 메서드.
	@Override
	public void printTable() {
		int[] humidities = {100, 95, 90, 85, 80, 75, 70, 65, 60, 55, 50, 45, 40, 35, 30, 25, 20, 15, 10};
		int[] fahrenheit = {110, 105, 100, 95, 90, 85, 80, 75, 70, 65, 60, 55, 50, 45, 40, 35, 32};
		
		System.out.print("F/RH\t100\t95\t90\t85\t80\t75\t70\t65\t60\t55\t50\t45\t40\t35\t30\t25\t20\t15\t10\n");
		
		for (int i = 0; i < fahrenheit.length; i++) {
			System.out.print(fahrenheit[i] + "\t");
			
			for (int j = 0; j < humidities.length; j++) {
				double dpt = calculate(fahrenheit[i], humidities[j]);
				
				if (dpt >= 32) System.out.print(dpt + "\t");
				else System.out.print("\t\t");
			}
			
			System.out.print("\n");
		}
		
	}

	//이슬점 계산을 위한 온도(F), 상대습도(%) 값을 User에게 입력 받는 메서드.
	@Override
	public void getUserInput() {
		System.out.println("\n[Calculate DewPoint]");
		System.out.print("Please enter temperature (F): ");
		setTemperature(UserInput.getDouble());
		
		System.out.print("Please enter relative humidity (%): ");
		setRelativeHumidity(UserInput.getDouble());
	}

	@Override
	public String toString() {
		return "DewPointCalculator [temperature=" + temperature + ", relativeHumidity=" + relativeHumidity + ", value="
				+ value + "]";
	}
}
