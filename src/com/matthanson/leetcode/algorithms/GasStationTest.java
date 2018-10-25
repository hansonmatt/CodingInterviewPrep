package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GasStationTest {
    private GasStation station = new GasStation();

    @Test
    public void canCompleteCircuit() {

        // gas, cost
        assertEquals(-1, station.canCompleteCircuit(null, null));
        assertEquals(-1, station.canCompleteCircuit(new int[]{}, new int[]{}));
        assertEquals(0, station.canCompleteCircuit(new int[]{5}, new int[]{1}));
        assertEquals(0, station.canCompleteCircuit(new int[]{1, 5}, new int[]{1, 5}));
        assertEquals(1, station.canCompleteCircuit(new int[]{1, 5}, new int[]{5, 1}));

        assertEquals(3, station.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        assertEquals(4, station.canCompleteCircuit(new int[]{1, 0, 2, 3, 4, 5}, new int[]{3, 0, 4, 5, 1, 2}));
        assertEquals(0, station.canCompleteCircuit(new int[]{5, 0, 0, 0, 0}, new int[]{1, 1, 1, 1, 1}));
        assertEquals(-1, station.canCompleteCircuit(new int[]{5, 0, 0, 0, 0}, new int[]{1, 2, 1, 1, 1}));

        assertEquals(-1, station.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
        assertEquals(-1, station.canCompleteCircuit(new int[]{2, 0, 4}, new int[]{2, 1, 4}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void canCompleteCircuitIllegalArgument() {
        station.canCompleteCircuit(new int[]{1}, new int[]{});
    }
}