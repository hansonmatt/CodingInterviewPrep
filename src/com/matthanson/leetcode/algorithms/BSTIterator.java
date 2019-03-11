package com.matthanson.leetcode.algorithms;

import java.util.Stack;

public class BSTIterator {
    public static class TreeNode {
        int val;
        BSTIterator.TreeNode left;
        BSTIterator.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        if (root != null) {
            stack.add(root);
            TreeNode node = root.left;
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Next cannot be called on empty iterator.");
        }

        TreeNode node = stack.pop();
        if (node.right != null) {
            TreeNode tmp = node.right;
            while (tmp != null) {
                stack.add(tmp);
                tmp = tmp.left;
            }
        }

        return node.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
