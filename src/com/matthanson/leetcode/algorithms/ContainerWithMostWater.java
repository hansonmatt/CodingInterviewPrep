package com.matthanson.leetcode.algorithms;

import java.math.BigInteger;

/**
 * Created by matthans on 10/18/16.
 */
public class ContainerWithMostWater {
    // https://leetcode.com/problems/container-with-most-water/
    public int maxArea(int[] height) {
        int max = 0;
        int maxHeight = 0;
        for (int n = 0; n < height.length - 1; ++n) {

            if (height[n] >= maxHeight) {
                maxHeight = height[n];
            }

            for (int m = n + 1; m < height.length; ++m) {
                int span = m - n;
                int minHeight = Math.min(height[n], height[m]);
                int thisMax = minHeight * span;

                if (thisMax > max) {
                    max = thisMax;
                }
            }
        }

        return max;
    }
}
