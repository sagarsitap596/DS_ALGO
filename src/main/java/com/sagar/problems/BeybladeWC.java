package com.sagar.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * 1
 * 10
 * 3 6 7 5 3 5 6 2 9 1 
 * 2 7 0 9 3 6 0 6 2 6 
 * 7
 * @author sitapsha
 *
 */
public class BeybladeWC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfTests = Integer.parseInt(sc.nextLine().trim());

		long[] team1;
		long[] team2;
		for (int i = 0; i < noOfTests; i++) {
			int noOfPlayers = Integer.parseInt(sc.nextLine().trim());
			team1 = new long[noOfPlayers];
			team2 = new long[noOfPlayers];

			String[] t1 = sc.nextLine().trim().split(" ");
			String[] t2 = sc.nextLine().trim().split(" ");
			for (int j = 0; j < noOfPlayers; j++) {
				team1[j] = Long.parseLong(t1[j]);
				team2[j] = Long.parseLong(t2[j]);
			}

			Arrays.sort(team1);
			Arrays.sort(team2);
			int x = noOfPlayers-1;
			int y = noOfPlayers-1;
			int result = 0;

			while (x >= 0 && y >= 0) {
				if (team1[x] > team2[y]) {
					result++;
					x--;
					y--;
				} else {
					y--;
				}
			}
			System.out.println(result);
		}
	}
}
