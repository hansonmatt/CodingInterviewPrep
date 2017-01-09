package com.matthanson.leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by matthans on 1/5/17.
 */
public class LetterCombinationsPhoneNumber {
    static private Map<Character, char[]> dialer = new HashMap<>();

    /**
     * unicode chars for 0 and 1 do not need to be supported...
     */
    public LetterCombinationsPhoneNumber() {
        //dialer.put(1, new Character[]{});
        dialer.put('2', new char[]{'a', 'b', 'c'});
        dialer.put('3', new char[]{'d', 'e', 'f'});
        dialer.put('4', new char[]{'g', 'h', 'i'});
        dialer.put('5', new char[]{'j', 'k', 'l'});
        dialer.put('6', new char[]{'m', 'n', 'o'});
        dialer.put('7', new char[]{'p', 'q', 'r', 's'});
        dialer.put('8', new char[]{'t', 'u', 'v'});
        dialer.put('9', new char[]{'w', 'x', 'y', 'z'});
        //dialer.put(0, new Character[]{});
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null) {
            return new ArrayList<String>();
        }

        List<StringBuilder> combinationsBuilder = new ArrayList<>();

        int nDigits = digits.length();
        for (int n = 0; n < nDigits; ++n) {
            char digit = digits.charAt(n);
            if (!dialer.containsKey(digit)) {
                throw new IllegalArgumentException("Unknown digit " + digit);
            }

            char[] chars = dialer.get(digit);
            if (combinationsBuilder.isEmpty()) {
                for (char c : chars) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(c);
                    combinationsBuilder.add(sb);
                }
            } else {
                int currSize = combinationsBuilder.size();

                for (int m = 0; m < chars.length - 1; ++m) {
                    for (int x = 0; x < currSize; ++x) {
                        combinationsBuilder.add(new StringBuilder(combinationsBuilder.get(x)));
                    }
                }

                int count = 0;
                for (int m = 0; m < chars.length; ++m) {
                    for (int l = 0; l < currSize; ++l) {
                        combinationsBuilder.get(count++).append(chars[m]);
                    }
                }
            }
        }

        List<String> combinations = new ArrayList<>(combinationsBuilder.size());
        for (StringBuilder sb : combinationsBuilder) {
            combinations.add(sb.toString());
        }

        return combinations;
    }
}
