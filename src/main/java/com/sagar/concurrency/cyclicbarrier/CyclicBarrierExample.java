package com.sagar.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 * In below example Two Threads waits at barries 1 and once both threads arrives
 * barrier1Action is executed and then both threads are resumed.
 * 
 * Then again , bith Threads waits at barries 2 and once both threads arrives
 * barrier2Action is executed and then both threads are resumed.
 * 
 * Then again, Threads waits at barries 1 and once both threads arrives
 * barrier1Action is executed and then both threads are resumed. ------ This
 * shows we can reuse same barrier
 * 
 * @author sitapsha
 *
 */
public class CyclicBarrierExample {

    public static void main(String[] args) throws InterruptedException {
        Runnable barrier1Action = new Runnable() {
            public void run() {
                System.out.println("BarrierAction 1 executed ");
            }
        };
        Runnable barrier2Action = new Runnable() {
            public void run() {
                System.out.println("BarrierAction 2 executed ");
            }
        };

        CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
        CyclicBarrier barrier2 = new CyclicBarrier(2, barrier2Action);

        CyclicBarrierRunnable barrierRunnable1 = new CyclicBarrierRunnable(barrier1, barrier2);

        CyclicBarrierRunnable barrierRunnable2 = new CyclicBarrierRunnable(barrier1, barrier2);

        new Thread(barrierRunnable1).start();
        new Thread(barrierRunnable2).start();
    }

}

class CyclicBarrierRunnable implements Runnable {

    CyclicBarrier barrier1 = null;
    CyclicBarrier barrier2 = null;

    public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {

        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }

    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " waiting at barrier 1");
            this.barrier1.await();

            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " waiting at barrier 2");
            this.barrier2.await();

            /**
             * Reuse Barrier
             */
            System.out.println(Thread.currentThread().getName() + " again waiting at barrier 1");
            this.barrier1.await();

            System.out.println(Thread.currentThread().getName() + " done!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}