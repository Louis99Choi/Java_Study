// �ڹ����α׷���_1�й�_2021_06_09_��âȯ_32184731

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

// # 6 
public class PolygonListManager {
	
	private List<Polygon> polygons = null;

	// ������.
	public PolygonListManager() { // # 6
		this.polygons = new ArrayList<Polygon>();
	}

	// ����Ʈ�� ���� �߰�
	public void add(Polygon c) { // # 6
		polygons.add(c);
	}

	// ����Ʈ���� �ش� calculator ����
	public void remove(Polygon c) {// # 6
		polygons.remove(c);
	}

	// ����Ʈ���� index�� calculator�� ��ü
	public void set(int index, Polygon c) {// # 6
		polygons.set(index, c);
	}

	// ����Ʈ���� index�� calculator ��ȯ
	public Polygon get(int index) { // # 6
		return polygons.get(index);
	}

	// ����Ʈ���� �ش� calculator�� index ��ȯ
	public int indexOf(Polygon c) { // # 6
		return polygons.indexOf(c);
	}

	// ����Ʈ�� ���� ������ ��ȯ
	public int size() { // # 6
		return polygons.size();
	}

	// ����Ʈ ��� ���� ���
	public void print() {// # 6
		Iterator<Polygon> iterator = polygons.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	/*
	 *  ����Ʈ���� �ش� predicate ���ǿ� �´� ��� polygon�� ����Ʈ ���·� ��ȯ.
	 *  ?�� ���ϵ� ī��� super �̹Ƿ� Polygon �Ǵ� �� super Ÿ�Ը� �����ϸ�
	 *  �Ű������� ���׸� �ڷ����� �ް� boolean ���� ��ȯ�ϴ� �ż��带 �������ִ� �Լ��� �������̽� 
	 *  Predicate�� ���� ���ٽ��� �Ű������� �Է¹ް� �ν��Ͻ� ����Ʈ�� ���� �߿��� �ش� ���ٽ��� �����ϴ�
	 *  ��ü���� ���ο� ����Ʈ�� �־� �� ����Ʈ�� ��ȯ�ϴ� �ż���.   
	 */
	public List<Polygon> select(Predicate<? super Polygon> predicate) {
		// # 6
		
		Iterator<Polygon> iterator = polygons.iterator(); // �ν��Ͻ� ����Ʈ polygons�� ���� Iterator ��ü ����

		List<Polygon> pList = new ArrayList<Polygon>(); // ���ǿ� �´� ���ҵ��� ���� ����Ʈ ����.
		
		/*
		 *  iterator�� ����Ʈ�� ��� ���ҿ� ���� predicate�� �����ϴ��� 
		 *  Ȯ�� �� �����ϸ� ���ο� ����Ʈ pList�� ���ҷ� �߰�.
		 */
		while(iterator.hasNext()) {
			Polygon a = iterator.next();
			if(predicate.test(a)) pList.add(a); 
		}
		
		return pList;
	}

}
