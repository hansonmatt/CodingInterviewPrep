package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingleNumberIITest {

    private SingleNumberII single = new SingleNumberII();

    @Test
    public void singleNumber() {
        int [] nums = new int[]{2,2,3,2};
        assertEquals(3, single.singleNumber(nums));

        assertEquals(99, single.singleNumber(new int[]{0,1,0,1,0,1,99}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void singleNumberIllegalArgumentNull() {
        single.singleNumber(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void singleNumberIllegalArgumentEmpty() {
        single.singleNumber(new int[]{});
    }

    @Test(expected = IllegalStateException.class)
    public void singleNumberIllegalStateException() {
        single.singleNumber(new int[]{0,1});
    }
}