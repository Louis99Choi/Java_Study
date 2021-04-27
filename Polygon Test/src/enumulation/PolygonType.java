//자바프로그래밍 1분반 32184731 최창환
//중간고사 대체 과제_

package enumulation;

/* static 메서드 PolygonType() 또는 인스턴스 메서드 getType() 를 통해
 * 사용자 입력 또는 주어진 점(좌표)의 개수가 n 개라면 n각형 인것을 열거형 자료형으로 저장하거나 반환함.
 */

public enum PolygonType {
	TRIANGLE(3), 
	RECTANGLE(4), 
	PENTAGON(5), 
	HEXAGON(6), 
	HEPTAGON(7), 
	OCTAGON(8);
	
	private final int type;	//enum 클래스 PolygonType의 인스턴스 변수.
	
	/* int형 변수를 매개변수로 받아 객체 생성시 인스턴스 변수 type에 저장하는 생성자.
	 * 위의 TRIANGLE, RECTANGLE,,,등은 각각 3,4,,,,8이라는 고유 TYPE 번호를 가지고있음
	 */
	private PolygonType(int type) {
		this.type = type;
	}
	
	//type에 대한 정보는 set할 필요 없으므로 getType 만 구현.
	public int getType() {
		return type;
	}
	
	public static PolygonType valueOf(int type) {
		switch(type) {
		case 3:
			return TRIANGLE;
		case 4:
			return RECTANGLE;
		case 5:
			return PENTAGON;
		case 6:
			return HEXAGON;
		case 7:
			return HEPTAGON;
		case 8:
			return OCTAGON;
		default:
			return null;
		}
  
  
	}
}
