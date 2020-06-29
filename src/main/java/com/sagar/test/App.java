package com.sagar.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class App {

	public static void main(String[] args) {
		Map<Integer, Integer> m = new ConcurrentHashMap<>();
		m.put(1, 1);
		m.put(11, 11);
		m.put(111, 111);

		Runnable r1 = () -> {
			m.put(2, 2);
			m.put(22, 22);
		};

		Runnable r2 = () -> {
			Iterator<Integer> it = m.keySet().iterator();

			while (it.hasNext()) {
				System.out.println("Size :" + m.size());
				System.out.println(m.get(it.next()));
				System.out.println("======");
				it.remove();
			}

			System.out.println("Final Size :" + m.size());
		};

		new Thread(r1).start();
		new Thread(r2).start();
	}

}

class A{
	
	private void show() {
		System.out.println("asdadad");
	}
}

class B extends A{
	
	private void show1() {
		this.s
	}
}
