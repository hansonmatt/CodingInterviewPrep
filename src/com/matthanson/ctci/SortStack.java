package com.matthanson.ctci;

import java.util.Stack;

public class SortStack {
    private Stack<Integer> stack = new Stack<>();

    public void push(int toPush) {
        if (stack.isEmpty() || (toPush <= stack.peek())) {
            stack.push(toPush);
            return;
        }

        if (toPush > stack.peek()) {
            Stack<Integer> tmp = new Stack<>();
            while (!stack.isEmpty() && stack.peek() < toPush) {
                tmp.push(stack.pop());
            }

            stack.push(toPush);
            while (!tmp.isEmpty()) {
                stack.push(tmp.pop());
            }
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
