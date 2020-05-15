package com.sagar.problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MapValueSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Map<String, Integer> data = new HashMap<>();
        data.put("A", 4);
        data.put("B", 8);
        data.put("C", 1);
        data.put("D", 5);

        System.out.println(sortByValue(data));
    }

    public static Map<? extends Object, ? extends Object> sortByValue(Map<? extends Object, ? extends Number> input) {

        return input.entrySet().stream()
                .sorted((k1, k2) -> -((Integer) k1.getValue()).compareTo((Integer) k2.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e2,
                        LinkedHashMap::new));

    }
    
    static class Cus implements Comparator<Map.Entry<String, Integer>>{

        @Override
        public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
            // TODO Auto-generated method stub
            return 0;
        }
        
    }

}

