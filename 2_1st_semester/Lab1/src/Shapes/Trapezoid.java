package Shapes;

import java.util.Scanner;

public class Trapezoid {
	public double Top;
	public double Bottom;
	public double Height;
	
	public double TrapezoidArea(double top, double bottom, double height) {
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
	
	public static void main(String[] args) {
		
		Trapezoid trap = new Trapezoid();
		trap.TrapInfoCmd();
		trap.InputTrapInfo();
		trap.OutputTrapArea(trap.TrapezoidArea(trap.Top, trap.Bottom, trap.Height));
		
	}
	
}

