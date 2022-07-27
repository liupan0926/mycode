package com.example.linkedlist;

public class DemoApplication {
	public static void main(String[] args) {
		MylinkedList linkedList = new MylinkedList();

		linkedList.addAtHead(7); // head->7;

		linkedList.addAtHead(2); // head->2->7;
		linkedList.addAtHead(1);// head->1->2->7;

		linkedList.addAtIndex(3, 0); // head->1->2->7->0;
		linkedList.print();

		linkedList.deleteAtIndex(2);
		linkedList.addAtHead(6);
		linkedList.addAtTail(4);
		linkedList.get(4);
		linkedList.addAtHead(4);

		linkedList.addAtIndex(5, 0);
		linkedList.addAtHead(6);

	}
}
