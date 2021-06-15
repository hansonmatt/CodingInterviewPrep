package com.matthanson.ctci;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListPartitionTest {
    private LinkedListPartition llp = new LinkedListPartition();

    @Test
    public void testLinkedListPartition() {
        LinkedListPartition.ListNode head = new LinkedListPartition.ListNode(3);
        LinkedListPartition.ListNode tail = new LinkedListPartition.ListNode(1);
        head.next = new LinkedListPartition.ListNode(5);
        head.next.previous = head;
        head.next.next = new LinkedListPartition.ListNode(8);
        head.next.next.previous = head.next;
        head.next.next.next = new LinkedListPartition.ListNode(5);
        head.next.next.next.next = new LinkedListPartition.ListNode(10);
        head.next.next.next.next.previous = head.next.next.next;
        head.next.next.next.next.next = new LinkedListPartition.ListNode(2);
        head.next.next.next.next.next.previous = head.next.next.next.next;
        head.next.next.next.next.next.next = tail;
        tail.previous = head.next.next.next.next.next;

        int partition = 5;
        head = llp.partition(head, tail, 7, partition);
        assertTrue(head.val < partition);
        assertTrue(head.next.val < partition);
        assertTrue(head.next.next.val < partition);
        assertTrue(head.next.next.next.val >= partition);
        assertTrue(head.next.next.next.next.val >= partition);
        assertTrue(head.next.next.next.next.next.val >= partition);
        assertTrue(head.next.next.next.next.next.next.val >= partition);

        // sorted list
        head = new LinkedListPartition.ListNode(1);
        tail = new LinkedListPartition.ListNode(4);
        head.next = new LinkedListPartition.ListNode(2);
        head.next.previous = head;
        head.next.next = new LinkedListPartition.ListNode(3);
        head.next.next.previous = head.next;
        head.next.next.next = tail;
        tail.previous = head.next.next;
        partition = 4;
        head = llp.partition(head, tail, 4, partition);
        assertTrue(head.val < partition);
        assertTrue(head.next.val < partition);
        assertTrue(head.next.next.val < partition);
        assertTrue(head.next.next.next.val == partition);
    }

}