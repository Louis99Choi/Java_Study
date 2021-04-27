//자료구조_1분반_32184731_최창환_동치클래스구현과제

package LinkedList;

//Linked List의 각 노드 객체 클래스
public class SingleNode {
	private int data;
	private SingleNode link;
	
	
	public SingleNode(int data, SingleNode link) {
		this.data = data;
		this.link = link;
	}
	
	//생성자 Overloading
	public SingleNode(SingleNode newNode) {
		this.data = newNode.getData();
		this.link = newNode.getLink();
	}
	
	//생성자 Overloading
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
