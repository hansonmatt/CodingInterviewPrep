package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class SameTreeTest {
    @Test
    public void isSameTree() throws Exception {

        SameTree sameTree = new SameTree();

        assertTrue(sameTree.isSameTree(new SameTree.TreeNode(1), new SameTree.TreeNode(1)));

        assertFalse(sameTree.isSameTree(new SameTree.TreeNode(0), new SameTree.TreeNode(1)));


        SameTree.TreeNode tree1 = new SameTree.TreeNode(1);
        tree1.left = new SameTree.TreeNode(2);
        tree1.right = new SameTree.TreeNode(3);

        SameTree.TreeNode tree2 = new SameTree.TreeNode(1);
        tree2.left = new SameTree.TreeNode(2);
        tree2.right = new SameTree.TreeNode(3);
        assertTrue(sameTree.isSameTree(tree1, tree2));

        tree2.left = new SameTree.TreeNode(3);
        tree2.right = new SameTree.TreeNode(2);
        assertFalse(sameTree.isSameTree(tree1, tree2));

        tree2.left = new SameTree.TreeNode(2);
        tree2.right = null;
        assertFalse(sameTree.isSameTree(tree1, tree2));

        tree2.left = new SameTree.TreeNode(2);
        tree2.right = new SameTree.TreeNode(3);
        assertTrue(sameTree.isSameTree(tree1, tree2));

        tree2.right.left = new SameTree.TreeNode(4);

        assertFalse(sameTree.isSameTree(tree1, tree2));

        tree1 = new SameTree.TreeNode(1);
        tree1.left = new SameTree.TreeNode(2);
        tree2 = new SameTree.TreeNode(1);
        tree2.right = new SameTree.TreeNode(2);
        assertFalse(sameTree.isSameTree(tree1, tree2));
    }

}