package com.matthanson.leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by matthans on 3/1/17.
 */
public class MatrixZeroes {
    /*
        https://leetcode.com/problems/set-matrix-zeroes/?tab=Description
    */
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[row].length; ++col) {
                if (matrix[row][col] == 0) {
                    rows.add(row);
                    columns.add(col);
                }
            }
        }

        for (int row : rows) {
            for (int n = 0; n < matrix[row].length; ++n) {
                matrix[row][n] = 0;
            }
        }

        for (int col : columns) {
            for (int n = 0; n < matrix.length; ++n) {
                matrix[n][col] = 0;
            }
        }
    }
}
