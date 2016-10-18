package com.matthanson.leetcode.algorithms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

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

        Vector<LinkedList<TreeNode>> pPaths = treeNodeSearchPaths(root, p.val);
        Vector<LinkedList<TreeNode>> qPaths = treeNodeSearchPaths(root, q.val);

        TreeNode lowestAncestor = null;
        int maxDepth = 0;
        for (LinkedList<TreeNode> pPath : pPaths) {
            for (LinkedList<TreeNode> qPath : qPaths) {
                Iterator<TreeNode> pIterator = pPath.descendingIterator();
                Iterator<TreeNode> qIterator = qPath.descendingIterator();
                TreeNode ancestor = null;
                boolean done = false;
                int currDepth = 0;
                while (!done && pIterator.hasNext() && qIterator.hasNext()) {
                    TreeNode next = pIterator.next();
                    if (next.val == qIterator.next().val) {
                        ancestor = next;
                        ++currDepth;
                    } else {
                        done = true;
                    }

                }

                if (currDepth > maxDepth) {
                    maxDepth = currDepth;
                    lowestAncestor = ancestor;
                }
            }
        }
        return lowestAncestor;
    }

    public TreeNode lowestCommonAncestorNoDuplicates(TreeNode root, TreeNode p, TreeNode q) {
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

    public Vector<LinkedList<TreeNode>> treeNodeSearchPaths(TreeNode curr, int searchVal) {
        Vector<LinkedList<TreeNode>> toReturn = new Vector<LinkedList<TreeNode>>();

        if (curr == null) {
            return toReturn;
        }


        Vector<LinkedList<TreeNode>> paths = treeNodeSearchPaths(curr.left, searchVal);
        for (LinkedList<TreeNode> vector : paths) {
            vector.add(curr);
            toReturn.add(vector);
        }
        paths = treeNodeSearchPaths(curr.right, searchVal);
        for (LinkedList<TreeNode> vector : paths) {
            vector.add(curr);
            toReturn.add(vector);
        }

        if (curr.val == searchVal && toReturn.isEmpty()) {
            LinkedList<TreeNode> path = new LinkedList<>();
            path.add(curr);
            toReturn.add(path);
        }
        return toReturn;
    }
}
