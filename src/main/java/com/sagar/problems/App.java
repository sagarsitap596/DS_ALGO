package com.sagar.problems;

import java.util.Hashtable;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
//		Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
//		SortedSet<String> set = stream.collect(Collectors.toCollection( ConcurrentSkipListSet::new ) );
//		System.out.println(set); // [f, l, o, w]

		String s1 = "123";
		String s2 = new Integer("123").toString();
		String s3 = "123";
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		
		
		Integer i1 =1;
		Integer i2 = new Integer(1);
		Integer i3 =1;
		
		System.out.println(i1==i2);
		System.out.println(i1==i3);
		
		System.out.println("aaadad".hashCode());
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put(null, null);
	}

	private static void update(Integer i) {
		i = i + 2;
	}

}
