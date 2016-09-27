package com.matthanson.fb;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matt on 9/27/16.
 */
public class LongestConsecutiveIntegerSubsequenceTest {
    @Test
    public void longestConsecutiveIntegerSubsequence() throws Exception {
        LongestConsecutiveIntegerSubsequence lcis = new LongestConsecutiveIntegerSubsequence();

        assertEquals(0, lcis.longestConsecutiveIntegerSubsequence(null));

        assertEquals(0, lcis.longestConsecutiveIntegerSubsequence(new int [0]));

        assertEquals(0, lcis.longestConsecutiveIntegerSubsequence(new int [] {1}));

        assertEquals(2, lcis.longestConsecutiveIntegerSubsequence(new int [] {1,2}));

        assertEquals(0, lcis.longestConsecutiveIntegerSubsequence(new int [] {1,3}));

        assertEquals(10, lcis.longestConsecutiveIntegerSubsequence(new int [] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));

        assertEquals(8, lcis.longestConsecutiveIntegerSubsequence(new int [] {0, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9}));

        assertEquals(4, lcis.longestConsecutiveIntegerSubsequence(new int [] {-1, 0, 1, 2, -5, -4}));
    }

}