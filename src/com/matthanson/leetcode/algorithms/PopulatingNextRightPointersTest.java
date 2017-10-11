package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class PopulatingNextRightPointersTest {
    private PopulatingNextRightPointers nextRightPointers = new PopulatingNextRightPointers();

    @Test
    public void connect() throws Exception {
        nextRightPointers.connect(null);

        PopulatingNextRightPointers.TreeLinkNode root = new PopulatingNextRightPointers.TreeLinkNode(1);
        nextRightPointers.connect(root);
        assertEquals(1, root.val);
        assertNull(root.left);
        assertNull(root.right);
        assertNull(root.next);

        root.left = new PopulatingNextRightPointers.TreeLinkNode(2);
        root.right = new PopulatingNextRightPointers.TreeLinkNode(3);
        root.left.left = new PopulatingNextRightPointers.TreeLinkNode(4);
        root.left.right = new PopulatingNextRightPointers.TreeLinkNode(5);
        root.right.left = new PopulatingNextRightPointers.TreeLinkNode(6);
        root.right.right = new PopulatingNextRightPointers.TreeLinkNode(7);

        nextRightPointers.connect(root);
        assertNull(root.next);
        assertEquals(root.right, root.left.next);
        assertEquals(root.left.right, root.left.left.next);
        assertEquals(root.right.left, root.left.right.next);
        assertEquals(root.right.right, root.right.left.next);
        assertNull(root.right.next);
        assertNull(root.right.right.next);
    }

}