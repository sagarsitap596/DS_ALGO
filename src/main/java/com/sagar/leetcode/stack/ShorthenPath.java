package com.sagar.leetcode.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// O(N) time and spcae complexity

public class ShorthenPath {
    public static String shortenPath(String path) {
        Map<String, Boolean> shouldPop = new HashMap<>();
        shouldPop.put("..", true);
        shouldPop.put(".", false);
        shouldPop.put("", false);

        boolean isRelativePath = !path.startsWith("/");
        List<String> stack = new ArrayList<>();
        for(String str : path.split("/")) {

            if(shouldPop.containsKey(str)) {
                if(shouldPop.get(str)) {
                    if(stack.isEmpty()) {
                        if(isRelativePath) {
                            stack.add(str);
                        }
                    } else if(".." .equals(stack.get(stack.size() - 1))) {
                        stack.add(str);
                    } else {
                        stack.remove(stack.size() - 1);
                    }
                }
            } else {
                stack.add(str);
            }
        }
        String finalPath = String.join("/", stack);
        finalPath = isRelativePath ? finalPath : "/" + finalPath;
        return finalPath;
    }
}

