
public class AmphibiousVehicle extends Vehicle implements Drivable, Floatable {

	private Status status;
	
	public AmphibiousVehicle() {
		super();
		this.status = Status.LAND;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public void move() {
		if(status == Status.LAND)
			driveInLand();
		
		else if(status == Status.WATER)
			floatOnWater();
	}

	@Override
	public String name() {
		return "AmphibiousVehicle";
	}

	@Override
	public void driveInLand() {
		System.out.println("It drives in land.");
		
	}

	@Override
	public void floatOnWater() {
		System.out.println("It floats on water.");
	}

}
