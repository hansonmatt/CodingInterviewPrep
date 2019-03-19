package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoveZeroesTest {
    private MoveZeroes moveZeroes = new MoveZeroes();

    @Test
    public void moveZeroes() {
        int[] nums = new int[0];

        moveZeroes.moveZeroes(nums);
        assertArrayEquals(new int[0], nums);

        nums = new int[]{5};
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(new int[]{5}, nums);

        nums = new int[]{5, 0};
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(new int[]{5, 0}, nums);

        nums = new int[]{0, 5};
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(new int[]{5, 0}, nums);

        nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);

        nums = new int[]{0, 0, 1, 0, 3, 0, 0, 0, 12, 0, 2, 15, 13, 0, 0, 18, 25, 1, 3, 6, 10};
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 2, 15, 13, 18, 25, 1, 3, 6, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0}, nums);

        nums = new int[]{0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0, 8, 0, 9, 0, 10, 0, 11, 0, 12, 0, 13, 0, 14, 0, 15, 0};
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, nums);

        nums = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, nums);

        nums = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, nums);
    }
}