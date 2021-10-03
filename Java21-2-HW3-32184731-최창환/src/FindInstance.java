// Java21-2-HW3-32184731-최창환

import java.util.ArrayList;

// [Add my Code] toString() 값이 인자와 같은 원소를 List에서 반환하는 메서드를 가진 클래스
public class FindInstance {
	
	// 리스트 객체와 찾고 싶은 동물의 이름 String 을 인자로 받아서 해당하는 리스트 원소인 동물 객체를 반환하는 메서드.
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
	
	// 리스트 객체와 찾고 싶은 Observer의 이름 String 을 인자로 받아서 해당하는 Observer 객체를 반환하는 메서드.
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
