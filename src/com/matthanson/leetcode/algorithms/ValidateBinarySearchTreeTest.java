package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateBinarySearchTreeTest {
    private ValidateBinarySearchTree validate = new ValidateBinarySearchTree();

    @Test
    public void isValidBST() throws Exception {
        assertTrue(validate.isValidBST(null));

        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(2);
        root.left = new ValidateBinarySearchTree.TreeNode(1);
        root.right = new ValidateBinarySearchTree.TreeNode(3);
        assertTrue(validate.isValidBST(root));

        root = new ValidateBinarySearchTree.TreeNode(1);
        root.left = new ValidateBinarySearchTree.TreeNode(2);
        root.right = new ValidateBinarySearchTree.TreeNode(3);
        assertFalse(validate.isValidBST(root));

        root = new ValidateBinarySearchTree.TreeNode(1);
        root.left = new ValidateBinarySearchTree.TreeNode(0);
        root.right = new ValidateBinarySearchTree.TreeNode(0);
        assertFalse(validate.isValidBST(root));

        root = new ValidateBinarySearchTree.TreeNode(1);
        root.left = new ValidateBinarySearchTree.TreeNode(0);
        root.right = new ValidateBinarySearchTree.TreeNode(1);
        assertFalse(validate.isValidBST(root));

        root = new ValidateBinarySearchTree.TreeNode(2);
        root.left = new ValidateBinarySearchTree.TreeNode(1);
        root.right = new ValidateBinarySearchTree.TreeNode(3);
        root.left.left = new ValidateBinarySearchTree.TreeNode(0);
        root.left.left.left = new ValidateBinarySearchTree.TreeNode(-1);
        root.right.right = new ValidateBinarySearchTree.TreeNode(8);
        root.right.right.left = new ValidateBinarySearchTree.TreeNode(5);
        root.right.right.right = new ValidateBinarySearchTree.TreeNode(15);
        assertTrue(validate.isValidBST(root));

        root.right.right.right.left = new ValidateBinarySearchTree.TreeNode(16);
        assertFalse(validate.isValidBST(root));

        root = new ValidateBinarySearchTree.TreeNode(10);
        root.left = new ValidateBinarySearchTree.TreeNode(5);
        root.right = new ValidateBinarySearchTree.TreeNode(15);
        root.right.left = new ValidateBinarySearchTree.TreeNode(6);
        root.right.right = new ValidateBinarySearchTree.TreeNode(20);
        assertFalse(validate.isValidBST(root));

        root = new ValidateBinarySearchTree.TreeNode(10);
        root.left = new ValidateBinarySearchTree.TreeNode(5);
        root.left.left = new ValidateBinarySearchTree.TreeNode(5);
        root.right = new ValidateBinarySearchTree.TreeNode(15);
        root.right.left = new ValidateBinarySearchTree.TreeNode(12);
        root.right.right = new ValidateBinarySearchTree.TreeNode(20);
        assertFalse(validate.isValidBST(root));

        root = new ValidateBinarySearchTree.TreeNode(10);
        root.left = new ValidateBinarySearchTree.TreeNode(5);
        root.left.right = new ValidateBinarySearchTree.TreeNode(3);
        root.right = new ValidateBinarySearchTree.TreeNode(15);
        root.right.left = new ValidateBinarySearchTree.TreeNode(12);
        root.right.right = new ValidateBinarySearchTree.TreeNode(20);
        assertFalse(validate.isValidBST(root));

        root = new ValidateBinarySearchTree.TreeNode(10);
        root.left = new ValidateBinarySearchTree.TreeNode(5);
        root.left.right = new ValidateBinarySearchTree.TreeNode(3);
        root.right = new ValidateBinarySearchTree.TreeNode(15);
        root.right.left = new ValidateBinarySearchTree.TreeNode(12);
        root.right.right = new ValidateBinarySearchTree.TreeNode(14);
        assertFalse(validate.isValidBST(root));
    }

}