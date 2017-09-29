package com.matthanson.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    private Map<Character, Character> tuples = new HashMap<>();

    public ValidParentheses() {
        tuples.put(')', '(');
        tuples.put('}', '{');
        tuples.put(']', '[');
    }

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     */
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        int stringLen = s.length();
        for (int n = 0; n < stringLen; ++n) {
            char c = s.charAt(n);
            if (tuples.containsKey(c)) {
                if (stack.empty() || tuples.get(c) != stack.pop()) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        if (!stack.empty()) return false;

        return true;
    }

}
