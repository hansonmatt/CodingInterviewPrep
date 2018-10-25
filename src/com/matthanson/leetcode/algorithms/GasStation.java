package com.matthanson.leetcode.algorithms;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null) {
            return -1;
        }

        if (gas.length != cost.length) {
            throw new IllegalArgumentException();
        }

        if (gas.length == 0 || cost.length == 0) {
            return -1;
        }

        int toReturn = -1;
        for (int n = 0; n < gas.length; ++n) {

            boolean[] processed = new boolean[gas.length];
            for (int m = 0; m < processed.length; ++m) {
                processed[m] = false;
            }

            int tank = gas[n];
            int m = n;
            while (tank >= cost[m]) {
                processed[m] = true;
                tank -= cost[m];

                m = (m + 1) % gas.length;

                tank += gas[m];

                if (processed[m]) {
                    return n;
                }
            }
        }

        return -1;
    }
}
