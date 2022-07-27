package com.example.leetcode;

/**
 * 
 * <pre>
给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月20日 上午10:28:24
 *
 */
public class Solution0207 {

	public static void main(String[] args) {
		ListNode headA = buildHeadA();
		ListNode headB = buildHeadB();

		ListNode res = getIntersectionNode(headA, headB);

		System.out.println(res);
	}

	private static ListNode buildHeadA() {
		ListNode head = new ListNode(4);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(8);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);

		head.next = second;
		second.next = third;
		third.next = four;
		four.next = five;
		return head;
	}

	private static ListNode buildHeadB() {

		ListNode prehead = new ListNode(5);
		ListNode head = new ListNode(0);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(8);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);

		prehead.next = head;
		head.next = second;
		second.next = third;
		third.next = four;
		four.next = five;
		return prehead;
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = getLength(headA);
		int lenB = getLength(headB);

		int diff = 0;
		boolean isLongA = false;
		if (lenA >= lenB) {
			diff = lenA - lenB;
			isLongA = true;
		} else {
			diff = lenB - lenA;
		}

		ListNode from = null;
		ListNode tempA = headA;
		ListNode tempB = headB;
		if (isLongA) {
			from = getByIndex(headA, diff);
			tempA = from;
		} else {
			from = getByIndex(headB, diff);
			tempB = from;
		}

		while (tempA != tempB && tempA != null && tempB != null) {
			tempA = tempA.next;
			tempB = tempB.next;
		}

		// 证明找到了
		if (tempA != null) {
			return tempA;
		}

		return null;
	}

	public static ListNode getByIndex(ListNode head, int index) {

		ListNode temp = head;
		// 如果index=0,返回头节点
		while (index > 0) {
			temp = temp.next;
			index--;
		}
		return temp;
	}

	public static int getLength(ListNode head) {
		ListNode cur = head;
		int i = 0;
		while (cur != null) {
			i++;
			cur = cur.next;
		}
		return i;
	}
}
