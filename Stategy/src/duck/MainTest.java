package duck;

public class MainTest {
	public static void main(String[] args) {
		Duck duck1 = new MallardDuck();
		
		duck1.display();
		duck1.performQuack();
		duck1.performFly();
		
		Duck duck2 = new RubberDuck();
		duck2.display();
		duck2.performQuack();
		duck2.setFlyBehavior(new RocketPoweredFly());
		duck2.performFly();
		
		Duck duck3 = new DecoyDuck();
		duck3.display();
		duck3.performQuack();
		duck3.performFly();
		
		Duck duck4 = new RedheadDuck();
		duck4.display();
		duck4.performQuack();
		duck4.performFly();
	}

}
