package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class Search2DMatrixTest {
    private Search2DMatrix search = new Search2DMatrix();

    @Test
    public void searchMatrix() throws Exception {
        assertFalse(search.searchMatrix(null, 1));
        assertFalse(search.searchMatrix(new int[][]{}, 1));
        assertFalse(search.searchMatrix(new int[][]{{}}, 1));

        int [][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        assertTrue(search.searchMatrix(matrix, 3));
        assertTrue(search.searchMatrix(matrix, 1));
        assertTrue(search.searchMatrix(matrix, 50));
        assertTrue(search.searchMatrix(matrix, 23));
        assertTrue(search.searchMatrix(matrix, 34));

        assertFalse(search.searchMatrix(matrix, 8));
        assertFalse(search.searchMatrix(matrix, 2));
        assertFalse(search.searchMatrix(matrix, -1));
        assertFalse(search.searchMatrix(matrix, 22));
        assertFalse(search.searchMatrix(matrix, 200));

        matrix = new int[][]{{1,3,5,7,9},{10,11,16},{23,30,34,50}};
        assertTrue(search.searchMatrix(matrix, 9));
        assertTrue(search.searchMatrix(matrix, 11));
        assertTrue(search.searchMatrix(matrix, 23));

        assertFalse(search.searchMatrix(matrix, 4));

        assertTrue(search.searchMatrix(new int[][]{{1}}, 1));
        assertFalse(search.searchMatrix(new int[][]{{0}}, 1));
        assertFalse(search.searchMatrix(new int[][]{{5}}, 1));
        assertFalse(search.searchMatrix(new int[][]{{-5}}, 1));
        assertFalse(search.searchMatrix(new int[][]{{5}}, -1));
    }

}