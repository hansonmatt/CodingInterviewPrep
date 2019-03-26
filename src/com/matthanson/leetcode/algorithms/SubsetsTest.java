package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SubsetsTest {

    private Subsets subSets = new Subsets();

    @Test
    public void subsets() {
        List<List<Integer>> subs = subSets.subsets(new int[]{1});
        assertEquals(2, subs.size());

        subs = subSets.subsets(new int[]{1, 2, 3});
        assertEquals(8, subs.size());
        assertTrue(subs.contains(listFromArray(new int[]{})));
        assertTrue(subs.contains(listFromArray(new int[]{1})));
        assertTrue(subs.contains(listFromArray(new int[]{2})));
        assertTrue(subs.contains(listFromArray(new int[]{3})));
        assertTrue(subs.contains(listFromArray(new int[]{1, 2})));
        assertTrue(subs.contains(listFromArray(new int[]{1, 3})));
        assertTrue(subs.contains(listFromArray(new int[]{2, 3})));
        assertTrue(subs.contains(listFromArray(new int[]{1, 2, 3})));


        subs = subSets.subsets(new int[]{2, 9, 4, 12});
        int[][] arrays = new int[][]{{}, {2}, {9}, {4}, {12}, {2, 9}, {2, 4}, {2, 12}, {9, 4}, {9, 12}, {4, 12}, {2, 9, 4}, {2, 9, 12}, {2, 4, 12}, {9, 4, 12}, {2, 9, 4, 12}};
        assertEquals(arrays.length, subs.size());
        for (int n = 0; n < arrays.length; ++n) {
            assertTrue(subs.contains(listFromArray(arrays[n])));
        }

        int[] nums = new int[]{9,6,3,8,50};
        subs = subSets.subsets(nums);
        assertEquals((long) Math.pow(2,nums.length), subs.size());

        nums = new int[]{9,6,3,8,50,-2,100,34,18,11,28};
        subs = subSets.subsets(nums);
        assertEquals((long) Math.pow(2,nums.length), subs.size());
    }

    private List<Integer> listFromArray(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        for (int n = 0; n < nums.length; ++n) {
            list.add(nums[n]);
        }

        return list;
    }
}