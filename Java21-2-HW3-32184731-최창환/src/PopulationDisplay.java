// Java21-2-HW3-32184731-��âȯ

public class PopulationDisplay implements DisplayElement, Observer{

	private int numOfAnimals;
	
	public PopulationDisplay(AnimalKingdom animalKingdom) {
		this.numOfAnimals = animalKingdom.getAnimals().size();
	}

	
	@Override
	public void onAdded(Animal animal) {
		numOfAnimals++;
		display();
	}

	@Override
	public void onRemoved(Animal animal) {
		numOfAnimals--;
		display();
	}

	@Override
	public void display() {
		System.out.println("\n====== Population of Animal Kingdom ======");
		AnimalKingdom.sleepThread_1To5secs(); // Thread.sleep() �� �̿��� ���� �ð� �� ����
		System.out.println("[ Population : " + this.numOfAnimals + " ]");
	}


	@Override
	public String toString() {
		return "PopulationDisplay";
	}
	
	

}
