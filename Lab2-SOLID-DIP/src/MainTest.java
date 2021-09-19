
public class MainTest {

	// DIP - Dependency Inversion Principle 
	// �߻��� ���� Ŭ������ �����ؾ� �Ѵ�. ���� ���� ���� Ŭ������ ���� Ŭ������ �����ؼ��� �ȵȴٴ� ���̴�.
	// ���� ���踦 ���� �� ��ȭ�ϱ� ���� �� �Ǵ� ���� ��ȭ�ϴ� �ͺ��ٴ� ��ȭ�ϱ� ����� ��, ���� ��ȭ�� ���� �Ϳ� �����϶�� ���̴�. 
	// ��ü���� Ŭ�������� �������̽��� �߻� Ŭ������ ���踦 ������� ���̴�.
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
