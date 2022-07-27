package com.example.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * 反转单链表 类ReverseLianBiao.java的实现描述：TODO 类实现描述
 * 
 * @author liupan May 23, 2022 7:05:23 PM
 */
public class ReverseLianBiao {

    public static void main(String[] args) {
        ListNode head = buildHead();
        System.out.println(JSON.toJSONString(head));
        ListNode result = reverseList(head);
        System.out.println(JSON.toJSONString(result));
    }

    private static ListNode buildHead() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);

        head.next = second;
        second.next = third;

        return head;
    }

    public static ListNode reverseList(ListNode head) {

        //1.头结点插入
        //        ListNode resultHead = new ListNode();
        //        if (head == null) {
        //            return null;
        //        }
        //      
        //
        //        while (head != null) {
        //            ListNode temp = new ListNode();
        //            temp.setVal(head.val);
        //            temp.next = resultHead.next;
        //            resultHead.next = temp;
        //
        //            head = head.next;
        //        }

        //尝试下递归

        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tail;

    }
}
