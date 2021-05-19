
public abstract class WeatherCalculator {
	protected double value;
	
	public final void process() {
		printTable();
		getUserInput();
		calculate();
		System.out.println(this);
	}
	
	protected abstract void printTable();
	protected abstract void getUserInput();
	protected abstract void calculate();
}
