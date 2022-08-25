package com.example.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * <pre>
给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月16日 上午11:38:44
 *
 */
public class Solution23 {

	/**
	 * 输入：lists = [[1,4,5],[1,3,4],[2,6]] 输出：[1,1,2,3,4,4,5,6] 解释：链表数组如下： [ 1->4->5,
	 * 1->3->4, 2->6 ] 将它们合并到一个有序链表中得到。 1->1->2->3->4->4->5->6
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/merge-k-sorted-lists
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {

		if (lists.length == 0 ) {
			return null;
		}
		ListNode resHead = new ListNode();

		ListNode cur = resHead;

		/**
		 * 使用堆排序,java里面 有 个priqueue队列，底层就是堆排序，每次弹出小顶堆的订单，再入队
		 */

		PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
		});
		// 链表循环
		for (ListNode node : lists) {
			queue.add(node);
		}
		// 如果队列不为空
		while (queue.peek() != null) {
			ListNode node = queue.poll();

			if (node.next != null) {
				queue.add(node.next);
			}

			ListNode newNode = new ListNode();
			newNode.val = node.val;

			cur.next = newNode;
			cur = newNode;
		}

		return resHead.next;
	}
}
