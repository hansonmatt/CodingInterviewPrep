package com.matthanson.leetcode.algorithms;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by matthans on 3/1/17.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || "".equals(path)) {
            return path;
        }

        StringTokenizer st = new StringTokenizer(path, "/");

        Stack<String> stack = new Stack<>();
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!".".equals(s)) {
                stack.push(s);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        Stack<String> newPath = new Stack<>();
        while (!stack.isEmpty()) {
            newPath.push(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!newPath.isEmpty()) {
            sb.append("/").append(newPath.pop());
        }

        return sb.toString();
    }
}
