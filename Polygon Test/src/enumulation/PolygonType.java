//�ڹ����α׷��� 1�й� 32184731 ��âȯ
//�߰���� ��ü ����_

package enumulation;

/* static �޼��� PolygonType() �Ǵ� �ν��Ͻ� �޼��� getType() �� ����
 * ����� �Է� �Ǵ� �־��� ��(��ǥ)�� ������ n ����� n���� �ΰ��� ������ �ڷ������� �����ϰų� ��ȯ��.
 */

public enum PolygonType {
	TRIANGLE(3), 
	RECTANGLE(4), 
	PENTAGON(5), 
	HEXAGON(6), 
	HEPTAGON(7), 
	OCTAGON(8);
	
	private final int type;	//enum Ŭ���� PolygonType�� �ν��Ͻ� ����.
	
	/* int�� ������ �Ű������� �޾� ��ü ������ �ν��Ͻ� ���� type�� �����ϴ� ������.
	 * ���� TRIANGLE, RECTANGLE,,,���� ���� 3,4,,,,8�̶�� ���� TYPE ��ȣ�� ����������
	 */
	private PolygonType(int type) {
		this.type = type;
	}
	
	//type�� ���� ������ set�� �ʿ� �����Ƿ� getType �� ����.
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
