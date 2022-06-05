package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 单链表 类SingLinkedList.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jun 4, 2022 3:33:26 PM
 */
public class SingLinkedList {

    private ListNode head;

    //不包括头结点的长度,限制链表的长度
    private int      size;

    public SingLinkedList(int size) {
        ListNode head = new ListNode();
        head.next = null;
        head.val = -1;

        this.head = head;
        this.size = size;
    }

    /**
     * 当超出链表长度时，淘汰末尾的Node
     */
    public void deleteNode() {
        ListNode before = head;
        ListNode temp = before.next;
        while (temp.next != null) {
            before = before.next;
            temp = temp.next;
        }

        //找到before和temp的位置以后，
        System.out.println("淘汰节点value:" + temp.val);
        before.next = null;
    }

    /**
     * 不算头结点的长度
     * 
     * @param head
     * @return
     */
    public int getLength() {
        int len = 0;
        ListNode temp = head;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    /**
     * @param node
     * @param head
     */
    public void insertNode(ListNode node) {

        //1.先判断此Node是否在链表当中
        //如果不在，直接插入到头结点后面
        ListNode cur = nodeInHead(node);
        //新插入,需要考虑链表长度
        if (cur.val == head.val) {
            node.next = head.next;
            head.next = node;
            if (getLength() > size) {
                deleteNode();
            }
        } else { //如果在，需要挪动节点
            cur.next = node.next;
            node.next = head.next;
            head.next = node;
        }
    }

    public void printListNode() {

        List<Integer> nums = new ArrayList<Integer>();

        ListNode temp = head.next;
        while (temp != null) {
            nums.add(temp.val);
            temp = temp.next;
        }
        System.out.println(nums);
    }

    /**
     * 找到要插入的节点位置
     * 
     * @param node
     * @param head
     * @return
     */
    private ListNode nodeInHead(ListNode node) {
        //循环指针
        ListNode cur = head;
        while (cur.next != null) {
            //有重复的节点
            if (cur.next.val == node.val) {
                return cur;
            } else {
                cur = cur.next;
            }
        }
        //无重复节点
        return head;
    }

    public ListNode getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
