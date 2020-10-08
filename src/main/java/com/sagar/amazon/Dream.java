package com.sagar.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dream {

	public static void main(String[] args) {

		List<Integer> s = Arrays.asList(1, 2, 2, 5, 3, 3, 6, 6, 4);
		List<Integer> e = Arrays.asList(2, 4, 3, 6, 6, 8, 8, 7, 5);
		List<Integer> w = Arrays.asList(2, 3, 10, 5, 10, 8, 1, 6, 4);
		System.out.println(minCostPath(8, s, e, w, 3, 6));
	}

	public static int minCostPath(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight, int x,
			int y) {
		Map<Integer, Map<Integer, Integer>> graph = createGraph(gFrom, gTo, gWeight);
		int shortestPathFrom1ToX = findShortestPath(1, x, graph);
		int shortestPathFromXToY = findShortestPath(x, y, graph);
		int shortestPathFromYToG = findShortestPath(y, gNodes, graph);
		return shortestPathFrom1ToX + shortestPathFromXToY + shortestPathFromYToG;
	}

	private static int findShortestPath(int startNode, int endNode, Map<Integer, Map<Integer, Integer>> graph) {

		return findDistance(new LinkedHashSet<Integer>(), startNode, endNode, graph, 0);
	}

	private static int findDistance(Set<Integer> path, int startNode, int endNode,
			Map<Integer, Map<Integer, Integer>> graph, int runningDistance) {

		if (path.contains(startNode))
			return Integer.MAX_VALUE;

		if (startNode == endNode) {
			System.out.println(path);
			return runningDistance;
		}

		path.add(startNode);
		Map<Integer, Integer> edges = graph.get(startNode);

		int min = Integer.MAX_VALUE;
		if (edges != null) {
			for (Integer to : edges.keySet()) {
				int p = findDistance(path, to, endNode, graph, runningDistance + edges.get(to));
				if (p < min) {
					min = p;
				}
			}
		}

		path.remove(startNode);
		return min;
	}

	private static Map<Integer, Map<Integer, Integer>> createGraph(List<Integer> gFrom, List<Integer> gTo,
			List<Integer> gWeight) {
		Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

		for (int i = 0; i < gFrom.size(); i++) {
			int startNode = gFrom.get(i);
			int toNode = gTo.get(i);
			int wt = gWeight.get(i);
			if (graph.containsKey(startNode)) {
				graph.get(startNode).put(toNode, wt);
			} else {
				Map<Integer, Integer> edge = new HashMap<>();
				edge.put(toNode, wt);
				graph.put(startNode, edge);
			}
			
			if (graph.containsKey(toNode)) {
				graph.get(toNode).put(startNode, wt);
			} else {
				Map<Integer, Integer> edge = new HashMap<>();
				edge.put(startNode, wt);
				graph.put(toNode, edge);
			}
		}
		return graph;
	}
}
