// Java21-2-HW3-32184731-최창환

import java.util.ArrayList;

public class ListDisplay implements DisplayElement, Observer{

	private ArrayList<Animal> animalsInListDisplay;
	
	public ListDisplay(AnimalKingdom animalKingdom) {
		this.animalsInListDisplay = animalKingdom.getAnimals();
	}

	
	@Override
	public void onAdded(Animal animal) {
		//this.animalsInListDisplay.add(animal);  // List 객체의 얕은 복사로 실행 시 중복 추가됨.
		display();
	}

	@Override
	public void onRemoved(Animal animal) {
		int i = this.animalsInListDisplay.indexOf(animal);
		if (i >= 0) this.animalsInListDisplay.remove(i);
		display();
	}

	@Override
	public void display() {
		System.out.println("\n===== Raw List of Animals =====");
		
		AnimalKingdom.sleepThread_1To5secs(); // Thread.sleep() 을 이용한 랜덤 시간 차 생성
		
		for(Animal animal : this.animalsInListDisplay) {
			System.out.println("[ Name : " + animal.getName() + ", Move : " + animal.getMove() +
					", Breath : " + animal.getBreath() + ", Reproduce : " + animal.getReproduce() +
					", Number Of Legs : " + animal.getNumberOfLegs() + ", Animal Type : " + 
					animal.type() + " ]");
		}
		
		System.out.println("===== End of Sorted List ======");

	}


	@Override
	public String toString() {
		return "ListDisplay";
	}
	
	

}
