
public abstract class Animal {
	protected String name;
	protected String move;
	protected String breath;
	protected String reproduce;
	protected int numberOfLegs;
	
	public Animal(String name, String move, String breath, String reproduce, int numberOfLegs) {
		this.name = name;
		this.move = move;
		this.breath = breath;
		this.reproduce = reproduce;
		this.numberOfLegs = numberOfLegs;
	}
	
	
	public String getName() {
		return name;
	}
	public String getMove() {
		return move;
	}
	public String getBreath() {
		return breath;
	}
	public String getReproduce() {
		return reproduce;
	}
	public int getNumberOfLegs() {
		return numberOfLegs;
	}

	public abstract AnimalType type();
	
	
	@Override
	public String toString() {
		return getName();
	}
	
}
