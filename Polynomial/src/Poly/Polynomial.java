package Poly;
import java.util.*;


class UtilInput {

	static Scanner scan = new Scanner(System.in);

	// 입력 받은 값을 줄 단위로 읽어 각각 Double형과 Integer형으로 변환하는 매서드
	public static float getFloat() {	return Float.parseFloat(scan.nextLine());	}
	public static int getInteger() {	return Integer.parseInt(scan.nextLine());	}
	// 입력 받은 값을 공백 단위로 읽어 각각 Double형과 Integer형으로 변환하는 매서드
	public static float getNextFloat() {	return scan.nextFloat();	}
	public static int getNextInt() {	return scan.nextInt();	}

	/*
	 * q를 입력해 프로그램을 종료하거나 엔터키를 눌러서 계속 실행하라는 안내문과 q 를 입력 받았을 경우 안내문과 함께 프로그램을 종료하도록
	 * 각각 true와 false를 반환하는 매서드
	 */
	public static boolean getExitKey() {
		System.out.print("\nPress q-key to Exit or Enter-key to Continue: ");
		String s = scan.nextLine();
		if (s.contentEquals("q")) {
			System.out.println("====================Exit Program====================");
			return true;
		} else
			return false;
	}
}


class OperatePoly {
	int deleteCount = 0;
	
	public int findValueIndex(float[] arr, int value) {
		int valueIndex = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				valueIndex = i;
				break;
			}
			else valueIndex = -1;
		}
		
		return valueIndex;
	}
	
	public void deleteIndexMono(float[][] arr, int index) {
		for(int i=index; i<arr.length-1;i++) {
			arr[i] = arr[i+1];
		}
	}
	
	public float[][] setPoly(String input_polyName){
		int numOfPoly;
		float[][] arr = null;
		
		System.out.printf("\n%s 다항식의 계수가 0이 아닌 항의 개수 : ", input_polyName);
		numOfPoly = UtilInput.getInteger();
		arr = new float[numOfPoly][2];
		
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%s 다항식의 %d 번째 항의 지수와 계수 : ", input_polyName, i+1);
			arr[i][0] = UtilInput.getNextInt();
			arr[i][1] = UtilInput.getNextFloat();
		}
		
		//UtilInput.scan.close();
		return arr;
	}
	
	public float[][] addPoly(float[][] a, float[][] b) {
		float[][] C = null;
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<b.length; j++) {
				if((int)a[i][0] == (int)b[j][0]) {
					a[i][1] += b[j][1];
					deleteIndexMono(b, j); //b배열에서 a배열에 추가한 항 원소 삭제
					deleteCount++; //b배열에서 삭제한 항의 수 증가
					break;
				}
			}
			
		}
		
		C = new float[a.length + b.length - deleteCount][2]; //C배열 동적 할당
		
		for(int i=0; i<C.length; i++) {
			if(i<a.length) C[i] = a[i];
			else C[i] = b[i-a.length]; 
		}
		
		return C;
	}
	
	public void printPoly(float[][] arr, String input_polyName) {
		System.out.printf("\n%s 다항식 : ", input_polyName);
		
		for(int i=0; i<arr.length; i++) {
			//두번째 항부터 음수일 경우 + 부호 미출력
			if(i > 0) {
				if(arr[i][1] > 0) System.out.printf(" + ");
				else System.out.printf(" ");
			}
			
			if(arr[i][0] == 0) System.out.printf("%.1f", arr[i][1]); //지수가 0이면 상수로만 출력
			else if(arr[i][1] == 0) continue; //계수가 0이면 출력 안함
			else System.out.printf("%.1fX^%.0f", arr[i][1], arr[i][0]);
			
		}
		
	}

}


public class Polynomial {
	public static String nullBbuffer;

	public static void main(String[] args) {
		
		float[][] A = null;
		float[][] B = null;
		float[][] C = null;
		OperatePoly opPoly = new OperatePoly();
		
		A = opPoly.setPoly("A");
		nullBbuffer = UtilInput.scan.nextLine();
		B = opPoly.setPoly("B");
		
		C = opPoly.addPoly(A, B);
		
		//addPoly 매서드 확인 for문
		/*
		 * for(float[] i: C) { for(float k : i) System.out.printf("%f ", k);
		 * System.out.println(""); }
		 */
		
		opPoly.printPoly(C, "C");
		
		System.out.println("");
	}

}
