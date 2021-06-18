package com.matthanson.ctci;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SuccessorTest {
    private Successor successor = new Successor();

    @Test(expected = IllegalArgumentException.class)
    public void testSuccessorNullRoot() {
        successor.findSuccessor(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSuccessorSearchValueNotFound() {
        Successor.TreeNode root = new Successor.TreeNode(1);
        successor.findSuccessor(root, 0);
    }

    @Test
    public void testSuccessor() {
        Successor.TreeNode root = new Successor.TreeNode(12);
        root.left = new Successor.TreeNode(6, root);

        root.left.left = new Successor.TreeNode(4, root.left);
        root.left.left.left = new Successor.TreeNode(2, root.left.left);
        root.left.left.left.left = new Successor.TreeNode(1, root.left.left.left);

        root.left.right = new Successor.TreeNode(8, root.left);
        root.left.right.left = new Successor.TreeNode(7, root.left.right);
        root.left.right.right = new Successor.TreeNode(10, root.left.right);

        root.right = new Successor.TreeNode(18, root);
        root.right.left = new Successor.TreeNode(15, root.right);
        root.right.right = new Successor.TreeNode(20, root.right);
        root.right.right.left = new Successor.TreeNode(19, root.right.right);
        root.right.right.right = new Successor.TreeNode(21, root.right.right);

        assertEquals(2, successor.findSuccessor(root, 1));
        assertEquals(6, successor.findSuccessor(root, 4));
        assertEquals(7, successor.findSuccessor(root, 6));
        assertEquals(12, successor.findSuccessor(root, 10));
        assertEquals(18, successor.findSuccessor(root, 15));
        assertEquals(21, successor.findSuccessor(root, 20));
        assertEquals(-1, successor.findSuccessor(root, 21));
    }

}