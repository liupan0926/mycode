package com.example.leetcode;

import java.util.ArrayList;

/**
 * 循环双向链表,head 节点的 next是第一个节点，before是最后一个节点。最好的LRU算法的数据结构
 * 
 * @author liupan Jun 10, 2022 4:52:03 PM
 */
public class SecondLinkedList {

    //链表头结点
    private InnerListNode head;

    private int           maxLength = 0;

    public void initSecondLinkedList(int length) {
        InnerListNode head = new InnerListNode();
        head.val = -1;
        this.head = head;
        this.maxLength = length;
    }

    /**
     * 循环列表
     * 
     * @param val
     * @return
     */
    public InnerListNode isExistNode(InnerListNode node) {
        InnerListNode temp = head.next;
        while (temp != null && temp != head) {
            if (temp.val == node.val) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * @param node
     */
    public void moveNode(InnerListNode node) {
        InnerListNode bef = node.before;
        InnerListNode next = node.next;
        bef.next = next;
        next.before = bef;
        insertNode(node);
    }

    /**
     * 原子操作 插入头结点后面
     * 
     * @param node
     */
    public void insertOrMoveNode(InnerListNode node) {
        InnerListNode linkNode = isExistNode(node);
        if (linkNode != null) {
            moveNode(linkNode);
        } else {
            if (getLength() == this.maxLength) {
                deleteNode();
            }
            insertNode(node);
        }
        this.printList();
    }

    public void insertNode(InnerListNode node) {
        //如果是第一个节点 ，要组成循环列表，得有特殊处理
        node.before = head;
        if (head.next == null) {
            //循环起来
            node.next = head;
            head.before = node;
        } else {
            node.next = head.next;
            head.next.before = node;
        }
        head.next = node;
    }

    /**
     * 删除尾部的节点
     * 
     * @param node
     */
    public void deleteNode() {

        InnerListNode deleteNode = head.before;

        if (deleteNode != null) {
            InnerListNode bef = deleteNode.before;
            bef.next = head;
            head.before = bef;
        }
        System.out.println("删除尾部节点，val:" + deleteNode.val);
    }

    /**
     * 不算头结点的链表长度
     * 
     * @return
     */
    public int getLength() {
        int length = 0;
        InnerListNode temp = head.next;
        while (temp != null && temp != head) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public void printList() {
        ArrayList list = new ArrayList<>();
        InnerListNode temp = head.next;
        while (temp != null && temp != head) {
            list.add(temp.val);
            temp = temp.next;
        }
        System.out.println(list);
    }

    public InnerListNode getHead() {
        return head;
    }

    public void setHead(InnerListNode head) {
        this.head = head;
    }

    public static void main(String[] args) {
        SecondLinkedList list = new SecondLinkedList();

        list.initSecondLinkedList(5);

        InnerListNode node1 = new InnerListNode(1);

        list.insertOrMoveNode(node1);

        InnerListNode node3 = new InnerListNode(3);
        list.insertOrMoveNode(node3);

        InnerListNode node2 = new InnerListNode(2);
        list.insertOrMoveNode(node2);
        InnerListNode node4 = new InnerListNode(4);
        list.insertOrMoveNode(node4);
        InnerListNode node5 = new InnerListNode(5);
        list.insertOrMoveNode(node5);
        InnerListNode node6 = new InnerListNode(3);
        list.insertOrMoveNode(node6);

        InnerListNode node7 = new InnerListNode(7);
        list.insertOrMoveNode(node7);

        InnerListNode node8 = new InnerListNode(8);
        list.insertOrMoveNode(node8);
        InnerListNode node9 = new InnerListNode(4);
        list.insertOrMoveNode(node9);

    }
}
