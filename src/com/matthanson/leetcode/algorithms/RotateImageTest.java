package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthans on 1/20/17.
 */
public class RotateImageTest {
    private RotateImage ri = new RotateImage();

    @Test
    public void rotateImageNull()
    {
        int [][] image = null;
        ri.rotate(image);
        assertNull(image);
    }

    @Test
    public void rotateImage1x1() {
        int[][] image = new int[1][1];
        image[0] = new int[]{1};
        ri.rotate(image);
        assertEquals(1, image[0][0]);
    }

    @Test
    public void rotateImage2x2() {
        int[][] image = new int[2][2];
        image[0] = new int[]{1,2};
        image[1] = new int[]{3,4};
        ri.rotate(image);

        int [] row = image[0];
        assertEquals(3, row[0]);
        assertEquals(1, row[1]);

        row = image[1];
        assertEquals(4, row[0]);
        assertEquals(2, row[1]);
    }

    @Test
    public void rotateImage4x4() {
        int[][] image = new int[4][4];
        image[0] = new int[]{1,2,3,4};
        image[1] = new int[]{5,6,7,8};
        image[2] = new int[]{9,10,11,12};
        image[3] = new int[]{13,14,15,16};
        ri.rotate(image);

        int [] row = image[0];
        assertEquals(13, row[0]);
        assertEquals(9, row[1]);
        assertEquals(5, row[2]);
        assertEquals(1, row[3]);

        row = image[1];
        assertEquals(14, row[0]);
        assertEquals(10, row[1]);
        assertEquals(6, row[2]);
        assertEquals(2, row[3]);

        row = image[2];
        assertEquals(15, row[0]);
        assertEquals(11, row[1]);
        assertEquals(7, row[2]);
        assertEquals(3, row[3]);

        row = image[3];
        assertEquals(16, row[0]);
        assertEquals(12, row[1]);
        assertEquals(8, row[2]);
        assertEquals(4, row[3]);
    }
}