package com.example.leetcode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 
 * <pre>
 * 
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月18日 下午3:30:03
 *
 */
public class Solution206 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(3);
		ListNode head4 = new ListNode(4);
		ListNode head5 = new ListNode(5);
		head.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;

		ListNode newHead = reverseList(head);

		ListNode.printListNode(newHead);
	}

	public static ListNode reverseList(ListNode head) {

		// 递归的出口
		if (head.next == null) {
			return head;
		}

		ListNode reverse = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return reverse;
	}
}
