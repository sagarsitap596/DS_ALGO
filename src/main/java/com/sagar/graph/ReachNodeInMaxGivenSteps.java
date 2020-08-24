package com.sagar.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  	3 --> number of nodes
	0 1 1
	1 0 0     --> adj matrix
	0 1 0
	
	0 1 4  --> startNode, destinationNode, Max number of steps
	
	5 --> o/p There are 5 paths from startNode to destinationNode. each path is < Max number of steps
	
	
	                 C
	               /   \ 
	              A <-->B    
	
	
	A -> B
	A -> B -> A -> B
	A -> B -> A -> C -> B
	A -> C -> B
	A -> C -> B -> A -> B
	
	 
*/
public class ReachNodeInMaxGivenSteps {
	private static int[][] adjacencyMatrix;

	public ReachNodeInMaxGivenSteps(int[][] input) {
		adjacencyMatrix = input;
	}

	static int numPaths(int sourceNode, int destNode, int maxSteps) {

		Result result = new Result();
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (adjacencyMatrix[sourceNode][i] == 1) {
				findPath(i, destNode, 1, maxSteps, result);
			}
		}

		return result.count;

	}

	static class Result {
		int count;
	}

	private static void findPath(int currentNode, int destNode, int curentStep, int maxSteps, Result result) {
		if (curentStep > maxSteps)
			return;

		if (currentNode == destNode) {
			result.count++;
		}
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (adjacencyMatrix[currentNode][i] == 1) {
				findPath(i, destNode, curentStep + 1, maxSteps, result);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);

		int vertices = Integer.parseInt(bufferedReader.readLine().trim());
		int[][] graphMatrix = new int[vertices][vertices];
		for (int i = 0; i < vertices; i++) {
			String[] row = bufferedReader.readLine().trim().split(" ");
			for (int j = 0; j < vertices; j++) {
				graphMatrix[i][j] = Integer.parseInt(row[j]);
			}
		}
		List<String> functionInputRowString = new ArrayList<String>(
				Arrays.asList(bufferedReader.readLine().trim().split(" ")));
//        List<Integer> functionInputRow = functionInputRowString.stream() 
//            .map(Integer::parseInt) 
//            .collect(Collectors.toList()); 

		List<Integer> functionInputRow = new ArrayList<Integer>();
		for (String s : functionInputRowString) {
			functionInputRow.add(Integer.valueOf(s));
		}

		ReachNodeInMaxGivenSteps graph = new ReachNodeInMaxGivenSteps(graphMatrix);
		int result = ReachNodeInMaxGivenSteps.numPaths(functionInputRow.get(0), functionInputRow.get(1),
				functionInputRow.get(2));

		System.out.println(result);

		wr.close();
		bufferedReader.close();
	}

}