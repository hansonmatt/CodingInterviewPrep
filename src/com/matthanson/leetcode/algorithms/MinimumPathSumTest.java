package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthans on 3/27/17.
 */
public class MinimumPathSumTest {
    private MinimumPathSum mps = new MinimumPathSum();

    @Test
    public void minPathSumNullGrid() throws Exception {
        assertEquals(0, mps.minPathSum(null));
    }

    @Test
    public void minPathSumSingleElement() throws Exception {
        int [][] grid = new int[1][1];
        assertEquals(0, mps.minPathSum(grid));

        grid[0][0] = 20;
        assertEquals(20, mps.minPathSum(grid));
    }

    @Test
    public void minPathSum() throws Exception {
        int [][] grid = new int[3][3];
        grid[0][0] = 5;
        grid[0][1] = 3;
        grid[0][2] = 2;

        grid[1][0] = 4;
        grid[1][1] = 1;
        grid[1][2] = 5;

        grid[2][0] = 6;
        grid[2][1] = 8;
        grid[2][2] = 1;

        assertEquals(15, mps.minPathSum(grid));
    }

}