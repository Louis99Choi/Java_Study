//이슬점 Table 출력 및 이슬점 계산을 위한 입력, 이슬점 결과값 출력을 위한 클래스
public class DewPointCalculator {
	//인스턴스 변수를 private 접근제어자 형식으로 선언.
	private double temperature; //F
	private double relativeHumidity; //%
	private double value; //DP
	
	public DewPointCalculator(double temperature, double relativeHumidity, double value) {
		//객체 생성시 파라미터로 객체의 인스턴스 변수를 초기화하는 생성자
		this.temperature = temperature;
		this.relativeHumidity = relativeHumidity;
		this.value = value;
	}
	
	public DewPointCalculator() {
		//객체 생성시 파라미터를 받지 않으며 default값인 0.0으로 초기화하는 생성자
		this(0.0, 0.0, 0.0);
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
	public void setValue(double value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "DewPointCalculator [temperature=" + temperature + "F, relativeHumidity=" + relativeHumidity + "%, value="
				+ value + "F]";
	}
	
	public static double calculate(double F, double RH) {
		//매개변수로 받은 온도와 상대습도 값으로 이슬점을 계산해 double형으로 반환하는 static 메서드
		double k = (17.62 * UserInput.convertFtoC(F)) / (243.12 + UserInput.convertFtoC(F)); //화씨온도를 섭씨온도로 변환하여 공식에 대입.
		
		double DewPointC = (243.12 * (Math.log(RH / 100) + k)) / (17.62 - (Math.log(RH / 100) + k)); //섭씨온도로 표현된 이슬점.
		double DewPointF = UserInput.convertCtoF(DewPointC); //섭씨온도로 표현된 이슬점을 화씨온도로 변환.
		
		return Math.round(DewPointF*10) / 10;
	}

	public void calculate() {
		//인스턴스 변수 온도와, 상대습도로 계산한 이슬점 값으로 value 값을 초기화하는 인스턴스 메서드.
		value = calculate(temperature, relativeHumidity);
	}
	
	public static void printTable() {
		//이슬점 테이블을 출력하는 static 메서드.

		int[] rhList = new int[19];
		int[] tfList = new int[17];
		
		for (int i = 0; i < 100; i++)
			System.out.printf("="); // Dew Point Table boundary
		
		System.out.print("\nT(˚F) \\ RH(%%)_");
		for (int i = 0; i < rhList.length; i++) {
			System.out.printf("%4d", rhList[i] = 100 - i*5);
		}
		System.out.println("");
		
		for(int i = 0; i<tfList.length; i++) {
			
			if(i == 16) System.out.printf("%7d        ", tfList[i] = 32);
			else System.out.printf("%7d        ", tfList[i] = 110 - i*5);
			
			for(int k = 0; k<rhList.length; k++) {
				if((int)Math.round(calculate(tfList[i], rhList[k])) >= 32)
					System.out.printf("%4d", (int)Math.round(calculate(tfList[i], rhList[k])) );
			}
			
			System.out.println("");	
		}
		
		for (int i = 0; i < 100; i++)
			System.out.printf("="); // Dew Point Table boundary
	}
	
	public void getUserInput() {
		//이슬점 계산을 위한 온도(F), 상대습도(%) 값을 User에게 입력 받는 메서드.
		System.out.println("\nDewPointCalculater 입니다. ");
		System.out.print("temperature(F) 입력 :");
		temperature = UserInput.getDouble();
		
		System.out.print("relativeHumidity(%) 입력 :");
		relativeHumidity = UserInput.getDouble();
	}
	
}
