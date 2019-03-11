package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class BSTIteratorTest {

    @Test
    public void next() {
        BSTIterator.TreeNode root = new BSTIterator.TreeNode(1);
        BSTIterator iterator = new BSTIterator(root);
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());

        root = new BSTIterator.TreeNode(7);
        root.left = new BSTIterator.TreeNode(3);
        root.right = new BSTIterator.TreeNode(15);
        root.right.left = new BSTIterator.TreeNode(9);
        root.right.right = new BSTIterator.TreeNode(20);

        iterator = new BSTIterator(root);
        assertEquals(3, iterator.next());
        assertEquals(7, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(9, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(15, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(20, iterator.next());
        assertFalse(iterator.hasNext());

        root = new BSTIterator.TreeNode(8);
        root.left = new BSTIterator.TreeNode(2);
        root.left.left = new BSTIterator.TreeNode(1);
        root.left.right = new BSTIterator.TreeNode(6);
        root.left.right.left = new BSTIterator.TreeNode(4);
        root.left.right.right = new BSTIterator.TreeNode(7);
        root.right = new BSTIterator.TreeNode(15);
        root.right.left = new BSTIterator.TreeNode(9);
        root.right.right = new BSTIterator.TreeNode(20);

        iterator = new BSTIterator(root);
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(4, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(6, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(7, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(8, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(9, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(15, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(20, iterator.next());
        assertFalse(iterator.hasNext());

        root = new BSTIterator.TreeNode(8);
        root.left = new BSTIterator.TreeNode(7);
        root.left.left = new BSTIterator.TreeNode(6);
        root.left.left.left = new BSTIterator.TreeNode(5);
        root.left.left.left.left = new BSTIterator.TreeNode(4);
        root.left.left.left.left.left = new BSTIterator.TreeNode(3);
        root.left.left.left.left.left.left = new BSTIterator.TreeNode(2);
        root.left.left.left.left.left.left.left = new BSTIterator.TreeNode(1);
        iterator = new BSTIterator(root);

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(4, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(6, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(7, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(8, iterator.next());
        assertFalse(iterator.hasNext());

        root = new BSTIterator.TreeNode(8);
        root.right = new BSTIterator.TreeNode(9);
        root.right.right = new BSTIterator.TreeNode(10);
        root.right.right.right = new BSTIterator.TreeNode(11);
        root.right.right.right.right = new BSTIterator.TreeNode(12);
        root.right.right.right.right.right = new BSTIterator.TreeNode(13);
        iterator = new BSTIterator(root);

        assertTrue(iterator.hasNext());
        assertEquals(8, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(9, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(11, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(12, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(13, iterator.next());
        assertFalse(iterator.hasNext());

    }

    @Test(expected = IllegalStateException.class)
    public void nextNullRoot() {
        BSTIterator iterator = new BSTIterator(null);
        assertFalse(iterator.hasNext());
        iterator.next();
    }
}