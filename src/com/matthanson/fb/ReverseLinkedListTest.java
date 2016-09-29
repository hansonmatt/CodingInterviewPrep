package com.matthanson.fb;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Matt on 9/29/16.
 */
public class ReverseLinkedListTest {
    @Test
    public void reverseLinkedList() throws Exception {
        ReverseLinkedList<Integer> reverseLinkedList = new ReverseLinkedList<>();
        assertNull(reverseLinkedList.reverseLinkedList(null));

        ReverseLinkedList.Node<Integer> root = new ReverseLinkedList.Node<>(1);
        assertEquals(root, reverseLinkedList.reverseLinkedList(root));

        ArrayList<Integer> a = new ArrayList<>();
        root = generateList(2, a);
        
        ReverseLinkedList.Node<Integer> newRoot = reverseLinkedList.reverseLinkedList(root);
        assertEquals(new Integer(2), newRoot.value);
        assertEquals(root, newRoot.next);
        assertNull(root.next);

        root = generateList(5, a);
        newRoot = reverseLinkedList.reverseLinkedList(root);
        assertEquals(new Integer(5), newRoot.value);
        assertEquals(4, newRoot.next.value);
        assertEquals(3, newRoot.next.next.value);
        assertEquals(2, newRoot.next.next.next.value);
        assertEquals(root, newRoot.next.next.next.next);
        assertNull(root.next);
    }

    private ReverseLinkedList.Node<Integer> generateList(int nNodes, ArrayList<Integer> a) {
        a.clear();

        ReverseLinkedList.Node<Integer> root = new ReverseLinkedList.Node<Integer>(1);
        a.add(1);

        ReverseLinkedList.Node<Integer> parent = root;
        for (int n = 2; n <= nNodes; ++n) {
            parent.next = new ReverseLinkedList.Node<Integer>(n);
            a.add(n);
            parent = parent.next;
        }

        return root;
    }

}