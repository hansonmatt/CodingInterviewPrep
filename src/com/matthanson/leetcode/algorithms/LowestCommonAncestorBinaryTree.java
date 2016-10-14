package com.matthanson.leetcode.algorithms;

import java.util.Stack;

/**
 * Created by matthans on 10/13/16.
 */
public class LowestCommonAncestorBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        Stack<TreeNode> pPath = new Stack<>();
        if (!treeNodeSearchWithPath(root, p.val, pPath)) {
            return null;
        }

        Stack<TreeNode> qPath = new Stack<>();
        if (!treeNodeSearchWithPath(root, q.val, qPath)) {
            return null;
        }

        TreeNode ancestor = null;
        boolean done = false;
        while (!done && !pPath.isEmpty() && !qPath.isEmpty()) {
            if (pPath.peek() == qPath.peek()) {
                ancestor = pPath.pop();
                qPath.pop();
            } else {
                done = true;
            }

        }

        return ancestor;
    }

    public boolean treeNodeSearchWithPath(TreeNode curr, int searchVal, Stack<TreeNode> path) {
        if (curr == null) {
            return false;
        }

        boolean found = false;
        if (curr.val == searchVal) {
            found = true;
        } else if (treeNodeSearchWithPath(curr.left, searchVal, path)) {
            found = true;
        } else if (treeNodeSearchWithPath(curr.right, searchVal, path)) {
            found = true;
        }

        if (found) {
            path.add(curr);
        }

        return found;
    }
}
