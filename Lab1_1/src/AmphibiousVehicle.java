
public class AmphibiousVehicle extends Vehicle {
	private Status status;
	private MoveBehavior driveInLand;
	private MoveBehavior floatOnWater;
	
	public AmphibiousVehicle(MoveBehavior driveInLand, MoveBehavior floatOnWater) {
		super(driveInLand);
		this.driveInLand = driveInLand;
		this.floatOnWater = floatOnWater;
		this.status = Status.LAND;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
		
		if(status == Status.LAND) {
			setMoveBehavior(driveInLand);
		}
		else if(status == Status.WATER) {
			setMoveBehavior(floatOnWater);
		}
		
	}


	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "AmphibiousVehicle";
	}
	
}
