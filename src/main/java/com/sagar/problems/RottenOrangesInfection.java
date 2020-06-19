package com.sagar.problems;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * https://leetcode.com/problems/rotting-oranges/
 * 
 * In a given grid, each cell can have one of three values:
 * 
 * the value 0 representing an empty cell; the value 1 representing a fresh
 * orange; the value 2 representing a rotten orange. Every minute, any fresh
 * orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1 instead.
 * 
 * @author sitapsha
 *
 */
public class RottenOrangesInfection {
    int[] dr = new int[] { -1, 0, 1, 0 };
    int[] dc = new int[] { 0, -1, 0, 1 };

    public static void main(String[] args) {
        int[][] grid = { { 1 }, { 2 }, { 1 }, { 2 } };

        System.out.println(new RottenOrangesInfection().orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        /**
         * Add all rotten orange index in queue. maintain Map that has count/every
         * Minute/iteration/ against each rotten index;
         * i.e min at wich that orange got rotten.
         */
        Queue<Index> rottenOrangeIndex = new ArrayDeque<Index>();
        Map<Index, Integer> count = new HashMap<Index, Integer>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    Index idx = new Index(i, j);
                    rottenOrangeIndex.add(idx);
                    count.put(idx, 0);
                }
            }
        }

        int result = 0;
        while (!rottenOrangeIndex.isEmpty()) {
            Index index = rottenOrangeIndex.remove();
            int r = index.row;
            int c = index.col;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                /*
                 * If adjacent is fresh then rot it i.e add it to queue.
                 */
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {

                    grid[nr][nc] = 2; // rot adj fresh orange
                    Index newIdx = new Index(nr, nc);
                    rottenOrangeIndex.add(newIdx);
                    count.put(newIdx, count.get(index) + 1);
                    result = count.get(newIdx);
                }
            }
        }

        for (int[] row : grid)
            for (int v : row)
                if (v == 1)
                    return -1;
        return result;

    }

    static class Index {
        int row = -1;
        int col = -1;

        public Index(int r, int c) {
            this.row = r;
            this.col = c;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + col;
            result = prime * result + row;
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
            Index other = (Index) obj;
            if (col != other.col)
                return false;
            if (row != other.row)
                return false;
            return true;
        }

    }
}
