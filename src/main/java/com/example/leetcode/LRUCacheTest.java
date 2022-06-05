package com.example.leetcode;

/**
 * 本地的相关算法类 类LRUCacheTest.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Sep 4, 2021 11:21:36 AM
 */
public class LRUCacheTest {

    /**
     * <pre>
     * 使用带头结点的单链表 实现 LRU算法。 
     * 1.
     * </pre>
     */

    public static void main(String[] args) {

        SingLinkedList list = new SingLinkedList(5);

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        ListNode node6 = new ListNode(6);

        list.insertNode(node1);
        list.insertNode(node2);
        list.insertNode(node3);
        list.insertNode(node4);
        list.insertNode(node5);

        list.printListNode();

        list.insertNode(node3);
        list.printListNode();

        list.insertNode(node6);
        list.printListNode();

    }

}
