package com.sagar.codeforce;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {

		new D().show1();

//		File file = new File(Sort.class.getClassLoader().getResource("sort.in").getFile());
//		try (FileReader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader)) {
//
//			Long n = Long.parseLong(br.readLine().trim());
//			long[] array = Arrays.stream(br.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
//
//			System.out.println(n);
//			System.out.println(array.length);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}

interface Foo<T> { void m(T arg); }
interface Bar<T> { void m(T arg); }
interface FooBar<X, X> extends Foo<X>, Bar<X> {}



