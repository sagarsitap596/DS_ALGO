package com.sagar.concurrency;

/**
 * Used for flags mostly
 * 
 * @author sitapsha
 *
 */
public class VolatileExample {
	static volatile Boolean isAlive = new Boolean(true);

	public static void main(String[] args) {

		new Thread1().start();
		new Thread2().start();
	}
}

class Thread1 extends Thread {

	@Override
	public void run() {
		System.out.print("Worker is Working");
		while (VolatileExample.isAlive) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println("Worker is asleep. can't work");
	}
}

class Thread2 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		VolatileExample.isAlive = false;
		System.out.println();
		System.out.println("Thread2 has put worker on sleep mode");
	}

}
