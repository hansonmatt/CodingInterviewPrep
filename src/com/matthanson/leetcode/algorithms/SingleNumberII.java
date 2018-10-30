package com.matthanson.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int n = 0; n < nums.length; ++n) {
            int num = nums[n];
            if (map.containsKey(num)) {
                int count = map.get(num);
                if (count == 2) {
                    map.remove(num);
                }
                else
                {
                    map.put(num, count + 1);
                }
            }
            else {
                map.put(num, 1);
            }
        }


        if (map.size() != 1){
            throw new IllegalStateException();
        }
        return map.keySet().iterator().next();
    }
}
