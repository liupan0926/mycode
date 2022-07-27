package com.example.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		List<String> timeList = new ArrayList<>();
//
//		for (int i = 0; i < n; i++) {
//			String str = sc.next();
//			timeList.add(str);
//		}
		List<String> timeList = new ArrayList<>();
		String time1 = "08:02:03.033";

		String time2 = "01:02:03.33";
		String time3 = "01:02:03.033";
		String time4 = "10:02:03.133";

		timeList.add(time1);
		timeList.add(time2);
		timeList.add(time3);
		timeList.add(time4);

		timeList.sort(new Comparator<String>() {

			@Override
			public int compare(String time1, String time2) {
				String[] arr1 = time1.split(":");
				String[] arr2 = time2.split(":");

				int res = 0;

				res = myCompare(arr1[0], arr2[0], 2);
				if (res == 0) {
					res = myCompare(arr1[1], arr2[1], 2);
					if (res == 0) {
						String strSec1 = arr1[2];
						String strSec2 = arr2[2];
						String sec1 = strSec1.substring(0, strSec1.indexOf("."));
						String sec2 = strSec2.substring(0, strSec1.indexOf("."));
						res = myCompare(sec1, sec2, 2);

						if (res == 0) {
							String miSec1 = strSec1.substring(strSec1.indexOf(".") + 1);
							String miSec2 = strSec2.substring(strSec2.indexOf(".") + 1);
							res = myCompare(miSec1, miSec2, 3);
						}
					}
				}

				return res;

			}
		});

		for (String s : timeList) {
			System.out.println(s);
		}

	}

//	public static void main(String[] args) {
//		String a = "1";
//		String b = "12";
//
//		// String str = a.replaceAll("^(0+)", "");
//
//		String str1 = flashleft('0', "1", 2);
//
//		System.out.println(compare("3", "02", 2));
//
//	}

	public static int myCompare(String hour1, String hour2, int length) {
		String str1 = flashleft('0', hour1, length);
		String str2 = flashleft('0', hour2, length);

		int res = 0;
		if (str1.equals(str2)) {
			return 0;
		}

		for (int i = 0; i < length; i++) {
			int a = str1.charAt(i) - '0';
			int b = str2.charAt(i) - '0';
			if (a < b) {
				return -1;
			} else if (a > b) {
				return 1;
			} else {
				continue;
			}
		}
		return res;
	}

	public static String flashleft(char c, String str, int length) {
		String cs = "";
		String res = "";
		if (str.length() >= length) {
			res = str;
		}
		for (int i = 0; i < length - str.length(); i++) {
			cs = cs + c;
		}
		res = cs + str;
		return res;
	}

}
