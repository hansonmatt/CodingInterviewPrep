package com.matthanson.hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matt on 9/29/16.
 */
public class IsThisABinaryTreeTest {
    @Test
    public void checkBST() throws Exception {
        IsThisABinaryTree.Node root = new IsThisABinaryTree.Node();
        root.data = 3;

        root.left = new IsThisABinaryTree.Node();
        root.left.data = 5;
        root.left.left = new IsThisABinaryTree.Node();
        root.left.left.data = 1;
        root.left.right = new IsThisABinaryTree.Node();
        root.left.right.data = 4;

        root.right = new IsThisABinaryTree.Node();
        root.right.data = 2;
        root.right.left = new IsThisABinaryTree.Node();
        root.right.left.data = 6;

        IsThisABinaryTree isBst = new IsThisABinaryTree();
        assertFalse(isBst.checkBST(root));
    }

}