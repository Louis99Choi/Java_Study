package Shapes;

import java.util.Scanner;


public class Rectangle {
	public double Length;
	public double Width;
	
	public double RectangleArea(double length, double width) {
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

	public static void main(String[] args) {
		
		Rectangle rec = new Rectangle();
		rec.RecInfoCmd();
		rec.InputRecInfo();
		rec.OutputRecArea(rec.RectangleArea(rec.Length, rec.Width));
		
	}

}
