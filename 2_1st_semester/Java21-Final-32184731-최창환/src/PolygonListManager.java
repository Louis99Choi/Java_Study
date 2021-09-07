// 자바프로그래밍_1분반_2021_06_09_최창환_32184731

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

// # 6 
public class PolygonListManager {
	
	private List<Polygon> polygons = null;

	// 생성자.
	public PolygonListManager() { // # 6
		this.polygons = new ArrayList<Polygon>();
	}

	// 리스트에 새로 추가
	public void add(Polygon c) { // # 6
		polygons.add(c);
	}

	// 리스트에서 해당 calculator 삭제
	public void remove(Polygon c) {// # 6
		polygons.remove(c);
	}

	// 리스트에서 index에 calculator로 교체
	public void set(int index, Polygon c) {// # 6
		polygons.set(index, c);
	}

	// 리스트에서 index의 calculator 반환
	public Polygon get(int index) { // # 6
		return polygons.get(index);
	}

	// 리스트에서 해당 calculator의 index 반환
	public int indexOf(Polygon c) { // # 6
		return polygons.indexOf(c);
	}

	// 리스트의 원소 개수를 반환
	public int size() { // # 6
		return polygons.size();
	}

	// 리스트 모든 원소 출력
	public void print() {// # 6
		Iterator<Polygon> iterator = polygons.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	/*
	 *  리스트에서 해당 predicate 조건에 맞는 모든 polygon을 리스트 형태로 반환.
	 *  ?는 와일드 카드로 super 이므로 Polygon 또는 그 super 타입만 가능하며
	 *  매개변수에 제네릭 자료형을 받고 boolean 값을 반환하는 매서드를 가지고있는 함수형 인터페이스 
	 *  Predicate에 의해 람다식을 매개변수로 입력받고 인스턴스 리스트의 원소 중에서 해당 람다식을 만족하는
	 *  객체만을 새로운 리스트에 넣어 그 리스트를 반환하는 매서드.   
	 */
	public List<Polygon> select(Predicate<? super Polygon> predicate) {
		// # 6
		
		Iterator<Polygon> iterator = polygons.iterator(); // 인스턴스 리스트 polygons에 대한 Iterator 객체 생성

		List<Polygon> pList = new ArrayList<Polygon>(); // 조건에 맞는 원소들을 담을 리스트 생성.
		
		/*
		 *  iterator로 리스트의 모든 원소에 대해 predicate를 만족하는지 
		 *  확인 후 만족하면 새로운 리스트 pList에 원소로 추가.
		 */
		while(iterator.hasNext()) {
			Polygon a = iterator.next();
			if(predicate.test(a)) pList.add(a); 
		}
		
		return pList;
	}

}
