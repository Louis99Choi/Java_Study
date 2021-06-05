package dao;

import java.util.ArrayList;
import java.util.List;

import dto.WeatherCalculator;

public class WeatherCalculatorListManager {
	private List<WeatherCalculator> calculators = null;

	public WeatherCalculatorListManager() {
		this.calculators = new ArrayList<>();
	}
}
