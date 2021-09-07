package Shapes;

import java.util.Scanner;


public class Rectangle {
	public double Length;
	public double Width;
	
	public double RectangleArea(double length, double width) {
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

	public static void main(String[] args) {
		
		Rectangle rec = new Rectangle();
		rec.RecInfoCmd();
		rec.InputRecInfo();
		rec.OutputRecArea(rec.RectangleArea(rec.Length, rec.Width));
		
	}

}
