package com.matthanson.hackerrank.ds.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Matt on 9/13/16.
 */
public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String s = in.next();

            Stack<Character> stack = new Stack<>();
            boolean go = true;
            for (int n = 0; n < s.length() && go; ++n) {
                char c = s.charAt(n);
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else if (c == ')' || c == '}' || c == ']') {
                    if (stack.isEmpty()) {
                        go = false;
                    }
                    else {
                        char left = stack.pop();
                        if (!((left == '(' && c == ')') || (left == '{' && c == '}')
                                || (left == '[' && c == ']'))) {
                            go = false;
                        }
                    }

                }
            }

            if (stack.isEmpty() && go) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
