package com.example.leetcode;

import java.util.LinkedList;

import com.alibaba.fastjson.JSON;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * <pre>
 * 
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月22日 下午8:56:40
 *
 */
public class Solution79 {

	LinkedList<int[]> path = new LinkedList();

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		Solution79 sol = new Solution79();

		System.out.println(sol.exist(board, "ABCCED"));

	}

	/**
	 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
	 * "ABCCED" 输出：true
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/word-search
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param board
	 * @param word
	 * @return
	 */

	public boolean exist(char[][] board, String word) {
	
		int[][] used = new int[board.length][board[0].length];
		return fetch(board, word, 0, used);
	}

	private boolean fetch(char[][] board, String word, int index, int[][] used) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (fetchNext(i, j, word, index, used, board)) {
					System.out.println(JSON.toJSONString(path));
					return true;
				}
			}
		}
		return false;
	}

	private boolean fetchNext(int i, int j, String word, int index, int[][] used, char[][] board) {

		if (index == word.length()) {
			return true;
		}
		if (i < 0 || i >= board.length) {
			return false;
		}

		if (j < 0 || j >= board[0].length) {
			return false;
		}

		if (board[i][j] != word.charAt(index)) {
			return false;
		}

		if (used[i][j] == 1) {
			return false;
		}

		used[i][j] = 1;

		int[] array = new int[2];
		array[0] = i;
		array[1] = j;

		path.add(array);
		// 上
		boolean flag = fetchNext(i, j - 1, word, index + 1, used, board);
		if (flag) {
			return true;
		}

		// 下
		flag = fetchNext(i, j + 1, word, index + 1, used, board);
		if (flag) {
			return true;
		}
		// 左
		flag = fetchNext(i - 1, j, word, index + 1, used, board);
		if (flag) {
			return true;
		}

		// 右
		flag = fetchNext(i + 1, j, word, index + 1, used, board);
		if (flag) {
			return true;
		}

		// 如果没找到
		used[i][j] = 0;
		path.removeLast();
		return false;
	}

}
