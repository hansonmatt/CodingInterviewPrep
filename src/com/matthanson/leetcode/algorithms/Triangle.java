package com.matthanson.leetcode.algorithms;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }

        int[][] intTriangle = new int[triangle.size()][];

        int n = 0;
        for (List<Integer> row : triangle) {
            intTriangle[n] = new int[row.size()];

            int m = 0;
            for (int val : row) {
                intTriangle[n][m++] = val;
            }
            ++n;
        }

        if (intTriangle.length == 1) {
            return intTriangle[0][0];
        }

        for (int k = intTriangle.length - 1; k > 0; --k) {
            for (int l = 0; l < intTriangle[k - 1].length; ++l) {
                intTriangle[k - 1][l] = intTriangle[k - 1][l] + Integer.min(intTriangle[k][l], intTriangle[k][l + 1]);
            }
        }

        return intTriangle[0][0];
    }
}
