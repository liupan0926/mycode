package com.example.leetcode;

/**
 * 
 * <pre>
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/rotate-image
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </pre>
 * 
 * @author liupan
 * @date 2022年8月21日 上午11:50:10
 *
 */
public class Solution48 {

	public static void main(String[] args) {

		// int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[][] matrix = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };

		Solution48 sol = new Solution48();

		sol.rotate(matrix);

		ArrayUtils.printArrays(matrix);
	}

	/**
	 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]] 输出：[[7,4,1],[8,5,2],[9,6,3]]
	 * 
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {

		// 看看几维的
		int n = matrix.length;

		// 奇数的话，中心点不变，n=1,0次循环，n=3，一层循环
		// 偶数的话，没有中心点, n=2 ,1次循环,n=4,两次循环

		int loop = n / 2;

		// 外层循环圈数
		for (int x = 0; x < loop; x++) {
			for (int i = 0 + x; i < n - 1 - x; i++) {
				// 旋转的4个等式
				// 没有循环时，第一层
				// 循环时，所有的坐标都得+x;
				int temp = matrix[0 + x][i];

				// 0行i列=0列n-1-i行；
				matrix[0 + x][i] = matrix[n - 1 - i][0 + x];

				// 0列n-1-i行 = n-1行n-1-i列;
				matrix[n - 1 - i][0 + x] = matrix[n - 1 - x][n - 1 - i];

				// 2列=2行；
				matrix[n - 1 - x][n - 1 - i] = matrix[i][n - 1 - x];

				// 1行=2列
				matrix[i][n - 1 - x] = temp;
			}
		}
	}

}
