package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthans on 10/14/16.
 */
public class LongestConsecutiveSequenceTest {
    private LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();

    @Test
    public void longestConsecutive() throws Exception {
        assertEquals(0, lcs.longestConsecutive(null));
        assertEquals(0, lcs.longestConsecutive(new int[] {}));
        assertEquals(4, lcs.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
        assertEquals(1, lcs.longestConsecutive(new int[] {100, 4, 200, 1}));
        assertEquals(1, lcs.longestConsecutive(new int[] {100, 4, 200, 1, Integer.MAX_VALUE}));
        assertEquals(2, lcs.longestConsecutive(new int[] {100, 4, 200, 1, Integer.MAX_VALUE, Integer.MAX_VALUE - 1}));
        assertEquals(2, lcs.longestConsecutive(new int[] {100, 4, 200, 4, 4, 3}));
        assertEquals(2, lcs.longestConsecutive(new int[] {100, 4, 200, 1, Integer.MIN_VALUE, Integer.MIN_VALUE + 1}));
        assertEquals(1, lcs.longestConsecutive(new int[] {100, 4, 200, 1, Integer.MIN_VALUE, Integer.MIN_VALUE - 1}));
    }

}