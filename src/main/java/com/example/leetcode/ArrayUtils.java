package com.example.leetcode;

public class ArrayUtils {

	public static void printArrays(int[][] mt) {
		for (int i = 0; i < mt.length; i++) {
			for (int j = 0; j < mt[0].length; j++) {
				System.out.println("i:" + i + ",j:" + j + ",value:" + mt[i][j]);
			}
		}
	}

}
