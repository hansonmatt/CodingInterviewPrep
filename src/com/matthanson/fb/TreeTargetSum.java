package com.matthanson.fb;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum
 */
public class TreeTargetSum {
    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> targetSumPaths(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new LinkedList<>();
        Stack<Integer> currPath = new Stack<>();
        int currSum = 0;

        targetSumPaths(root, targetSum, currSum, paths, currPath);
        return paths;
    }

    private void targetSumPaths(TreeNode node, int targetSum, int currSum, List<List<Integer>> paths, Stack<Integer> currPath) {
        if (node == null)
        {
            return;
        }

        currSum += node.val;
        currPath.push(node.val);

        if (node.left == null && node.right == null) {
            // we found a leaf
            if (currSum == targetSum) {
                // we found a path equal to target sum
                List<Integer> pathToAdd = new LinkedList<>();
                for (int nodeVal : currPath) {
                    pathToAdd.add(nodeVal);
                }

                paths.add(pathToAdd);
            }

        }

        targetSumPaths(node.left, targetSum, currSum, paths, currPath);
        targetSumPaths(node.right, targetSum, currSum, paths, currPath);

        currPath.pop();
    }
}
