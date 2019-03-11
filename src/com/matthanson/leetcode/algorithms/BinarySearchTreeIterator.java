package com.matthanson.leetcode.algorithms;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinarySearchTreeIterator {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public BinarySearchTreeIterator(TreeNode root) {

    }

    /** @return the next smallest number */
    public int next() {
        return -1;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return false;
    }
}
