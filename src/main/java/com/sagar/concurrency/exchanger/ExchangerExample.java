package com.sagar.concurrency.exchanger;

import java.util.concurrent.Exchanger;

/**
 * The java.util.concurrent.Exchanger class represents a kind of rendezvous
 * point where two threads can exchange objects.
 * 
 * @author sitapsha
 *
 */
public class ExchangerExample {

    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger<String>();
        new Thread(new Task(exchanger, "A")).start();
        new Thread(new Task(exchanger, "B")).start();

//        new Thread(new Task(exchanger, "C")).start();  ---- This will cause infinite waiting for exchange partner/Thread

    }

}

class Task implements Runnable {

    String data;
    Exchanger<String> exchanger;

    public Task(Exchanger<String> exchanger, String data) {
        this.data = data;
        this.exchanger = exchanger;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is Running");

            System.out.println(Thread.currentThread().getName() + " is ready to exchang data : " + data);
            data = exchanger.exchange(data);
            System.out.println(Thread.currentThread().getName() + " exchange done! new data : " + data);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}