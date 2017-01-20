package com.matthanson.leetcode.algorithms;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by matthans on 1/20/17.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        Stack<int[]> s = new Stack<>();

        for (int n = 0; n < matrix.length; ++n) {
            s.push(matrix[n].clone());
        }

        for (int n = 0; n < matrix.length; ++n) {
            int[] row = s.pop();

            for (int m = 0; m < matrix.length; ++m) {
                matrix[m][n] = row[m];
            }
        }
    }
}
