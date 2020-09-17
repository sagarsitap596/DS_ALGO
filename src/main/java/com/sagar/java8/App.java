package com.sagar.java8;

public class App {

	public static void main(String[] args) {
		new Parent().show();
		new Child().show();

		Parent p = new Child();
		p.show();
		System.out.println(p.name);
		
		Child c = new Child();
		System.out.println(c.name);

	}

}

class Parent {

	static String name = "sagar";

	public void show() {
		System.out.println(name);
	}
}

class Child extends Parent {
	String name = "bro";

	public void show() {
		System.out.println(name);
	}
}

class Child2 extends Parent {

}

class Child3 extends Parent {

}
