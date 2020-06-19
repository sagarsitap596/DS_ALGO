package com.sagar.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.j256.ormlite.stmt.query.In;

/**
 * 
 * 
 *
 */
public class Graph {

	Map<Integer, GraphNode> nodes = new HashMap<>();

	public GraphNode getNode(Integer data) {
		return nodes.get(data);
	}

	public Set<GraphNode> getAdjacentNodes(Integer data) {
		if (data != null && nodes.containsKey(data)) {
			return getNode(data).childNode;
		}
		throw new RuntimeException("Invalid Node : " + data);
	}

	public boolean isConnected(Integer origin, Integer destination) {
		if (origin == null || destination == null) {
			throw new RuntimeException("One of the nodes is null");
		}
		return getAdjacentNodes(origin).stream().anyMatch(n -> destination.equals(n.data));
	}

	public void addNode(GraphNode node) {
		nodes.put(node.data, node);
	}

	public void addEdge(Integer n1, Integer n2) {
		GraphNode node1 = getNode(n1);
		if (node1 == null) {
			node1 = new GraphNode(n1);
			addNode(node1);
		}

		GraphNode node2 = getNode(n2);
		if (node2 == null) {
			node2 = new GraphNode(n2);
			addNode(node2);
		}
		node1.childNode.add(node2);
	}

	public List<Integer> getTopologicalSort() {

		Set<Integer> visited = new HashSet<Integer>();
		Stack<Integer> stack = new Stack<Integer>();

		for (Integer nodeData : nodes.keySet()) {
			if (visited.contains(nodeData)) {
				continue;
			}
			traverse(nodes.get(nodeData), visited, stack);
		}
		List<Integer> ts = new ArrayList<Integer>();
		while (!stack.isEmpty()) {
			ts.add(stack.pop());
		}
		return ts;
	}

	public void traverse(GraphNode node, Set<Integer> visited, Stack<Integer> stack) {
		visited.add(node.data);
		for (GraphNode childNode : node.childNode) {
			if (visited.contains(childNode.data)) {
				continue;
			}
			traverse(childNode, visited, stack);
		}
		stack.push(node.data);
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdge(1, 3);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		graph.addEdge(5, 6);
		graph.addEdge(6, 3);
		graph.addEdge(3, 8);
		graph.addEdge(8, 11);

		for (Integer data : graph.nodes.keySet()) {
			System.out.println(data + " > " + graph.nodes.get(data).childNode);
		}

		System.out.println(graph.getTopologicalSort());
	}

}

class GraphNode {
	Integer data;
	Set<GraphNode> childNode = new HashSet<GraphNode>();
//	Map<GraphNode, Integer> weightedEdges = new HashMap<>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GraphNode other = (GraphNode) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " " + data;
	}

	public GraphNode(Integer data) {
		super();
		this.data = data;
	}

}
