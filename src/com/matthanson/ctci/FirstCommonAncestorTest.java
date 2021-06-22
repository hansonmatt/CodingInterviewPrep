package com.matthanson.ctci;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstCommonAncestorTest {
    private FirstCommonAncestor fca = new FirstCommonAncestor();

    @Test
    public void firstCommonAncestor() {
        FirstCommonAncestor.TreeNode root = new FirstCommonAncestor.TreeNode(1);
        root.left = new FirstCommonAncestor.TreeNode(2);
        root.left.left = new FirstCommonAncestor.TreeNode(4);
        root.left.left.left = new FirstCommonAncestor.TreeNode(7);
        root.left.left.right = new FirstCommonAncestor.TreeNode(8);
        root.right = new FirstCommonAncestor.TreeNode(3);
        root.right.left = new FirstCommonAncestor.TreeNode(5);
        root.right.left.left = new FirstCommonAncestor.TreeNode(9);
        root.right.left.right = new FirstCommonAncestor.TreeNode(10);
        root.right.right = new FirstCommonAncestor.TreeNode(6);
        root.right.right.left = new FirstCommonAncestor.TreeNode(11);
        root.right.right.left.right = new FirstCommonAncestor.TreeNode(13);
        root.right.right.left.right.left = new FirstCommonAncestor.TreeNode(14);

        assertEquals(1, fca.firstCommonAncestor(root, 2, 3));
        assertEquals(1, fca.firstCommonAncestor(root, 2, 11));
        assertEquals(1, fca.firstCommonAncestor(root, 6, 7));
        assertEquals(3, fca.firstCommonAncestor(root, 5, 14));
        assertEquals(4, fca.firstCommonAncestor(root, 4, 8));
    }
}