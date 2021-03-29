package Poly;

import java.util.*;

class UtilInput {

	static Scanner scan = new Scanner(System.in);

	// �Է� ���� ���� �� ������ �о� ���� Double���� Integer������ ��ȯ�ϴ� �ż���
	public static String getNextLine() {
		return scan.nextLine();
	}
	
}

class OperatePoly {
	public static String replaceXelse(String str) {
		str = str.replace("+", " ");
		str = str.replace("- ", " -");
		
		//ù��° ���� ����� 1�� ���.
		if(str.indexOf("x") == 0) {
			str = "1 " + str.substring(1);
			//���ÿ� �ŵ������� ���.
			if(str.indexOf("^") == 2) {
				str = str.substring(0,2) + str.substring(3);
			}
			//����� 1�̰� ������ 1�� ���.
			else {
				str = str.substring(0,2) + "1 " + str.substring(2);
			}
		}
		
		//���� ����� 1, -1, ������ 1 ���� ������ ��쿡 ���� �������� ��ȯ
		str = str.replace(" x", "1x");

		str = str.replace("-x^", "-1 ");
		str = str.replace(" x^", "1 ");
		str = str.replace("x^", " ");

		str = str.replace("-x", "-1 1");
		
		str = str.replace(" x", "1 1");
		str = str.replace("x", " 1");

		str = str.trim();
		
		return str;
	}
	
	//������ �������� ���� ��ū�� ���ҷ� �ϴ� �迭�� ��ȯ�ϴ� �ż���.
	public static float[] tokenizerSpaceToIntArray(String str) {
		float[] poly;
		
		StringTokenizer tokenizer = new StringTokenizer(str, " ");
		//�Է¹��� ���׽Ŀ� ����� ���� ���.
		if(tokenizer.countTokens()%2 != 0) {
			poly = new float[tokenizer.countTokens() + 2]; //ù��° ���ҿ� ���� ������ �־��ֱ����� ũ�� 1 ����.
			poly[0] = (tokenizer.countTokens() + 1)/2; //ù��° ���ҿ� ���� ������ �־���.
			poly[poly.length-1] = 0; //�迭�� ������ ������ ����� ���� '0'�� ����
		}
		//�Է¹��� ���׽Ŀ� ����� ���� ���.
		else {
			poly = new float[tokenizer.countTokens() + 1]; //ù��° ���ҿ� ���� ������ �־��ֱ����� ũ�� 1 ����.
			poly[0] = ( tokenizer.countTokens() )/2; //ù��° ���ҿ� ���� ������ �־���.
		}
				
		//��ū�� for���� �̿��� �迭�� ����.
		for(int i=1; tokenizer.hasMoreTokens(); i++) {
			poly[i] = Float.parseFloat(tokenizer.nextToken()); 
		}
		
		return poly;
	}

	public float[] setPoly(String input_polyName) {
		float[] arr = null;
		String polyString;
		System.out.printf("\nx�� ���� ���׽� %s�� ������������ �Է� �Ͻÿ�(ex_ 3x^2 - 4x + 7) \n%s: ", input_polyName, input_polyName);
		polyString = UtilInput.getNextLine();
		
		arr = tokenizerSpaceToIntArray(replaceXelse(polyString));
		System.out.println(" ");
		return arr;
		
		
	}
	
	/*
	 * ���׽��� ������ �����ϴ� �ż���.
	 * �� �ڵ忡���� ���׽� �迭�� ������ [���� ����, ���, ����, ���, ����...] ���̹Ƿ� ������ �ε��� ���� �Ʒ��� ����.
	 */
	public float[] addPoly(float[] a, float[] b, float[] c) {
		int m = (int)a[0], n = (int)b[0]; 
		int p = 2, q = 2, r = 2; //�� ���׽��� ���� ������ �ε����� ǥ���ϴ� ����.
		
		while(p <= (2*m) && q <= (2*n)) {
			//������ ���� ���.
			if(a[p] == b[q]) {
				c[r-1] = a[p-1] + b[q-1]; //����� ���Ѵ�.
				
				if(c[r-1] != 0) {
					c[r]= a[p]; r +=2; //������ ���Ѵ�.
				}
				p +=2; q +=2; //���� ������ �̵�.
			}
			
			else if(a[p] < b[q]) {
				c[r-1] = b[q-1]; c[r] = b[q]; //���ο� ���� ����.
				q +=2; r +=2; //���� ������ �̵�.
			}
			
			else if(a[p] > b[q]) {
				c[r-1] = a[p-1]; c[r] = a[p]; //���ο� ���� ����.
				p +=2; r +=2; //���� ������ �̵�.
			}
		}
		
		while(p <= 2*m) {
			c[r]= a[p]; c[r-1]=a[p-1]; //a���׽��� ������ ���� ����
			p +=2; r +=2;
		}
		
		while(q <= 2*n) {
			c[r]= a[q]; c[r-1]=a[q-1]; //b���׽��� ������ ���� ����
			q +=2; r +=2;
		}
		
		c[0] = r/2 -1;
		
		return c;
	}

	//���׽��� ����� ���� ���� ���ҷ� �ϴ� �迭�� ���׽��� �÷� Symbolic�ϰ� ����ϴ� �ż���.
	public void printPoly(float[] arr, String input_polyName) {
		System.out.printf("\n%s ���׽� : ", input_polyName);
		
		for(int i=1; i<arr.length; i+=2) {
			//ù��° ���� ��� �տ� ��ȣ�� ������ �ʰ� ���
			if(i==1) {
				
				if((int)arr[i] == 1) {
					if((int)arr[i+1] == 0) System.out.printf(" 1 ");
					else if((int)arr[i+1] == 1) System.out.printf(" x ");
					else System.out.printf(" x^%d ", (int)arr[i+1]);
				}
				
				else {
					if((int)arr[i+1] == 0) System.out.printf(" %.1f ", arr[i]); //������ 0�̸� ����� ���
					else if((int)arr[i+1] == 1) System.out.printf(" %.1fx ", arr[i]);
					else System.out.printf(" %.1fx^%d ", arr[i], (int)arr[i+1]);
				}
			}
			//���� ����� ����̸� �� �տ� + ��ȣ�� ���̰� ����� ������ ���� 1 / 0, 1 �� ��쿡 ����(1, x, 3.0x ��) �ٸ��� ���.
			else if(i>1 && arr[i] > 0) {
				if((int)arr[i] == 1) {
					if((int)arr[i+1] == 0) System.out.printf("+ 1 ");
					else if((int)arr[i+1] == 1) System.out.printf("+ x ");
					else System.out.printf("+ x^%d ", (int)arr[i+1]);
				}
				else {
					if((int)arr[i+1] == 0) System.out.printf("+ %.1f ", arr[i]);
					else if((int)arr[i+1] == 1) System.out.printf("+ %.1fx ", arr[i]);
					else System.out.printf("+ %.1fx^%d ", arr[i], (int)arr[i+1]);
				}
			}
			//���� ����� �����̸� - �� �տ� ��ȣ�� ���̰� ������ ���, ����� ������ ���� -1 / 0, 1 �� ��쿡 ����(- 1, - x, - 3.0x ��) �ٸ��� ���.
			else if(i>1 && arr[i] < 0) {
				if((int)arr[i] == -1) {
					if((int)arr[i+1] == 0) System.out.printf("- 1 ");
					else if((int)arr[i+1] == 1) System.out.printf("- x ");
					else System.out.printf("- x^%d ", (int)arr[i+1]);
				}
				
				else {
					if((int)arr[i+1] == 0) System.out.printf("- %.1f ", (-1) * arr[i]);
					else if((int)arr[i+1] == 1) System.out.printf("- %.1fx ", (-1) * arr[i]);
					else System.out.printf("- %.1fx^%d ", (-1) * arr[i], (int)arr[i+1]);
				}
			}
			
		}

		System.out.println(" ");
	}
}

public class Polynomial {

	public static void main(String[] args) {
		System.out.println("x�� ���� �� ���� ���׽� A, B�� �Է��ϰ� A�� B�� ���� ���׽� C�� ����ϴ� ���α׷��Դϴ�.");
		System.out.println("=======================================================================");

		float[] A = null;
		float[] B = null;
		
		OperatePoly opPoly = new OperatePoly();
		
		A = opPoly.setPoly("A");
		B = opPoly.setPoly("B");
		
		float[] C = new float[A.length + B.length];
		
		C = opPoly.addPoly(A, B, C);
		opPoly.printPoly(C, "C");
	}

}
