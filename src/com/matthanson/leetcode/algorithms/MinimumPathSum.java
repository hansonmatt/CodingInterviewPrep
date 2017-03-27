package com.matthanson.leetcode.algorithms;

/**
 * Created by matthans on 3/27/17.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[r].length; ++c) {
                int toAdd = -1;

                if (r > 0) {
                    toAdd = grid[r - 1][c];
                }

                if (c > 0) {
                    if (r > 0) { // or if toAdd >= 0...
                        toAdd = Math.min(toAdd, grid[r][c - 1]);
                    } else {
                        toAdd = grid[r][c - 1];
                    }
                }

                if (toAdd >= 0) {
                    grid[r][c] = grid[r][c] + toAdd;
                }

            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
