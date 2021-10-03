package duck;

public class RubberDuck extends Duck{
	public RubberDuck() {
		setQuackBehavior(new Squack());
	}
	
	@Override
	public void display() {
		System.out.println("Rubber Duck\n");
	}
}
