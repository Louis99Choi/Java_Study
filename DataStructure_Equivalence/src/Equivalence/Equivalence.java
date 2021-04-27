package Equivalence;

import java.util.StringTokenizer;

import org.graalvm.compiler.core.common.cfg.Loop;

import LinkedList.*;
import UserUtil.UserInput;

public class Equivalence<E> {
	public SingleLinkedList<Integer>[] seq; // �� LinkedList ��ü(������)�� ���ҷ� �ϴ� �迭

	int[] bit; // ������� ���θ� ǥ���ϴ� ��Ʈ�迭
	int i, j; // ��ġ�� (i, j)
	int pairNum = 0; // m : ��ġ���� ��
	int elements; // n : ������ ��
	int index = 0; // bit[] �迭�� index ����;


	
	public static void main(String[] args) {
		Equivalence<Integer> equivalence = new Equivalence<Integer>();
		
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
			seq[i] = new SingleLinkedList<Integer>();
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
			 * 
			 * ���� ������� SingleLinkedList Ŭ���� ��ü seq[i]�� �ν��Ͻ� �޼��� push�� ����� �Ʒ� �������� ��ü
			 * �����ϴ�.
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
				System.out.printf("\n{ %c Class : %d", className + (classCount++), index+1);
				bit[index] = 1;

				SingleNode<Integer> ptrNode = new SingleNode<Integer>(seq[index].getTop());
				SingleLinkedList<Integer> stack = new SingleLinkedList<Integer>(); //���� �ʱ�ȭ;

				Loop1 : while(true) {
					while(ptrNode != null) {
						j = ptrNode.getData(); // j <- DATA(ptr)

						if (bit[j] == 0) {
							System.out.printf(", %d", j+1); // print(j);
							bit[j] = 1;					  // BIT(j) <- 1;

							
							/*
							 * t <- LINK(ptr);	LINK(ptr) <- top;	top <- ptr;	ptr <- t;
							 * �� �װ��� ������ SEQ(index)ù��° ��带 pop�ؼ� stack�� push �ϴ� �Ͱ� ����.
							 */
							stack.push(seq[index].popNode()); //SEQ(index)ù��° ��带 pop�ؼ� stack�� push.
							ptrNode = seq[index].getTop(); //ptr �� ���� ��� ����.
						}
						
						else {
							if(seq[index].getTop() != null)
								seq[index].setTop(seq[index].getTop().getLink()); // ptr <- LINK(ptr);
						}

					}
					
					if (stack.getTop() == null) break Loop1; //if top = 0 then exit
					
					if(ptrNode == null) { ptrNode = new SingleNode<>(); }
					
					ptrNode = new SingleNode<Integer>(seq[ (int)stack.popNode().getData() ].getTop() ); // ptr <- SEQ(DATA(top)), top <- LINK(top).
					
				}
								
			}

			index++;
		}

	}

}
