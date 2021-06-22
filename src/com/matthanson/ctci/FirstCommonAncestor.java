package com.matthanson.ctci;

public class FirstCommonAncestor {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int firstCommonAncestor(TreeNode root, int node1, int node2) {
        return commonAncestor(root, node1, node2).val;
    }

    private TreeNode commonAncestor(TreeNode node, int node1, int node2) {
        if (node.val == node1 || node.val == node2) {
            if (node.val == node1) {
                if (find(node.left, node2) || find(node.right, node2)) {
                    return node;
                }
            } else if (node.val == node2) {
                if (find(node.left, node1) || find(node.right, node1)) {
                    return node;
                }
            }

            return null;
        }


        boolean node1Left = find(node.left, node1);
        boolean node2Left = find(node.left, node2);
        if (node1Left && node2Left) {
            return commonAncestor(node.left, node1, node2);
        }

        boolean node1Right = find(node.right, node1);
        boolean node2Right = find(node.right, node2);
        if (node1Right && node2Right) {
            return commonAncestor(node.right, node1, node2);
        }

        if ((node1Left || node1Right) && (node2Left || node2Right)) {
            return node;
        }

        return null;
    }

    private boolean find(TreeNode node, int toFind) {
        if (node == null) {
            return false;
        }

        if (node.val == toFind) {
            return true;
        }

        if (find(node.left, toFind)) {
            return true;
        } else if (find(node.right, toFind)) {
            return true;
        }

        return false;
    }
}
