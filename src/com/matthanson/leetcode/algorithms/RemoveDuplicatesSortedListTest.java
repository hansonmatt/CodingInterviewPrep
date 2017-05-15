package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthans on 5/15/17.
 */
public class RemoveDuplicatesSortedListTest {
    private RemoveDuplicatesSortedList removeDuplicates = new RemoveDuplicatesSortedList();

    @Test
    public void deleteDuplicates() throws Exception {
        assertNull(removeDuplicates.deleteDuplicates(null));

        RemoveDuplicatesSortedList.ListNode head = new RemoveDuplicatesSortedList.ListNode(1);
        head = removeDuplicates.deleteDuplicates(head);
        assertEquals(1, head.val);
        assertNull(head.next);

        head.next = new RemoveDuplicatesSortedList.ListNode(1);
        head = removeDuplicates.deleteDuplicates(head);
        assertEquals(1, head.val);
        assertNull(head.next);

        head.next = new RemoveDuplicatesSortedList.ListNode(1);
        head.next.next = new RemoveDuplicatesSortedList.ListNode(1);
        head = removeDuplicates.deleteDuplicates(head);
        assertEquals(1, head.val);
        assertNull(head.next);

        head.next = new RemoveDuplicatesSortedList.ListNode(1);
        head.next.next = new RemoveDuplicatesSortedList.ListNode(1);
        head.next.next.next = new RemoveDuplicatesSortedList.ListNode(10);
        head = removeDuplicates.deleteDuplicates(head);
        assertEquals(1, head.val);
        assertEquals(10, head.next.val);
        assertNull(head.next.next);

        head.next = new RemoveDuplicatesSortedList.ListNode(1);
        head.next.next = new RemoveDuplicatesSortedList.ListNode(1);
        head.next.next.next = new RemoveDuplicatesSortedList.ListNode(10);
        head.next.next.next.next = new RemoveDuplicatesSortedList.ListNode(20);
        head.next.next.next.next.next = new RemoveDuplicatesSortedList.ListNode(30);
        head.next.next.next.next.next.next = new RemoveDuplicatesSortedList.ListNode(30);
        head.next.next.next.next.next.next.next = new RemoveDuplicatesSortedList.ListNode(40);
        head = removeDuplicates.deleteDuplicates(head);
        assertEquals(1, head.val);
        assertEquals(10, head.next.val);
        assertEquals(20, head.next.next.val);
        assertEquals(30, head.next.next.next.val);
        assertEquals(40, head.next.next.next.next.val);
        assertNull(head.next.next.next.next.next);
    }

}