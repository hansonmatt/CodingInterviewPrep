package com.matthanson.leetcode.algorithms;

import java.text.StringCharacterIterator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by matthans on 10/12/16.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null) {
            return 0;
        }

        Map<Character, Integer> charCount = new HashMap<>();
        StringCharacterIterator i = new StringCharacterIterator(s);
        for (char c = i.first(); c != i.DONE; c = i.next()) {
            if (!charCount.containsKey(c)) {
                charCount.put(c, 1);
            } else {
                int count = charCount.get(c);
                charCount.put(c, count + 1);
            }
        }

        boolean mod = false;
        int longestPalindrome = 0;
        for (char c : charCount.keySet()) {
            int count = charCount.get(c);
            if (count % 2 == 0) {
                longestPalindrome += count;
            } else {
                longestPalindrome += count - 1;
                mod = true;
            }
        }

        if (mod == true) {
            longestPalindrome++;
        }

        return longestPalindrome;
    }
}
