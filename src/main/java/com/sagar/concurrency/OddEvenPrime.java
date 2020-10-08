package com.sagar.concurrency;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;

public class OddEvenPrime {

	public static volatile boolean shouldRun = true;

	public static void main(String[] args) throws InterruptedException {
		Phaser phaser = new Phaser();
		Exchanger<Integer> exchanger = new Exchanger<Integer>();

		EvenThread evenThread = new EvenThread(phaser, exchanger);

		OddThread oddThread = new OddThread(phaser, exchanger);
		PrimeThread primeThread = new PrimeThread(exchanger);

		new Thread(oddThread, "Odd").start();
		new Thread(evenThread, "Even").start();
		new Thread(primeThread, "Prime").start();

	}

	public static boolean isPrime(int n) {

		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}

class EvenThread implements Runnable {

	Phaser phaser;
	Exchanger<Integer> exchanger;

	public EvenThread(Phaser phaser, Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
		this.phaser = phaser;
	}

	@Override
	public void run() {
		phaser.register();
		for (int n = 2; n <= 100; n += 2) {
			phaser.arriveAndAwaitAdvance();//
			if (OddEvenPrime.isPrime(n)) {
				try {
					exchanger.exchange(n);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println(Thread.currentThread().getName() + "-" + n);
			}
			phaser.arriveAndAwaitAdvance();
		}
		OddEvenPrime.shouldRun = false;
	}
}

//   
class OddThread implements Runnable {

	Phaser phaser;
	Exchanger<Integer> exchanger;

	public OddThread(Phaser phaser, Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
		this.phaser = phaser;
	}

	@Override
	public void run() {
		phaser.register();
		for (int n = 1; n < 100; n += 2) {

			if (OddEvenPrime.isPrime(n)) {
				try {
					exchanger.exchange(n);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println(Thread.currentThread().getName() + "-" + n);
			}
			phaser.arriveAndAwaitAdvance(); //
			phaser.arriveAndAwaitAdvance();
		}
	}
}

class PrimeThread implements Runnable {

	Exchanger<Integer> exchanger;

	PrimeThread(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		while (OddEvenPrime.shouldRun) {
			try {
				int n = exchanger.exchange(-1);
				System.out.println(Thread.currentThread().getName() + "-" + n);
				;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
