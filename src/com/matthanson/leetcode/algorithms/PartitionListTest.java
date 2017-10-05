package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionListTest {
    private PartitionList partitionList = new PartitionList();

    @Test
    public void testPartition() {
        assertNull(partitionList.partition(null, 5));

        PartitionList.ListNode head = new PartitionList.ListNode(1);
        assertEquals(1, partitionList.partition(head, 3).val);
        assertEquals(1, partitionList.partition(head, 1).val);
        assertEquals(1, partitionList.partition(head, 0).val);

        head = newList();
        PartitionList.ListNode node = partitionList.partition(head, 3);
        assertEquals(1, node.val);
        assertEquals(2, node.next.val);
        assertEquals(2, node.next.next.val);
        assertEquals(4, node.next.next.next.val);
        assertEquals(3, node.next.next.next.next.val);
        assertEquals(5, node.next.next.next.next.next.val);
        assertNull(node.next.next.next.next.next.next);

        node = partitionList.partition(newList(), 10);
        assertEquals(1, node.val);
        assertEquals(4, node.next.val);
        assertEquals(3, node.next.next.val);
        assertEquals(2, node.next.next.next.val);
        assertEquals(5, node.next.next.next.next.val);
        assertEquals(2, node.next.next.next.next.next.val);
        assertNull(node.next.next.next.next.next.next);

        node = partitionList.partition(newList(), 0);
        assertEquals(1, node.val);
        assertEquals(4, node.next.val);
        assertEquals(3, node.next.next.val);
        assertEquals(2, node.next.next.next.val);
        assertEquals(5, node.next.next.next.next.val);
        assertEquals(2, node.next.next.next.next.next.val);
        assertNull(node.next.next.next.next.next.next);

        head = new PartitionList.ListNode(2);
        head.next = new PartitionList.ListNode(-5);
        head.next.next = new PartitionList.ListNode(1);
        head.next.next.next = new PartitionList.ListNode(-1);
        head.next.next.next.next = new PartitionList.ListNode(0);
        head.next.next.next.next.next = new PartitionList.ListNode(-10);

        node = partitionList.partition(head, -3);
        assertEquals(-5, node.val);
        assertEquals(-10, node.next.val);
        assertEquals(2, node.next.next.val);
        assertEquals(1, node.next.next.next.val);
        assertEquals(-1, node.next.next.next.next.val);
        assertEquals(0, node.next.next.next.next.next.val);
        assertNull(node.next.next.next.next.next.next);
    }

    private PartitionList.ListNode newList() {
        PartitionList.ListNode head = new PartitionList.ListNode(1);
        head.next = new PartitionList.ListNode(4);
        head.next.next = new PartitionList.ListNode(3);
        head.next.next.next = new PartitionList.ListNode(2);
        head.next.next.next.next = new PartitionList.ListNode(5);
        head.next.next.next.next.next = new PartitionList.ListNode(2);

        return head;
    }

}