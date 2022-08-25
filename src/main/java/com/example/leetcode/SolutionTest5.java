package com.example.leetcode;

public class SolutionTest5 {

	public static volatile boolean isT1 = true;

	public static volatile boolean isT2 = false;
	public static volatile boolean isT3 = false;
	public static volatile boolean isT4 = false;

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {

					if (isT1) {
						System.out.println(1);

						isT1 = false;
						isT2 = true;
					}

				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					if (isT2) {
						System.out.println(2);
						isT2 = false;
						isT3 = true;
					}

				}
			}
		});
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					if (isT3) {
						System.out.println(3);
						isT3 = false;
						isT4 = true;
					}

				}
			}
		});
		Thread t4 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					if (isT4) {
						System.out.println(4);
						isT4 = false;
						isT1 = true;
					}

				}
			}
		});

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
