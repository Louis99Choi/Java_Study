
public class Main {
	public static void main(String[] args) {
		
		AmphibiousVehicle car = new AmphibiousVehicle();
		
		System.out.println(car.name());
		car.move();
		car.setStatus(Status.WATER);
		
		System.out.println(car.getStatus());
		car.move();
		
	}

}
