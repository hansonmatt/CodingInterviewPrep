package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthans on 3/1/17.
 */
public class MatrixZeroesTest {
    private MatrixZeroes mz = new MatrixZeroes();

    @Test
    public void setZeroes() throws Exception {
        int[][] matrix = getMatrix(4,4);
        mz.setZeroes(matrix);
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[row].length; ++col) {
                assertEquals(1, matrix[row][col]);
            }
        }

        matrix[0][0] = 0;
        mz.setZeroes(matrix);
        validateRow(matrix, 0);
        validateCol(matrix, 0);

        matrix = getMatrix(5,5);
        matrix[0][4] = 0;
        matrix[2][2] = 0;
        matrix[3][1] = 0;
        mz.setZeroes(matrix);
        validateRow(matrix, 0);
        validateRow(matrix, 2);
        validateRow(matrix, 3);
        validateCol(matrix, 4);
        validateCol(matrix, 2);
        validateCol(matrix, 1);
    }

    private int [][] getMatrix(int rows, int cols) {
        int [][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                matrix[row][col] = 1;
            }
        }

        return matrix;
    }

    private void validateRow(int[][] matrix, int rowNum) {
        int [] row = matrix[rowNum];
        for (int n = 0; n < row.length; ++n) {
            assertEquals(0, matrix[rowNum][n]);
        }
    }

    private void validateCol(int[][] matrix, int colNum) {
        for (int n = 0; n < matrix.length; ++n) {
            assertEquals(0, matrix[n][colNum]);
        }
    }

}