// Java21-2-HW3-32184731-√÷√¢»Ø
public class Fish extends Animal {

	public Fish(String name, String move, String breath, String reproduce, int numberOfLegs) {
		super(name, move, breath, reproduce, numberOfLegs);
	}

	@Override
	public AnimalType type() {
		return AnimalType.FISH;
	}

}
