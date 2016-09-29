package com.matthanson.fb;

/**
 * Created by Matt on 9/29/16.
 */
public class ReverseLinkedList<T> {
    public static class Node<T> {
        public Node(T theValue) {
            this.value = theValue;
        }

        T value;
        Node next;
    }

    public Node<T> reverseLinkedList(Node<T> root) {
        if (root == null || root.next == null) {
            return root;
        }

        Node<T> toReturn = reverse(root, root.next);
        root.next = null;
        return toReturn;
    }

    private Node<T> reverse(Node<T> parent, Node<T> child) {
        Node temp = child.next;
        child.next = parent;

        if (temp == null) {
            return child;
        }

        return reverse(child, temp);
    }
}
