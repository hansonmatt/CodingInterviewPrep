package com.matthanson.leetcode.algorithms;

import java.util.*;

public class CloneGraph {
    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        public boolean equals(Object o) {
            if (o == null || !(o instanceof Node)) {
                return false;
            }

            Node n = (Node) o;
            return this.val == n.val;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Integer, Node> copyMap = new HashMap<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(node);

        copyMap.put(node.val, copyNode(node.val));

        while (!nodeQueue.isEmpty()) {
            Node n = nodeQueue.poll();

            Node nCopy = copyMap.get(n.val);

            for (Node neighbor : n.neighbors) {
                if (!copyMap.containsKey(neighbor.val)) {
                    copyMap.put(neighbor.val, copyNode(neighbor.val));
                    nodeQueue.add(neighbor);
                }

                Node neighborNode = copyMap.get(neighbor.val);
                neighborNode.neighbors.add(nCopy);
            }
        }

        return copyMap.get(node.val);
    }

    private Node copyNode(int nodeVal) {
        Node n = new Node();
        n.val = nodeVal;
        n.neighbors = new LinkedList<>();
        return n;
    }
}
