package com.sagar.problems;

import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * 
 * https://www.hackerrank.com/contests/crescent-practice-3rd-years/challenges/islands-1
 * 
 * Given a boolean matrix,find the number of islands.
 * 
 * What is an island?
 * 
 * A group of connected 1s forms an island. For example, the below matrix
 * contains 5 islands
 * 
 * {1, 1, 0, 0, 0},<br>
 * {0, 1, 0, 0, 1},<br>
 * {1, 0, 0, 1, 1},<br>
 * {0, 0, 0, 0, 0}, <br>
 * {1, 0, 1, 0, 1}<br>
 * 
 * 
 * Sample Input
 * 
 * 5 5 <br>
 * 1 1 0 0 0 <br>
 * 0 1 0 0 1 <br>
 * 1 0 0 1 1 <br>
 * 0 0 0 0 0 <br>
 * 1 0 1 0 1 <br>
 * 
 * 
 * Sample Output
 * 
 * 5
 * 
 * 
 * @author sitapsha
 *
 */
public class NumberOfIslands {

    static int[] dr = { -1, 1, 0, 0, -1, 1, 1, -1 };
    static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = { 1, 3, 2, 5, 4 };

        int[] arrDesc = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue)
                .toArray();

//        Scanner sc = new Scanner(System.in);
//        int rows = sc.nextInt();
//        int cols = sc.nextInt();
//
//        int[][] grid = new int[rows][cols];
//        for (int i = 0; i < rows; i++)
//            for (int j = 0; j < cols; j++)
//                grid[i][j] = sc.nextInt();
//
//        System.out.println(countIslands(grid));

    }

    public static int countIslands(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    DFS(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;

    }

    private static void DFS(int[][] grid, int r, int c, int[][] visited) {

        System.out.println(" DFS for ( " + r + " , " + c + " )");
        for (int k = 0; k < dr.length; k++) {

            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1
                    && visited[nr][nc] == 0) {
                visited[nr][nc] = 1;
                DFS(grid, nr, nc, visited);
            }

        }

    }

}
