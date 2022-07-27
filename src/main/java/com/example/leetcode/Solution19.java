package com.example.leetcode;

/**
 * 
 * <pre>
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 
 * 
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月19日 下午5:03:25
 *
 */
public class Solution19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode dummy = new ListNode(-1);

		dummy.next = head;

		// [1,2] 2
		ListNode slow = dummy;
		ListNode fast = dummy;

		int j = 1;
		// n=2,倒数第2个节点，则间隔1个
		while (j <= n) {
			fast = fast.next;
			j++;
		}
		// 确认fast跟slow的位置以后,开始循环到链表尾部

		// 删节点时，其实是需要确认要删节点的前面一个节点的位置，
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return dummy.next;
	}
}
