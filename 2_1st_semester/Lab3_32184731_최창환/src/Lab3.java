//체감온도 값의 범위에 따라 출력할 경고 문구를 다르게 하기 위해 사용할 열거형 변수 생성
enum WindChillTemperatureIndex {
	
	EXTREME_DANGER("-75.0"), DANGER("-50.0"), WARNING("-15.0"), 
	CAUTION("15.0"), AWARE("32.0"), NEGLIGIBLE("32.0");
	
	private double value; //열거형의 인스턴스 변수 선언
	private WindChillTemperatureIndex(String _value) {
		this.value = Double.parseDouble(_value); //문자열로 실수를 저장했으므로 인스턴스 변수 value에 double형으로 형변환하여 저장.
	}
	
	//각각의 변수의 범위의 경계값을 반환하는 인스턴스 메서드.
	public double getValue() {
		return value;
	}
	
	//각각의 변수의 범위의 경계값을 재설정하는 메서드.
	public void setValue(double value) {
		this.value = value;
	}
	
	/*
	 * 매개변수로 체감온도 값을 double형으로 받고 해당 값이 포함되는 범위의
	 * 열거형 변수 WindChillTemperatureIndex 형(ex_ CAUTION)으로 반환하는 static 메서드.
	 */
	public static WindChillTemperatureIndex getIndex(double value) {
		return (value < EXTREME_DANGER.getValue())? EXTREME_DANGER : (value < DANGER.getValue())? DANGER : 
			 (value < WARNING.getValue())? WARNING : (value < CAUTION.getValue())? CAUTION : NEGLIGIBLE;
	}
}

//열지수 값의 범위에 따라 출력할 경고 문구를 다르게 하기 위해 사용할 열거형 변수 생성
enum HeatIndex {
	
	EXTREME_DANGER("130.0"), DANGER("105.0"), EXTREME_CAUTION("90.0"), CAUTION("80.0"), NEGLIGIBLE("80.0");
	private double value;
	private HeatIndex(String _value) {
		this.value = Double.parseDouble(_value); 
		//문자열로 실수를 저장했으므로 인스턴스 변수 value에 double형으로 형변환하여 저장.
	}
	
	//각각의 변수의 범위의 경계값을 반환하는 인스턴스 메서드.
	public double getValue() { return value; }
	
	//각각의 변수의 범위의 경계값을 재설정하는 메서드.
	public void setValue(double value) { this.value = value; }
	
	/*
	 * 매개변수로 열지수 값을 double형으로 받고 해당 값이 포함되는 범위의
	 * 열거형 변수 HeatIndex 형(ex_ CAUTION)으로 반환하는 static 메서드.
	 */
	public static HeatIndex getIndex(double value) {
		 return (value >= EXTREME_DANGER.getValue())? EXTREME_DANGER : (value >= DANGER.getValue())? DANGER : 
			 (value >= EXTREME_CAUTION.getValue())? EXTREME_CAUTION : 
				 (value >= CAUTION.getValue())? CAUTION : NEGLIGIBLE;
	 }
}

/*메뉴 선택창에서 User에게 정수 1,2,3 중 하나를 입력 받아 모드를 선택하기위해
 *열거형 변수 생성
 */
enum Mode {
	
	DEW_POINT(1), WIND_CHILL_TEMPERATURE(2), HEAT_INDEX(3);
	private int num;
	private Mode(int _num) {
		this.num = _num;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	/*
	 * User로부터 메뉴 선택 번호로 int형 매개변수를 받아 그 값에 해당하는 열거형 Mode 변수를 반환하는 메서드.
	 */
	public static Mode getMode(int _num) {
		return (_num == 1)? DEW_POINT : (_num == 2)? WIND_CHILL_TEMPERATURE : HEAT_INDEX;
	}
	
}

public class Lab3 {
	
	static double[][] weatherData = { 
			{110, 100, 0}, // F, relative humidity, wind velocity
			{105, 90, 0},
			{100, 80, 0},
			{95, 70, 0},
			{90, 60, 0},
			{90, 50, 0},
			{85, 40, 0},
			{80, 30, 0},
			{30, 20, 5},
			{20, 10, 5},
			{10, 0, 5},
			{0, 0, 5},
			{-5, 40, 5},
			{-10, 40, 5},
			{-15, 40, 10},
			{-20, 40, 20},
			{-25, 40, 30},
			{-30, 40, 40},
			{-35, 40, 50},
			{-40, 40, 60}
	};

	/*
	 * 사용자의 입력으로 값을 구할때와 weatherData로 값을 구할 때 모두 사용 가능한 메서드로
	 * if문을 이용해 userInput이 true일때는 매개변수 data에 null값을 넣고 사용자의 입력을 통해 해당 값을 
	 * 구해 출력하고 false일때는 매개변수 data에 weatherData의 원소인 1차원 배열을 넣어 사용한다.
	 * switch문을 통해 매개변수 mode로부터 모드 정보를 받아 해당 모드의 값을 계산하여 출력한다.
	 */
	 static void calculate(Mode mode, double[] data, boolean userInput) {
	      
	      if(!userInput) {
	         switch(mode) {
	         /*
	          * 각각의 case에서 해당 클래스로 객체를 생성하고
	          * 매개변수로 입력된 data를 .set--() 매서드로 객체의 인스턴스 변수를 초기화 한 후 
	          * .calculate() 매서드로 .value 에 결과값을 저장한 후 출력한다.
	          */
	         case DEW_POINT:
	            DewPointCalculator dp = new DewPointCalculator();
	            
	            dp.setTemperature(data[0]);
	            dp.setRelativeHumidity(data[1]);
	            dp.calculate();
	            System.out.printf("Dew Point: %.1fF /	", dp.getValue());
	            break;
	            
	         case WIND_CHILL_TEMPERATURE:
	            WindChillTemperatureCalculator wct = new WindChillTemperatureCalculator();
	            
	            wct.setTemperature(data[0]);
	            wct.setWindVelocity(data[2]);
	            wct.calculate();
	            System.out.printf("Wind Chill: %.1fF", wct.getValue()); 
	            System.out.print("["+ WindChillTemperatureIndex.getIndex(wct.getValue()) + "] / ");
	            break;
	            
	         case HEAT_INDEX:
	            HeatIndexCalculator hi = new HeatIndexCalculator();
	            
	            hi.setTemperature(data[0]);
	            hi.setRelativeHumidity(data[1]);
	            hi.calculate();
	            System.out.printf("Heat Index: %.1fF", hi.getValue());
	            System.out.print("["+ HeatIndex.getIndex(hi.getValue()) + "] / ");
	            
	            break;
	            
	         default :
	        	break;
	            
	         }
	      }
	      
	      else {
	         switch(mode) {
	         /*
	          * 각 case에서는 해당 클래스로 객체를 생성해 .getUserInput() 메서드로 입력을 받고,
	          * .calculate() 메서드로 .value에 결과값을 저장하며 결과값을 출력한다.
	          */
	         case DEW_POINT:
	            DewPointCalculator.printTable();
	            
	            DewPointCalculator dp = new DewPointCalculator();
	            dp.getUserInput();
	            dp.calculate();
	            System.out.printf("Dew Point : %.1fF\n", dp.getValue());
	            break;
	            
	         case WIND_CHILL_TEMPERATURE:
	            WindChillTemperatureCalculator.printTable();
	            
	            WindChillTemperatureCalculator wct = new WindChillTemperatureCalculator();
	            wct.getUserInput();
	            wct.calculate();
	            System.out.printf("Wind Chill Temperature : %.1fF", wct.getValue() );
	            System.out.print("["+ WindChillTemperatureIndex.getIndex(wct.getValue()) + "]\n");
	            break;
	            
	         case HEAT_INDEX:
	            HeatIndexCalculator.printTable();
	            
	            HeatIndexCalculator hi = new HeatIndexCalculator();
	            hi.getUserInput();
	            hi.calculate();
	            System.out.printf("Heat Index : %.1fF", hi.getValue() );
	            System.out.print("["+ HeatIndex.getIndex(hi.getValue()) + "]\n");
	            break;
	         }
	         
	      }
	 }
	
	public static void main(String[] args) {
		System.out.println("기본 weatherData를 이용한 <이슬점>, <체감온도>, <열지수> 값_\n");
		for(double[] trv : weatherData) {
			System.out.printf("<온도: %.0fF, 상대습도: %.0f%%, 풍속: %.0fmph>\n", trv[0], trv[1], trv[2]);
			calculate(Mode.DEW_POINT, trv, false);
			calculate(Mode.WIND_CHILL_TEMPERATURE, trv, false);
			calculate(Mode.HEAT_INDEX, trv, false);
			System.out.println("\n");
		}
		
		do {
			System.out.println("================================================================================");
			System.out.println("DEW_POINT, WIND_CHILL_TEMPERATURE, HEAT_INDEX 를 계산하는 프로그램입니다.");
			System.out.println("_____Menu_____");
			System.out.println("# 1. get DEW_POINT ");
			System.out.println("# 2. WIND_CHILL_TEMPERATURE ");
			System.out.println("# 3. HEAT_INDEX ");
			System.out.print("원하는 메뉴의 숫자를 입력하시오(EX_ 2) : ");
			
			calculate(Mode.getMode(UserInput.getIntegerBetween(1, 3) ), null, true);
			
		} while (!UserInput.getExitKey());

	}

}
