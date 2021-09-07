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
		System.out.printf("원의 반지름을 입력하시오 : ");
		return;
	}
	public void InputCircleInfo() {
		Scanner Input_radius = new Scanner(System.in);
		Radius = Input_radius.nextDouble();
		return;
	}
	public void OutputCircleArea(double area) {
		System.out.printf("원의 넓이는 %.3f 입니다.\n", area);
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
		System.out.printf("\n직사각형의 가로와 세로를 빈칸으로 구분하여 입력하시오 : ");
		return;
	}
	public void InputRecInfo() {
		Scanner Input_RecInfo = new Scanner(System.in);
		Length = Input_RecInfo.nextDouble();
		Width = Input_RecInfo.nextDouble();
		return;
	}
	
	public void OutputRecArea(double area) {
		System.out.printf("직사각형의 넓이는 %.3f 입니다.\n", area);
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
		System.out.printf("\n사다리꼴의 윗변, 아랫변의 길이와 높이를 빈칸으로 구분하여 입력하시오 : ");
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
		System.out.printf("사다리꼴의 넓이는 %.3f 입니다.\n", area);
		return;
	}
}
