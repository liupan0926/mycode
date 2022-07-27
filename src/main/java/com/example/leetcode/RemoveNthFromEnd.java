package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 类RemoveNthFromEnd.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jun 6, 2022 8:06:39 PM
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);

        ListNode num1 = new ListNode(1);
        head.next = num1;

        ListNode resHead = removeNthFromEnd(head, 1);

        while (resHead != null) {
            System.out.println(resHead.val);
            resHead = resHead.next;
        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<ListNode>();

        ListNode temp = head;
        while (temp.next != null) {
            list.add(temp.next);
            temp = temp.next;
        }

        //假如一共5个节点，倒数第一个就是index =4;删除最后节点时，要找前一个节点的地址，即index=3;
        int length = list.size();
        ListNode before = null;
        // 1=< n <= length; 
        if (length >= n + 1) {
            before = list.get(length - n - 1);
        } else {
            before = head;
        }
        if (length >= n) {
            ListNode delNode = list.get(length - n);
            before.next = delNode.next;
        }

        return head.next;
    }
}
