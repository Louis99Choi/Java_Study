
public class ForecastDisplay implements Observer, DisplayElement {
	private Subject weatherData;
	
	public ForecastDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this); // register forecast display
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		display();
	}

	@Override
	public void display() {
		System.out.println("forecast..");
	}


}
