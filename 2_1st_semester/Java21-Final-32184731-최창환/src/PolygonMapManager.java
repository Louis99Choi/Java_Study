// �ڹ����α׷���_1�й�_2021_06_09_��âȯ_32184731

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

// # 7
public class PolygonMapManager {
	private Map<PolygonType, Polygon> polygons = null;

	// ������.
	public PolygonMapManager() {

		this.polygons = new HashMap<PolygonType, Polygon>();
	}

	// �ʿ� ���� �߰�
	public void add(Polygon c) {

		polygons.put(c.type, c);
	}

	// �ʿ��� ���ڷ� ���� �ٰ��� ��ü�� ������ ����(key���� ����) Polygon ��� ����
	public void remove(Polygon c) {

		polygons.remove(c.type);
	}

	// ���� (key, value) ���� ������ ��ȯ
	public int size() {

		return polygons.size();
	}

	// �ʿ��� type�� ���εǴ� Value �� ù��° Polygon ��ü�� ��ȯ.
	public Polygon get(PolygonType type) {

		return polygons.get(type);
	}

	// ���ڷ� ������ �ʿ��� �����ϰ� key��(PolygonType) �ϳ��� �����ؼ� �ش� key�� ���εǴ� ù��° value(Polygon)
	// ��ȯ.
	public static Polygon getRandom(HashMap<PolygonType, Polygon> map) {
		Polygon tempPolygon = null; // ��ȯ�� Polygon ��ü�� ������ ���� �ʱ�ȭ.

		int randomIndex = (int) (Math.random() * map.keySet().size()); // 0�� map�� key�� ���� ������ ������ ����.
		int loopCount = 0; // set�� ���Ҹ� �ε��� �ϱ� ���� ����

		// �� ũ�Ⱑ 0�̶�� null���� ��ȯ.
		if (map.size() == 0)
			return null;

		// for-each������ key�� ���� ���� ��Ҹ� �ݺ�
		for (PolygonType key : map.keySet()) {
			tempPolygon = map.get(key); // tempPolygon �� ������� ��.

			if (randomIndex == loopCount)
				break;
			loopCount++;
		}

		return tempPolygon;

	}

	// ����Ʈ ��� ���� ���
	public void print() {

		// for-each������ key�� ���� ���� ��Ҹ� �ݺ�
		for (PolygonType key : polygons.keySet()) {
			System.out.println(this.get(key)); // value(polygon) ���.
		}
	}

	/*
	 * map���� �ش� predicate ���ǿ� �´� ��� polygon�� map ���·� ��ȯ. ?�� ���ϵ� ī��� super �̹Ƿ�
	 * Polygon �Ǵ� �� super Ÿ�Ը� �����ϸ� �Ű������� ���׸� �ڷ����� �ް� boolean ���� ��ȯ�ϴ� �ż��带 �������ִ� �Լ���
	 * �������̽� Predicate�� ����, ���ٽ��� �Ű������� �Է¹ް� �ν��Ͻ� map�� ���� �߿��� �ش� ���ٽ��� �����ϴ� ��ü���� ���ο�
	 * map�� �־� �� map�� ��ȯ�ϴ� �żҵ�.
	 */
	public HashMap<PolygonType, Polygon> select(Predicate<? super Polygon> predicate) {

		HashMap<PolygonType, Polygon> pMap = new HashMap<PolygonType, Polygon>(); // ���ǿ� �´� ���ҵ��� ���� ����Ʈ ����.
		Polygon tempPolygon = null; // �Ʒ��� �ݺ��� ������ ���ǿ� �����ϴ� Polygon ��ü�� ��� ������ ���� �ʱ�ȭ.
		
		/*
		 * for-each������ key�� ���� ���� ��Ҹ� �ݺ��ϸ� �ش� key�� ���ε� ��ü�� predicate�� �����ϴ��� Ȯ�� �� 
		 * �����ϸ� ���ο� map�� pMap�� ��ҷ� �߰�.
		 */
		for (PolygonType key : polygons.keySet()) {
			tempPolygon = polygons.get(key); // tempPolygon �� ��� ����.

			if (predicate.test(tempPolygon)) pMap.put(tempPolygon.type, tempPolygon); 
		}

		return pMap;
	}

}
