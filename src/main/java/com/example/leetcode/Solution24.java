package com.example.leetcode;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）
 * 类Solution24.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jun 15, 2022 3:45:44 PM
 */
public class Solution24 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);

        ListNode num2 = new ListNode(2);
        ListNode num3 = new ListNode(3);
        ListNode num4 = new ListNode(4);
        ListNode num5 = new ListNode(5);

        head.next = num2;
        num2.next = num3;
        num3.next = num4;
        num4.next = num5;

        System.out.println(swapPairs(head));
    }

    //写个递归的

    public static ListNode swapPairs(ListNode head) {

        ListNode node1 = head;
        ListNode bef = null;

        ListNode res = swap(bef, node1);
        ListNode.printListNode(res);
        return res;
    }

    public static ListNode swap(ListNode bef, ListNode node1) {

        if (node1 == null) {
            return null;
        }
        if (node1.next == null) {
            return node1;
        }

        ListNode node2 = node1.next;
        ListNode temp = node2.next;

        node2.next = node1;
        node1.next = temp;

        if (bef != null) {
            bef.next = node2;
        }

        bef = node1;
        swap(bef, node1.next);

        return node2;
    }

    //    public static ListNode swapPairs(ListNode head) {
    //
    //        if (head.next == null) {
    //            return head;
    //        }
    //
    //        //双指针,如果是奇数，剩下一个节点，则不交换
    //        ListNode left = head;
    //        ListNode right = head.next;
    //
    //        //交换节点的逻辑
    //        ListNode temp = right.next;
    //
    //        right.next = left;
    //        left.next = temp;
    //        //设置头结点
    //        head = right;
    //
    //        ListNode bef = left;
    //        
    //        //temp节点就是原始的链表
    //        while (temp != null) {
    //            ListNode node1 = temp;
    //            ListNode node2 = node1.next;
    //            //奇数节点
    //            if (node2 == null) {
    //                break;
    //            }
    //
    //            temp = node2.next;
    //            node2.next = node1;
    //            node1.next = temp;
    //            bef.next = node2;
    //            //bef 和 temp 需要循环
    //            bef = node1;
    //        }
    //
    //        List<Integer> list = new ArrayList<>();
    //        ListNode tem = head;
    //        while (tem != null) {
    //            list.add(tem.val);
    //            tem = tem.next;
    //        }
    //        System.out.println(list);
    //
    //        return head;
    //    }
}
