package com.sagar.string;

public class App {

	public static void main(String[] args) {
		System.out.println(caesarCypherEncryptor("az", 2));
	}

	public static String caesarCypherEncryptor(String str, int key) {
		
		key = key % 26;
		char[] result = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			int charValue = str.charAt(i) + key;
			if (charValue > 'z') {
				charValue = 'a' + charValue - 'z' - 1;
			}
			result[i] = (char) charValue;
		}
		return new String(result);
	}
}
