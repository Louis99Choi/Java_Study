// Java21-2-HW3-32184731-최창환
import java.util.ArrayList;
import java.util.Collections;

public class SurveyDisplay implements DisplayElement, Observer{

	private ArrayList<Animal> animals;
	
	public SurveyDisplay(AnimalKingdom animalKingdom) {
		this.animals = animalKingdom.getAnimals();
		
		// 리스트의 얕은 복사 때문에 display() 실행시 sorting 해야함.
		//Collections.sort(this.animals,(a1, a2) -> (a1.type().ordinal() - a2.type().ordinal() ) );
	}
	
	
	@Override
	public void onAdded(Animal animal) {
		//this.animals.add(animal);  // List 객체의 얕은 복사로 실행 시 중복 추가됨.
		display();
	}

	@Override
	public void onRemoved(Animal animal) {
		int i = this.animals.indexOf(animal);
		if (i >= 0) this.animals.remove(i);
		display();
	}

	@Override
	public void display() {
		System.out.println("\n===== Sorted List of Animals =====");
		
		// 리스트의 얕은 복사 때문에 display() 실행시 sorting 해야함.
		// Animal Type 의 멤버의 ordinal() 값인 0,1,2,3,4 int형 값을 기준으로
		// comparator를 람다식으로 익명 클래스를 통해 오버라이딩하고 this.animals을 정렬.
		Collections.sort(this.animals,(a1, a2) -> (a1.type().ordinal() - a2.type().ordinal() ) );
		
		AnimalKingdom.sleepThread_1To5secs(); // Thread.sleep() 을 이용한 랜덤 시간 차 생성
		
		for(Animal animal : this.animals) {
			System.out.println("[ Name : " + animal.getName() + ", Move : " + animal.getMove() +
					", Breath : " + animal.getBreath() + ", Reproduce : " + animal.getReproduce() +
					", Number Of Legs : " + animal.getNumberOfLegs() + ", Animal Type : " + 
					animal.type() + " ]");
		}
		
		System.out.println("===== End of Raw List ======");
	}


	@Override
	public String toString() {
		return "SurveyDisplay";
	}
	
	

}
