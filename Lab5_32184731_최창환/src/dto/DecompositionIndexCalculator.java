package dto;

import Enum_Index.DecompositionIndex;
import controller.UserInput;

// 부패(식중독)지수 Table 출력 및 부패(식중독)지수 계산을 위한 입력, 부패(식중독)지수 결과값 출력을 위한 클래스
public class DecompositionIndexCalculator extends WeatherCalculator {
	
	private double temperature; // fahrenheit
	private double relativeHumidity; // %
	
	//객체 생성시 파라미터를 받지 않으며 default값인 0.0으로 초기화하는 생성자
	public DecompositionIndexCalculator() {
		this(0.0, 0.0);
	}
	
	//객체 생성시 파라미터로 객체의 인스턴스 변수를 초기화하는 생성자
	public DecompositionIndexCalculator(double temperature, double relativeHumidity) {
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

	// 섭씨온도를 화씨온도로 static 메서드.
	public static double fromCelsiusToFahrenheit(double C) {
		return ((9.0 / 5.0) * C + 32.0);
	}

	// 화씨온도와 상대습도를 입력 받고, 부패(식중독)지수 공식을 이용해 부패(식중독)지수 값을 구해 반환하는 메서드.
	public static double calculate(double F, double RH) {
		// 부패(식중독)지수 계산 공식 DI = ((RH - 65) / 14) * (1.054)^T [T: celsius]
		double T = fromFahrenheitToCelsius(F);
		
		if(T <= 0 || RH < 65.0) return 0.0; // 기온이 영하이거나 습도가 65% 이하 이면 부패지수는 0과 같다.
		
		else {
			double value = ((RH - 65) / 14) * Math.pow(1.054, T);
			
			return Math.round(value*10)/10.0;
		}
		
	}
		
	// 멤버 필드 온도와 상대습도로 부패(식중독)지수 계산 매서드.
	@Override
	protected void calculate() {
		this.value = calculate(temperature, relativeHumidity);
	}
	
	// 부패(식중독)지수 테이블 출력 매서드.
	@Override
	protected void printTable() {
		int[] fahrenheit = {68, 71, 74, 77, 80, 83, 86, 89, 92, 95, 98, 101, 104, 107, 110};
		int[] humidities = {66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 100};

		System.out.println("\n{DecompositionIndex_Table}");
		System.out.print("RH/F\t68\t71\t74\t77\t80\t83\t86\t89\t92\t95\t98\t101\t104\t107\t110\n");
		
		for (int i = 0; i < humidities.length; i++) {
			System.out.print(humidities[i] + "\t");
			
			for (int j = 0; j < fahrenheit.length; j++) {
				double value = calculate(fahrenheit[j], humidities[i]);
				System.out.print(value + "\t");
			}
			
			System.out.print("\n");
		}
		
	}

	// 부패(식중독)지수 계산을 위한 온도(F), 상대습도(%) 사용자 입력 매서드.
	@Override
	protected void getUserInput() {
		System.out.println("\n[Calculate DiscomfortIndex]");
		System.out.print("Please enter temperature (F): ");
		setTemperature(UserInput.getDouble());
		
		System.out.print("Please enter relative humidity (%): ");
		setRelativeHumidity(UserInput.getDouble());
	}

	@Override
	public String toString() {
		return "DecompositionIndexCalculator [temperature=" + temperature + "F, relativeHumidity=" + relativeHumidity
				+ "%, value=" + value + ", index=" + DecompositionIndex.getIndex(value) + "]";
	}
	
}
