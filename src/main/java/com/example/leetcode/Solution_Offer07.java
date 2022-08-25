package com.example.leetcode;

import java.util.Arrays;

/**
 * 
 * <pre>
输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。

假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月27日 下午5:13:16
 *
 */
public class Solution_Offer07 {

	public static void main(String[] args) {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };

		System.out.println(buildTree(preorder, inorder));
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		/**
		 * 思路就是递归,前序的第一个就是根节点，中序的根节点左边的都是左节点
		 * 
		 */

		if (preorder.length == 0) {
			return null;
		}

		int root = preorder[0];

		int rootIndex = getRootIndex(root, inorder);

		TreeNode rootNode = new TreeNode();
		rootNode.val = root;
		// preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]

		// 左子树，前序是[9],中序也是9，rootIndex = 1;
		int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
		int[] leftInOrder = Arrays.copyOfRange(inorder, 0, rootIndex);
		// 右子树,前序是 20,15,7, 中序是 15，20，7
		int[] rightPrePrder = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);

		int[] rightInPrder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);

		rootNode.left = buildTree(leftPreOrder, leftInOrder);
		rootNode.right = buildTree(rightPrePrder, rightInPrder);

		return rootNode;
	}

	private static int getRootIndex(int root, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == root) {
				return i;
			}
		}
		return 0;
	}
}
