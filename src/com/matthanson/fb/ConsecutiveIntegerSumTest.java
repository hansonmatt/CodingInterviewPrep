package com.matthanson.fb;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matt on 9/28/16.
 */
public class ConsecutiveIntegerSumTest {
    @Test
    public void consecutiveSum() throws Exception {
        assertFalse(ConsecutiveIntegerSum.consecutiveSumBruteForce(null, 100));
        assertFalse(ConsecutiveIntegerSum.consecutiveSumBruteForce(new int[0], 100));
        assertFalse(ConsecutiveIntegerSum.consecutiveSumBruteForce(new int[]{15, 2, 11, 5, 5, 6}, 0));
        assertTrue(ConsecutiveIntegerSum.consecutiveSumBruteForce(new int[]{15, 2, 11, 5, 5, 6}, 10));
        assertTrue(ConsecutiveIntegerSum.consecutiveSumBruteForce(new int[]{15, 8, 30, 500, 25, 3, 2, 4, 1, 19, 50, 40, 80}, 10));
        assertFalse(ConsecutiveIntegerSum.consecutiveSumBruteForce(new int[]{15, 8, 30, 500, 25, 3, 2, 4, 19, 50, 40, 80}, 10));
    }

    @Test
    public void consecutiveSumBruteForce() throws Exception {
        assertFalse(ConsecutiveIntegerSum.consecutiveSum(null, 100));
        assertFalse(ConsecutiveIntegerSum.consecutiveSum(new int[0], 100));
        assertFalse(ConsecutiveIntegerSum.consecutiveSum(new int[]{15, 2, 11, 5, 5, 6}, 0));
        assertTrue(ConsecutiveIntegerSum.consecutiveSum(new int[]{15, 2, 11, 5, 5, 6}, 10));
        assertTrue(ConsecutiveIntegerSum.consecutiveSum(new int[]{15, 8, 30, 500, 25, 3, 2, 4, 1, 19, 50, 40, 80}, 10));
        assertFalse(ConsecutiveIntegerSum.consecutiveSum(new int[]{15, 8, 30, 500, 25, 3, 2, 4, 19, 50, 40, 80}, 10));
    }

}