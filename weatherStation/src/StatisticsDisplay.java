
import java.util.ArrayList;
import java.util.List;

public class StatisticsDisplay implements Observer, DisplayElement {
	private float minTemperature = 999;
	private float maxTemperature = -999;
	private float avgTemperature = 0;
	private List<Float> tempList = new ArrayList<>();
	private Subject weatherData;

	public StatisticsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this); // register statistics display
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		tempList.add(temperature);
		display();
	}
	
	@Override
	public void display() {
		float sumTemperature = 0;
		for (float t : tempList) {
			if (t < minTemperature) minTemperature = t;
			if (t > maxTemperature) maxTemperature = t;
			sumTemperature += t;
		}
		avgTemperature = sumTemperature/(int)tempList.size();
		System.out.println("minTemperature=" + minTemperature + " maxTemperature=" + maxTemperature + " avgTemperature=" + avgTemperature);
	}
}
