package datastr;

public class MyNode {
	private char element;
	private MyNode previous_node = null;
	private MyNode next_node = null;
	
//	Getters
	public char get_element() {
		return element;
	}

	public MyNode get_previous_node() {
		return previous_node;
	}
	
	public MyNode get_next_node() {
		return next_node;
	}
	
//	Setters
	public void set_element(char element) {
		this.element = element;
	}
	
	public void set_previous_node(MyNode previous_node) {
		this.previous_node = previous_node;
	}

	public void set_next_node(MyNode next_node) {
		this.next_node = next_node;
	}
	
//	Constructors
	
	public MyNode(char element) {
		set_element(element);
	}
	
	public String print() {
		return "" + this.element;
	}
	
}
