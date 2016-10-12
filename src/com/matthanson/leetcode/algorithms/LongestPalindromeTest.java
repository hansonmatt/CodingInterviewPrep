package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthans on 10/12/16.
 */
public class LongestPalindromeTest {
    @Test
    public void longestPalindrome() throws Exception {
        LongestPalindrome lp = new LongestPalindrome();
        assertEquals(0, lp.longestPalindrome(null));
        assertEquals(0, lp.longestPalindrome(""));
        assertEquals(7, lp.longestPalindrome("abccccdd"));
    }

}