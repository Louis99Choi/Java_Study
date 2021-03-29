package Poly;

import java.util.*;

class UtilInput {

	static Scanner scan = new Scanner(System.in);

	// 입력 받은 값을 줄 단위로 읽어 각각 Double형과 Integer형으로 변환하는 매서드
	public static String getNextLine() {
		return scan.nextLine();
	}
	
}

class OperatePoly {
	public static String replaceXelse(String str) {
		str = str.replace("+", " ");
		str = str.replace("- ", " -");
		
		//첫번째 항이 계수가 1인 경우.
		if(str.indexOf("x") == 0) {
			str = "1 " + str.substring(1);
			//동시에 거듭제곱인 경우.
			if(str.indexOf("^") == 2) {
				str = str.substring(0,2) + str.substring(3);
			}
			//계수가 1이고 지수도 1인 경우.
			else {
				str = str.substring(0,2) + "1 " + str.substring(2);
			}
		}
		
		//이후 계수가 1, -1, 지수가 1 등의 각각의 경우에 대해 공백으로 변환
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
	
	//공백을 기준으로 나눈 토큰을 원소로 하는 배열을 반환하는 매서드.
	public static float[] tokenizerSpaceToIntArray(String str) {
		float[] poly;
		
		StringTokenizer tokenizer = new StringTokenizer(str, " ");
		//입력받은 다항식에 상수가 있을 경우.
		if(tokenizer.countTokens()%2 != 0) {
			poly = new float[tokenizer.countTokens() + 2]; //첫번째 원소에 항의 개수를 넣어주기위해 크기 1 증가.
			poly[0] = (tokenizer.countTokens() + 1)/2; //첫번째 원소에 항의 개수를 넣어줌.
			poly[poly.length-1] = 0; //배열의 마지막 원소인 상수의 지수 '0'을 저장
		}
		//입력받은 다항식에 상수가 없을 경우.
		else {
			poly = new float[tokenizer.countTokens() + 1]; //첫번째 원소에 항의 개수를 넣어주기위해 크기 1 증가.
			poly[0] = ( tokenizer.countTokens() )/2; //첫번째 원소에 항의 개수를 넣어줌.
		}
				
		//토큰을 for문을 이용해 배열에 저장.
		for(int i=1; tokenizer.hasMoreTokens(); i++) {
			poly[i] = Float.parseFloat(tokenizer.nextToken()); 
		}
		
		return poly;
	}

	public float[] setPoly(String input_polyName) {
		float[] arr = null;
		String polyString;
		System.out.printf("\nx에 대한 다항식 %s를 내림차순으로 입력 하시오(ex_ 3x^2 - 4x + 7) \n%s: ", input_polyName, input_polyName);
		polyString = UtilInput.getNextLine();
		
		arr = tokenizerSpaceToIntArray(replaceXelse(polyString));
		System.out.println(" ");
		return arr;
		
		
	}
	
	/*
	 * 다항식의 덧셈을 구현하는 매서드.
	 * 본 코드에서는 다항식 배열의 순서가 [항의 개수, 계수, 지수, 계수, 지수...] 순이므로 각각의 인덱스 값이 아래와 같음.
	 */
	public float[] addPoly(float[] a, float[] b, float[] c) {
		int m = (int)a[0], n = (int)b[0]; 
		int p = 2, q = 2, r = 2; //각 다항식의 항의 지수의 인덱스를 표현하는 변수.
		
		while(p <= (2*m) && q <= (2*n)) {
			//지수가 같은 경우.
			if(a[p] == b[q]) {
				c[r-1] = a[p-1] + b[q-1]; //계수를 더한다.
				
				if(c[r-1] != 0) {
					c[r]= a[p]; r +=2; //지수를 더한다.
				}
				p +=2; q +=2; //다음 항으로 이동.
			}
			
			else if(a[p] < b[q]) {
				c[r-1] = b[q-1]; c[r] = b[q]; //새로운 항을 저장.
				q +=2; r +=2; //다음 항으로 이동.
			}
			
			else if(a[p] > b[q]) {
				c[r-1] = a[p-1]; c[r] = a[p]; //새로운 항을 저장.
				p +=2; r +=2; //다음 항으로 이동.
			}
		}
		
		while(p <= 2*m) {
			c[r]= a[p]; c[r-1]=a[p-1]; //a다항식의 나머지 항을 복사
			p +=2; r +=2;
		}
		
		while(q <= 2*n) {
			c[r]= a[q]; c[r-1]=a[q-1]; //b다항식의 나머지 항을 복사
			q +=2; r +=2;
		}
		
		c[0] = r/2 -1;
		
		return c;
	}

	//다항식의 계수와 지수 값을 원소로 하는 배열을 다항식의 꼴로 Symbolic하게 출력하는 매서드.
	public void printPoly(float[] arr, String input_polyName) {
		System.out.printf("\n%s 다항식 : ", input_polyName);
		
		for(int i=1; i<arr.length; i+=2) {
			//첫번째 항일 경우 앞에 기호를 붙이지 않고 출력
			if(i==1) {
				
				if((int)arr[i] == 1) {
					if((int)arr[i+1] == 0) System.out.printf(" 1 ");
					else if((int)arr[i+1] == 1) System.out.printf(" x ");
					else System.out.printf(" x^%d ", (int)arr[i+1]);
				}
				
				else {
					if((int)arr[i+1] == 0) System.out.printf(" %.1f ", arr[i]); //지수가 0이면 상수만 출력
					else if((int)arr[i+1] == 1) System.out.printf(" %.1fx ", arr[i]);
					else System.out.printf(" %.1fx^%d ", arr[i], (int)arr[i+1]);
				}
			}
			//항의 계수가 양수이면 항 앞에 + 기호를 붙이고 계수와 차수가 각각 1 / 0, 1 일 경우에 따라(1, x, 3.0x 등) 다르게 출력.
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
			//항의 계수가 음수이면 - 항 앞에 기호를 붙이고 절댓값을 출력, 계수와 차수가 각각 -1 / 0, 1 일 경우에 따라(- 1, - x, - 3.0x 등) 다르게 출력.
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
		System.out.println("x에 대한 두 개의 다항식 A, B를 입력하고 A와 B를 더한 다항식 C를 출력하는 프로그램입니다.");
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
