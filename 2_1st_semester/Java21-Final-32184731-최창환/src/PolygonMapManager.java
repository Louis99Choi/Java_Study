// 자바프로그래밍_1분반_2021_06_09_최창환_32184731

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

// # 7
public class PolygonMapManager {
	private Map<PolygonType, Polygon> polygons = null;

	// 생성자.
	public PolygonMapManager() {

		this.polygons = new HashMap<PolygonType, Polygon>();
	}

	// 맵에 새로 추가
	public void add(Polygon c) {

		polygons.put(c.type, c);
	}

	// 맵에서 인자로 받은 다각형 객체와 차수가 같은(key값이 같은) Polygon 모두 삭제
	public void remove(Polygon c) {

		polygons.remove(c.type);
	}

	// 맵의 (key, value) 쌍의 개수를 반환
	public int size() {

		return polygons.size();
	}

	// 맵에서 type과 맵핑되는 Value 중 첫번째 Polygon 객체를 반환.
	public Polygon get(PolygonType type) {

		return polygons.get(type);
	}

	// 인자로 보내준 맵에서 랜덤하게 key값(PolygonType) 하나를 선택해서 해당 key에 맵핑되는 첫번째 value(Polygon)
	// 반환.
	public static Polygon getRandom(HashMap<PolygonType, Polygon> map) {
		Polygon tempPolygon = null; // 반환할 Polygon 객체를 저장할 변수 초기화.

		int randomIndex = (int) (Math.random() * map.keySet().size()); // 0과 map의 key의 개수 사이의 랜덤한 정수.
		int loopCount = 0; // set의 원소를 인덱싱 하기 위한 변수

		// 맵 크기가 0이라면 null값을 반환.
		if (map.size() == 0)
			return null;

		// for-each문으로 key에 대해 맵의 요소를 반복
		for (PolygonType key : map.keySet()) {
			tempPolygon = map.get(key); // tempPolygon 을 백업시켜 둠.

			if (randomIndex == loopCount)
				break;
			loopCount++;
		}

		return tempPolygon;

	}

	// 리스트 모든 원소 출력
	public void print() {

		// for-each문으로 key에 대해 맵의 요소를 반복
		for (PolygonType key : polygons.keySet()) {
			System.out.println(this.get(key)); // value(polygon) 출력.
		}
	}

	/*
	 * map에서 해당 predicate 조건에 맞는 모든 polygon을 map 형태로 반환. ?는 와일드 카드로 super 이므로
	 * Polygon 또는 그 super 타입만 가능하며 매개변수로 제네릭 자료형을 받고 boolean 값을 반환하는 매서드를 가지고있는 함수형
	 * 인터페이스 Predicate에 의해, 람다식을 매개변수로 입력받고 인스턴스 map의 원소 중에서 해당 람다식을 만족하는 객체만을 새로운
	 * map에 넣어 그 map을 반환하는 매소드.
	 */
	public HashMap<PolygonType, Polygon> select(Predicate<? super Polygon> predicate) {

		HashMap<PolygonType, Polygon> pMap = new HashMap<PolygonType, Polygon>(); // 조건에 맞는 원소들을 담을 리스트 생성.
		Polygon tempPolygon = null; // 아래의 반복문 내에서 조건에 만족하는 Polygon 객체를 잠시 저장할 변수 초기화.
		
		/*
		 * for-each문으로 key에 대해 맵의 요소를 반복하며 해당 key에 맵핑된 객체가 predicate를 만족하는지 확인 후 
		 * 만족하면 새로운 map인 pMap에 요소로 추가.
		 */
		for (PolygonType key : polygons.keySet()) {
			tempPolygon = polygons.get(key); // tempPolygon 을 잠시 저장.

			if (predicate.test(tempPolygon)) pMap.put(tempPolygon.type, tempPolygon); 
		}

		return pMap;
	}

}
