
public class PushDoor extends Door {

	@Override
	public void open() {
		pushOpen();
	}

	public void pushOpen() {
		System.out.println("push to open push door");
	}

}
