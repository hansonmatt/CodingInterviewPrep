package com.matthanson.leetcode.algorithms;

import java.util.List;
import java.util.Stack;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Stack<String> stack = new Stack<>();

        StringBuilder builder = new StringBuilder();

        int start = 0;
        boolean backTrack = false;
        int backtrackLen = 0;

        int len = s.length();
        do {
            if (!stack.isEmpty()) {
                builder.setLength(0);
                builder.append(stack.pop());
                backtrackLen = builder.length();
                backTrack = true;
            }
            for (int n = start; n < len; ++n) {
                builder.append(s.charAt(n));
                if (wordDict.contains(builder.toString())) {
                    stack.push(builder.toString());
                    builder.setLength(0);
                    start = n + 1;
                    backTrack = false;
                }
            }

            if (backTrack) {
                start -= backtrackLen;
            }
        }
        while (!stack.isEmpty() && builder.length() > 0);

        return builder.length() == 0;
    }
}
