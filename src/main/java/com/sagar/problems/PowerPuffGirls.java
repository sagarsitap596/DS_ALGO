package com.sagar.problems;

import java.util.Scanner;


/**
 *  Input Format
 *	The first line of input consists of the number of ingredients, N
 *
 *	The second line of input consists of the N space-separated integers representing the quantity of each ingredient required to create a Powerpuff Girl.
 *	The third line of input consists of the N space-separated integers representing the quantity of each ingredient present in the laboratory.
 *
 * 
 * 4
 * 2 5 6 3 
 * 20 40 90 50 
 * @author sitapsha
 *
 */
public class PowerPuffGirls {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine().trim());
		String input1 = sc.nextLine();
		String input2 = sc.nextLine();
		String[] c = input1.trim().split(" ");
		String[] q = input2.trim().split(" ");

		long ingredient;
		long ingredientQuantity;
		long result = Long.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			ingredient = Long.parseLong(c[i]);
			ingredientQuantity = Long.parseLong(q[i]);
			if (ingredient > 0) {
				if (ingredientQuantity <= 0) {
					result = 0;
				} else if (ingredientQuantity / ingredient < result) {
					result = ingredientQuantity / ingredient;
				}
			}
		}
		sc.close();
		if (result == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(result);

	}

}
