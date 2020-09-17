package com.sagar.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

	public static void main(String[] args) {

		// [abc] -- a or b or c

		Pattern pattern = Pattern.compile("[abc]?");
		Matcher matcher = pattern.matcher("abc");
		System.out.println(matcher.matches());
		System.out.println(Pattern.matches("[abc]?", "abc"));
	}

}
