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
			MyNode new_node = new MyNode('a');
			this.first_node = new_node;
			this.last_node = new_node;
			this.size += 1;
		}
	}
	
}
