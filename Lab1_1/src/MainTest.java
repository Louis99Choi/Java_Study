
public class MainTest {

	public static void main(String[] args) {
		AmphibiousVehicle car = new AmphibiousVehicle(new DrivableBehavior(), new FloatableBehavior());
		
		System.out.println(car.name());
		car.fillGas(new Gas());
		car.move();
		car.setStatus(Status.WATER);
		
		System.out.println(car.getStatus());
		car.move();

	}

}
