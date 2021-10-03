// Java21-2-HW3-32184731-��âȯ

import java.util.ArrayList;

// [Add my Code] toString() ���� ���ڿ� ���� ���Ҹ� List���� ��ȯ�ϴ� �޼��带 ���� Ŭ����
public class FindInstance {
	
	// ����Ʈ ��ü�� ã�� ���� ������ �̸� String �� ���ڷ� �޾Ƽ� �ش��ϴ� ����Ʈ ������ ���� ��ü�� ��ȯ�ϴ� �޼���.
	public static Animal findAnimalInList(ArrayList<Animal> animals, String name) {
		int index = 0;
		
		for(Animal animal : animals) {
			if (animal.getName() == name) { return animal; }
			else { index++; }
		}
		
		if (index == animals.size()) { 
			System.out.println("== !! There is no [" + name + "] in Animal List");
		}
		
		return null;
	}
	
	// ����Ʈ ��ü�� ã�� ���� Observer�� �̸� String �� ���ڷ� �޾Ƽ� �ش��ϴ� Observer ��ü�� ��ȯ�ϴ� �޼���.
	public static Observer findObserverInList(ArrayList<Observer> observers, String name) {
		int index = 0;
		
		for(Observer observer : observers) {
			if (observer.toString() == name) { return observer; }
			else { index++; }
		}
		
		if (index == observers.size()) { 
			System.out.println("== !! There is no [" + name + "] in Observer List !! ==");
		}
		
		return null;
	}
	
	
}
