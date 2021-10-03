// Java21-2-HW3-32184731-최창환

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
	
	
	// [Add my Code] Observer List를 출력하는 메서드.
	public void printObserverList() {
		System.out.println("===== Observer List =====");
		for(Observer observer : this.observers) {
			System.out.println(observer.toString());
		}
	}

	// [Add my Code] DisplayElement로 Casting을 통해
	// Animal List를 ListDisplay Observer로 raw하게 출력하는 메서드.
	public void printAnimalList() {
		System.out.println("\n...... printAnimalList() ......");

		// ListDisplay 객체가 있다면 실행하고 없으면 알림문 출력.
		if(FindInstance.findObserverInList(observers, "ListDisplay") != null){
		((DisplayElement) FindInstance.findObserverInList(observers, "ListDisplay")).display();
		}else return;
	}

	// [Add my Code] DisplayElement로 Casting을 통해
	// PopulationDisplay Observer로 Animal 인구수를 출력하는 메서드.
	public void printPopulationNumber() {
		
		// PopulationDisplay 객체가 있다면 실행하고 없으면 알림문 출력.
		if(FindInstance.findObserverInList(observers, "PopulationDisplay") != null){
			((DisplayElement) FindInstance.findObserverInList(observers, "PopulationDisplay")).display();
		}else return;
	}


	// [Add my Code] DisplayElement로 Casting을 통해
	// Animal List를 SurveyDisplay Observer로 Animal Type을 기준으로 
	// 정렬하여 출력하는 메서드.
	public void printSortedAnimalList() {
		System.out.println("\n..... printSortedAnimalList() .....");

		// SurveyDisplay 객체가 있다면 실행하고 없으면 알림문 출력.
				if(FindInstance.findObserverInList(observers, "SurveyDisplay") != null){
				((DisplayElement) FindInstance.findObserverInList(observers, "SurveyDisplay")).display();
				} else return;
	}


	public void addAnimal(Animal animal) {
		System.out.println("\n... Adding [" + animal.getName() + "] ...");

		sleepThread_1To5secs(); // Thread.sleep() 을 이용한 랜덤 시간 차 생성

		this.animals.add(animal);
		notifyObservers(animal, true);

		System.out.println("!!! Add [" + animal.getName() + "] Complete !!!");
	}

	public void removeAnimal(Animal animal) {
		System.out.println("\n... Removing animal ...");

		sleepThread_1To5secs(); // Thread.sleep() 을 이용한 랜덤 시간 차 생성

		int i = this.animals.indexOf(animal);
		if (i >= 0) this.animals.remove(i);

		notifyObservers(animal, false);
		System.out.println("!!! Remove Animal Complete !!!");
	}


	@Override
	public void addObserver(Observer o) {	
		observers.add(o);	

		sleepThread_1To5secs(); // Thread.sleep() 을 이용한 랜덤 시간 차 생성

		System.out.println("!!! Add [ " + o.toString() + " ] Observer Complete !!!");
	}

	@Override
	public void removeObserver(Observer o) {
		System.out.println("... Removing Observer ...");

		int i = this.observers.indexOf(o);
		if (i >= 0) this.observers.remove(i);
		
		sleepThread_1To5secs(); // Thread.sleep() 을 이용한 랜덤 시간 차 생성

		System.out.println("!!! Remove Observer Complete !!!");
	}

	@Override
	public void notifyObservers(Animal animal, boolean flag) {
		// flag 인자가 true 이면 animal을 추가.
		if(flag) {
			// notify adding animal to Observers
			for (Observer observer : this.observers) { observer.onAdded(animal);}
		}
		// flag 인자가 false 이면 animal을 제거.
		else {	for (Observer observer : this.observers) { observer.onRemoved(animal); } }

	}

	public static void sleepThread_1To5secs() {
		// Thread.sleep() 을 이용한 랜덤 시간 차 생성
		try {
			Thread.sleep((long) ((Math.random() + 1) * 2000) );
		} catch (InterruptedException e) { e.printStackTrace(); }
	}
}