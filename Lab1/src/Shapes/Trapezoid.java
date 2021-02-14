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
	
	public static void main(String[] args) {
		
		Trapezoid trap = new Trapezoid();
		trap.TrapInfoCmd();
		trap.InputTrapInfo();
		trap.OutputTrapArea(trap.TrapezoidArea(trap.Top, trap.Bottom, trap.Height));
		
	}
	
}

