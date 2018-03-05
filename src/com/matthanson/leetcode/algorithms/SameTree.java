package com.matthanson.leetcode.algorithms;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class SameTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null  && q == null)) {
            return false;
        }

        if (p == null && q == null)
            return true;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
