package com.matthanson.hackerrank;

/**
 * Created by Matt on 9/29/16.
 */
public class IsThisABinaryTree {
    public static class Node {
        int data;
        Node left;
        Node right;
    }

    public boolean checkBST(Node root) {
        if (root == null) {
            return false;
        }

        boolean isBST = true;
        if (root.left != null) {
            isBST &= root.left.data < root.data && checkBST(root.left);
        }

        if (isBST && root.right != null) {
            isBST &= root.right.data > root.data && checkBST(root.right);
        }

        return isBST;
    }
}
