// Lab5_32184731_최창환

package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import dto.WeatherCalculator;

/*
 * 리스트를 인스턴스로 하는 클래스로
 */
public class WeatherCalculatorListManager {
	private List<WeatherCalculator> calculators = null;

	public WeatherCalculatorListManager() {
		this.calculators = new ArrayList<WeatherCalculator>();
	}
	
	// 리스트에 새로 추가
	public void add(WeatherCalculator c) {
		calculators.add(c);
	}

	// 리스트에서 해당 calculator 삭제
	public void remove(WeatherCalculator c) {
		calculators.remove(c);
	}
	
	// 리스트에서 index에 calculator로 교체
	public void set(int index, WeatherCalculator c) {
		calculators.set(index, c);
	}

	// 리스트에서 index의 calculator 반환
	public WeatherCalculator get(int index) {
		return calculators.get(index);
	}

	// 리스트에서 해당 calculator의 index 반환
	public int indexOf(WeatherCalculator c) {
		return calculators.indexOf(c);
	}

	// 리스트의 원소 개수를 반환
	public int size() {
		return calculators.size();
	}

	// 리스트 모든 원소 출력
	public void print() {
		Iterator<WeatherCalculator> iterator = calculators.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	/*
	 *  리스트에서 해당 predicate 조건에 맞는 모든 calculator 리스트 반환.
	 *  ?는 와일드 카드로 super 이므로 WeatherCalculator 또는 그 super 타입만 가능하며
	 *  매개변수에 제네릭 자료형을 받고 boolean 값을 반환하는 매서드를 가지고있는 함수형 인터페이스 
	 *  Predicate에 의해 람다식을 매개변수로 입력받고 인스턴스 리스트의 원소 중에서 해당 람다식을 만족하는
	 *  객체만을 새로운 리스트에 넣어 그 리스트를 반환하는 매서드.   
	 */
	public List<WeatherCalculator> select(Predicate<? super WeatherCalculator> predicate) {
		
		// 인스턴스 리스트 calculators에 대한 Iterator 객체 생성
		Iterator<WeatherCalculator> iterator = calculators.iterator();

		List<WeatherCalculator> pList = new ArrayList<WeatherCalculator>();
		
		/*
		 *  iterator로 리스트의 모든 원소에 대해 predicate를 만족하는지 
		 *  확인 후 만족하면 새로운 리스트 pList에 원소로 추가.
		 */
		while(iterator.hasNext()) {
			WeatherCalculator a = iterator.next();
			if(predicate.test(a)) pList.add(a); 
		}
		
		return pList;
	}

	// 인자로 넘겨준 리스트에서 랜덤하게 하나 선택해서 반환
	public static WeatherCalculator getRandom(List<WeatherCalculator> list) {
		int randomIndex = (int) (Math.random() * list.size());
		
		if(list.size() == 0) return null;
		
		return list.get(randomIndex);
	}
}
