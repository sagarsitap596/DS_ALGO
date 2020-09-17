package com.sagar.leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OverlapRectangle {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        List<Integer[]> rec1 = createCordinates(sc.nextLine().split(" "));
	        List<Integer[]> rec2 = createCordinates(sc.nextLine().split(" "));
	        
	        if(isOverlap(rec1, rec2) || isOverlap(rec2, rec1)){
	            System.out.println("overlap");
	        }
	        else {
	        	System.out.println("no overlap");
	        }
	    }
	    
	    private static List<Integer[]> createCordinates(String[] cords){
	    	Integer[] topLeft = new Integer[]{Integer.parseInt(cords[0]), Integer.parseInt(cords[1])};
	    	Integer[] bottomRight = new Integer[]{Integer.parseInt(cords[2]), Integer.parseInt(cords[3])};
	        Integer[] bottomLeft = new Integer[]{Integer.parseInt(cords[0]), Integer.parseInt(cords[3])};
	        Integer[] topRight = new Integer[]{Integer.parseInt(cords[2]), Integer.parseInt(cords[1])};
	        List<Integer[]> rec = new ArrayList<>();
	        rec.add(bottomLeft);
	        rec.add(topLeft);
	        rec.add(topRight);
	        rec.add(bottomRight);
	        return rec;
	    }
	    private static boolean isOverlap(List<Integer[]> rec1, List<Integer[]> rec2){
	        Integer[] bottomleft = rec1.get(0);
	        Integer[] topRight = rec1.get(2);
	        for(Integer[] cord : rec2){
	            if(bottomleft[0] <= cord[0] && cord[0] <= topRight[0] &&
	               bottomleft[1] <= cord[1] && cord[1] <= topRight[1]) {
	                return true;
	            }
	        }
	         return false;
	    }

}
