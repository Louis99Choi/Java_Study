//�ڷᱸ��_1�й�_32184731_��âȯ_��ġŬ������������

package Equivalence;

import java.util.StringTokenizer;
import LinkedList.*;
import UserUtil.UserInput;

public class Equivalence {
	public SingleLinkedList[] seq; // �� LinkedList ��ü(������)�� ���ҷ� �ϴ� �迭
	int[] bit; // ������� ���θ� ǥ���ϴ� ��Ʈ�迭
	int i, j; // ��ġ�� (i, j)
	int pairNum = 0; // m : ��ġ���� ��
	int elements; // n : ������ ��
	int index = 0; // bit[] �迭�� index ����;

	public static void main(String[] args) {
		Equivalence equivalence = new Equivalence();

		equivalence.input();
		equivalence.printClass();
	}

	/*
	 * 1�ܰ� : ��� �Է��� ó��. ����ڿ��� 1���� n������ �������� ��ġ���踦 ��ġ��(ex_ 1=12)�� �Է� �ް� ��ġ���� ���Ḯ��Ʈ��
	 * �����ϴ� �ż���
	 */
	public void input() {
		System.out.print("1���� ���� n������ ��ġ���踦 ��ġ�� ���·� �Է� �޾� ��ġ �η��� ���� ������ִ� ���α׷��Դϴ�.\n" + "�ִ� ���� n�� �Է��Ͻÿ� : ");
		elements = UserInput.getInteger(); // ����ڿ��� n�� �Է¹���.(n�� element ���� ����)

		this.bit = new int[elements];
		this.seq = new SingleLinkedList[elements];

		// �迭 bit[]�� seq[]�� ���Ҹ� ���� 0�� null�� �ʱ�ȭ.
		for (int i = 0; i < elements; i++) {
			bit[i] = 0;
			seq[i] = new SingleLinkedList();
		}

		System.out.println();

		// ����ڷκ��� ��ġ���� �Է¹���.{-1(�� ����)�� �Է��ϸ� ��ġ�� �Է��� ����}
		while (true) {
			System.out.printf("%d ��° ��ġ�� �Է�.(EX_ 1=9 / ������ �Է��ϸ� ��ġ�� �Է� ����) : ", pairNum + 1);

			StringTokenizer token = new StringTokenizer(UserInput.replaceEqual(UserInput.getNextLine()), " ");

			i = Integer.parseInt(token.nextToken()) - 1;

			if (i < 0) {
				break;
			} // ������� �Է��� -1 �� �����̸� ��ġ�� �Է� ����.

			j = Integer.parseInt(token.nextToken()) - 1;

			/*
			 * DATA(av) <- j; LINK(av) <- SEQ(i); SEQ(i) <- av; av <- av + 1; 
			 * DATA(av) <- i; LINK(av) <- SEQ(j); SEQ(j) <- av; av <- av + 1;
			 * ���� ������� SingleLinkedList Ŭ���� ��ü seq[i]�� �ν��Ͻ� �޼��� push�� ����� �Ʒ� �ڵ�� ��ü �����ϴ�.
			 */
			seq[i].push(j);
			seq[j].push(i);

			pairNum++;
		}
	}

	/*
	 * 2�ܰ� : ��� ������ ��ġ ���迡 ���� �η��� ������ ���.
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
				SingleLinkedList stack = new SingleLinkedList(); // ���� �ʱ�ȭ;
				
				while (true) {
					while (ptrNode != null) {
						j = ptrNode.getData(); // j <- DATA(ptr)

						if (bit[j] == 0) {
							System.out.printf(", %d", j + 1); // print(j);
							bit[j] = 1; // BIT(j) <- 1;

							/*
							 * t <- LINK(ptr); LINK(ptr) <- top; top <- ptr; ptr <- t; �� �װ��� ������
							 * SEQ(index)ù��° ��带 pop�ؼ� stack�� push �ϴ� �Ͱ� ����.
							 */
							SingleNode t = ptrNode.getLink();
							stack.push(ptrNode); // SEQ(index)ù��° ��带 pop�ؼ� stack�� push.
							ptrNode = t; // ptr �� ���� ��� ����.
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
