
enum WindChillTemperatureIndex {
	EXTREME_DANGER("-75.0"), DANGER("-50.0"), WARNING("-15.0"), CAUTION("15.0"), AWARE("32.0");
	private double value;
	private WindChillTemperatureIndex(String _value) {
		this.value = Double.parseDouble(_value);
	}
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}	
}

enum HeatIndex {
	EXTREME_DANGER("130.0"), DANGER("105.0"), EXTREME_CAUTION("90.0"), CAUTION("80.0");
	private double value;
	private HeatIndex(String _value) {
		this.value = Double.parseDouble(_value);
	}
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
}

enum Mode {
	DP, WCT, HI
}

public class Lab3 {
	
	static double[][] weatherData = { 
			{110, 100, 0}, // fahrenheit, relative humidity, wind velocity
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

	static void calculate(Mode mode, double[] data, boolean userInput) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
