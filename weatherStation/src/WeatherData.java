
import java.util.ArrayList;

public class WeatherData implements Subject {
	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		this.observers = new ArrayList<>();
	}
	
	
	public float getTemperature() {
		return temperature;
	}


	public float getHumidity() {
		return humidity;
	}


	public float getPressure() {
		return pressure;
	}

	// set measurements (temperature, humidity, pressure)
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}

	@Override
	public void registerObserver(Observer o) {
		this.observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = this.observers.indexOf(o);
		if (i >= 0) this.observers.remove(i);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : this.observers) {
			observer.update(temperature, humidity, pressure);
		}
	}

}
