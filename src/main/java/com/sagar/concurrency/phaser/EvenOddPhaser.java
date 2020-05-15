package com.sagar.concurrency.phaser;

import java.util.concurrent.Phaser;

public class EvenOddPhaser {

    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser();

        Runnable even = () -> {
            phaser.register();
            for (int i = 0; i <= 20; i += 2) {

                System.out.println(i);
//                phaser.arriveAndAwaitAdvance();
//                phaser.arriveAndAwaitAdvance();
                System.out.println("Current phase : "+phaser.getPhase());
                int phase = phaser.arrive();
                System.out.println("Even1 phase : "+phase);
                System.out.println("Current phase : "+phaser.getPhase());
                System.out.println("Current phase : "+phaser.getPhase());
                phaser.awaitAdvance(30);
                phase = phaser.arrive();
                System.out.println("Even2 phase : "+phase);
                phaser.awaitAdvance(phase);
            }
        };

        Runnable odd = () -> {
            phaser.register();
            for (int i = 1; i < 20; i += 2) {
//                phaser.arriveAndAwaitAdvance();
                int phase = phaser.arrive();
                System.out.println("Odd1 phase : " + phase);
                phaser.awaitAdvance(phase);
                System.out.println(i);
//                phaser.arriveAndAwaitAdvance();
                phase = phaser.arrive();
                System.out.println("Odd2 phase : " + phase);
                phaser.awaitAdvance(phase);
            }
        };

        new Thread(even).start();
//        new Thread(odd).start();

//        System.out.println(phaser.getRegisteredParties());
//        System.out.println(phaser.getUnarrivedParties());
//        Thread.sleep(3000);
//        System.out.println(phaser.getPhase());

//        phaser.forceTermination();

    }

}
