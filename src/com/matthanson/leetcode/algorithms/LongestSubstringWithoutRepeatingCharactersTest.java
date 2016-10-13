package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthans on 10/12/16.
 */
public class LongestSubstringWithoutRepeatingCharactersTest {
    @Test
    public void lengthOfLongestSubstring() throws Exception {
        LongestSubstringWithoutRepeatingCharacters longest = new LongestSubstringWithoutRepeatingCharacters();
        assertEquals(0, longest.lengthOfLongestSubstring(null));
        assertEquals(0, longest.lengthOfLongestSubstring(""));
        assertEquals(2, longest.lengthOfLongestSubstring("abba"));
        assertEquals(3, longest.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, longest.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, longest.lengthOfLongestSubstring("pwwkew"));
        assertEquals(5, longest.lengthOfLongestSubstring("aaabcde"));
        assertEquals(3, longest.lengthOfLongestSubstring("dvdf"));
        assertEquals(7, longest.lengthOfLongestSubstring("aablmnacd"));
        assertEquals(8, longest.lengthOfLongestSubstring("aablmdxnacddad"));
        assertEquals(7, longest.lengthOfLongestSubstring("aablmdnacddad"));
        assertEquals(3, longest.lengthOfLongestSubstring("abcabcbb"));
    }

}