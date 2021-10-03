
public class Mammal extends Animal {
	
	public Mammal(String name, String move, String breath, String reproduce, int numberOfLegs) {
		super(name, move, breath, reproduce, numberOfLegs);
	}

	@Override
	public AnimalType type() {
		return AnimalType.MAMMAL;
	}

}
