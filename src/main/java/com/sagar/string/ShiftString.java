package com.sagar.string;

public class ShiftString {

	public static void main(String[] args) {
		System.out.println(getShiftedString("ab", 1, 2));

	}

	public static String getShiftedString(String s, int leftShifts, int rightShifts) {

		if (s.isEmpty() || s.length() == 1 || (leftShifts == rightShifts && s.length() == leftShifts)) {
			return s;
		}
		char[] characters = s.toCharArray();

		int length = s.length();
		int numberOfLeftShift = leftShifts % length;
		int numberOfRightShift = rightShifts % length;

		characters = shiftCharacters(characters, length - numberOfLeftShift);
		characters = shiftCharacters(characters, numberOfRightShift);
		return new String(characters);

	}

	private static char[] shiftCharacters(char[] characters, int shifts) {

		char[] temp = characters.clone();
		for (int index = 0; index < temp.length; index++) {
			if (shifts == temp.length) {
				shifts = 0;
			}
			characters[shifts] = temp[index];
			shifts++;
		}
		return characters;
	}

}
