package datastr;

public class MyLinkedList {
	private MyNode first_node = null;
	private MyNode last_node = null;
	private int size = 0;
	
//	Getters

	public int get_size() {
		return size-1;
	}
	
//	No need to create a constructor because the Object class has a pre-defined one for every class if the class has no defined constructor.
	public void print() {
		MyNode current_node = this.first_node;
		
		while(current_node!=null) {
			System.out.print(current_node.print() + " ");
			current_node = current_node.get_next_node();
		}
	}
	
	
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
				
				for(int i = 1; i < index; i++) {
					current_node = current_node.get_next_node();
				}
				
				MyNode previous_node = current_node;
				MyNode next_node = current_node.get_next_node();
				
				new_node.set_previous_node(previous_node);
				new_node.set_next_node(next_node);
				
				previous_node.set_next_node(new_node);
				next_node.set_previous_node(new_node);
				
				this.size += 1;
			}
			else {
				MyNode current_node = this.last_node;
				
				for(int i = this.size; i > index; i--){
					current_node = current_node.get_previous_node();
				}
				
				MyNode next_node = current_node;
				MyNode previous_node = current_node.get_previous_node();
				
				new_node.set_next_node(next_node);
				new_node.set_previous_node(previous_node);
				
				previous_node.set_next_node(new_node);
				next_node.set_previous_node(new_node);
				
				this.size += 1;
			}
		}
	}
	
	public int index(char element) throws Exception{
		if(this.is_empty()) {
			throw new Exception("LinkedList is empty...");
		}
		
		MyNode current_node = first_node;
		int pass_counter = 0;
		
		while(!current_node.get_next_node().equals(null)) {
			if (current_node.get_element() == element) {
				return pass_counter;
			}
			current_node = current_node.get_next_node();
			pass_counter += 1;
		}
		System.out.println("Cannot find the passed element...");
		return -1;
		
	}
	
	public void remove(int index) throws Exception{
		if(this.is_empty()) {
			throw new Exception("The LinkedList is empty...");
		}
		
		if(index < 0 || index >= this.size) {
			throw new Exception("Passed index is out of bounds...");
		}
		
		if(index == 0) {
			MyNode new_first_node = this.first_node.get_next_node();
			new_first_node.set_previous_node(null);
			this.first_node = new_first_node;
			this.size -= 1;
		}
		
		if(index == this.size-1) {
			MyNode new_last_node = this.last_node.get_previous_node();
			new_last_node.set_next_node(null);
			this.last_node = new_last_node;
			this.size -= 1;
		}
		
		else {
			if(index < this.size / 2) {
				MyNode current_node = this.first_node;
				for(int i = 1; i < index; i++) {
					current_node = current_node.get_next_node();
				}
				
				MyNode new_previous_node = current_node;
				MyNode new_next_node = current_node.get_next_node();
				
				new_previous_node.set_next_node(new_next_node);
				new_next_node.set_previous_node(new_previous_node);
				
				this.size -= 1;
			}
			else {
				MyNode current_node = this.last_node;
				for(int i = this.size; i > index; i--) {
					current_node = current_node.get_previous_node();
				}
				
				MyNode new_next_node = current_node;
				MyNode new_previous_node = current_node.get_previous_node();
				
				new_next_node.set_previous_node(new_previous_node);
				new_previous_node.set_next_node(new_next_node);
				
				this.size -= 1;
			}
		}
	}
	
	public char find(int index) throws Exception{
		if(this.is_empty()) {
			throw new Exception("Cannot start search if the LinkedList is empty...");
		}
		
		if(index < 0 || index > this.size) {
			throw new Exception("Passed index is out of bounds...");
		}
		
		MyNode current_node = this.first_node;
		
		for(int i=1; i < index; i++) {
			current_node = current_node.get_next_node();
		}
		
		return current_node.get_element();
	}
	
	public void trash() {
		this.first_node = null;
		this.last_node = null;
		this.size = 0;
		
		System.gc();
	}
	
}
