package com.matthanson.leetcode.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThreeSumClosestTest {
    private ThreeSumClosest tsc = new ThreeSumClosest();

    @Test(expected = IllegalArgumentException.class)
    public void threeSumClosestBadArguments() {
        tsc.threeSumClosest(null, 1);
        tsc.threeSumClosest(new int[]{}, 10);
        tsc.threeSumClosest(new int[]{1}, 10);
        tsc.threeSumClosest(new int[]{1,-50}, 10);
    }

    @Test
    public void threeSumClosest() {

    }
}