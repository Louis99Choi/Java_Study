
public class MainTest {

	// DIP - Dependency Inversion Principle 
	// 추상성이 높은 클래스에 의존해야 한다. 쉽게 말해 상위 클래스가 하위 클래스를 의존해서는 안된다는 것이다.
	// 의존 관계를 맺을 때 변화하기 쉬운 것 또는 자주 변화하는 것보다는 변화하기 어려운 것, 거의 변화가 없는 것에 의존하라는 것이다. 
	// 구체적인 클래스보다 인터페이스나 추상 클래스와 관계를 맺으라는 것이다.
	public static void main(String[] args) {
		// example of DIP violation
		StreamingService service = new StreamingService();
		System.out.println(service.stream());
		service.setMelonMusic(new MelonMusic());
		System.out.println(service.stream(Music.MELON));
		
		// example of DIP
		Streaming2 service2 = new BugsMusic2();
		System.out.println(service2.stream());
		service2 = new MelonMusic2();
		System.out.println(service2.stream());
	}
}
