// Java21-2-HW3-32184731-��âȯ
import java.util.ArrayList;
import java.util.Collections;

public class SurveyDisplay implements DisplayElement, Observer{

	private ArrayList<Animal> animals;
	
	public SurveyDisplay(AnimalKingdom animalKingdom) {
		this.animals = animalKingdom.getAnimals();
		
		// ����Ʈ�� ���� ���� ������ display() ����� sorting �ؾ���.
		//Collections.sort(this.animals,(a1, a2) -> (a1.type().ordinal() - a2.type().ordinal() ) );
	}
	
	
	@Override
	public void onAdded(Animal animal) {
		//this.animals.add(animal);  // List ��ü�� ���� ����� ���� �� �ߺ� �߰���.
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
		
		// ����Ʈ�� ���� ���� ������ display() ����� sorting �ؾ���.
		// Animal Type �� ����� ordinal() ���� 0,1,2,3,4 int�� ���� ��������
		// comparator�� ���ٽ����� �͸� Ŭ������ ���� �������̵��ϰ� this.animals�� ����.
		Collections.sort(this.animals,(a1, a2) -> (a1.type().ordinal() - a2.type().ordinal() ) );
		
		AnimalKingdom.sleepThread_1To5secs(); // Thread.sleep() �� �̿��� ���� �ð� �� ����
		
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
