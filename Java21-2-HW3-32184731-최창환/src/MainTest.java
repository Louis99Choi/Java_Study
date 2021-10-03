// Java21-2-HW3-32184731-��âȯ
public class MainTest {

	public static void main(String[] args) {

		AnimalKingdom animalKingdom = new AnimalKingdom();
		System.out.println("Java21-2-HW3-32184731-��âȯ _ Observer ����");
		
		animalKingdom.addAnimal(new Fish("Salman", "swim", "gills", "lay eggs", 0));
		animalKingdom.addAnimal(new Mammal("Dog", "walk", "lungs", "live birth", 4));
		animalKingdom.addAnimal(new Amphibian("Frog", "walk & swim", "lungs & gills", "lay eggs", 4));
		animalKingdom.addAnimal(new Mammal("Human", "walk", "lungs", "live birth", 2));
		animalKingdom.addAnimal(new Mammal("Whale", "swim", "lungs", "live birth", 0));
		animalKingdom.addAnimal(new Bird("Ostrich", "walk", "lungs", "lay eggs", 2));
		animalKingdom.addAnimal(new Reptile("Turtle", "walk", "lungs", "lay eggs", 4));
		animalKingdom.addAnimal(new Reptile("Snake", "walk", "lungs", "lay eggs", 0));
		
		// Observer ����Ʈ�� Observer ��ü�� �߰�.
		animalKingdom.addObserver(new ListDisplay(animalKingdom));
		animalKingdom.addObserver(new PopulationDisplay(animalKingdom));
		animalKingdom.addObserver(new SurveyDisplay(animalKingdom));
		
		animalKingdom.printObserverList(); // ���� ��� ���� Observer ���.
		
		// "Eagle" �̶�� �̸��� ���� ������ ����Ʈ�� �߰�.
		animalKingdom.addAnimal(new Bird("Eagle", "fly", "lungs", "lay eggs", 2));
		
		// "Human" �̶�� �̸��� ������ ����Ʈ���� ����
		animalKingdom.removeAnimal(FindInstance.findAnimalInList(animalKingdom.getAnimals(), "Human"));
		
		// ListDisplay Observer�� ����Ʈ���� ����
		animalKingdom.removeObserver(FindInstance.findObserverInList(animalKingdom.getObservers(), "ListDisplay"));
		
		animalKingdom.printObserverList(); // ���� ��� ���� Observer ���.

		// "Dog" �̶�� �̸��� ������ ����Ʈ���� ����
		animalKingdom.removeAnimal(FindInstance.findAnimalInList(animalKingdom.getAnimals(), "Dog"));
		
		
		// [Add my Code] 
		animalKingdom.printAnimalList(); // Raw List ���. (�� �ڵ忡�� �����ؼ� ���ٰ� �˸��� ���)
		animalKingdom.printPopulationNumber(); // ���� �� ���.
		animalKingdom.printSortedAnimalList(); // Type �������� ������ List ���.
	}

}
