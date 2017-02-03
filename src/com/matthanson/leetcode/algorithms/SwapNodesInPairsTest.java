package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthans on 2/1/17.
 */
public class SwapNodesInPairsTest {
    private SwapNodesInPairs swap = new SwapNodesInPairs();

    @Test
    public void swapPairsNull() throws Exception {
        assertNull(swap.swapPairs(null));
    }

    @Test
    public void swapPairsHeadOnly() throws Exception {
        assertEquals(10, swap.swapPairs(new SwapNodesInPairs.ListNode(10)).val);
    }

    @Test
    public void swapPairs123() throws Exception {
        SwapNodesInPairs.ListNode head = new SwapNodesInPairs.ListNode(1);
        head.next = new SwapNodesInPairs.ListNode(2);
        head.next.next = new SwapNodesInPairs.ListNode(3);

        head = swap.swapPairs(head);

        assertEquals(2, head.val);
        assertEquals(1, head.next.val);
        assertEquals(3, head.next.next.val);
    }

    @Test
    public void swapPairs1234() throws Exception {
        SwapNodesInPairs.ListNode head = new SwapNodesInPairs.ListNode(1);
        head.next = new SwapNodesInPairs.ListNode(2);
        head.next.next = new SwapNodesInPairs.ListNode(3);
        head.next.next.next = new SwapNodesInPairs.ListNode(4);

        head = swap.swapPairs(head);

        assertEquals(2, head.val);
        assertEquals(1, head.next.val);
        assertEquals(4, head.next.next.val);
        assertEquals(3, head.next.next.next.val);
    }

    @Test
    public void swapPairs12345() throws Exception {
        SwapNodesInPairs.ListNode head = new SwapNodesInPairs.ListNode(1);
        head.next = new SwapNodesInPairs.ListNode(2);
        head.next.next = new SwapNodesInPairs.ListNode(3);
        head.next.next.next = new SwapNodesInPairs.ListNode(4);
        head.next.next.next.next = new SwapNodesInPairs.ListNode(5);

        head = swap.swapPairs(head);

        assertEquals(2, head.val);
        assertEquals(1, head.next.val);
        assertEquals(4, head.next.next.val);
        assertEquals(3, head.next.next.next.val);
        assertEquals(5, head.next.next.next.next.val);
    }

    @Test
    public void swapPairs2534622() throws Exception {
        SwapNodesInPairs.ListNode head = new SwapNodesInPairs.ListNode(2);
        head.next = new SwapNodesInPairs.ListNode(5);
        head.next.next = new SwapNodesInPairs.ListNode(3);
        head.next.next.next = new SwapNodesInPairs.ListNode(4);
        head.next.next.next.next = new SwapNodesInPairs.ListNode(6);
        head.next.next.next.next.next = new SwapNodesInPairs.ListNode(2);
        head.next.next.next.next.next.next = new SwapNodesInPairs.ListNode(2);

        head = swap.swapPairs(head);

        assertEquals(5, head.val);
        assertEquals(2, head.next.val);
        assertEquals(4, head.next.next.val);
        assertEquals(3, head.next.next.next.val);
        assertEquals(2, head.next.next.next.next.val);
        assertEquals(6, head.next.next.next.next.next.val);
        assertEquals(2, head.next.next.next.next.next.next.val);
    }

}