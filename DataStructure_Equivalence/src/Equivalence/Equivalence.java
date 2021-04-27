//자료구조_1분반_32184731_최창환_동치클래스구현과제

package Equivalence;

import java.util.StringTokenizer;
import LinkedList.*;
import UserUtil.UserInput;

public class Equivalence {
	public SingleLinkedList[] seq; // 각 LinkedList 객체(헤더노드)를 원소로 하는 배열
	int[] bit; // 변수출력 여부를 표시하는 비트배열
	int i, j; // 동치쌍 (i, j)
	int pairNum = 0; // m : 동치쌍의 수
	int elements; // n : 변수의 수
	int index = 0; // bit[] 배열의 index 변수;

	public static void main(String[] args) {
		Equivalence equivalence = new Equivalence();

		equivalence.input();
		equivalence.printClass();
	}

	/*
	 * 1단계 : 모든 입력을 처리. 사용자에게 1부터 n까지의 정수들의 동치관계를 동치쌍(ex_ 1=12)을 입력 받고 동치쌍을 열결리스트로
	 * 정리하는 매서드
	 */
	public void input() {
		System.out.print("1부터 정수 n까지의 동치관계를 동치쌍 형태로 입력 받아 동치 부류를 나눠 출력해주는 프로그램입니다.\n" + "최대 정수 n을 입력하시오 : ");
		elements = UserInput.getInteger(); // 사용자에게 n을 입력받음.(n은 element 수와 같음)

		this.bit = new int[elements];
		this.seq = new SingleLinkedList[elements];

		// 배열 bit[]와 seq[]의 원소를 각각 0과 null로 초기화.
		for (int i = 0; i < elements; i++) {
			bit[i] = 0;
			seq[i] = new SingleLinkedList();
		}

		System.out.println();

		// 사용자로부터 동치쌍을 입력받음.{-1(등 음수)을 입력하면 동치쌍 입력을 종료}
		while (true) {
			System.out.printf("%d 번째 동치쌍 입력.(EX_ 1=9 / 음수를 입력하면 동치쌍 입력 종료) : ", pairNum + 1);

			StringTokenizer token = new StringTokenizer(UserInput.replaceEqual(UserInput.getNextLine()), " ");

			i = Integer.parseInt(token.nextToken()) - 1;

			if (i < 0) {
				break;
			} // 사용자의 입력이 -1 등 음수이면 동치쌍 입력 종료.

			j = Integer.parseInt(token.nextToken()) - 1;

			/*
			 * DATA(av) <- j; LINK(av) <- SEQ(i); SEQ(i) <- av; av <- av + 1; 
			 * DATA(av) <- i; LINK(av) <- SEQ(j); SEQ(j) <- av; av <- av + 1;
			 * 위의 실행들은 SingleLinkedList 클래스 객체 seq[i]의 인스턴스 메서드 push를 사용해 아래 코드로 대체 가능하다.
			 */
			seq[i].push(j);
			seq[j].push(i);

			pairNum++;
		}
	}

	/*
	 * 2단계 : 모든 변수를 동치 관계에 대한 부류로 구분해 출력.
	 */
	public void printClass() {
		System.out.println("==================================================");
		char className = 'A';
		int classCount = 0;

		while (index < elements) {
			if (bit[index] == 0) {
				System.out.printf("\n{ %c Class : %d", className + (classCount++), index + 1);
				bit[index] = 1;
				
				SingleNode ptrNode = new SingleNode(seq[index].getTop());
				SingleLinkedList stack = new SingleLinkedList(); // 스택 초기화;
				
				while (true) {
					while (ptrNode != null) {
						j = ptrNode.getData(); // j <- DATA(ptr)

						if (bit[j] == 0) {
							System.out.printf(", %d", j + 1); // print(j);
							bit[j] = 1; // BIT(j) <- 1;

							/*
							 * t <- LINK(ptr); LINK(ptr) <- top; top <- ptr; ptr <- t; 이 네가지 실행은
							 * SEQ(index)첫번째 노드를 pop해서 stack에 push 하는 것과 같다.
							 */
							SingleNode t = ptrNode.getLink();
							stack.push(ptrNode); // SEQ(index)첫번째 노드를 pop해서 stack에 push.
							ptrNode = t; // ptr 에 다음 노드 저장.
						}

						else { ptrNode = ptrNode.getLink(); } // ptr <- LINK(ptr);
					}

					if (stack.getTop() == null) {
						System.out.print(" }");
						break; // if top = 0 then exit
					}
					
					ptrNode = seq[stack.pop()].getTop(); // ptr <- SEQ(DATA(top)), top <- LINK(top).
					
				}
			}

			index++;
		}
	}

}
