package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by matthans on 10/11/16.
 */
public class BinaryTreePathsTest {
    @Test
    public void binaryTreePaths() throws Exception {
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        assertNotNull(binaryTreePaths.binaryTreePaths(null));
        assertTrue(binaryTreePaths.binaryTreePaths(null).isEmpty());

        BinaryTreePaths.TreeNode root = new BinaryTreePaths.TreeNode(10);
        List<String> paths = binaryTreePaths.binaryTreePaths(root);
        assertEquals(1, paths.size());
        assertEquals("10", paths.get(0));

        root.left = new BinaryTreePaths.TreeNode(5);
        paths = binaryTreePaths.binaryTreePaths(root);
        assertEquals(1, paths.size());
        assertEquals("10->5", paths.get(0));

        root.right = new BinaryTreePaths.TreeNode(30);
        paths = binaryTreePaths.binaryTreePaths(root);
        assertEquals(2, paths.size());
        assertEquals("10->5", paths.get(0));
        assertEquals("10->30", paths.get(1));

        root.left.left = new BinaryTreePaths.TreeNode(4);
        root.left.right = new BinaryTreePaths.TreeNode(7);
        root.left.right.left = new BinaryTreePaths.TreeNode(6);
        root.right.left = new BinaryTreePaths.TreeNode(25);
        root.right.right = new BinaryTreePaths.TreeNode(40);
        root.right.right.left = new BinaryTreePaths.TreeNode(35);
        paths = binaryTreePaths.binaryTreePaths(root);
        assertEquals(4, paths.size());
        assertEquals("10->5->4", paths.get(0));
        assertEquals("10->5->7->6", paths.get(1));
        assertEquals("10->30->25", paths.get(2));
        assertEquals("10->30->40->35", paths.get(3));
    }

}