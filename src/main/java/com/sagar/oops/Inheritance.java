package com.sagar.oops;

public class Inheritance {

	public static class Parent {

		{
			System.out.println("Parent non static block");
		}
		static {
			System.out.println("Parent static block");
		}

		public Parent() {
			System.out.println("Parent Constructor");
		}

		int val = 12;

		public int getVal() {
			return val;
		}
	}

	public static class Child extends Parent {

		{
			System.out.println("Child non static block");
		}
		static {
			System.out.println("Child static block");
		}

		public Child() {
			System.out.println("Child Constructor");
		}

		int val = 90;

		public int getVal() {
			return val;
		}
	}

	public static void main(String[] args) {
		Parent p = new Child();
		System.out.println(p.val);
		System.out.println(p.getVal());

	}

}
