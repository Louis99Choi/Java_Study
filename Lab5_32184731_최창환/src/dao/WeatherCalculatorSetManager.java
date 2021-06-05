package dao;

import java.util.HashSet;
import java.util.Set;

import dto.WeatherCalculator;

public class WeatherCalculatorSetManager {
	private Set<WeatherCalculator> calculators = null;

	public WeatherCalculatorSetManager() {
		this.calculators = new HashSet<>();
	}
}
