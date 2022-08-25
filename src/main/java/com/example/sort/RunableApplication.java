package com.example.sort;

public class RunableApplication {

	public static void main(String[] args) {

		Runnable run = new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 50; i++) {
					int res = i * 2 + 1;
					System.out.println(res);
				}

			}
		};

		for (int i = 0; i < 50; i++) {
			int res = i * 2 + 2;
			System.out.println(res);
		}

		Thread r = new Thread(run);

		r.start();
		// r.run();

		System.out.println(Thread.currentThread().getName() + "_hello");
	}

}
