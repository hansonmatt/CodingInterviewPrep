package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthans on 5/17/17.
 */
public class RotateListTest {
    private RotateList rotate = new RotateList();

    @Test
    public void rotateRight() throws Exception {
        assertNull(rotate.rotateRight(null, 5));

        RotateList.ListNode head = new RotateList.ListNode(1);
        head = rotate.rotateRight(head, 0);
        assertEquals(1, head.val);
        assertNull(head.next);

        head = new RotateList.ListNode(1);
        head.next = new RotateList.ListNode(2);
        head = rotate.rotateRight(head, 1);
        assertEquals(2, head.val);
        assertEquals(1, head.next.val);
        assertNull(head.next.next);

        head = new RotateList.ListNode(1);
        head.next = new RotateList.ListNode(2);
        head = rotate.rotateRight(head, 1);
        assertEquals(2, head.val);
        assertEquals(1, head.next.val);
        assertNull(head.next.next);

        head = new RotateList.ListNode(1);
        head.next = new RotateList.ListNode(2);
        head = rotate.rotateRight(head, 2);
        assertEquals(1, head.val);
        assertEquals(2, head.next.val);
        assertNull(head.next.next);

        head = rotate.rotateRight(head, 10);
        assertEquals(1, head.val);
        assertEquals(2, head.next.val);
        assertNull(head.next.next);

        head = rotate.rotateRight(head, 15);
        assertEquals(2, head.val);
        assertEquals(1, head.next.val);
        assertNull(head.next.next);

        head = new RotateList.ListNode(1);
        head.next = new RotateList.ListNode(2);
        head.next.next = new RotateList.ListNode(3);
        head.next.next.next = new RotateList.ListNode(4);
        head.next.next.next = new RotateList.ListNode(5);

        head = rotate.rotateRight(head, 2);
        assertEquals(4, head.val);
        assertEquals(5, head.next.val);
        assertEquals(1, head.next.next.val);
        assertEquals(2, head.next.next.next.val);
        assertEquals(3, head.next.next.next.next.val);
        assertNull(head.next.next.next.next.next);
    }

}