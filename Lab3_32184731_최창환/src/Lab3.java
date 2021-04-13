//ü���µ� ���� ������ ���� ����� ��� ������ �ٸ��� �ϱ� ���� ����� ������ ���� ����
enum WindChillTemperatureIndex {
	
	EXTREME_DANGER("-75.0"), DANGER("-50.0"), WARNING("-15.0"), 
	CAUTION("15.0"), AWARE("32.0"), NEGLIGIBLE("32.0");
	
	private double value; //�������� �ν��Ͻ� ���� ����
	private WindChillTemperatureIndex(String _value) {
		this.value = Double.parseDouble(_value); //���ڿ��� �Ǽ��� ���������Ƿ� �ν��Ͻ� ���� value�� double������ ����ȯ�Ͽ� ����.
	}
	
	//������ ������ ������ ��谪�� ��ȯ�ϴ� �ν��Ͻ� �޼���.
	public double getValue() {
		return value;
	}
	
	//������ ������ ������ ��谪�� �缳���ϴ� �޼���.
	public void setValue(double value) {
		this.value = value;
	}
	
	/*
	 * �Ű������� ü���µ� ���� double������ �ް� �ش� ���� ���ԵǴ� ������
	 * ������ ���� WindChillTemperatureIndex ��(ex_ CAUTION)���� ��ȯ�ϴ� static �޼���.
	 */
	public static WindChillTemperatureIndex getIndex(double value) {
		return (value < EXTREME_DANGER.getValue())? EXTREME_DANGER : (value < DANGER.getValue())? DANGER : 
			 (value < WARNING.getValue())? WARNING : (value < CAUTION.getValue())? CAUTION : NEGLIGIBLE;
	}
}

//������ ���� ������ ���� ����� ��� ������ �ٸ��� �ϱ� ���� ����� ������ ���� ����
enum HeatIndex {
	
	EXTREME_DANGER("130.0"), DANGER("105.0"), EXTREME_CAUTION("90.0"), CAUTION("80.0"), NEGLIGIBLE("80.0");
	private double value;
	private HeatIndex(String _value) {
		this.value = Double.parseDouble(_value); 
		//���ڿ��� �Ǽ��� ���������Ƿ� �ν��Ͻ� ���� value�� double������ ����ȯ�Ͽ� ����.
	}
	
	//������ ������ ������ ��谪�� ��ȯ�ϴ� �ν��Ͻ� �޼���.
	public double getValue() { return value; }
	
	//������ ������ ������ ��谪�� �缳���ϴ� �޼���.
	public void setValue(double value) { this.value = value; }
	
	/*
	 * �Ű������� ������ ���� double������ �ް� �ش� ���� ���ԵǴ� ������
	 * ������ ���� HeatIndex ��(ex_ CAUTION)���� ��ȯ�ϴ� static �޼���.
	 */
	public static HeatIndex getIndex(double value) {
		 return (value >= EXTREME_DANGER.getValue())? EXTREME_DANGER : (value >= DANGER.getValue())? DANGER : 
			 (value >= EXTREME_CAUTION.getValue())? EXTREME_CAUTION : 
				 (value >= CAUTION.getValue())? CAUTION : NEGLIGIBLE;
	 }
}

/*�޴� ����â���� User���� ���� 1,2,3 �� �ϳ��� �Է� �޾� ��带 �����ϱ�����
 *������ ���� ����
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
	 * User�κ��� �޴� ���� ��ȣ�� int�� �Ű������� �޾� �� ���� �ش��ϴ� ������ Mode ������ ��ȯ�ϴ� �޼���.
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
	 * ������� �Է����� ���� ���Ҷ��� weatherData�� ���� ���� �� ��� ��� ������ �޼����
	 * if���� �̿��� userInput�� true�϶��� �Ű����� data�� null���� �ְ� ������� �Է��� ���� �ش� ���� 
	 * ���� ����ϰ� false�϶��� �Ű����� data�� weatherData�� ������ 1���� �迭�� �־� ����Ѵ�.
	 * switch���� ���� �Ű����� mode�κ��� ��� ������ �޾� �ش� ����� ���� ����Ͽ� ����Ѵ�.
	 */
	 static void calculate(Mode mode, double[] data, boolean userInput) {
	      
	      if(!userInput) {
	         switch(mode) {
	         /*
	          * ������ case���� �ش� Ŭ������ ��ü�� �����ϰ�
	          * �Ű������� �Էµ� data�� .set--() �ż���� ��ü�� �ν��Ͻ� ������ �ʱ�ȭ �� �� 
	          * .calculate() �ż���� .value �� ������� ������ �� ����Ѵ�.
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
	          * �� case������ �ش� Ŭ������ ��ü�� ������ .getUserInput() �޼���� �Է��� �ް�,
	          * .calculate() �޼���� .value�� ������� �����ϸ� ������� ����Ѵ�.
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
		System.out.println("�⺻ weatherData�� �̿��� <�̽���>, <ü���µ�>, <������> ��_\n");
		for(double[] trv : weatherData) {
			System.out.printf("<�µ�: %.0fF, ������: %.0f%%, ǳ��: %.0fmph>\n", trv[0], trv[1], trv[2]);
			calculate(Mode.DEW_POINT, trv, false);
			calculate(Mode.WIND_CHILL_TEMPERATURE, trv, false);
			calculate(Mode.HEAT_INDEX, trv, false);
			System.out.println("\n");
		}
		
		do {
			System.out.println("================================================================================");
			System.out.println("DEW_POINT, WIND_CHILL_TEMPERATURE, HEAT_INDEX �� ����ϴ� ���α׷��Դϴ�.");
			System.out.println("_____Menu_____");
			System.out.println("# 1. get DEW_POINT ");
			System.out.println("# 2. WIND_CHILL_TEMPERATURE ");
			System.out.println("# 3. HEAT_INDEX ");
			System.out.print("���ϴ� �޴��� ���ڸ� �Է��Ͻÿ�(EX_ 2) : ");
			
			calculate(Mode.getMode(UserInput.getIntegerBetween(1, 3) ), null, true);
			
		} while (!UserInput.getExitKey());

	}

}
