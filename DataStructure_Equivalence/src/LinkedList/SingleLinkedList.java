package LinkedList;

public class SingleLinkedList<E> {
	private SingleNode<E> top;
	private int size;
	
	
	public SingleLinkedList() {
		this.top = null;
		this.size = 0;
	}
	//생성자 Overloading
	public SingleLinkedList(SingleNode<E> newNode) {
		this.top = newNode;
		this.size = 1;
	}
	
	public void setTop(SingleNode<E> newNode) {
		this.top = newNode;
	}
	public SingleNode<E> getTop() {
		return this.top;
	}
	
	public void push(E newItem) {
		SingleNode<E> newNode = new SingleNode<E>(newItem, getTop());
		
		if(top == null) { top = new SingleNode<E>(); }
		top.setNode(newNode);
		size++;
	}
	//push 매서드 Overloading
	public void push(SingleNode<E> newNode) {
		if(newNode == null) return;
		
		newNode.setLink(top);
		
		if(top == null) { top = new SingleNode<E>(); }
		top = new SingleNode<E>(newNode);
		size++;
	}

	public E pop() {
		SingleNode<E> popNode = new SingleNode<E>();
		
		if(top != null) {
			popNode.setNode(top);
			
			if(top.getLink() == null) { top = null; }
			else { top = new SingleNode<E>(top.getLink()); }
			size--;
		}
		
		return popNode.getData();
		
	}
	
	public SingleNode<E> popNode() {
		if(top != null) {
			SingleNode<E> popNode = new SingleNode<E>();
			
			popNode.setNode(top);
			
			top = top.getLink();
			size--;
			return popNode;
		}
		
		return null;
		
	}


}
