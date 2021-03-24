package com.matthanson.leetcode.algorithms;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class PathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, 0, targetSum);
    }

    private boolean hasPathSum(TreeNode node, int runningSum, int targetSum) {
        if (node == null) {
            return false;
        }

        int internalSum = runningSum + node.val;

        boolean hasPath = false;
        if (node.left != null || node.right != null) {
            if (node.left != null) {
                hasPath = hasPathSum(node.left, internalSum, targetSum);
            }

            if (node.right != null) {
                hasPath |= hasPathSum(node.right, internalSum, targetSum);
            }

            return hasPath;
        }

        return internalSum == targetSum;
    }
}
