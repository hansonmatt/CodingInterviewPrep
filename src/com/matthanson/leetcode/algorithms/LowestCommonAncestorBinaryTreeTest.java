package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

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
        assertNull(lcabt.lowestCommonAncestorNoDuplicates(null, root.left, root.right));
        assertNull(lcabt.lowestCommonAncestorNoDuplicates(root, null, root.right));

        assertEquals(3, lcabt.lowestCommonAncestorNoDuplicates(root, new LowestCommonAncestorBinaryTree.TreeNode(5), new LowestCommonAncestorBinaryTree.TreeNode(1)).val);
        assertEquals(5, lcabt.lowestCommonAncestorNoDuplicates(root, new LowestCommonAncestorBinaryTree.TreeNode(5), new LowestCommonAncestorBinaryTree.TreeNode(4)).val);
        assertEquals(3, lcabt.lowestCommonAncestorNoDuplicates(root, new LowestCommonAncestorBinaryTree.TreeNode(2), new LowestCommonAncestorBinaryTree.TreeNode(1)).val);
        assertEquals(2, lcabt.lowestCommonAncestorNoDuplicates(root, new LowestCommonAncestorBinaryTree.TreeNode(7), new LowestCommonAncestorBinaryTree.TreeNode(4)).val);
        assertEquals(5, lcabt.lowestCommonAncestorNoDuplicates(root, new LowestCommonAncestorBinaryTree.TreeNode(6), new LowestCommonAncestorBinaryTree.TreeNode(4)).val);

        root.right.left.right = new LowestCommonAncestorBinaryTree.TreeNode(7);
        root.right.right.right = new LowestCommonAncestorBinaryTree.TreeNode(4);
        assertEquals(2, lcabt.lowestCommonAncestorNoDuplicates(root, new LowestCommonAncestorBinaryTree.TreeNode(7), new LowestCommonAncestorBinaryTree.TreeNode(4)).val);
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

    @Test
    public void treeNodeSearchPaths() {
        LowestCommonAncestorBinaryTree lcabt = new LowestCommonAncestorBinaryTree();
        assertTrue(lcabt.treeNodeSearchPaths(null, 5).isEmpty());

        LowestCommonAncestorBinaryTree.TreeNode root = new LowestCommonAncestorBinaryTree.TreeNode(3);
        // left side
        root.left = new LowestCommonAncestorBinaryTree.TreeNode(5);
        root.left.left = new LowestCommonAncestorBinaryTree.TreeNode(6);
        root.left.right = new LowestCommonAncestorBinaryTree.TreeNode(2);
        root.left.right.left = new LowestCommonAncestorBinaryTree.TreeNode(7);
        root.left.right.left.left = new LowestCommonAncestorBinaryTree.TreeNode(7); // 3,5,2,7,7
        root.left.right.right = new LowestCommonAncestorBinaryTree.TreeNode(4);
        // right side
        root.right = new LowestCommonAncestorBinaryTree.TreeNode(1);
        root.right.left = new LowestCommonAncestorBinaryTree.TreeNode(0);
        root.right.right = new LowestCommonAncestorBinaryTree.TreeNode(8);

        Vector<LinkedList<LowestCommonAncestorBinaryTree.TreeNode>> paths = lcabt.treeNodeSearchPaths(root, 7);
        assertEquals(1, paths.size());
        List<LowestCommonAncestorBinaryTree.TreeNode> path = paths.firstElement();
        assertEquals(5, path.size());
        assertEquals(7, path.get(0).val);
        assertEquals(7, path.get(1).val);
        assertEquals(2, path.get(2).val);
        assertEquals(5, path.get(3).val);
        assertEquals(3, path.get(4).val);

        root.right.left.right = new LowestCommonAncestorBinaryTree.TreeNode(7);
        paths = lcabt.treeNodeSearchPaths(root, 7);
        assertEquals(2, paths.size());
        path = paths.get(0);
        assertEquals(5, path.size());
        assertEquals(7, path.get(0).val);
        assertEquals(7, path.get(1).val);
        assertEquals(2, path.get(2).val);
        assertEquals(5, path.get(3).val);
        assertEquals(3, path.get(4).val);

        path = paths.get(1);
        assertEquals(4, path.size());
        assertEquals(7, path.get(0).val);
        assertEquals(0, path.get(1).val);
        assertEquals(1, path.get(2).val);
        assertEquals(3, path.get(3).val);
    }

}