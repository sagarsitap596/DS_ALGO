package com.sagar.concurrency.countdownlatch;

import java.util.PriorityQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Task 1 to 4 runs and waits for all the task to complete at some point.
 * Once task is completed, countdown()  is called. and Task  waits for other tasks to complete by calling await()
 * Once countdown reaches to zero. All the waiting task are resumed.
 * 
 * In our case task 4 is hig priority task. So task 4 waits for just 2 seonds and resumes irrespective of other task status.
 * 
 * Note : CountDownLatch cannot be reused.
 * 
 * @author sitapsha
 *
 */
public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        
        PriorityQueue<String> q = new PriorityQueue<String>();

        Task t1 = new Task(1, latch);
        Task t2 = new Task(2, latch);
        Task t3 = new Task(3, latch);
        Task t4 = new Task(4, latch);
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();

        latch.await();
        System.out.println("Main Tread completed");

    }

}

class Task implements Runnable {

    int taskNo;
    CountDownLatch latch;

    public Task(int taskNo, CountDownLatch latch) {
        this.taskNo = taskNo;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task : " + taskNo + " running ");
            if (taskNo != 4) {
                Thread.sleep(taskNo * 3000);
            }
            System.out.println("Task : " + taskNo + " completed ");
            latch.countDown();
            System.out.println("Task : " + taskNo + " wating for other Tasks to complete ");
            if (taskNo == 4) {
                latch.await(2, TimeUnit.SECONDS);
                System.out.println("Task : " + taskNo + " cannot wait for more atn 2 seconds.");
            } else {
                latch.await();
            }
            System.out.println("Task : " + taskNo + " resumed and final step Completed ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
