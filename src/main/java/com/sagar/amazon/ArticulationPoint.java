package com.sagar.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticulationPoint {

	public static void main(String[] args) {
		ArticulationPoint b = new ArticulationPoint();

		System.out.println(
				b.findArticulationPoints(6, Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(2, 0),
						Arrays.asList(1, 3), Arrays.asList(3, 4), Arrays.asList(4, 5), Arrays.asList(5, 3))));

	}

	/*
	 * Time complexity : O(V + E) and Space complexity : O(V)
	 */
	public List<Integer> findArticulationPoints(int n, List<List<Integer>> connections) {

		Map<Integer, List<Integer>> graph = createGraph(connections);
		List<Integer> ap = new ArrayList<>();
		Map<Integer, Integer> discoverTime = new HashMap<>();
		Map<Integer, Integer> lowLink = new HashMap<>();
		for (Integer root : graph.keySet()) {
			if (!discoverTime.containsKey(root)) {
				DFS(root, null, discoverTime, lowLink, 0, graph, root, ap);
			}
		}
		return ap;
	}

	private void DFS(Integer currentNode, Integer parent, Map<Integer, Integer> discoverTime,
			Map<Integer, Integer> lowLink, int time, Map<Integer, List<Integer>> graph, Integer root,
			List<Integer> ap) {

		discoverTime.put(currentNode, time);
		lowLink.put(currentNode, time);
		int children = 0;
		boolean isArticulationPoint = false;

		for (Integer adjNode : graph.get(currentNode)) {

			if (adjNode == parent)
				continue;

			if (discoverTime.containsKey(adjNode)) {
				lowLink.put(currentNode, Math.min(lowLink.get(currentNode), discoverTime.get(adjNode)));
			} else {
				children++;
				DFS(adjNode, currentNode, discoverTime, lowLink, time + 1, graph, root, ap);
				lowLink.put(currentNode, Math.min(lowLink.get(currentNode), lowLink.get(adjNode)));
				if (lowLink.get(adjNode) >= discoverTime.get(currentNode)) {
					isArticulationPoint = true;
				}
			}
		}
		if ((parent == null && children > 1) || parent != null && isArticulationPoint) {
			ap.add(currentNode);
		}
	}

	private Map<Integer, List<Integer>> createGraph(List<List<Integer>> connections) {

		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (List<Integer> connection : connections) {
			if (graph.containsKey(connection.get(0))) {
				graph.get(connection.get(0)).add(connection.get(1));
			} else {
				List<Integer> con = new ArrayList<>();
				con.add(connection.get(1));
				graph.put(connection.get(0), con);
			}
			if (graph.containsKey(connection.get(1))) {
				graph.get(connection.get(1)).add(connection.get(0));
			} else {
				List<Integer> con = new ArrayList<>();
				con.add(connection.get(0));
				graph.put(connection.get(1), con);
			}
		}
		return graph;
	}

}
