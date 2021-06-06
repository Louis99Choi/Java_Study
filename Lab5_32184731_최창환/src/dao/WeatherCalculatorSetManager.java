package dao;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
import java.util.function.Predicate;

import dto.WeatherCalculator;

public class WeatherCalculatorSetManager {
	private Set<WeatherCalculator> calculators = null;

	public WeatherCalculatorSetManager() {
		this.calculators = new HashSet<WeatherCalculator>();
	}

	// 세트에 새로 추가
	public void add(WeatherCalculator c) {
		calculators.add(c);
	}

	public void remove(WeatherCalculator c) {// 세트에서 해당 c 삭제
		calculators.remove(c);
	}

	public int size() {// 세트의 크기 반환
		return calculators.size();
	}

	public void print() {// 세트 프린트
		Iterator<WeatherCalculator> iterator = calculators.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public Set<WeatherCalculator> select(Predicate<? super WeatherCalculator> predicate) {
		// 리스트에서 해당 predicate 조건에 맞는 모든 calculator 세트 반환
		
		Iterator<WeatherCalculator> iterator = calculators.iterator();
		HashSet<WeatherCalculator> pSet = new HashSet<WeatherCalculator>();
		
		while(iterator.hasNext()) {
			WeatherCalculator a = iterator.next();
			if(predicate.test(a)) pSet.add(a);
		}
		
		return pSet;
	}

	public static WeatherCalculator getRandom(Set<WeatherCalculator> set) {// 인자로 보내준 셋에서 랜덤하게 하나 선택해서 반환
		Iterator<WeatherCalculator> iterator = set.iterator();
		int randomIndex = (int) (Math.random() * set.size());
		int loopCount = 0; // set의 원소를 인덱싱 하기 위한 변수

		if(set.size() == 0) return null;
		
		while(iterator.hasNext()) {
			if(randomIndex == loopCount) break;
			
			iterator.next(); // if문의 조건이 성립되지 않으면 iterator 객체에 다음 원소를 받아옴.
			loopCount++; // 인덱스 변수 1증가.
		}
	
		return iterator.next();
	}
}