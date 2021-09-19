
public abstract class Vehicle {
	public void fillGas(Gas gas){
		System.out.println("fill " + gas.getClass().getName());
	}
	
	public abstract void move();
	public abstract String name();

}
