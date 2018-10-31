package com.matthanson.leetcode.algorithms;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new LinkedList<>();
        }

        Map<Integer, Integer> vals = new HashMap<>(nums.length);
        for (int n = 0; n < nums.length; ++n) {
            int count = 1;
            if (vals.containsKey(nums[n])) {
                count += vals.get(nums[n]);
            }
            vals.put(nums[n], count);
        }

        Set<List<Integer>> s = new HashSet<>();

        int tmp = 0;
        for (int x = 0; x < nums.length - 1; ++x) {
            for (int y = x + 1; y < nums.length; ++y) {
                tmp = 0 - nums[x] - nums[y];
                if (vals.containsKey(tmp)) {
                    boolean add = true;
                    if (tmp == nums[x] || tmp == nums[y]) {
                        int count = vals.get(tmp);
                        if (count == 1) {
                            add = false;
                        }
                    }

                    if (add) {
                        s.add(this.getSortedList(nums[x], nums[y], tmp));
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
