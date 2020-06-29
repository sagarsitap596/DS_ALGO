package com.sagar.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class DocPatientProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line1 = sc.nextLine().trim().split(" ");
		int pat = Integer.parseInt(line1[0]);
		int doc = Integer.parseInt(line1[1]);

		int[][] mat = new int[doc][pat];
		for (int d = 0; d < doc; d++) {
			String[] line = sc.nextLine().trim().split(" ");
			for (int p = 0; p < line.length; p++) {
				mat[d][p] = Integer.parseInt(line[p]);
			}
		}

		String docsString = "";
		for (int i = 0; i < doc; i++) {
			docsString = docsString + i;
		}
		List<String> docCombinations = new ArrayList<String>();
		createAllCombinations(docsString, docCombinations, pat);

		AtomicLong minSum = new AtomicLong(Long.MAX_VALUE);
		
		docCombinations.parallelStream().forEach(combination  ->{
			

			long sum = 0;
			String[] docIdx = combination.split("~");
			int prevIdx = -1;
			Set<Integer> usedDoc = new HashSet<>();
			for (int p = 0; p < docIdx.length; p++) {
				int docIndex = Integer.parseInt(docIdx[p]);
				if (usedDoc.contains(docIndex)) {
					sum =Long.MAX_VALUE;
				}
				if (prevIdx == -1 || prevIdx == docIndex) {
					sum = sum + mat[docIndex][p];
					prevIdx = docIndex;

				} else {
					sum = sum + mat[docIndex][p];
					usedDoc.add(prevIdx);
					prevIdx = docIndex;
				}
			}
			if (sum < minSum.get()) {
				minSum.set(sum);
			}
		
			
			
		});
//		outerloop: for (String combination : docCombinations) {
//			sum = 0;
//			String[] docIdx = combination.split("~");
//			int prevIdx = -1;
//			Set<Integer> usedDoc = new HashSet<>();
//			for (int p = 0; p < docIdx.length; p++) {
//				int docIndex = Integer.parseInt(docIdx[p]);
//				if (usedDoc.contains(docIndex)) {
//					continue outerloop;
//				}
//				if (prevIdx == -1 || prevIdx == docIndex) {
//					sum = sum + mat[docIndex][p];
//					prevIdx = docIndex;
//
//				} else {
//					sum = sum + mat[docIndex][p];
//					usedDoc.add(prevIdx);
//					prevIdx = docIndex;
//				}
//			}
//			if (sum < minSum) {
//				minSum = sum;
//
//			}
//		}
		sc.close();
		System.out.println(minSum);
	}

	static void generateCombination(String docs, String[] data, int last, int index, List<String> result) {
		int length = docs.length();

		for (int i = 0; i < length; i++) {
			data[index] = docs.charAt(i) + "";

			if (index == last) {
				result.add(String.join("~", data));
			} else
				generateCombination(docs, data, last, index + 1, result);
		}
	}

	static void createAllCombinations(String docs, List<String> result, int places) {

		String[] data = new String[places];

		generateCombination(docs, data, places - 1, 0, result);
	}

}
