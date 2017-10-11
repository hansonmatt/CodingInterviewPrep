package com.matthanson.leetcode.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {
    static public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;

        if (root.left == null || root.right == null) return;

        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        int level = 1;
        while (!q.isEmpty()) {
            int nodes = (int) Math.pow(2, level);

            TreeLinkNode node = null;
            for (int x = 0; x < nodes; ++x) {
                node = q.poll();

                if (x < (nodes - 1)) {
                    node.next = q.peek();
                }

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }

            ++level;
        }
    }
}
