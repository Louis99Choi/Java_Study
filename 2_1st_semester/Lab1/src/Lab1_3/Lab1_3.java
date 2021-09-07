package Lab1_3;

import java.util.Scanner;


import Shapes.*;

public class Lab1_3 {

	public static void main(String[] args) {
		String shape;
		Loop1 : while(true) {
			System.out.println("--------------------------------------------");
			System.out.println("원, 직사각형, 사다리꼴의 넓이를 구해주는 프로그램입니다.");
			System.out.println("입력 예시1) CIRCLE 5");
			System.out.println("입력 예시2) RECTANGLE 3 5");
			System.out.println("입력 예시3) TRAPEZOID 3 4 5");
			System.out.println("--------------------------------------------");
			System.out.printf("정보를 입력하시오(프로그램을 끝내려면 X를 입력하시오) : ");
			
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
				System.out.println("프로그램을 종료합니다.");
				break Loop1;
			
			default :
				System.out.println("도형 선택이 잘못되었습니다, 다시 입력하시오.\n");
				System.out.println("--------------------------------------------");
			}
			

		}

	}

}

