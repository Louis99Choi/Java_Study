//자료구조_1분반_32184731_최창환_동치클래스구현과제

package LinkedList;

public class SingleLinkedList {
	private SingleNode top;
	
	public SingleLinkedList() {
		this.top = null;
	}
	
	//생성자 Overloading
	public SingleLinkedList(SingleNode newNode) {
		this.top = newNode;
	}
	
	public void setTop(SingleNode newNode) {
		this.top = newNode;
	}
	
	public SingleNode getTop() {
		return this.top;
	}
	
	public void push(int newItem) {
		SingleNode newNode = new SingleNode(newItem, getTop());
		
		top = newNode;
	}
	
	//push 매서드 Overloading
	public void push(SingleNode newNode) {
		newNode.setLink(top);
		
		top = newNode;
	}

	public int pop() {
		if(top != null) {
			SingleNode popNode = new SingleNode();
			popNode.setNode(top);
		
			if(top.getLink() == null) { top = null; }
			else { top.setNode(top.getLink()); }
		
			return popNode.getData();
		}
		
		return -1;
	}
	
	public SingleNode popNode() {
		if(top != null) {
			SingleNode popNode = top;
			top = top.getLink();
		
			return popNode;
		}
		
		return null;
	}


}
