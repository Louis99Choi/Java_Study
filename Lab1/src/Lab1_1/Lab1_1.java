package Lab1_1;

import java.util.Scanner;

public class Lab1_1 {

	public static void main(String[] args) {
		
		Circle cir = new Circle();
		cir.CircleInfoCmd();
		cir.InputCircleInfo();
		cir.OutputCircleArea(cir.CircleArea(cir.Radius));

		Rectangle rec = new Rectangle();
		rec.RecInfoCmd();
		rec.InputRecInfo();
		rec.OutputRecArea(rec.RectangleArea(rec.Length, rec.Width));
		
		Trapezoid trap = new Trapezoid();
		trap.TrapInfoCmd();
		trap.InputTrapInfo();
		trap.OutputTrapArea(trap.TrapezoidArea(trap.Top, trap.Bottom, trap.Height));
		
	}

}

class Circle {
	
	public final static double PI = 3.14;
	public double Radius;
	
	public static double CircleArea(double r) {
		return (PI * r * r);
	}
	
	public void CircleInfoCmd() {
		System.out.printf("���� �������� �Է��Ͻÿ� : ");
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
}

class Rectangle {
	public double Length;
	public double Width;
	
	public static double RectangleArea(double length, double width) {
		return (length * width);
	}
	public void RecInfoCmd() {
		System.out.printf("\n���簢���� ���ο� ���θ� ��ĭ���� �����Ͽ� �Է��Ͻÿ� : ");
		return;
	}
	public void InputRecInfo() {
		Scanner Input_RecInfo = new Scanner(System.in);
		Length = Input_RecInfo.nextDouble();
		Width = Input_RecInfo.nextDouble();
		return;
	}
	
	public void OutputRecArea(double area) {
		System.out.printf("���簢���� ���̴� %.3f �Դϴ�.\n", area);
		return;
	}
}

class Trapezoid {
	public double Top;
	public double Bottom;
	public double Height;
	
	public static double TrapezoidArea(double top, double bottom, double height) {
		return ((top + bottom) * height) / 2.0;
	}

	public void TrapInfoCmd() {
		System.out.printf("\n��ٸ����� ����, �Ʒ����� ���̿� ���̸� ��ĭ���� �����Ͽ� �Է��Ͻÿ� : ");
		return;
	}
	public void InputTrapInfo() {
		Scanner Input_TrapInfo = new Scanner(System.in);
		Top = Input_TrapInfo.nextDouble();
		Bottom = Input_TrapInfo.nextDouble();
		Height = Input_TrapInfo.nextDouble();
		return;
	}
	
	public void OutputTrapArea(double area) {
		System.out.printf("��ٸ����� ���̴� %.3f �Դϴ�.\n", area);
		return;
	}
}
