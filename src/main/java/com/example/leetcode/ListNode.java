package com.example.leetcode;

/**
 * 链表原型 类ListNode.java的实现描述：TODO 类实现描述
 * 
 * @author liupan May 23, 2022 7:06:02 PM
 */
public class ListNode {
    int      val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
