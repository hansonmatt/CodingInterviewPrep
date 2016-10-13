package com.matthanson.leetcode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by matthans on 10/12/16.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        Map<Character, Integer> characterIdxMap = new HashMap<>();
        int startIdx = 0;
        int stringLen = s.length();
        int longest = 0;
        int longestSoFar = 0;
        for (int n = 0; n < stringLen; ++n) {
            char c = s.charAt(n);
            if (!characterIdxMap.containsKey(c) || (characterIdxMap.containsKey(c) && characterIdxMap.get(c) < startIdx)) {
                longestSoFar++;
            } else {
                if (longestSoFar > longest) {
                    longest = longestSoFar;
                }

                startIdx = characterIdxMap.get(c) + 1;
                longestSoFar = n - characterIdxMap.get(c);
            }

            characterIdxMap.put(c, n);
        }

        if (longestSoFar > longest) {
            longest = longestSoFar;
        }

        return longest;
    }
}
