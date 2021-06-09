package com.matthanson.fb;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TreeTargetSumTest {
    private TreeTargetSum treeTargetSum = new TreeTargetSum();

    @Test
    public void testTreeTargetSum() {
        TreeTargetSum.TreeNode root = new TreeTargetSum.TreeNode(10);
        root.left = new TreeTargetSum.TreeNode(6);
        root.left.left = new TreeTargetSum.TreeNode(4);
        root.left.right = new TreeTargetSum.TreeNode(9);
        root.left.left.left = new TreeTargetSum.TreeNode(3);
        root.left.left.right = new TreeTargetSum.TreeNode(5);
        root.left.left.left.left = new TreeTargetSum.TreeNode(2);

        root.right = new TreeTargetSum.TreeNode(14);
        root.right.left = new TreeTargetSum.TreeNode(1);
        root.right.right = new TreeTargetSum.TreeNode(15);

        List<List<Integer>> paths = treeTargetSum.targetSumPaths(root, 25);
    }
}