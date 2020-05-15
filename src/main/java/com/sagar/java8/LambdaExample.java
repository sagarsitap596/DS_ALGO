package com.sagar.java8;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class LambdaExample {

	public static void main(String[] args) {

		// Example one -- functional interface method with one parameter

		// Traditional method of creating nstance of functional interface
		FileFilter fileFilter = new FileFilter() {

			@Override
			public boolean accept(File file) {
				// TODO Auto-generated method stub
				return file.getName().endsWith(".java");
			}
		};

		// various ways of creating lambda method

		FileFilter fileFilterLambda1 = (File file) -> file.getName().endsWith(".java");
		FileFilter fileFilterLambda2 = file -> file.getName().endsWith(".java");
		FileFilter fileFilterLambda3 = (File file) -> {
			return file.getName().endsWith(".java");
		};
		FileFilter fileFilterLambda4 = file -> {
			return file.getName().endsWith(".java");
		};

		File dir = new File("/tmp/");
		File[] filteredFiles = dir.listFiles(fileFilter);
		filteredFiles = dir.listFiles(fileFilterLambda1);
		filteredFiles = dir.listFiles(fileFilterLambda2);
		filteredFiles = dir.listFiles(fileFilterLambda3);
		filteredFiles = dir.listFiles(fileFilterLambda4);

		// Example two -- functional interface method without parameter

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Inside Thread : " + Thread.currentThread().getName());
			}
		};

		Runnable runnableLambda1 = () -> System.out.println("Inside Thread : " + Thread.currentThread().getName());

		Runnable runnableLambda2 = () -> {
			System.out.println("Inside Thread : " + Thread.currentThread().getName());
		};

		new Thread(runnable).start();
		new Thread(runnableLambda1).start();
		new Thread(runnableLambda2).start();

		// Example two -- functional interface method with 2 parameters

		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		};

		Comparator<String> comparatorLambda1 = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());

		Comparator<String> comparatorLambda2 = (s1, s2) -> Integer.compare(s1.length(), s2.length());

		Set<String> names = new TreeSet<String>(comparator);
		Set<String> names1 = new TreeSet<String>(comparatorLambda1);
		Set<String> names2 = new TreeSet<String>(comparatorLambda2);

		// Examples

		List<String> fruits = new ArrayList<String>();
		fruits.add("mango");
		fruits.add("apple");
		fruits.add("banana");
		fruits.add("grapes");

		List<String> result = new ArrayList<String>();
		fruits.forEach(fruit -> System.out.println(fruit));
		System.out.println("================================");
		Consumer<String> c1 = System.out::println;

		Consumer<String> c2 = result::add; // f -> result.add(f)
		
		BiConsumer<Integer,String> c3 = (i,s) -> fruits.set(i, s);

		c3.accept(1, "brooo");
		 
		// first print and then add to ressult
		fruits.forEach(c1.andThen(c2));
		result.sort((s1, s2) -> s1.compareTo(s2));
		
		System.out.println("Length of result : " + result.size());
		System.out.println(Objects.deepEquals(fruits, result));
	}

}

/**
 * @FunctionalInterface must have one abstract (without body) method. It can any
 *                      number of static and default methods
 * @author sitapsha
 *
 */
@FunctionalInterface
interface MyInterface {

	public int a = 10;

	public void showOriginal();

	default public void show() {
		System.out.println();
	}

	default public void show2() {
		System.out.println();
	}

	public static void show3() {
		System.out.println();
	}

	public static void show4() {
		System.out.println();
	}
}
