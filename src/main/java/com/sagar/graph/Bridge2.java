package com.sagar.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bridge2 {

	public static void main(String[] args) {
		Bridge2 b = new Bridge2();

		System.out.println(
				b.criticalConnections(6, Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(2, 0),
						Arrays.asList(1, 3), Arrays.asList(3, 4), Arrays.asList(4, 5), Arrays.asList(5, 3))));

	}

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

		List<List<Integer>> graph = createGraph(connections, n);

		List<List<Integer>> bridges = new ArrayList<>();
		int[] discoverTime = new int[n];
		int[] lowLink = new int[n];

		Arrays.fill(discoverTime, -1);
		Arrays.fill(lowLink, Integer.MAX_VALUE);

		for (int node = 0; node < n; node++) {
			if (discoverTime[node] == -1) {
				DFS(node, -1, discoverTime, lowLink, 1, bridges, graph);
			}
		}
		return bridges;
	}

	private void DFS(int currentNode, int parent, int[] discoverTime, int[] lowLink, int time,
			List<List<Integer>> bridges, List<List<Integer>> graph) {

		discoverTime[currentNode] = time;
		lowLink[currentNode] = time;

		for (Integer adjNode : graph.get(currentNode)) {

			if (adjNode == parent)
				continue;

			if (discoverTime[adjNode] == -1) {

				DFS(adjNode, currentNode, discoverTime, lowLink, time + 1, bridges, graph);
				lowLink[currentNode] = Math.min(lowLink[currentNode], lowLink[adjNode]);
				if (lowLink[adjNode] > discoverTime[currentNode]) {
					// there is no bagage
					bridges.add(Arrays.asList(adjNode, currentNode));
				}
			} else {
				lowLink[currentNode] = Math.min(lowLink[currentNode], discoverTime[adjNode]);
			}
		}
	}

	private List<List<Integer>> createGraph(List<List<Integer>> connections, int n) {

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < connections.size(); i++) {
			System.out.println(connections.get(i).get(0) + ", " + connections.get(i).get(1));
			graph.get(connections.get(i).get(0)).add(connections.get(i).get(1));
			graph.get(connections.get(i).get(1)).add(connections.get(i).get(0));
			System.out.println(graph);
		}
		return graph;
	}

}
