package com.example.leetcode;

public class SolutionTest3 {

	public static void main(String[] args) {

		ListNode l1 = new ListNode();

		l1.val = 1;

		ListNode l2 = new ListNode();

		l2.val = 3;

		ListNode l3 = new ListNode();
		l3.val = 4;

		l1.next = l2;
		l2.next = l3;

		SolutionTest3 sol = new SolutionTest3();

		ListNode res = sol.reverse(l1);

		sol.printNode(res);
	}

	public void printNode(ListNode res) {

		ListNode cur = res;
		while (cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}

	}

	public ListNode reverse(ListNode listNode) {

		if (listNode.next == null) {
			return listNode;
		}

		ListNode head = reverse(listNode.next);

		listNode.next.next = listNode;

		listNode.next = null;

		return head;
	}
}
