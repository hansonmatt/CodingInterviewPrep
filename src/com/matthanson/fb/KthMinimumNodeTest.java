package com.matthanson.fb;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matt on 9/26/16.
 */
public class KthMinimumNodeTest {
    @Test
    public void kthMinimumNode() throws Exception {
        KthMinimumNode.Node<Integer> root = new KthMinimumNode.Node<>();
        root.value = 10;

        KthMinimumNode.Node<Integer> five = new KthMinimumNode.Node<>();
        five.value = 5;

        KthMinimumNode.Node<Integer> three = new KthMinimumNode.Node<>();
        three.value = 3;

        KthMinimumNode.Node<Integer> seven = new KthMinimumNode.Node<>();
        seven.value = 7;

        KthMinimumNode.Node<Integer> fifty = new KthMinimumNode.Node<>();
        fifty.value = 50;

        root.left = five;
        root.right = fifty;
        five.left = three;
        five.right = seven;

        KthMinimumNode<Integer> kth = new KthMinimumNode<>();

        assertEquals(new Integer(3), kth.kthMinimumNode(root, 1));
        assertEquals(new Integer(5), kth.kthMinimumNode(root, 2));
        assertEquals(new Integer(7), kth.kthMinimumNode(root, 3));
        assertEquals(new Integer(10), kth.kthMinimumNode(root, 4));
    }

}