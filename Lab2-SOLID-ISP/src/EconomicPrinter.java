// ISP violation example
public class EconomicPrinter implements IDevice {

	@Override
	public void print() {
		System.out.println("print..");		
	}

	@Override
	public void fax() {
		// not supported		
	}

	@Override
	public void scan() {
		// not supported		
	}

}
