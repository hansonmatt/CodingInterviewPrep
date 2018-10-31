package com.matthanson.leetcode.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new LinkedList<>();
        }

        Set<List<Integer>> s = new HashSet<>();
        for (int x = 0; x < nums.length - 2; ++x) {
            for (int y = x + 1; y < nums.length - 1; ++y) {
                for (int z = y + 1; z < nums.length; ++z) {
                    if (nums[x] + nums[y] + nums[z] == 0) {
                        s.add(this.getSortedList(nums[x], nums[y], nums[z]));
                    }
                }
            }
        }

        return new LinkedList<>(s);
    }

    public List<Integer> getSortedList(int x, int y, int z) {
        int low = x;
        int med = x;
        int high = x;

        if (y < x) {
            low = y;
        } else if (y > x) {
            med = y;
            high = y;
        }

        if (z < low) {
            high = med;
            med = low;
            low = z;
        } else if (z < med) {
            high = med;
            med = z;
        } else {
            high = z;
        }

        List<Integer> list = new LinkedList<>();
        list.add(low);
        list.add(med);
        list.add(high);

        return list;
    }
}
