public class Lab4 {

	public static void main(String[] args) {
		
		WeatherCalculator[] calculators = new WeatherCalculator[5];
		
		System.out.println("user input..");
		
		for (int i = 0; i < calculators.length; i++) {
			System.out.print("\nPlease enter mode [1: DP, 2: WCT, 3: HI, 4: DI, 5: DE]: "); // DE는 부패지수(식중독지수) 클래스
			int mode = UserInput.getIntegerBetween(1, 5);
			
			calculators[i] = WeatherCalculatorFactory.getInstance(Mode.valueOf(mode));
			calculators[i].process();
		}
		
		System.out.println("\n\nprint..\n");
		
		for (WeatherCalculator calculator : calculators)
			System.out.println(calculator);
		
		System.out.println("\ndone..\n");
	}
}