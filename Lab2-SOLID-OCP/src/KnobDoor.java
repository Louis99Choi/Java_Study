
public class KnobDoor extends Door {

	@Override
	public void open() {
		twistOpen();
	}

	public void twistOpen() {
		System.out.println("twist a knob to open knob door");
	}
}
