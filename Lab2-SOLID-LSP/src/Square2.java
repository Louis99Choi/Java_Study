
public class Square2 implements Shape {
	private int length;
	
	public Square2(int length) {
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public int getArea() {
		return length * length;
	}

	@Override
	public int getPerimeter() {
		return 4 * length;
	}
}
