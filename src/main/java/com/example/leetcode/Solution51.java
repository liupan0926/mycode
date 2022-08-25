package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <pre>
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/n-queens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月29日 下午3:23:07
 *
 */
public class Solution51 {

	List<List<String>> res = new ArrayList<>();

	public static void main(String[] args) {
		Solution51 sol = new Solution51();

		System.out.println(sol.solveNQueens(3));
	}

	/**
	 * 输入：n = 4 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
	 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/n-queens
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param n
	 * @return
	 */
	public List<List<String>> solveNQueens(int n) {

		String[][] strArrays = new String[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				strArrays[i][j] = ".";
			}
		}

		int row = 0;
		// 设置皇后位置开始回溯
		// 记录列使用情况
		// 行是循环保证每一行只有一个
		// 关键是斜的

		setQ(strArrays, row, n);

		return res;

	}

	/*
	 * 
	 */
	private void setQ(String[][] strArrays, int row, int n) {

		// 找到答案,行数为4时,代表前面都找到答案了
		if (row == n) {
			List<String> thisRes = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++) {
					sb.append(strArrays[i][j]);
				}
				thisRes.add(sb.toString());
			}
			res.add(thisRes);
			return;
		}

		for (int col = 0; col < n; col++) {
			if (isValid(row, col, strArrays, n)) {
				strArrays[row][col] = "Q";
				setQ(strArrays, row + 1, n);
				strArrays[row][col] = ".";
			}
		}
	}

	/**
	 * 验证合法就可以放置
	 * 
	 * @param row
	 * @param col
	 * @param strArrays
	 * @param n
	 * @return
	 */
	private boolean isValid(int row, int col, String[][] strArrays, int n) {

		// 竖着

		for (int tempRow = row; tempRow >= 0; tempRow--) {
			if (strArrays[tempRow][col] == "Q") {
				return false;
			}
		}
		// 左上斜
		for (int tempRow = row, tempCol = col; tempRow >= 0 && tempCol >= 0; tempRow--, tempCol--) {
			if (strArrays[tempRow][tempCol] == "Q") {
				return false;
			}
		}

		// 右上斜
		for (int tempRow = row, tempCol = col; tempRow >= 0 && tempCol < n; tempRow--, tempCol++) {
			if (strArrays[tempRow][tempCol] == "Q") {
				return false;
			}
		}

		return true;
	}

}
