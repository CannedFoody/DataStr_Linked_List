package datastr;

public class MyLinkedList {
	private MyNode first_node = null;
	private MyNode last_node = null;
	private int size = 0;
	
//	Getters

	public int get_size() {
		return size;
	}
	
//	No need to create a constructor because the Object class has a pre-defined one for every class if the class has no defined constructor.
	
	public boolean is_empty() {
		return (this.size == 0);
	}
	
	public boolean is_full(){
		try {
			new MyNode('a');	
			return false;
		}
		catch (OutOfMemoryError e) {
			return true;
		}
	}
	
	public void add(char element) throws Exception {
		if (this.is_full()) {
			throw new Exception("Cannot add new element, the LinkedList is full...");
		}
	
		if(this.size == 0) {
			MyNode new_node = new MyNode(element);
			this.first_node = new_node;
			this.last_node = new_node;
			this.size += 1;
		} 
		else {
			MyNode new_node = new MyNode(element);
			
			new_node.set_previous_node(this.last_node);
			this.last_node.set_next_node(new_node);
			
			this.last_node = new_node;
			this.size += 1;
		}
	}
	
	public int list_size() throws Exception {
		if (this.is_empty()) {
			throw new Exception("Linked list object is empty...");
		}
		
		int element_count = 0;
		
		MyNode current_node = this.first_node;
		
		while(!current_node.get_next_node().equals(null)) {
			element_count += 1;
			
			current_node = current_node.get_next_node();
		}
		
		return element_count;
	}
}
