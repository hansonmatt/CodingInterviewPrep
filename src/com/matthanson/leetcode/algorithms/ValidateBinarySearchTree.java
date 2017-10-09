package com.matthanson.leetcode.algorithms;

public class ValidateBinarySearchTree {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class MaxHolder {
        Integer max;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, new MaxHolder());
    }

    private boolean isValidBST(TreeNode node, MaxHolder maxHolder) {
        if (node == null) {
            return true;
        }

        if (node.left != null) {
            if (!isValidBST(node.left, maxHolder)) {
                return false;
            }
        }

        if (maxHolder.max != null) {
            if (node.val <= maxHolder.max) {
                return false;
            }
        }

        maxHolder.max = node.val;

        if (node.right != null) {
            return isValidBST(node.right, maxHolder);
        }

        return true;
    }
}
