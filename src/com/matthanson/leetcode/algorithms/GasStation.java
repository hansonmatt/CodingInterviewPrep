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

        int tank = 0;
        int cumulativeTank = 0;
        for (int n = 0; n < gas.length; ++n) {
            int net = gas[n] - cost[n];
            tank += net;
            cumulativeTank += net;

            if (tank >= 0) {
                if (toReturn == -1) {
                    toReturn = n;
                }
            } else {
                toReturn = -1;
                tank = 0;
            }
        }

        if (cumulativeTank < 0) {
            toReturn = -1;
        }

        return toReturn;
    }
}
