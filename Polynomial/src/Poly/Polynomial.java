package Poly;
import java.util.*;


class UtilInput {

	static Scanner scan = new Scanner(System.in);

	// �Է� ���� ���� �� ������ �о� ���� Double���� Integer������ ��ȯ�ϴ� �ż���
	public static float getFloat() {	return Float.parseFloat(scan.nextLine());	}
	public static int getInteger() {	return Integer.parseInt(scan.nextLine());	}
	// �Է� ���� ���� ���� ������ �о� ���� Double���� Integer������ ��ȯ�ϴ� �ż���
	public static float getNextFloat() {	return scan.nextFloat();	}
	public static int getNextInt() {	return scan.nextInt();	}

	/*
	 * q�� �Է��� ���α׷��� �����ϰų� ����Ű�� ������ ��� �����϶�� �ȳ����� q �� �Է� �޾��� ��� �ȳ����� �Բ� ���α׷��� �����ϵ���
	 * ���� true�� false�� ��ȯ�ϴ� �ż���
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
		
		System.out.printf("\n%s ���׽��� ����� 0�� �ƴ� ���� ���� : ", input_polyName);
		numOfPoly = UtilInput.getInteger();
		arr = new float[numOfPoly][2];
		
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%s ���׽��� %d ��° ���� ������ ��� : ", input_polyName, i+1);
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
					deleteIndexMono(b, j); //b�迭���� a�迭�� �߰��� �� ���� ����
					deleteCount++; //b�迭���� ������ ���� �� ����
					break;
				}
			}
			
		}
		
		C = new float[a.length + b.length - deleteCount][2]; //C�迭 ���� �Ҵ�
		
		for(int i=0; i<C.length; i++) {
			if(i<a.length) C[i] = a[i];
			else C[i] = b[i-a.length]; 
		}
		
		return C;
	}
	
	public void printPoly(float[][] arr, String input_polyName) {
		System.out.printf("\n%s ���׽� : ", input_polyName);
		
		for(int i=0; i<arr.length; i++) {
			//�ι�° �׺��� ������ ��� + ��ȣ �����
			if(i > 0) {
				if(arr[i][1] > 0) System.out.printf(" + ");
				else System.out.printf(" ");
			}
			
			if(arr[i][0] == 0) System.out.printf("%.1f", arr[i][1]); //������ 0�̸� ����θ� ���
			else if(arr[i][1] == 0) continue; //����� 0�̸� ��� ����
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
		
		//addPoly �ż��� Ȯ�� for��
		/*
		 * for(float[] i: C) { for(float k : i) System.out.printf("%f ", k);
		 * System.out.println(""); }
		 */
		
		opPoly.printPoly(C, "C");
		
		System.out.println("");
	}

}
