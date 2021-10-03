
public class Bird extends Animal {

	public Bird(String name, String move, String breath, String reproduce, int numberOfLegs) {
		super(name, move, breath, reproduce, numberOfLegs);
	}

	@Override
	public AnimalType type() {
		return AnimalType.BIRD;
	}

}
