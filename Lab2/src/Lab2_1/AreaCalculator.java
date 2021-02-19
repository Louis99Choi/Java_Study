package Lab2_1;

public class AreaCalculator {

	static final int CIRCLE = 0; // circle
	static final int RECTANGLE = 1; // rectangle
	static final int TRIANGLE = 2; // triangle
	static final int TRAPEZOID = 3; // trapezoid
	
	static double circleArea(double radius) {
		return Math.PI * radius * radius;
	}
	static double rectangleArea(double length, double width) {
		return (length * width);
	}
	static double triangleArea(double bottom, double height) {
		return (bottom * height) / 2.0;
	}
	static double trapezoidArea(double top, double bottom, double height) {
		return ((top + bottom) * height) / 2.0;
	}
}
