
public class AutomaticDoor extends Door {

	@Override
	public void open() {
		pressOpen();
	}

	public void pressOpen() {
		System.out.println("press button to open automatic door");
	}

}
