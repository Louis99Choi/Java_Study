
public class AllInOnePrinter2 implements IPrinter, IFax, IScanner {

	@Override
	public void print() {
		System.out.println("print..");		
	}

	@Override
	public void fax() {
		System.out.println("fax..");
	}

	@Override
	public void scan() {
		System.out.println("scan..");
	}

}
