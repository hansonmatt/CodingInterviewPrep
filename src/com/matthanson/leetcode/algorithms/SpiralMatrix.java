package com.matthanson.leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by matthans on 1/30/17.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new LinkedList<>();

        if (matrix == null || matrix.length == 0) {
            return spiral;
        }

        int startX = 0;
        int startY = 0;
        int maxRowIdx = matrix.length - 1;
        int maxColIdx = matrix[0].length - 1;

        while (startX <= maxRowIdx && startY <= maxColIdx) {

            for (int idx = startY; idx <= maxColIdx; ++idx) {
                spiral.add(matrix[startX][idx]);
            }

            for (int idx = startX + 1; idx <= maxRowIdx; ++idx) {
                spiral.add(matrix[idx][maxColIdx]);
            }

            if (maxRowIdx > startX) {
                for (int idx = maxColIdx - 1; idx >= startY; --idx) {
                    spiral.add(matrix[maxRowIdx][idx]);
                }
            }


            if (maxColIdx > startY) {
                for (int idx = maxRowIdx - 1; idx > startX; --idx) {
                    spiral.add(matrix[idx][startY]);
                }
            }


            ++startX;
            ++startY;
            --maxRowIdx;
            --maxColIdx;
        }

        return spiral;
    }
}
