package LinkedList;

//Linked List�� �� ��� ��ü Ŭ����
public class SingleNode<E> {
	private E data;
	private SingleNode<E> link;
	
	
	public SingleNode(E data, SingleNode<E> link) {
		super();
		this.data = data;
		this.link = null;
	}
	//������ Overloading
	public SingleNode(SingleNode<E> newNode) {
		this.data = newNode.getData();
		this.link = newNode.getLink();
	}
	//������ Overloading
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
