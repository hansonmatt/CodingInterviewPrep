package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthans on 10/18/16.
 */
public class ContainerWithMostWaterTest {
    @Test
    public void maxArea() throws Exception {
        ContainerWithMostWater container = new ContainerWithMostWater();
        assertEquals(9, container.maxArea(new int[] {3,2,1,3}));
    }

}