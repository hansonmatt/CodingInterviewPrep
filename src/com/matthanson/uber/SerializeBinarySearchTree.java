package com.matthanson.uber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Matt on 9/27/16.
 */
public class SerializeBinarySearchTree {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
    }

    public List<Integer> serialize(Node root) {
        ArrayList<Integer> a = new ArrayList<>();
        serialize(root, a);
        return a;
    }

    private void serialize(Node node, List<Integer> list) {
        if (node == null) {
            list.add(null);
            return;
        }

        list.add(node.val);
        serialize(node.left, list);
        serialize(node.right, list);
    }

    public Node deserialize(List<Integer> serialized) {
        if (serialized == null || serialized.isEmpty()) {
            return null;
        }

        Queue<Integer> q = new LinkedList<>(serialized);
        return deserialize(q);
    }

    private Node deserialize(Queue<Integer> serialized) {
        Integer value = serialized.poll();
        if (value == null) {
            return null;
        }

        Node node = new Node();
        node.val = value;
        node.left = deserialize(serialized);
        node.right = deserialize(serialized);
        return node;
    }
}
