// Lab5_32184731_최창환

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

	/*
	 *  Set(집합)에서 해당 predicate 조건에 맞는 모든 calculator를 원소로 하는 Set 반환.
	 *  ?는 와일드 카드로 super 이므로 WeatherCalculator 또는 그 super 타입만 가능하며
	 *  매개변수에 제네릭 자료형을 받고 boolean 값을 반환하는 매서드를 가지고있는 함수형 인터페이스 
	 *  Predicate에 의해 람다식을 매개변수로 입력받고, 인스턴스 Set의 원소 중에서 해당 람다식을 만족하는
	 *  객체만을 새로운 Set에 넣어 그 Set를 반환하는 매서드.   
	 */
	public Set<WeatherCalculator> select(Predicate<? super WeatherCalculator> predicate) {

		// 인스턴스 Set calculators에 대한 Iterator 객체 생성
		Iterator<WeatherCalculator> iterator = calculators.iterator();
		
		HashSet<WeatherCalculator> pSet = new HashSet<WeatherCalculator>();
		
		/*
		 *  iterator로 Set의 모든 원소에 대해 predicate를 만족하는지 
		 *  확인 후 만족하면 새로운 리스트 pSet에 원소로 추가.
		 */
		while(iterator.hasNext()) {
			WeatherCalculator a = iterator.next();
			if(predicate.test(a)) pSet.add(a);
		}
		
		return pSet;
	}

	// 인자로 보내준 셋에서 랜덤하게 하나 선택해서 반환
	public static WeatherCalculator getRandom(Set<WeatherCalculator> set) {
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