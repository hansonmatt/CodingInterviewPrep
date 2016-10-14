package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Created by matthans on 10/13/16.
 */
public class LowestCommonAncestorBinaryTreeTest {
    @Test
    public void lowestCommonAncestor() throws Exception {
        LowestCommonAncestorBinaryTree.TreeNode root = new LowestCommonAncestorBinaryTree.TreeNode(3);
        // left side
        root.left = new LowestCommonAncestorBinaryTree.TreeNode(5);
        root.left.left = new LowestCommonAncestorBinaryTree.TreeNode(6);
        root.left.right = new LowestCommonAncestorBinaryTree.TreeNode(2);
        root.left.right.left = new LowestCommonAncestorBinaryTree.TreeNode(7);
        root.left.right.right = new LowestCommonAncestorBinaryTree.TreeNode(4);
        // right side
        root.right = new LowestCommonAncestorBinaryTree.TreeNode(1);
        root.right.left = new LowestCommonAncestorBinaryTree.TreeNode(0);
        root.right.right = new LowestCommonAncestorBinaryTree.TreeNode(8);

        LowestCommonAncestorBinaryTree lcabt = new LowestCommonAncestorBinaryTree();
        assertNull(lcabt.lowestCommonAncestor(null, root.left, root.right));
        assertNull(lcabt.lowestCommonAncestor(root, null, root.right));

        assertEquals(3, lcabt.lowestCommonAncestor(root, new LowestCommonAncestorBinaryTree.TreeNode(5), new LowestCommonAncestorBinaryTree.TreeNode(1)).val);
        assertEquals(5, lcabt.lowestCommonAncestor(root, new LowestCommonAncestorBinaryTree.TreeNode(5), new LowestCommonAncestorBinaryTree.TreeNode(4)).val);
        assertEquals(3, lcabt.lowestCommonAncestor(root, new LowestCommonAncestorBinaryTree.TreeNode(2), new LowestCommonAncestorBinaryTree.TreeNode(1)).val);
        assertEquals(2, lcabt.lowestCommonAncestor(root, new LowestCommonAncestorBinaryTree.TreeNode(7), new LowestCommonAncestorBinaryTree.TreeNode(4)).val);
        assertEquals(5, lcabt.lowestCommonAncestor(root, new LowestCommonAncestorBinaryTree.TreeNode(6), new LowestCommonAncestorBinaryTree.TreeNode(4)).val);
    }

    @Test
    public void treeNodeSearchWithPath() throws Exception {
        LowestCommonAncestorBinaryTree.TreeNode root = new LowestCommonAncestorBinaryTree.TreeNode(3);
        // left side
        root.left = new LowestCommonAncestorBinaryTree.TreeNode(5);
        root.left.left = new LowestCommonAncestorBinaryTree.TreeNode(6);
        root.left.right = new LowestCommonAncestorBinaryTree.TreeNode(2);
        root.left.right.left = new LowestCommonAncestorBinaryTree.TreeNode(7);
        root.left.right.right = new LowestCommonAncestorBinaryTree.TreeNode(4);
        // right side
        root.right = new LowestCommonAncestorBinaryTree.TreeNode(1);
        root.right.left = new LowestCommonAncestorBinaryTree.TreeNode(0);
        root.right.right = new LowestCommonAncestorBinaryTree.TreeNode(8);

        LowestCommonAncestorBinaryTree lcabt = new LowestCommonAncestorBinaryTree();
        Stack<LowestCommonAncestorBinaryTree.TreeNode> path = new Stack<>();
        assertFalse(lcabt.treeNodeSearchWithPath(null, 3, path));
        assertTrue(path.isEmpty());

        assertTrue(lcabt.treeNodeSearchWithPath(root, 3, path));
        assertEquals(1, path.size());
        assertEquals(3, path.pop().val);

        assertTrue(lcabt.treeNodeSearchWithPath(root, 1, path));
        assertEquals(2, path.size());
        assertEquals(3, path.pop().val);
        assertEquals(1, path.pop().val);

        assertTrue(lcabt.treeNodeSearchWithPath(root, 7, path));
        assertEquals(4, path.size());
        assertEquals(3, path.pop().val);
        assertEquals(5, path.pop().val);
        assertEquals(2, path.pop().val);
        assertEquals(7, path.pop().val);

        assertTrue(lcabt.treeNodeSearchWithPath(root, 4, path));
        assertEquals(4, path.size());
        assertEquals(3, path.pop().val);
        assertEquals(5, path.pop().val);
        assertEquals(2, path.pop().val);
        assertEquals(4, path.pop().val);

        assertTrue(lcabt.treeNodeSearchWithPath(root, 8, path));
        assertEquals(3, path.size());
        assertEquals(3, path.pop().val);
        assertEquals(1, path.pop().val);
        assertEquals(8, path.pop().val);
    }

}