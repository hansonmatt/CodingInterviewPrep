package com.matthanson.leetcode.algorithms;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int inRow = -1;
        for (int n = 0; inRow == -1 && n < matrix.length; ++n) {
            int[] row = matrix[n];

            if (row.length == 0) {
                return false;
            }

            if (target <= row[row.length - 1]) {
                inRow = n;

                return binarySearch(row, target);
            }
        }

        return false;
    }


    private boolean binarySearch(int[] row, int target) {
        int low = 0, high = row.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;

            if (target > row[mid]) {
                low = mid + 1;
            } else if (target < row[mid]) {
                high = mid - 1;
            } else return true;
        }

        return false;
    }
}
