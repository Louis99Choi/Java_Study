// Java21-2-HW3-32184731-��âȯ

import java.util.ArrayList;

public class AnimalKingdom implements Subject{

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private ArrayList<DisplayElement> displays = new ArrayList<>(); // [add my_code]
	private ArrayList<Animal> animals = new ArrayList<Animal>();


	public ArrayList<Observer> getObservers() {
		return observers;
	}
	public ArrayList<DisplayElement> getDisplays() {
		return displays;
	}
	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(ArrayList<Animal> animals) {
		this.animals = animals;
	}
	
	
	// [Add my Code] Observer List�� ����ϴ� �޼���.
	public void printObserverList() {
		System.out.println("===== Observer List =====");
		for(Observer observer : this.observers) {
			System.out.println(observer.toString());
		}
	}

	// [Add my Code] DisplayElement�� Casting�� ����
	// Animal List�� ListDisplay Observer�� raw�ϰ� ����ϴ� �޼���.
	public void printAnimalList() {
		System.out.println("\n...... printAnimalList() ......");

		// ListDisplay ��ü�� �ִٸ� �����ϰ� ������ �˸��� ���.
		if(FindInstance.findObserverInList(observers, "ListDisplay") != null){
		((DisplayElement) FindInstance.findObserverInList(observers, "ListDisplay")).display();
		}else return;
	}

	// [Add my Code] DisplayElement�� Casting�� ����
	// PopulationDisplay Observer�� Animal �α����� ����ϴ� �޼���.
	public void printPopulationNumber() {
		
		// PopulationDisplay ��ü�� �ִٸ� �����ϰ� ������ �˸��� ���.
		if(FindInstance.findObserverInList(observers, "PopulationDisplay") != null){
			((DisplayElement) FindInstance.findObserverInList(observers, "PopulationDisplay")).display();
		}else return;
	}


	// [Add my Code] DisplayElement�� Casting�� ����
	// Animal List�� SurveyDisplay Observer�� Animal Type�� �������� 
	// �����Ͽ� ����ϴ� �޼���.
	public void printSortedAnimalList() {
		System.out.println("\n..... printSortedAnimalList() .....");

		// SurveyDisplay ��ü�� �ִٸ� �����ϰ� ������ �˸��� ���.
				if(FindInstance.findObserverInList(observers, "SurveyDisplay") != null){
				((DisplayElement) FindInstance.findObserverInList(observers, "SurveyDisplay")).display();
				} else return;
	}


	public void addAnimal(Animal animal) {
		System.out.println("\n... Adding [" + animal.getName() + "] ...");

		sleepThread_1To5secs(); // Thread.sleep() �� �̿��� ���� �ð� �� ����

		this.animals.add(animal);
		notifyObservers(animal, true);

		System.out.println("!!! Add [" + animal.getName() + "] Complete !!!");
	}

	public void removeAnimal(Animal animal) {
		System.out.println("\n... Removing animal ...");

		sleepThread_1To5secs(); // Thread.sleep() �� �̿��� ���� �ð� �� ����

		int i = this.animals.indexOf(animal);
		if (i >= 0) this.animals.remove(i);

		notifyObservers(animal, false);
		System.out.println("!!! Remove Animal Complete !!!");
	}


	@Override
	public void addObserver(Observer o) {	
		observers.add(o);	

		sleepThread_1To5secs(); // Thread.sleep() �� �̿��� ���� �ð� �� ����

		System.out.println("!!! Add [ " + o.toString() + " ] Observer Complete !!!");
	}

	@Override
	public void removeObserver(Observer o) {
		System.out.println("... Removing Observer ...");

		int i = this.observers.indexOf(o);
		if (i >= 0) this.observers.remove(i);
		
		sleepThread_1To5secs(); // Thread.sleep() �� �̿��� ���� �ð� �� ����

		System.out.println("!!! Remove Observer Complete !!!");
	}

	@Override
	public void notifyObservers(Animal animal, boolean flag) {
		// flag ���ڰ� true �̸� animal�� �߰�.
		if(flag) {
			// notify adding animal to Observers
			for (Observer observer : this.observers) { observer.onAdded(animal);}
		}
		// flag ���ڰ� false �̸� animal�� ����.
		else {	for (Observer observer : this.observers) { observer.onRemoved(animal); } }

	}

	public static void sleepThread_1To5secs() {
		// Thread.sleep() �� �̿��� ���� �ð� �� ����
		try {
			Thread.sleep((long) ((Math.random() + 1) * 2000) );
		} catch (InterruptedException e) { e.printStackTrace(); }
	}
}