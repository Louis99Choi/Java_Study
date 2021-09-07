package Lab1_3;

import java.util.Scanner;


import Shapes.*;

public class Lab1_3 {

	public static void main(String[] args) {
		String shape;
		Loop1 : while(true) {
			System.out.println("--------------------------------------------");
			System.out.println("��, ���簢��, ��ٸ����� ���̸� �����ִ� ���α׷��Դϴ�.");
			System.out.println("�Է� ����1) CIRCLE 5");
			System.out.println("�Է� ����2) RECTANGLE 3 5");
			System.out.println("�Է� ����3) TRAPEZOID 3 4 5");
			System.out.println("--------------------------------------------");
			System.out.printf("������ �Է��Ͻÿ�(���α׷��� �������� X�� �Է��Ͻÿ�) : ");
			
			Scanner Shape_Info = new Scanner(System.in);
			shape = Shape_Info.next();
			
			switch (shape) {
			case "CIRCLE" :
				Circle cir = new Circle();
				cir.Radius = Shape_Info.nextDouble();
				cir.OutputCircleArea(cir.CircleArea(cir.Radius));
				System.out.println();
				break;
				
			case "RECTANGLE" :
				Rectangle rec = new Rectangle();
				rec.Length = Shape_Info.nextDouble();
				rec.Width = Shape_Info.nextDouble();
				rec.OutputRecArea(rec.RectangleArea(rec.Length, rec.Width));
				System.out.println();
				break;
				
			case "TRAPEZOID" :
				Trapezoid trap = new Trapezoid();
				trap.Top = Shape_Info.nextDouble();
				trap.Bottom = Shape_Info.nextDouble();
				trap.Height = Shape_Info.nextDouble();
				trap.OutputTrapArea(trap.TrapezoidArea(trap.Top, trap.Bottom, trap.Height));
				System.out.println();
				break;
				
			case "X" :
				System.out.println("���α׷��� �����մϴ�.");
				break Loop1;
			
			default :
				System.out.println("���� ������ �߸��Ǿ����ϴ�, �ٽ� �Է��Ͻÿ�.\n");
				System.out.println("--------------------------------------------");
			}
			

		}

	}

}

