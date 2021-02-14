package Lab2_1;

public class AreaCalculator {

	public static final int CIRCLE = 0; // circle
	public static final int RECTANGLE = 1; // rectangle
	public static final int TRIANGLE = 2; // triangle
	public static final int TRAPEZOID = 3; // trapezoid
	
	public static double circleArea(double radius) {
		return Math.PI * radius * radius;
	}
	public static double rectangleArea(double length, double width) {
		return (length * width);
	}
	public static double triangleArea(double bottom, double height) {
		return (bottom * height) / 2.0;
	}
	public static double trapezoidArea(double top, double bottom, double height) {
		return ((top + bottom) * height) / 2.0;
	}
}
