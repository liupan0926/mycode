package com.example.leetcode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 
 * @author liupan Jun 5, 2022 4:25:55 PM
 */
public class MergeLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode();

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while (temp1 != null || list2 != null) {

            ListNode newNode = new ListNode();

            if (temp1 == null) {
                newNode.val = temp2.val;
                temp2 = temp2.next;
            } else if (temp2 == null) {
                newNode.val = temp1.val;
                temp1 = temp1.next;
            } else if (temp1.val <= temp2.val) {
                newNode.val = temp1.val;
                temp1 = temp1.next;
            } else {
                newNode.val = temp2.val;
                temp2 = temp2.next;
            }

            head.next = newNode;
            newNode.next = null;
        }

        return head.next;
    }
}
