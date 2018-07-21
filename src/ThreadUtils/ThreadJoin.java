package ThreadUtils;

import java.util.concurrent.TimeUnit;

public class ThreadJoin {
	public static void main(String[] args) throws Exception {
		Thread previous = Thread.currentThread();
		for (int i = 0; i < 10; i++) {
			// Thread 传入一个进程变量   String.valueOf(i) 进程名字
			// 每个线程拥有前一个线程的引用，需要等待前一个线程终止，才能从等待中返回
			Thread thread = new Thread(new Domino(previous), String.valueOf(i));
			thread.start();
			previous = thread;
		}
		TimeUnit.SECONDS.sleep(5);
		System.out.println(Thread.currentThread().getName() + " terminate.");
	}

	static class Domino implements Runnable {
		private Thread thread;

		public Domino(Thread thread) {
			this.thread = thread;
		}

		public void run() {
			try {
				thread.join(); // 等待上一个进程结束
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName() + " terminate.");
		}
	}
}