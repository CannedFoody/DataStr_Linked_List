package model;

import datastr.*;
public class MainService {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		
		try {
			list.add('A');
			list.add('B');
			list.add('C');
			
			list.add('D', 0);
			
			System.out.println(list.get_size());
			
			list.print();
			
			list.remove(3);
			
			list.print();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
