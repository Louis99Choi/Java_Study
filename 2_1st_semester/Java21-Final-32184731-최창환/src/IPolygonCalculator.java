// 자바프로그래밍_1분반_2021_06_09_최창환_32184731

public interface IPolygonCalculator {
	abstract double getArea(); // 다각형의 넓이
	abstract double getPerimeter(); // 다각형의 둘레
	abstract boolean isRegular(); // 정다각형인지의 여부
	abstract void getUserInput(); // 사용자로부터 다각형을 구성할 points 입력 받음
	
}
