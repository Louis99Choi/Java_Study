//�ڷᱸ��_1�й�_32184731_��âȯ_��ġŬ������������

package LinkedList;

//Linked List�� �� ��� ��ü Ŭ����
public class SingleNode {
	private int data;
	private SingleNode link;
	
	
	public SingleNode(int data, SingleNode link) {
		this.data = data;
		this.link = link;
	}
	
	//������ Overloading
	public SingleNode(SingleNode newNode) {
		this.data = newNode.getData();
		this.link = newNode.getLink();
	}
	
	//������ Overloading
	public SingleNode() {
		this.data = -1;
		this.link = null;
	}


	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}

	public SingleNode getLink() {
		return link;
	}
	public void setLink(SingleNode link) {
		this.link = link;
	}

	public void setNode(SingleNode newNode) {
		setData(newNode.getData());
		setLink(newNode.getLink());
	}
}
