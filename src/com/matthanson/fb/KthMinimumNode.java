package com.matthanson.fb;

/**
 * Created by Matt on 9/26/16.
 */
public class KthMinimumNode<T> {
    public static class Node<T> {
        public T value;
        public Node<T> left;
        public Node<T> right;
    }

    private static class IntHolder {
        public int value;
    }

    public T kthMinimumNode(Node<T> root, int k) {
        IntHolder holder = new IntHolder();
        holder.value = 0;

        return process(root, k, holder);
    }

    private T process(Node<T> node, int k, IntHolder counter) {
        if (node == null) {
            return null;
        }
        T value = process(node.left, k, counter);
        if (value != null) return value;

        counter.value = counter.value + 1;
        if (counter.value == k) {
            return node.value;
        }

        return process(node.right, k, counter);
    }
}
