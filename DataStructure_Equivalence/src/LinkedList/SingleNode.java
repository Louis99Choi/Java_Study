package LinkedList;

//Linked List의 각 노드 객체 클래스
public class SingleNode<E> {
	private E data;
	private SingleNode<E> link;
	
	
	public SingleNode(E data, SingleNode<E> link) {
		super();
		this.data = data;
		this.link = null;
	}
	//생성자 Overloading
	public SingleNode(SingleNode<E> newNode) {
		this.data = newNode.getData();
		this.link = newNode.getLink();
	}
	//생성자 Overloading
		public SingleNode() {
			this.data = null;
			this.link = null;
		}


	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}

	public SingleNode<E> getLink() {
		return link;
	}
	public void setLink(SingleNode<E> link) {
		this.link = link;
	}

	public void setNode(SingleNode<E> newNode) {
		setData(newNode.getData());
		setLink(newNode.getLink());
	}
	
}
