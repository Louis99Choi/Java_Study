
public class MainTest {
	// ISP - Interface Segregation Principle
	// 한 클래스는 자신이 사용하지않는 인터페이스는 구현하지 말아야 한다. 
	// 하나의 일반적인 인터페이스보다 여러개의 구체적인 인터페이스가 낫다.
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
