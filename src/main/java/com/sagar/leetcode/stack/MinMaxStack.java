package com.sagar.leetcode.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Overall implementing space complexity is O(N) bcz we use additional List<Map<String,Integer>>
 * Time complexity for each operation is O(1)
 */
public class MinMaxStack {
    List<Integer> stack = new LinkedList<Integer>();
    List<Map<String, Integer>> minMaxHeap = new ArrayList<>();

    public int peek() {
        if(stack.isEmpty()) return -1;
        return stack.get(stack.size() - 1);
    }

    public int pop() {
        if(stack.isEmpty()) return -1;
        minMaxHeap.remove(minMaxHeap.size() - 1);
        return stack.remove(stack.size() - 1);
    }

    public void push(Integer number) {
        Map<String, Integer> newMap = new HashMap<>();
        newMap.put("min", number);
        newMap.put("max", number);
        if(stack.size() > 0) {
            Map<String, Integer> lastmap = minMaxHeap.get(minMaxHeap.size() - 1);
            int min = Math.min(lastmap.get("min"), number);
            int max = Math.max(lastmap.get("max"), number);
            newMap.put("min", min);
            newMap.put("max", max);
        }
        minMaxHeap.add(newMap);
        stack.add(number);
    }

    public int getMin() {
        if(stack.isEmpty()) return -1;
        return minMaxHeap.get(minMaxHeap.size() - 1).get("min");
    }

    public int getMax() {
        if(stack.isEmpty()) return -1;
        return minMaxHeap.get(minMaxHeap.size() - 1).get("max");
    }
}

