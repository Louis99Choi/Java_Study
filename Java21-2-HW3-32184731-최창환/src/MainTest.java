// Java21-2-HW3-32184731-최창환
public class MainTest {

	public static void main(String[] args) {

		AnimalKingdom animalKingdom = new AnimalKingdom();
		System.out.println("Java21-2-HW3-32184731-최창환 _ Observer 패턴");
		
		animalKingdom.addAnimal(new Fish("Salman", "swim", "gills", "lay eggs", 0));
		animalKingdom.addAnimal(new Mammal("Dog", "walk", "lungs", "live birth", 4));
		animalKingdom.addAnimal(new Amphibian("Frog", "walk & swim", "lungs & gills", "lay eggs", 4));
		animalKingdom.addAnimal(new Mammal("Human", "walk", "lungs", "live birth", 2));
		animalKingdom.addAnimal(new Mammal("Whale", "swim", "lungs", "live birth", 0));
		animalKingdom.addAnimal(new Bird("Ostrich", "walk", "lungs", "lay eggs", 2));
		animalKingdom.addAnimal(new Reptile("Turtle", "walk", "lungs", "lay eggs", 4));
		animalKingdom.addAnimal(new Reptile("Snake", "walk", "lungs", "lay eggs", 0));
		
		// Observer 리스트에 Observer 객체를 추가.
		animalKingdom.addObserver(new ListDisplay(animalKingdom));
		animalKingdom.addObserver(new PopulationDisplay(animalKingdom));
		animalKingdom.addObserver(new SurveyDisplay(animalKingdom));
		
		animalKingdom.printObserverList(); // 현재 사용 가능 Observer 출력.
		
		// "Eagle" 이라는 이름을 가진 동물을 리스트에 추가.
		animalKingdom.addAnimal(new Bird("Eagle", "fly", "lungs", "lay eggs", 2));
		
		// "Human" 이라는 이름의 동물을 리스트에서 제거
		animalKingdom.removeAnimal(FindInstance.findAnimalInList(animalKingdom.getAnimals(), "Human"));
		
		// ListDisplay Observer를 리스트에서 제거
		animalKingdom.removeObserver(FindInstance.findObserverInList(animalKingdom.getObservers(), "ListDisplay"));
		
		animalKingdom.printObserverList(); // 현재 사용 가능 Observer 출력.

		// "Dog" 이라는 이름의 동물을 리스트에서 제거
		animalKingdom.removeAnimal(FindInstance.findAnimalInList(animalKingdom.getAnimals(), "Dog"));
		
		
		// [Add my Code] 
		animalKingdom.printAnimalList(); // Raw List 출력. (위 코드에서 삭제해서 없다고 알림문 출력)
		animalKingdom.printPopulationNumber(); // 동물 수 출력.
		animalKingdom.printSortedAnimalList(); // Type 기준으로 정렬한 List 출력.
	}

}
