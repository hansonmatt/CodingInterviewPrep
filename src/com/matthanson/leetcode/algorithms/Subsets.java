package com.matthanson.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> toReturn = new ArrayList();
        toReturn.add(new ArrayList<Integer>());

        ArrayList<ArrayList<Integer>> current = new ArrayList<>();

        for (int n = 0; n < nums.length; ++n) {
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(n);
            current.add(curr);
        }

        ArrayList<ArrayList<Integer>> next = new ArrayList<>();

        while (!current.isEmpty()) {
            for (ArrayList<Integer> curr : current) {
                ArrayList<Integer> toAdd = new ArrayList<>();
                for (Integer add : curr) {
                    toAdd.add(nums[add]);
                }

                toReturn.add(toAdd);

                int last = curr.get(curr.size() - 1) + 1;
                if (last < nums.length) {
                    for (int n = last; n < nums.length; ++n) {
                        ArrayList<Integer> toNext = new ArrayList<>(curr);
                        toNext.add(n);
                        next.add(toNext);
                    }
                }
            }

            current.clear();
            current.addAll(next);
            next.clear();
        }

        return toReturn;
    }
}
