
package Shapes;
import java.util.Scanner;

public class Circle {
	
	final static double PI = 3.14;
	public double Radius;
	
	public double CircleArea(double r) {
		return (PI * r * r);
	}
	
	public void CircleInfoCmd() {
		System.out.printf("\n���� �������� �Է��Ͻÿ� : ");
		return;
	}
	public void InputCircleInfo() {
		Scanner Input_radius = new Scanner(System.in);
		Radius = Input_radius.nextDouble();
		return;
	}
	public void OutputCircleArea(double area) {
		System.out.printf("���� ���̴� %.3f �Դϴ�.\n", area);
		return;
	}
	
	public static void main(String[] args) {
		
		Circle cir = new Circle();
		cir.CircleInfoCmd();
		cir.InputCircleInfo();
		cir.OutputCircleArea(cir.CircleArea(cir.Radius));
	}
	
	
}