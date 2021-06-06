package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import dto.WeatherCalculator;

public class WeatherCalculatorListManager {
	private List<WeatherCalculator> calculators = null;

	public WeatherCalculatorListManager() {
		this.calculators = new ArrayList<WeatherCalculator>();
	}
	
	// 리스트에 새로 추가
	public void add(WeatherCalculator c) {
		calculators.add(c);
	}

	public void remove(WeatherCalculator c) {// 리스트에서 해당 calculator 삭제
		calculators.remove(c);
	}

	public void set(int index, WeatherCalculator c) {// 리스트에서 index에 calculator로 교체
		calculators.set(index, c);
	}

	public WeatherCalculator get(int index) {// 리스트에서 index의 calculator 반환
		return calculators.get(index);
	}

	public int indexOf(WeatherCalculator c) {// 리스트에서 해당 calculator의 index 반환
		return calculators.indexOf(c);
	}

	public int size() {
		return calculators.size();
	}

	public void print() {
		Iterator<WeatherCalculator> iterator = calculators.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public List<WeatherCalculator> select(Predicate<? super WeatherCalculator> predicate) {
		// 리스트에서 해당 predicate 조건에 맞는 모든 calculator 리스트 반환
		
		Iterator<WeatherCalculator> iterator = calculators.iterator();
		List<WeatherCalculator> pList = new ArrayList<WeatherCalculator>();
		
		while(iterator.hasNext()) {
			WeatherCalculator a = iterator.next();
			if(predicate.test(a)) pList.add(a);
		}
		
		return pList;
	}

	public static WeatherCalculator getRandom(List<WeatherCalculator> list) {// 인자로 넘겨준 리스트에서 랜덤하게 하나 선택해서 반환
		int randomIndex = (int) (Math.random() * list.size());
		
		if(list.size() == 0) return null;
		
		return list.get(randomIndex);
	}
}
