package datastr;

public class MyNode {
	private char element;
	private MyNode previous_node = null;
	private MyNode next_node = null;
	
//	Getters
	public char getElement() {
		return element;
	}

	public MyNode getPrevious_node() {
		return previous_node;
	}
	
	public MyNode getNext_node() {
		return next_node;
	}
	
//	Setters
	public void setElement(char element) {
		this.element = element;
	}
	
	public void setPrevious_node(MyNode previous_node) {
		this.previous_node = previous_node;
	}

	public void setNext_node(MyNode next_node) {
		this.next_node = next_node;
	}
	
//	Constructors
	
	public MyNode(char element) {
		setElement(element);
	}
	
	public String print() {
		return "" + this.element;
	}
	
}
