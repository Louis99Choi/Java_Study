package dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherData {
	protected DateFormat stringToDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	protected Date dataTime;
	protected double temperature;
	protected double relativeHumidity;
	protected double windVelocity; 
	
	public WeatherData() {
		this(null, 0.0, 0.0, 0.0);
	}
	
	public WeatherData(String dataTime, double temperature, double relativeHumidity, double windVelocity) {
		try {
			this.dataTime = stringToDateFormat.parse(dataTime);
		} catch (ParseException e) {
			this.dataTime = null;
			e.printStackTrace();
		}
		
		this.temperature = temperature;
		this.relativeHumidity = relativeHumidity;
		this.windVelocity = windVelocity;
	}
	
	public WeatherData(WeatherData data) {
		this.dataTime = data.dataTime;
		this.temperature = data.temperature;
		this.relativeHumidity = data.relativeHumidity;
		this.windVelocity = data.windVelocity;
	}
	
	public Date getDataTime() {
		return dataTime;
	}
	public void setDataTime(Date dataTime) {
		this.dataTime = dataTime;
		
	}
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
	public double getWindVelocity() {
		return windVelocity;
	}
	public void setWindVelocity(double windVelocity) {
		this.windVelocity = windVelocity;
	}
	
	@Override
	public String toString() {
		return "WeatherData [dataTime=" + dataTime + ", temperature=" + temperature + ", relativeHumidity="
				+ relativeHumidity + ", windVelocity=" + windVelocity + "]";
	}
}
