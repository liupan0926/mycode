package com.example.leetcode;

/**
 * 
 * <pre>
 * 现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年7月25日 下午4:41:44
 *
 */
public class Solution_Offer04 {

	/**
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		// 从左下角开始

		// 指针只能是向右和向上移动
		int row = matrix.length;
		int col = matrix[0].length;

		int curRow = row - 1;
		int curCol = 0;

		while (curCol < col && curRow < row) {
			int number = matrix[curRow][curCol];
			if (target == number) {
				return true;
			}

			if (target > number) {
				curCol++;
			} else if (target < number) {
				curRow--;
			}
		}

		return false;

	}
}
