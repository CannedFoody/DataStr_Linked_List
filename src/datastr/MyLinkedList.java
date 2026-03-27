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
	
	public void add(char element, int index) throws Exception {
		if (this.is_full()) {
			throw new Exception("Cannot add new element, the LinkedList is full...");
		}
		
		if (index > this.size || index < 0) {
			throw new Exception("Cannot add new element at that index, index out of bounds...");
		}
		
		MyNode new_node = new MyNode(element);
		
		if(index == 0) {
			first_node.set_previous_node(new_node);
			new_node.set_next_node(first_node);
			this.first_node = new_node;
			this.size += 1;
		}
		
		if(index == this.size) {
			this.add(element);
		}
		
		else {
			if(index < (size / 2)) {
				MyNode current_node = this.first_node;
				int pass_counter = 0;
				
				MyNode before_node = null;
				MyNode after_node = null;
				
				while(!current_node.get_next_node().equals(null)) {
					if (pass_counter == index) {
						before_node = current_node;
						after_node = current_node.get_next_node();
						break;
					}
					current_node = current_node.get_next_node();
					pass_counter += 1;
				}
				
				before_node.set_next_node(new_node);
				after_node.set_previous_node(new_node);
				
				new_node.set_next_node(after_node);
				new_node.set_previous_node(before_node);
				
				this.size += 1;
			}
			else {
				MyNode current_node = this.last_node;
				int pass_counter = this.size;
				
				MyNode before_node = null;
				MyNode after_node = null;
				
				while(!current_node.get_previous_node().equals(null)) {
					if(pass_counter == index) {
						after_node = current_node;
						before_node = current_node.get_previous_node();
						break;
					}
					
					current_node = current_node.get_previous_node();
					pass_counter -= 1;
				}
				
				before_node.set_next_node(new_node);
				after_node.set_previous_node(new_node);
				
				new_node.set_next_node(after_node);
				new_node.set_previous_node(before_node);
				
				this.size += 1;
			}
		}
	}
}
