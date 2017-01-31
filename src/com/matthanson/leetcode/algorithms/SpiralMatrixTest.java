package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by matthans on 1/30/17.
 */
public class SpiralMatrixTest {
    private SpiralMatrix spiralMatrix = new SpiralMatrix();

    @Test
    public void spiralOrderNull() throws Exception {
        assertTrue(spiralMatrix.spiralOrder(null).isEmpty());
    }

    @Test
    public void spiralOrderEmpty() throws Exception {
        assertTrue(spiralMatrix.spiralOrder(new int[0][0]).isEmpty());
    }

    @Test
    public void spiralOrder1x1() throws Exception {
        int[][] matrix = new int[1][1];
        matrix[0][0] = 5;
        List<Integer> spiral = spiralMatrix.spiralOrder(matrix);
        assertEquals(1, spiral.size());
        assertEquals((int) 5, (int) spiral.get(0));
    }

    @Test
    public void spiralOrder2x2() throws Exception {
        int[][] matrix = new int[2][2];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[1][0] = 3;
        matrix[1][1] = 4;
        List<Integer> spiral = spiralMatrix.spiralOrder(matrix);
        assertEquals(4, spiral.size());
        assertEquals((int) 1, (int) spiral.get(0));
        assertEquals((int) 2, (int) spiral.get(1));
        assertEquals((int) 4, (int) spiral.get(2));
        assertEquals((int) 3, (int) spiral.get(3));
    }

    @Test
    public void spiralOrder5x5() throws Exception {
        int[][] matrix = new int[5][5];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 4;
        matrix[0][4] = 5;

        matrix[1][0] = 6;
        matrix[1][1] = 7;
        matrix[1][2] = 8;
        matrix[1][3] = 9;
        matrix[1][4] = 10;

        matrix[2][0] = 11;
        matrix[2][1] = 12;
        matrix[2][2] = 13;
        matrix[2][3] = 14;
        matrix[2][4] = 15;

        matrix[3][0] = 16;
        matrix[3][1] = 17;
        matrix[3][2] = 18;
        matrix[3][3] = 19;
        matrix[3][4] = 20;

        matrix[4][0] = 21;
        matrix[4][1] = 22;
        matrix[4][2] = 23;
        matrix[4][3] = 24;
        matrix[4][4] = 25;

        List<Integer> spiral = spiralMatrix.spiralOrder(matrix);
        assertEquals(25, spiral.size());
        assertEquals((int) 1, (int) spiral.get(0));
        assertEquals((int) 2, (int) spiral.get(1));
        assertEquals((int) 3, (int) spiral.get(2));
        assertEquals((int) 4, (int) spiral.get(3));
        assertEquals((int) 5, (int) spiral.get(4));
        assertEquals((int) 10, (int) spiral.get(5));
        assertEquals((int) 15, (int) spiral.get(6));
        assertEquals((int) 20, (int) spiral.get(7));
        assertEquals((int) 25, (int) spiral.get(8));
        assertEquals((int) 24, (int) spiral.get(9));
        assertEquals((int) 23, (int) spiral.get(10));
        assertEquals((int) 22, (int) spiral.get(11));
        assertEquals((int) 21, (int) spiral.get(12));
        assertEquals((int) 16, (int) spiral.get(13));
        assertEquals((int) 11, (int) spiral.get(14));
        assertEquals((int) 6, (int) spiral.get(15));
    }

    @Test
    public void spiralOrder5x3() throws Exception {
        int[][] matrix = new int[3][5];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 4;
        matrix[0][4] = 5;


        matrix[1][0] = 6;
        matrix[1][1] = 7;
        matrix[1][2] = 8;
        matrix[1][3] = 9;
        matrix[1][4] = 10;

        matrix[2][0] = 11;
        matrix[2][1] = 12;
        matrix[2][2] = 13;
        matrix[2][3] = 14;
        matrix[2][4] = 15;

        List<Integer> spiral = spiralMatrix.spiralOrder(matrix);
        assertEquals(15, spiral.size());
        assertEquals((int) 1, (int) spiral.get(0));
        assertEquals((int) 2, (int) spiral.get(1));
        assertEquals((int) 3, (int) spiral.get(2));
        assertEquals((int) 4, (int) spiral.get(3));
        assertEquals((int) 5, (int) spiral.get(4));
        assertEquals((int) 10, (int) spiral.get(5));
        assertEquals((int) 15, (int) spiral.get(6));
        assertEquals((int) 14, (int) spiral.get(7));
        assertEquals((int) 13, (int) spiral.get(8));
        assertEquals((int) 12, (int) spiral.get(9));
        assertEquals((int) 11, (int) spiral.get(10));
        assertEquals((int) 6, (int) spiral.get(11));
        assertEquals((int) 7, (int) spiral.get(12));
        assertEquals((int) 8, (int) spiral.get(13));
        assertEquals((int) 9, (int) spiral.get(14));
    }

    @Test
    public void spiralOrder3x5() throws Exception {
        int[][] matrix = new int[5][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;

        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;

        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;

        matrix[3][0] = 10;
        matrix[3][1] = 11;
        matrix[3][2] = 12;

        matrix[4][0] = 13;
        matrix[4][1] = 14;
        matrix[4][2] = 15;

        List<Integer> spiral = spiralMatrix.spiralOrder(matrix);
        assertEquals(15, spiral.size());
        assertEquals((int) 1, (int) spiral.get(0));
        assertEquals((int) 2, (int) spiral.get(1));
        assertEquals((int) 3, (int) spiral.get(2));
        assertEquals((int) 6, (int) spiral.get(3));
        assertEquals((int) 9, (int) spiral.get(4));
        assertEquals((int) 12, (int) spiral.get(5));
        assertEquals((int) 15, (int) spiral.get(6));
        assertEquals((int) 14, (int) spiral.get(7));
        assertEquals((int) 13, (int) spiral.get(8));
        assertEquals((int) 10, (int) spiral.get(9));
        assertEquals((int) 7, (int) spiral.get(10));
        assertEquals((int) 4, (int) spiral.get(11));
        assertEquals((int) 5, (int) spiral.get(12));
        assertEquals((int) 8, (int) spiral.get(13));
        assertEquals((int) 11, (int) spiral.get(14));
    }

}