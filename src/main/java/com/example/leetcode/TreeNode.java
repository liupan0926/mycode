package com.example.leetcode;

/**
 * 二叉树
 * 
 * @author liupan May 30, 2022 3:03:51 PM
 */
public class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
