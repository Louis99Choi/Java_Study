
public class MainTest {
	// ISP - Interface Segregation Principle
	// �� Ŭ������ �ڽ��� ��������ʴ� �������̽��� �������� ���ƾ� �Ѵ�. 
	// �ϳ��� �Ϲ����� �������̽����� �������� ��ü���� �������̽��� ����.
	public static void main(String[] args) {
		// example of ISP violation
		AllInOnePrinter a = new AllInOnePrinter();
		a.print();
		a.fax();
		a.scan();
		EconomicPrinter b = new EconomicPrinter();
		b.print();
		
		// example of ISP
		AllInOnePrinter2 a2 = new AllInOnePrinter2();
		a2.print();
		a2.fax();
		a2.scan();
		EconomicPrinter2 b2 = new EconomicPrinter2();
		b2.print();
	}

}
