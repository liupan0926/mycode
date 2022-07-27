package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。 
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 * </pre>
 * 
 * @author liupan May 30, 2022 3:04:24 PM
 */
public class SumRootToLeaf {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);

        TreeNode right1 = new TreeNode(1);
        root.right = right1;

        TreeNode right21 = new TreeNode(1);
        right1.right = right21;

        TreeNode right30 = new TreeNode(0);
        TreeNode right31 = new TreeNode(1);

        right21.left = right30;
        right21.right = right31;

        System.out.println(root);

        //先序打印 
        printTree(root);

    }

    private static void printTree(TreeNode root) {

        if (root == null) {
            return;
        }
        System.out.println(root.val);

        printTree(root.left);
        printTree(root.right);
    }

    public int sumRootToLeaf(TreeNode root) {
        int res = 0;

        //如何遍历一颗树,二叉树的后序遍历，先左子树，再右子树，最后 root;
        List<Integer> treeList = new ArrayList<Integer>();
        postorder(root, treeList);

        return res;
    }

    public void postorder(TreeNode root, List<Integer> treeList) {
        if (root == null) {
            return;
        }

        postorder(root.left, treeList);
        postorder(root.right, treeList);
        treeList.add(root.val);
    }
}
