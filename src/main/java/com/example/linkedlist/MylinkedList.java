package com.example.linkedlist;

public class MylinkedList {

	// 虚拟头节点 ，不计算此节点索引，值为null
	MyNode head = null;

	/**
	 * 单链表
	 */
	public MylinkedList() {
		head = new MyNode();
		head.next = null;
	}

	/**
	 * index 从0开始
	 * 
	 * @param index
	 * @return
	 */
	public MyNode getNodeByIndex(int index) {
		int count = 0;
		MyNode cur = head;

		// head->0->1;
		while (count <= index) {
			cur = cur.next;
			if (cur == null) {
				return null;
			}
			count++;
		}
		return cur;
	}

	public int get(int index) {
		MyNode node = getNodeByIndex(index);
		if (node == null) {
			return -1;
		}
		return node.val;
	}

	public void addAtHead(int val) {
		MyNode node = new MyNode();
		node.val = val;
		node.next = head.next;
		head.next = node;
	}

	public int listSize() {
		MyNode cur = head;
		int size = 0;
		while (cur.next != null) {
			cur = cur.next;
			size++;
		}
		return size;
	}

	public void addAtTail(int val) {

		MyNode addNode = new MyNode();
		addNode.val = val;

		MyNode cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = addNode;
	}

	/**
	 * 在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index
	 * 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/design-linked-list
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param index
	 * @param val
	 */
	public void addAtIndex(int index, int val) {
		if (index < 0) {
			addAtHead(val);
		}
		int size = listSize();

		if (index > size) {
			return;
		}
		if (index == size) {
			addAtTail(val);
		}
		if (index < size) {
			// index =0时，
			MyNode cur = getNodeByIndex(index);
			MyNode pre;
			if (index == 0) {
				pre = head;
			} else {
				pre = getNodeByIndex(index - 1);
			}
			MyNode node = new MyNode();
			node.val = val;
			pre.next = node;
			node.next = cur;
		}
	}

	public void deleteAtIndex(int index) {
		// 一共多少个节点
		int size = this.listSize();
		// index从0开始，最后一个的index = size-1;
		if (index >= 0 && index <= size - 1) {
			MyNode cur = getNodeByIndex(index);
			MyNode pre;
			if (index == 0) {
				pre = head;
			} else {
				pre = getNodeByIndex(index - 1);
			}
			pre.next = cur.next;
			cur = null;
		} else {
			System.out.println("index无效");
		}
	}

	public void print() {
		MyNode cur = head;
		System.out.println("print starts:");
		while (cur.next != null) {
			cur = cur.next;
			System.out.println(cur.val);
		}
	}
}
