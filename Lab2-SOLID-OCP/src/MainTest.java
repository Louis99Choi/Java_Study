
public class MainTest {

	public static void main(String[] args) {
		// OCP violation
		System.out.println("version1 - ifelseif");
		Door[] doors = {new PushDoor(), new AutomaticDoor(), new KnobDoor(), new SlidingDoor() };
		for (Door door : doors) {
			if (door instanceof AutomaticDoor) {
				((AutomaticDoor)door).pressOpen();
			} else if (door instanceof KnobDoor) {
				((KnobDoor)door).twistOpen();
			} else if (door instanceof SlidingDoor) {
				((SlidingDoor)door).slideOpen();
			} else if (door instanceof PushDoor) {
				((PushDoor)door).pushOpen();
			}	
		}
		
		// OCP
		System.out.println("\nversion2 - polymorphism");
		for (Door door : doors) {
			door.open();
		}
	}

}
