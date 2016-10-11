package com.matthanson.leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by matthans on 10/11/16.
 */
public class BinaryTreePaths {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();

        if (root != null) {
            traverse(root, null, paths);
        }
        return paths;
    }

    private void traverse(TreeNode node, String path, List<String> paths) {
        String currPath = (path == null) ? String.valueOf(node.val) : path.concat("->" + node.val);

        if (node.left == null && node.right == null) {
            paths.add(currPath);
            return;
        }

        if (node.left != null) {
            traverse(node.left, currPath, paths);
        }

        if (node.right != null) {
            traverse(node.right, currPath, paths);
        }
    }
}
