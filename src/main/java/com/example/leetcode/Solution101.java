package com.example.leetcode;

/**
 * 
 * <pre>
给你一个二叉树的根节点 root ， 检查它是否轴对称。
https://leetcode.cn/problems/symmetric-tree/
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月17日 上午9:56:49
 *
 */
public class Solution101 {
	/**
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {

		TreeNode left = root.left;
		TreeNode right = root.right;

		return isDc(left, right);

	}

	private boolean isDc(TreeNode left, TreeNode right) {

		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}

		if (left.val != right.val) {
			return false;
		}

		return isDc(left.left, right.right) && isDc(left.right, right.left);
	}
}
