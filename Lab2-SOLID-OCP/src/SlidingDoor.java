
public class SlidingDoor extends Door {

	@Override
	public void open() {
		slideOpen();
	}
	
	public void slideOpen() {
		System.out.println("slide to open sliding door");
	}
}
