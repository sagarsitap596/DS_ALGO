package com.sagar.concurrency.phaser;

import java.util.concurrent.Phaser;

public class PhaserExample {

    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser();
        phaser.register();// register self... phaser waiting for 1 party (thread)
        System.out.println(phaser.getUnarrivedParties());
        phaser.arriveAndAwaitAdvance();
        System.out.println(phaser.getUnarrivedParties());
        int phasecount = phaser.getPhase();
        System.out.println("Phasecount is " + phasecount);
        new PhaserExample().testPhaser(phaser, 2000);// phaser waiting for 2 parties
        new PhaserExample().testPhaser(phaser, 4000);// phaser waiting for 3 parties
        new PhaserExample().testPhaser(phaser, 6000);// phaser waiting for 4 parties
        /**
         * now that all threads are initiated, we will de-register main thread so that
         * the barrier condition of 3 thread arrival is meet.
         */
        phaser.arriveAndDeregister();
        System.out.println("Main Thread resumed");
        phasecount = phaser.getPhase();
        System.out.println("Phasecount is " + phasecount);

    }

    private void testPhaser(final Phaser phaser, final int sleepTime) {
        phaser.register();
        new Thread() {
            @Override
            public void run() {
                try {
                    
                    Thread.sleep(sleepTime);
                    System.out.println(Thread.currentThread().getName() + " arrived");
                    phaser.arriveAndAwaitAdvance();// threads register arrival to the phaser.
                    System.out.println(Thread.currentThread().getName() + " after passing barrier");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }
}
