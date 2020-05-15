package com.sagar.concurrency;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConcurrencyApplication {

	public static void main(String[] args) throws InterruptedException {
		// SpringApplication.run(ConcurrencyApplication.class, args);

		Map<Integer, Integer> data = new HashMap<>();

		Runnable r1 = () -> {

			for (int i = 0; i < 5000000; i++) {
				data.put(i, i);
				System.out.println("--------");

			}
		};

		Runnable r2 = () -> {

			for (int i = 0; i < 5000000; i++) {
				System.out.println("check");
				if (data.containsKey(i)) {
					System.out.println(true);
				}
			}
		};

		Thread t1 = new Thread(r1);
		t1.start();
		Thread t2 = new Thread(r2);
		t2.start();

		System.out.println("End11111111111111111");
//		t1.join();
//		t2.join();
		System.out.println("End22222222222222222");

	}

}
