
public class Rectangle2 implements Shape {
	private int width;
	private int height;
		
	public Rectangle2(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public int getArea() {
		return width * height;
	}

	@Override
	public int getPerimeter() {
		return 2 * (width + height);
	}
}
