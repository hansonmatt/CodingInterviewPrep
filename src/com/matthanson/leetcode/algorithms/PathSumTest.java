package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class PathSumTest {
    private PathSum pathSum = new PathSum();

    private class TreeBuilder {
        public PathSum.TreeNode build(Integer[] tree) {
            if (tree == null || tree.length == 0) {
                return null;
            }

            Queue<PathSum.TreeNode> q = new LinkedList<>();
            LinkedList<Integer> list = new LinkedList<>(Arrays.asList(tree));

            PathSum.TreeNode root = new PathSum.TreeNode(list.remove());
            q.add(root);
            while (!q.isEmpty() && !list.isEmpty()) {
                PathSum.TreeNode node = q.remove();
                if (node != null) {
                    Integer childVal = list.remove();
                    if (childVal != null) {
                        node.left = new PathSum.TreeNode(childVal);
                    }
                    q.add(node.left);

                    childVal = list.remove();
                    if (childVal != null) {
                        node.right = new PathSum.TreeNode(childVal);
                    }
                    q.add(node.right);
                }
            }

            return root;
        }
    }

    @Test
    public void testTreeBuilder() {
        TreeBuilder builder = new TreeBuilder();

        PathSum.TreeNode root = builder.build(new Integer[]{1, 2, null, 3, null});
        assertEquals(root.val, 1);
        assertEquals(root.left.val, 2);
        assertNull(root.right);
        assertEquals(root.left.left.val, 3);
        assertNull(root.left.right);

        root = builder.build(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        assertEquals(root.val, 5);
        assertEquals(root.left.val, 4);
        assertEquals(root.right.val, 8);
        assertEquals(root.left.left.val, 11);
        assertNull(root.left.right);
        assertEquals(root.right.left.val, 13);
        assertEquals(root.right.right.val, 4);
        assertEquals(root.left.left.left.val, 7);
        assertEquals(root.left.left.right.val, 2);
        assertNull(root.right.left.left);
        assertNull(root.right.left.right);
        assertNull(root.right.right.left);
        assertEquals(root.right.right.right.val, 1);
    }

    @Test
    public void testHasPathSum() {

        assertFalse(pathSum.hasPathSum(null, 10));
        PathSum.TreeNode root = new PathSum.TreeNode(10);
        assertTrue(pathSum.hasPathSum(root, 10));

        TreeBuilder builder = new TreeBuilder();
        root = builder.build(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        assertTrue(pathSum.hasPathSum(root, 22));
        assertTrue(pathSum.hasPathSum(root, 27));
        assertTrue(pathSum.hasPathSum(root, 26));
        assertTrue(pathSum.hasPathSum(root, 18));
        assertFalse(pathSum.hasPathSum(root, 1));
        assertFalse(pathSum.hasPathSum(root, 19));

        root = builder.build(new Integer[]{2, -2, -2, 0, 6, 8, 1, 0, 100, null, -20, null, null, -2, 0});
        assertTrue(pathSum.hasPathSum(root, 0));
        assertTrue(pathSum.hasPathSum(root, 100));
        assertTrue(pathSum.hasPathSum(root, -14));
        assertTrue(pathSum.hasPathSum(root, 8));
        assertTrue(pathSum.hasPathSum(root, -1));
        assertTrue(pathSum.hasPathSum(root, 1));
        assertFalse(pathSum.hasPathSum(root, 2));
        assertFalse(pathSum.hasPathSum(root, -50));

        root = builder.build(new Integer[]{1, 2, 3});
        assertFalse(pathSum.hasPathSum(root, 5));

        root = builder.build(new Integer[]{1, 2, null});
        assertFalse(pathSum.hasPathSum(root, 0));
    }
}
