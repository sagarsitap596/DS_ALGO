package com.sagar.leetcode.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MatchBrackets {

    public static boolean balancedBrackets(String str) {
        List<Character> stack = new ArrayList<Character>();

        HashMap<Character, Character> closingAndStartingMap = new HashMap<>();
        closingAndStartingMap.put(')', '(');
        closingAndStartingMap.put(']', '[');
        closingAndStartingMap.put('}', '{');

        HashSet<Character> startingBrackets = new HashSet<>();
        startingBrackets.add('{');
        startingBrackets.add('[');
        startingBrackets.add('(');

        for(int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if(startingBrackets.contains(c)) {
                stack.add(c);
            } else if(closingAndStartingMap.containsKey(c)) {
                if(stack.isEmpty()) return false;

                Character poppedChar = stack.remove(stack.size() - 1);
                if(!poppedChar.equals(closingAndStartingMap.get(c))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
