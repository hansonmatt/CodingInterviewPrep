package com.matthanson.ctci;


public class Successor {
    public static class TreeNode {
        int val;
        TreeNode parent;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode parent) {
            val = x;
            this.parent = parent;
        }
    }

    public int findSuccessor(TreeNode root, int searchValue) {
        if (root == null) {
            throw new IllegalArgumentException("Root cannot be  null");
        }

        TreeNode node = find(root, searchValue);
        if (node == null) {
            throw new IllegalArgumentException("Search value not found");
        }


        // if node has a right child, minimum right node is the successor
        if (node.right != null) {
            return findMin(node.right).val;
        }

        // if node is left of its parent, parent is the successor
        if (node.val == node.parent.left.val) {
            return node.parent.val;
        }

        // find a parent with a higher value
        TreeNode parent = node.parent;
        while (parent != null) {
            if (parent.val > node.val) {
                return parent.val;
            }

            parent = parent.parent;
        }
        // no parent successor, so this node is the largest; return -1;
        return -1;
    }

    private TreeNode find(TreeNode node, int searchValue) {
        if (node == null) return null;

        if (node.val == searchValue) {
            return node;
        }

        TreeNode child = find(node.left, searchValue);
        if (child != null) {
            return child;
        }

        return find(node.right, searchValue);
    }

    private TreeNode findMin(TreeNode node) {
        if (node.left == null) {
            return node;
        }

        TreeNode left = node.left;
        while (left.left != null) {
            left = left.left;
        }
        return left;
    }
}
