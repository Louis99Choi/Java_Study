package duck;

public class RedheadDuck extends Duck{
	public RedheadDuck() {
		setQuackBehavior(new Quack());
		setFlyBehavior(new FlyWithWings());
	}
	
	@Override
	public void display() {
		System.out.println("Readhead Duck\n");
	}
}
