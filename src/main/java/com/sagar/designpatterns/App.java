package com.sagar.designpatterns;

import java.util.Calendar;

public class App {

	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		System.out.println(cal1.hashCode());
		System.out.println(cal2.hashCode());
	}

}
