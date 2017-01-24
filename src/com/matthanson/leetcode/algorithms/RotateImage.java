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

        int rOffset = 0;
        int cOffset = 0;
        while (rOffset < (matrix.length / 2)) {

            int rowBegin = rOffset;
            int rowEnd = matrix.length - 1 - rOffset;

            int colBegin = cOffset;
            int colEnd = matrix.length - 1 - cOffset;

            int ops = colEnd - colBegin;

            for (int c = 0; c < ops; ++c) {
                int buffer = matrix[rowBegin][colBegin + c];
                matrix[rowBegin][colBegin + c] = matrix[rowEnd - c][rowBegin];
                matrix[rowEnd - c][rowBegin] = matrix[rowEnd][colEnd - c];
                matrix[rowEnd][colEnd - c] = matrix[rowBegin + c][colEnd];
                matrix[rowBegin + c][colEnd] = buffer;
            }

            ++rOffset;
            ++cOffset;
        }
    }
}
